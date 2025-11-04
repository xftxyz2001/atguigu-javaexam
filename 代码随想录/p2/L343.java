import java.util.ArrayList;
import java.util.List;

public class L343 {
    public static void main(String[] args) {
        new L343().integerBreak(25);
    }
    
    List<Integer> path = new ArrayList<>();
    int ans = 0;

    public int integerBreak(int n) {
        integerBreak0(n);
        return ans;
    }

    private void integerBreak0(int n) {
        if (!path.isEmpty()) {
            path.add(n);
            ans = Math.max(getResult(), ans);
            path.remove(path.size() - 1);
        }

        for (int i = 1; i < n; i++) {
            path.add(i);
            integerBreak0(n - i);
            path.remove(path.size() - 1);
        }
    }

    private int getResult() {
        int s = 1;
        for (Integer i : path) {
            s *= i;
        }
        return s;
    }
}
