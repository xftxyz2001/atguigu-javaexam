import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QS1 {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> list = new ArrayList<>();
        int maxVal = 0;
        for (int i = 1; i <= n; i++) {
            list.add("Push");
            int tmp = maxVal;
            maxVal = i;
            if (target[target.length - 1] == maxVal) {
                return list;
            }
            if (Arrays.binarySearch(target, i) < 0) {
                list.add("Pop");
            }
            maxVal = tmp;
        }
        return list;
    }
}
