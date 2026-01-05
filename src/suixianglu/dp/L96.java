package suixianglu.dp;

public class L96 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        // dp[i]: i个节点的二叉树有多少个
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        // dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}
