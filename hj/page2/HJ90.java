import java.util.Scanner;

public class HJ90 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String ip = in.nextLine();
        in.close();
        System.out.println(isValid(ip) ? "YES" : "NO");
    }

    private static boolean isValid(String ip) {
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (int i = 0; i < split.length; i++) {
            int i0 = 0;
            try {
                i0 = Integer.parseInt(split[i]);
            } catch (NumberFormatException e) {
                return false;
            }
            if (!Integer.toString(i0).equals(split[i])) {
                return false;
            }
            if (i0 < 0 || i0 > 255) {
                return false;
            }
        }
        return true;
    }
}
