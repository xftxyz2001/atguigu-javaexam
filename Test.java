public class Test {

    public static void main(String[] args) {

        try {
            int i = 100 / 0;
            System.out.print(i);
        } catch (Exception e) {
            System.out.println(1);
            throw new RuntimeException();
        } finally {
            System.out.println(2);
        }
        System.out.println(3);
    }
}
// 1
// 2
// Exception in thread "main" java.lang.RuntimeException