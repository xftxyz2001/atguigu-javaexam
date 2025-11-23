public class L3663 {

    public static void main(String[] args) {
        new L3663().getLeastFrequentDigit(723344511);
    }
    
    public int getLeastFrequentDigit(int n) {
        int[] count = new int[10];
        while (n > 0) {
            int rem = n % 10;
            count[rem]++;
            n /= 10;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if (count[i] == 0) continue;
            if (count[i] < min) {
                min = count[i];
            }
        }
        int index = -1;
        for (int i = 0; i < 10; i++) {
            if (count[i] == min) {
                index = i;
                break;
            }
        }
        return index;
    }
}
