public class TestOverflow {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            i++;
            if (i == 3) {
                System.out.println("i=3");
            }
        }
    }
}
