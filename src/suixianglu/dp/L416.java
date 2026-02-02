package suixianglu.dp;

public class L416 {
    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // 不选当前数
                if (j >= num) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - num]; // 选当前数
                }
            }
        }

        return dp[nums.length][target];
    }

}
