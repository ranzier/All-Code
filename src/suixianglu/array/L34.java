package suixianglu.array;

import java.util.Arrays;

public class L34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        // 数组不存在或者为空
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        // target在数组左右边界之外
        int left = nums[0], right = nums[nums.length - 1];
        if (target > right || target < left)
            return new int[]{-1, -1};

        // target在数组左右边界之内
        int resLeft = searchLeft(nums, target);   //寻找左边界
        int resRight = searchRight(nums, target); //寻找右边界
        return new int[]{resLeft, resRight};
    }

    // 寻找左边界
    public static int searchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) { //找到target的时候，记录当前的左边界，继续寻找左边界的左边是否还有target
                res = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    // 寻找右边界
    public static int searchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) { //找到target的时候，记录当前的右边界，继续寻找右边界的右边是否还有target
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }

}