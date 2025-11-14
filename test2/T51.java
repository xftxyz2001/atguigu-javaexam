public class T51 {
    public static void main(String[] args) {
        int a = 500;
        int b = 100;
        System.out.println(a * b / lcm(a, b));

    }

    private static int lcm(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        } else {
            return lcm(b, a % b);
        }
    }
}
