import java.util.Arrays;

public class L3668 {
    public int[] recoverOrder(int[] order, int[] friends) {
        int[] res = new int[friends.length];
        int k = 0;
        for (int i = 0; i < order.length; i++) {
            if (Arrays.binarySearch(friends, order[i]) >= 0) {
                res[k++] = order[i];
            }
            if (k == res.length) {
                break;
            }
        }
        return res;
    }
}
