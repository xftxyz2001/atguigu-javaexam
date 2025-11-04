import java.util.Scanner;

public class HJ57_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        in.close();
        System.out.println(bigIntAdd(s1, s2));

    }

    private static String bigIntAdd(String s1, String s2) {
        int[] arr1 = toIntArray(s1);
        int[] arr2 = toIntArray(s2);

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        StringBuilder sb = new StringBuilder((i > j ? i : j) + 1);
        int c = 0;
        while (i >= 0 && j >= 0) {
            int b = arr1[i--] + arr2[j--] + c;
            sb.append(b % 10);
            c = b / 10;
        }
        while (i >= 0) {
            int b = arr1[i--] + c;
            sb.append(b % 10);
            c = b / 10;
        }
        while (j >= 0) {
            int b = arr2[j--] + c;
            sb.append(b % 10);
            c = b / 10;
        }
        if (c > 0) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }

    private static int[] toIntArray(String s) {
        int[] res = new int[s.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = s.charAt(i) - '0';
        }
        return res;
    }
}
