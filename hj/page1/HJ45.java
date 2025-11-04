import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class HJ45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String[] names = new String[T];
        for (int i = 0; i < names.length; i++) {
            names[i] = in.next();
        }
        in.close();

        for (int i = 0; i < names.length; i++) {
            System.out.println(beauty(names[i]));
        }
    }

    private static int beauty(String name) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = name.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);
        }

        ArrayList<Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int value = 26;
        for (Entry<Character, Integer> e : list) {
            map.put(e.getKey(), value--);
        }

        int result = 0;
        for (int i = 0; i < charArray.length; i++) {
            result += map.get(charArray[i]);
        }
        return result;

    }
}
