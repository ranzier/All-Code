package suixianglu.array;

public class L367 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }

/*
输入：num = 16
输出：true
解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 */

    // 基本的二分查找
    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        long left = 1, right = num / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
