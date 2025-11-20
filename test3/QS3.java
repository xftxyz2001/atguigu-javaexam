import java.util.LinkedList;
import java.util.List;

public class QS3 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] times = new int[n];

        LinkedList<FuncItem> stack = new LinkedList<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int functionId = Integer.parseInt(split[0]);
            int time = Integer.parseInt(split[2]);
            if ("start".equals(split[1])) {
                if (!stack.isEmpty()) {
                    FuncItem f0 = stack.peek();
                    times[f0.functionId] += time - f0.startTime;
                }
                stack.push(new FuncItem(functionId, time));
            } else {
                FuncItem f0 = stack.pop();
                times[f0.functionId] += time - f0.startTime + 1;
                if (!stack.isEmpty()) {
                    stack.peek().startTime = time + 1;
                }
            }
        }
        return times;
    }
}

class FuncItem {
    int functionId;
    int startTime;

    public FuncItem(int functionId, int startTime) {
        this.functionId = functionId;
        this.startTime = startTime;
    }

}