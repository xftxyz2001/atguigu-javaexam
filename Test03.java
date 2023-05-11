public class Test03 {
    private Test03() {
    }

    private static Test03 instance = null;

    public static Test03 getInstance() {
        // 有可能在多线程访问的时候，重复 new 了对象
        if (instance == null) {
            // 可能会有多个线程 进入抢锁等待状态
            synchronized (Test03.class) {
                if (instance == null) {
                    instance = new Test03();
                } else {
                    return instance;
                }
            }
        }
        return instance;
    }
}