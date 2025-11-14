import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR157 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LCR157().goodsOrder("abc")));
    }

    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public String[] goodsOrder(String goods) {
        boolean[] used = new boolean[goods.length()];
        goodsOrder0(goods, used);
        return ans.toArray(new String[0]);
    }

    private void goodsOrder0(String goods, boolean[] used) {
        if (sb.length() == goods.length()) {
            ans.add(sb.toString());
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            sb.append(goods.charAt(i));

            goodsOrder0(goods, used);

            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

}
