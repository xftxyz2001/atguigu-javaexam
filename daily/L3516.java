public class L3516 {
    public int findClosest(int x, int y, int z) {
        int xz = Math.abs(x - z);
        int yz = Math.abs(y - z);
        if (xz == yz) {
            return 0;
        } else if (xz < yz) {
            return 1;
        } else {
            return 2;
        }
    }
}
