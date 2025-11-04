import java.util.LinkedList;

public class L739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            // if (temperatures[i] <= stack.peek()) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int pop = stack.pop();
                    // res[pop] = i;
                    res[pop] = i - pop;
                }
                stack.push(i);
            }
        }
        return res;
    }
}