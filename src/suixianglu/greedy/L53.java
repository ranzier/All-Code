package suixianglu.greedy;

public class L53 {
    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int count = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (count < 0) // 只要前面的和拉低了后面的和，就不要前面的和了
                count = 0;
            count += nums[i];
            res = Math.max(res, count);
        }
        return res;
    }
}
