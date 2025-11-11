package suixianglu.array;

import java.util.Arrays;

public class L283 {
    /*
    输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums)
            System.out.println(num + ",");
    }

    // 双指针实现
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // 将后面的元素[slow, nums.length)填充为0
        Arrays.fill(nums, slow, nums.length, 0);
    }
}
