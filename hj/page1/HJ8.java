import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = in.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < cnt; i++) {
            int index = in.nextInt();
            int value = in.nextInt();
            map.put(index, map.getOrDefault(index, 0) + value);
        }
        in.close();

        for (Entry<Integer, Integer> entrySet : map.entrySet()) {
            System.out.println(entrySet.getKey() + " " + entrySet.getValue());
        }
    }
}
