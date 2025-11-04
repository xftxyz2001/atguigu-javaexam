import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class L347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> o1.getValue() - o2.getValue());
        for (Entry<Integer, Integer> entrySet : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(entrySet);
            } else {
                if (priorityQueue.peek().getValue() < entrySet.getValue()) {
                    priorityQueue.poll();
                    priorityQueue.add(entrySet);
                }
            }
        }
        int[] res = new int[priorityQueue.size()];
        int i = 0;
        for (Entry<Integer, Integer> entrySet : priorityQueue) {
            res[i++] = entrySet.getKey();
        }
        return res;

    }
}
