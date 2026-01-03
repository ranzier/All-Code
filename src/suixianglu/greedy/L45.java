package suixianglu.greedy;

public class L45 {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int count = 0;
        int curEnd = 0;     // 当前跳跃的最远边界
        int nextEnd = 0;    // 下一跳的最远边界

        for (int i = 0; i < nums.length - 1; i++) {
            nextEnd = Math.max(nextEnd, i + nums[i]);

            // 到达当前边界，需要跳一次
            if (i == curEnd) {
                count++;
                curEnd = nextEnd;
            }
        }
        return count;
    }
}
