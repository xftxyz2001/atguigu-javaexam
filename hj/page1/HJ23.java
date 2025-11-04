import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map.Entry;

public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        in.close();

        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = line.toCharArray();
        for (char ch : charArray) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        HashSet<Character> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (Entry<Character, Integer> entrySet : map.entrySet()) {
            if (entrySet.getValue() < min) {
                min = entrySet.getValue();
                set.clear();
                set.add(entrySet.getKey());
            } else if (entrySet.getValue() == min) {
                set.add(entrySet.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : set) {
            sb.append(c);
        }
        String res = line.replaceAll("[" + sb.toString() + "]", "");
        System.out.println(res);
    }
}
