import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 现场编程题题目内容：
 * 题目描述
 * 请实现一个简易内存池,根据请求命令完成内存分配和释放，内存池支持两种操作命令，REQUEST和RELEASE，其格式为:
 * REQUEST=请求的内存大小表示请求分配指定大小内存，如果分配成功，返回分配到的内存首地址，如果内存不足，或指定的大小为0，则输出error。
 * RELEASE=释放的内存首地址表示程放掉之前分配的内存，释放成功无需输出，如果释放不存在的首地址则输出error.
 * 
 * 注意:
 * 1.内存池总大小为100字节
 * 2.内存池地址分配必须是连续内存，并优先从低地址分配
 * 3.内存释放后可被再次分配，已释放的内存在空闲时不能被二次释放。
 * 4.不会释放已申请的内存块的中间地址。
 * 5.释放操作只是针对首地址所对应的单个内存块进行操作，不会影响其它内存块。
 * 
 * 输入描述
 * 首行为整数N,表示操作命令的个数，取值范围:0<N<=100接下来的N行，每行将给出一个操作命令，操作命令和参数之间用“=”分割.
 * 
 * 输出描述
 * 请求分配指定大小内存时，如果分配成功，返回分配到的内存首地址，如果内存不足，
 * 或指定的大小为0，则输出error释放掉之前分配的内存时，释放成功无需输出，如果释放不
 * 存在的首地址则输出error。
 * 
 * 输入样例：
 * 5
 * REQUEST=10
 * REQUEST=20
 * RELEASE=0
 * REQUEST=20
 * REQUEST=10
 * 输出样例：
 * 0
 * 10
 * 30
 * 0
 */
class MemPool {
    private int remain = 100;
    PriorityQueue<int[]> unusedList;
    PriorityQueue<int[]> usedList;

    public MemPool() {
        this.unusedList = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        this.usedList = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        this.unusedList.add(new int[] { 0, 99 });
    }

    // 分配
    public int get(int size) {
        if (size <= 0 || size > remain) {
            return -1;
        }
        int head = -1;
        for (int[] unused : unusedList) {
            if (unused[1] - unused[0] + 1 < size) {
                continue;
            }
            unusedList.removeIf(t -> t[0] == unused[0]);
            head = unused[0];
            usedList.add(new int[] { unused[0], unused[0] + size - 1 });
            unused[0] += size;
            if (unused[0] <= unused[1]) {
                unusedList.add(unused);
            }
            break;
        }
        if (head != -1) {
            remain -= size;
        }

        return head;
    }

    // 回收
    public int free(int head) {
        int res = -1;
        for (int[] used : usedList) {
            if (used[0] != head) {
                continue;
            }
            usedList.removeIf(t -> t[0] == used[0]);
            res = head;

            AtomicInteger front = new AtomicInteger(-1);
            for (int[] unused : unusedList) {
                if (unused[1] + 1 == used[0]) {
                    // 前面有
                    unused[1] = used[1];
                    front.set(unused[0]);
                }
                if (used[1] + 1 == unused[0]) {
                    // 后面有
                    if (front.get() != -1) {
                        unusedList.removeIf(t -> t[0] == front.get());
                        unusedList.add(new int[] { front.get(), unused[1] });
                    } else {
                        unused[0] = unused[0];
                    }
                }
            }
        }
        return res;
    }

}

public class Hello {
    public static void main(String[] args) {

        MemPool mp = new MemPool();

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String cmd = in.next();
            String[] cmds = cmd.split("=");
            if ("REQUEST".equals(cmds[0])) {
                int res = mp.get(Integer.parseInt(cmds[1]));
                System.out.println(res == -1 ? "error" : res);
            } else if ("RELEASE".equals(cmds[0])) {
                int res = mp.free(Integer.parseInt(cmds[1]));
                System.out.println(res == -1 ? "error" : res);
            } else {
                // 命令错误
                System.out.println("error");
            }

        }
        in.close();
    }
}
