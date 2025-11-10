package suixianglu.array;

public class L35 {
    /*
    输入: nums = [1,3,5,6], target = 2
    输出: 1
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(searchInsert(nums, target));

    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                right = mid - 1;
            if (nums[mid] < target)
                left = mid + 1;
        }
        return left;
    }
}
