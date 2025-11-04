import java.util.Comparator;
import java.util.PriorityQueue;

public class L1049 {

    public static void main(String[] args) {
        new L1049().lastStoneWeightII(new int[] { 31, 26, 33, 21, 40 });
    }

    public int lastStoneWeightII(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            Integer poll1 = queue.poll();
            Integer poll2 = queue.poll();
            if (poll1 > poll2) {
                queue.add(poll1 - poll2);
            }
        }
        if (queue.isEmpty()) {
            return 0;
        }
        return queue.poll();
    }
}
