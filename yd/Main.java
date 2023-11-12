import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 输入
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        scanner.close();
        // 非法输入
        if (nextLine.length() < 3) {
            System.out.println(-1);
            return;
        }

        // 转数字
        String[] split = nextLine.substring(1, nextLine.length() - 1).split(",");
        // System.out.println(split.length);
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        // 统计
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 排序
        Entry<Integer, Integer>[] entries = map.entrySet().toArray(new Entry[0]);
        // Arrays.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());
        Arrays.sort(entries, new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        // 测试
        // for (int i = 0; i < entries.length; i++) {
        // System.out.println(entries[i].getKey() + "," + entries[i].getValue());
        // }

        // 输出
        // 如果存在多个最大值，输出-1（排除只有一个元素的情况）
        if (entries.length > 1 && entries[0].getValue() == entries[1].getValue()) {
            System.out.println(-1);
        } else {
            System.out.println(entries[0].getKey() + "," + entries[0].getValue());
        }

        // 找出value最大的Entry
        // Entry<Integer, Integer> e = map.entrySet().stream().max((o1, o2) ->
        // o1.getValue() - o2.getValue()).get();
        // System.out.println(e.getKey() + "," + e.getValue());
        // [1,3,3,5,6,3,3,4]
        // 3,4
    }
}
