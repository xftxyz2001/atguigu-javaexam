import java.util.LinkedList;

public class QMS2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];

        LinkedList<int[]> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            // if (stack.isEmpty() || stack.peek()[0] >= temperatures[i]) {
            //     stack.push(new int[] { temperatures[i], i });
            // } else {
                while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                    int[] pop = stack.pop();
                    ans[pop[1]] = i - pop[1];
                }
                stack.push(new int[] { temperatures[i], i });
            // }
        }
        return ans;
    }
}
