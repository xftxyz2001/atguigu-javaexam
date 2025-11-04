import java.util.Arrays;

public class L435 {

    public static void main(String[] args) {
        new L435().eraseOverlapIntervals(new int[][] { { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 6 } });
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                res++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }

        return res;
    }
}
