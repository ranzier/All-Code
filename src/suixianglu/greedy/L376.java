package suixianglu.greedy;

public class L376 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 5};
        System.out.println(wiggleMaxLength(nums));
    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;

        int count;
        int prevDiff = nums[1] - nums[0]; // 初始化上一次的差值方向
        if (prevDiff == 0)
            count = 1;
        else count = 2;

        for (int i = 2; i < nums.length; i++) {
            int curDiff = nums[i] - nums[i - 1]; // 当前差值，用于判断方向
            // 贪心判断：如果当前差值和上一次差值方向相反，则计入摆动序列
            if ((curDiff > 0 && prevDiff <= 0) || (curDiff < 0 && prevDiff >= 0)) {
                count++;
                prevDiff = curDiff;
            }
        }
        return count;
    }

}
