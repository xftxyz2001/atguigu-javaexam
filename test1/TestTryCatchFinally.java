public class TestTryCatchFinally {

    public static void main(String[] args) {
        System.out.println(test());
    }

    private static int test() {
        try {
            int a = 10;
            int b = 1;
            int c = a / b;
            System.out.println(c);
            return getNum(c);
        } catch (Exception e) {
            System.out.println("Exception");
            return getNum(-1);
        } finally {
            System.out.println("Finally");
            return getNum(-2);
        }
    }

    private static int getNum(int num) {
        System.out.println("getNum: " + num);
        return num;
    }
}