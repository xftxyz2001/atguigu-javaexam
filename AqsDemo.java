import java.util.concurrent.CountDownLatch;

public class AqsDemo {
    public static void main(String[] args) throws InterruptedException {
        // ReentrantLock lock = new ReentrantLock();
        // lock.lock(); // 获取锁
        // lock.tryLock(); // 尝试获取锁

        DataThree dataThree = new DataThree();
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                dataThree.incr();
                countDownLatch.countDown();
            }, "").start();
        }

        countDownLatch.await();
        System.out.println(dataThree.getNum());
    }
}

class DataThree {

    private volatile int num;
    Mutex mutex = new Mutex();

    public void incr() {
        mutex.lock();
        for (int i = 0; i < 1000; i++) {
            num++;
        }
        mutex.unlock();
    }

    public int getNum() {
        return num;
    }

}
