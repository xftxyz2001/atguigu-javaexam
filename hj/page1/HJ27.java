import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] sn = new String[n];
        for (int i = 0; i < sn.length; i++) {
            sn[i] = in.next();
        }
        String x = in.next();
        int k = in.nextInt();
        in.close();

        Arrays.sort(sn);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < sn.length; i++) {
            if (isBroStr(x, sn[i])) {
                result.add(sn[i]);
            }
        }
        System.out.println(result.size());
        if (k <= result.size()) {
            System.out.println(result.get(k - 1));
        }
    }

    private static boolean isBroStr(String x, String y) {
        int len = x.length();
        if (len != y.length() || x.equals(y)) {
            return false;
        }
        ArrayList<Character> xCharacters = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            xCharacters.add(x.charAt(i));
        }
        xCharacters.sort(Character::compareTo);
        ArrayList<Character> yCharacters = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            yCharacters.add(y.charAt(i));
        }
        yCharacters.sort(Character::compareTo);
        for (int i = 0; i < len; i++) {
            if (Character.compare(xCharacters.get(i), yCharacters.get(i)) != 0) {
                return false;
            }
        }
        return true;
    }
}
