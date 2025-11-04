import java.util.Arrays;

public class L455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // 胃口
        Arrays.sort(s); // 饼干

        int ans = 0;
        int j = s.length - 1;

        for (int i = g.length - 1; i >= 0; i--) {
            if (s[j] >= g[i]) {
                ans++;
                j--;
            }
        }
        return ans;
    }
}
