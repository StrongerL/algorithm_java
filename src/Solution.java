class Solution {
    public static boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int n = sum >> 1;
        int m = nums.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 初始化
        for (int j = 0; j <= n; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = true;
        }

        // 转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        printArray(dp);

        return dp[m][n];
    }

    public static void main(String[] args) {
        canPartition(new int[]{1, 2, 4, 5});
    }

    private static void printArray(boolean[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%-8b", nums[i][j]);
            }
            System.out.println();
        }
    }

}