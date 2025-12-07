package suixianglu.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18 {

    public static void main(String[] args) {
        int[] nums={1,0,-1,0,-2,2};
        List<List<Integer>> res = fourSum(nums,0);
        for(List<Integer> list:res){
            System.out.println(list);
        }
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 剪枝处理
            if (nums[i] > target && nums[i] >= 0) {
                break;
            }
            // 对nums[i]去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 第二级剪枝
                if (nums[i] + nums[j] > target && nums[i] + nums[j] >= 0) {
                    break;	// 注意是break到上一级for循环，如果直接return result;会有遗漏
                }
                // 对nums[j]去重
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对nums[left]和nums[right]去重
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }

}
