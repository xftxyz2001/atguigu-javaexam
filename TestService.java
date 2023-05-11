@Service
@Transactional
public class TestService {
    @Autowired
    private JdbcTemplate jt;

    public void insertA() {
        jt.update("insert into test(name) values('a')");
        insertB();
    }

    public void insertB() {
        jt.update("insert into test(name) values('b')");
    }
}
