import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class HJ59 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();
        HashSet<Character> set1 = new HashSet<>();
        LinkedHashSet<Character> set2 = new LinkedHashSet<>();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (set1.contains(ch)) {
                if (set2.contains(ch)) {
                    set2.remove(ch);
                }
            } else {
                set1.add(ch);
                set2.add(ch);
            }
        }

        if (set2.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(set2.iterator().next());
        }
    }
}
