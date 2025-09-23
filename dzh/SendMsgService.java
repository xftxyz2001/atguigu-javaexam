import com.finchina.example.entity.User;
import com.finchina.example.service.UserService;
import org.springframework.data.redis.core.RedisTemplate;
import javax.annotation.Resource;

public class SendMsgService {
    @Resource
    UserService userService;

    @Resource
    RedisTemplate<String, String> redisTemplate;

    public void send(List<String> UserIds) {
        List<User> userPhones = userService.findAllPhone(UserIds);
        for (User user : userPhones) {
            // 这里是为了校验用户是否在线，redis中存在online表示在线
            if (redisTemplate.opsForValue().get("online_" + user.getId())) {
                // 调用第三方推送信息的伪方法
                sendMsg(user.getPhone());
            }
        }
    }
}

// 如上的代码中findAllPhone和sendMsg不可见，但是一个明显的的问题是在循环中请求Redis数据库，是一个同步阻塞操作，随着用户量的增加，处理时间会逐渐变长。
// 可以使用stream的并行流进行优化，也可以使用redisTemplate中的multiGet进行批量查询，还可以结合方式分批查询并行处理。
// 另外Service似乎不是面向接口编程的，另外代码中没有日志记录相关的代码，如果没有通过其他方式进行监控和配置，可能导致问题不好追踪。