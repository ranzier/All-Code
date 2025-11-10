package suixianglu.array;

public class L26 {
/*
输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4,_,_,_,_,_]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 */

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }

    // 双指针
    public static int removeDuplicates(int[] nums) {
        int slow = 1, cur = nums[0]; // 慢指针记录返回的数组

        // 快指针判断当前元素是否重复
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != cur) {
                nums[slow] = nums[fast];
                slow++;
                cur = nums[fast];
            }
        }
        return slow;
    }
}
