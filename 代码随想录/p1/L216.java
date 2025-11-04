import java.util.ArrayList;
import java.util.List;

public class L216 {

    public static void main(String[] args) {
        new L216().combinationSum3(3, 7);
    }

    List<Integer> path = new ArrayList<>();
    int sum = 0;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum30(1, k, n);
        return ans;
    }

    private void combinationSum30(int start, int k, int n) {
        // ---
        if (sum > n) { // 和超了
            return;
        }
        if (k - path.size() > 9 - start + 1) { // 剩下的数不够了
            return;
        }
        // ---

        if (path.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            sum += i;
            combinationSum30(i + 1, k, n);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
