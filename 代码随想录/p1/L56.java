import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56 {
    public static void main(String[] args) {
        new L56().merge(new int[][] { { 4, 7 }, { 1, 4 } });
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                res.add(new int[] { left, right });
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.add(new int[] { left, right });
        int[][] resArr = new int[res.size()][2];
        for (int i = 0; i < resArr.length; i++) {
            int[] js = res.get(i);
            resArr[i][0] = js[0];
            resArr[i][1] = js[1];
        }
        return resArr;
    }
}
