public class L2428 {
    public int maxSum(int[][] grid) {
        int maxSum = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j]
                        + grid[i + 2][j + 1] + grid[i + 2][j + 2];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
