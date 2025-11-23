import java.util.ArrayList;
import java.util.List;

public class L386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        res.sort((a, b) -> a.toString().compareTo(b.toString()));
        return res;
    }
}
