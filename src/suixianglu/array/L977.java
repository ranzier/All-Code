package suixianglu.array;

import java.util.Arrays;

public class L977 {

    /*
    输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
     */

    public static void main(String[] args) {
        //int[] nums={-4,-1,0,3,10};
        int[] nums = {-5, -4, -3, -2};
        int[] array = sortedSquares(nums);
        System.out.println(Arrays.toString(array));
    }


    // 双指针分别记录数组的左右端元素，谁的平方更大，谁就赋入新建数组的最后一个元素
    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] array = new int[nums.length]; //新创建一个数组用于记录结果
        int point = right;

        // 将更大的平方的值赋值到新数组的最后一个位置
        while (point >= 0) {
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                array[point] = nums[right] * nums[right];
                right--;
            } else {
                array[point] = nums[left] * nums[left];
                left++;
            }
            point--;
        }

        return array;
    }


}
