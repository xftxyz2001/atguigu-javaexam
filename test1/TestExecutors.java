import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestExecutors {

    public static void main(String[] args) {
        // ExecutorService es = Executors.newCachedThreadPool();
        // es.execute(null);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.compareAndSet(1, 2));
    }
}