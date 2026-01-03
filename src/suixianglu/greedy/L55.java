package suixianglu.greedy;

public class L55 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int far = 0; // 最远能到哪
        int i = 0;
        while (i <= far) {
            far = Math.max(far, i + nums[i]);
            if (far >= nums.length - 1)
                return true;
            i++; //只要还可以走，就继续往前走一步
        }
        return false;
    }
}
