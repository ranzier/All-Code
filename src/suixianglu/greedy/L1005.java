package suixianglu.greedy;

import java.util.Arrays;

public class L1005 {
    public static void main(String[] args) {
        int[] nums={4,2,3};
        System.out.println(largestSumAfterKNegations(nums,1));
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        // 1. 先把负数翻成正数
        for (int i = 0; i < nums.length && k > 0 && nums[i] < 0; i++) {
            nums[i] = -nums[i];
            k--;
        }

        // 2. 如果 k 还剩奇数次，翻绝对值最小的数
        if (k % 2 == 1) {
            int minIndex = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i;
                }
            }
            nums[minIndex] = -nums[minIndex];
        }

        // 3. 求和
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }

}
