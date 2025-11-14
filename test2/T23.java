import java.util.Arrays;

public class T23 {
    public static void main(String[] args) {
        new T23().numRescueBoats(new int[] { 3, 8, 4, 9, 2, 2, 7, 1, 6, 10, 6, 7, 1, 7, 7, 6, 4, 4, 10, 1 }, 10);
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        boolean[] used = new boolean[people.length];
        int cnt = 0;

        for (int i = people.length - 1; i >= 0; i--) {
            if (used[i]) {
                continue;
            }
            cnt++; // 需要一艘船
            used[i] = true; // 第i个人上船
            int r = limit - people[i]; // 还可以载重
            int index = Arrays.binarySearch(people, r+1); // 找一个最重的上去
            if (index < 0) {
                index = Math.min(-index - 1, people.length - 1);
            }
            for (int j = index; j >= 0; j--) {
                if (used[j] || r < people[j]) {
                    continue;
                }
                used[j] = true;
                break;
            }
        }

        return cnt;

    }
}
