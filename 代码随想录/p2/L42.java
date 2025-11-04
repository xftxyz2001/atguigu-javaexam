public class L42 {
    public int trap(int[] height) {
        int length = height.length;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        // maxLeft[0] = height[0];
        maxLeft[0] = 0;
        for (int i = 1; i < length; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }
        // maxRight[length - 1] = height[length - 1];
        maxRight[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i + 1], maxRight[i + 1]);
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) {
                sum += count;
            }
        }

        return sum;
    }
}
