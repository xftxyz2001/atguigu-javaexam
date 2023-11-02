import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 集合的数量
        ArrayList<HashSet<Integer>> sets = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt(); // 第i个集合的大小
            HashSet<Integer> set = new HashSet<>(m);
            for (int j = 0; j < m; j++) {
                int nextInt = sc.nextInt();
                set.add(nextInt);
            }
            sets.add(set);
        }
        sc.close();
        int sum = 0;
        for (int i = 0; i < sets.size(); i++) {
            for (int j = i + 1; j < sets.size(); j++) {
                HashSet<Integer> set1 = sets.get(i);
                HashSet<Integer> set2 = sets.get(j);
                int count = 0;
                for (Integer integer : set1) {
                    if (set2.contains(integer)) {
                        count++;
                    }
                }
                // card(set1 ∩ set2)
                sum += set1.size() + set2.size() - count;
            }
        }
        int c = n * (n - 1) / 2;
        System.out.printf("%.11f", (double) sum / c);
    }
}
