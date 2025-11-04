import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class HJ36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String t = in.nextLine();
        in.close();

        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Character> map = new HashMap<>();
        char key = 'a';
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!set.contains(charArray[i])) {
                set.add(charArray[i]);
                map.put(key++, charArray[i]);
            }
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (!set.contains(i)) {
                map.put(key++, i);
            }
        }
        char[] charArray2 = t.toCharArray();
        for (int i = 0; i < charArray2.length; i++) {
            charArray2[i] = map.get(charArray2[i]);
        }

        System.out.println(charArray2);
    }
}
