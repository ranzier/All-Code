package suixianglu.array;

public class L209 {

    /*
    输入：target = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    // 滑动窗口
    // 从初始位置开始滑动遍历找到总和大于target的结束位置
    // 然后再逐步移动初始位置缩小窗口，找到总和大于target的最小窗口
    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, sum = 0, len = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) { // 移动窗口的结束位置
            sum += nums[j];
            while (sum >= target) { // 移动窗口的初始位置
                len = Math.min(len, j - i + 1); // 记录最小窗口的长度
                sum -= nums[i];
                i++;
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
