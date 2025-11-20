public class QMS3 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            // for (int j = i + 1; j < heights.length; j++) {
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                if (minHeight <= 0) {
                    break;
                }
                maxArea = Math.max(maxArea, (j - i + 1) * minHeight);
            }
        }
        return maxArea;
    }
}
