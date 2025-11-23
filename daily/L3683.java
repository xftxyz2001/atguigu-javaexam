public class L3683 {
    public int earliestTime(int[][] tasks) {
        int earliestTime = Integer.MAX_VALUE;
        for (int[] task : tasks) {
            earliestTime = Math.min(earliestTime, task[0] + task[1]);
        }
        return earliestTime;
    }
}
