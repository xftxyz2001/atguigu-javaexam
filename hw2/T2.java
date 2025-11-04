import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringJoiner;

public class T2 {

    // PriorityQueue

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        while (in.hasNextLine()) {
            String nextLine = in.nextLine();
            if (nextLine.length() == 1 && Character.isDigit(nextLine.charAt(0))) {
                int n = nextLine.charAt(0) - '0';
                // 输出
                printTopN(map, n);
            } else {
                map.put(nextLine, map.getOrDefault(nextLine, 0) + 1);
            }
        }
        in.close();
    }

    private static void printTopN(HashMap<String, Integer> map, int n) {
        Set<Entry<String, Integer>> entrySet = map.entrySet();
        ArrayList<Entry<String, Integer>> arrayList = new ArrayList<>(entrySet);
        arrayList.sort((o1, o2) -> {
            int s = o2.getValue() - o1.getValue();
            if (s != 0) {
                return s;
            }
            return o1.getKey().compareTo(o2.getKey());
        });
        StringJoiner sj = new StringJoiner(",");
        for (int i = 0; i < n; i++) {
            sj.add(arrayList.get(i).getKey());
        }
        System.out.println(sj.toString());
    }
}
