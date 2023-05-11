public class Test11 {

    public static void main(String[] args) {
        Test11 a = new Test11();
        Test11 b = new Test11();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.xxoo();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                b.xxoo();
            }
        }).start();

    }

    public synchronized void xxoo() {
        System.out.println(Thread.currentThread() + " xxoo");
    }
}
