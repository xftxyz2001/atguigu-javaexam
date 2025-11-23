import java.util.PriorityQueue;

class RecentCounter {

    private PriorityQueue<Integer> pq;

    public RecentCounter() {
        this.pq = new PriorityQueue<>();
    }

    public int ping(int t) {
        pq.add(t);
        while (pq.peek() < t - 3000) {
            pq.poll();
        }
        return pq.size();
    }
}