package suixianglu.array;

public class L69 {

    /*
    输入：x = 8
输出：2
解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     */

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }


    // 二分查找寻找平方根
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        // 平方根不会大于二分之一的X
        int left = 1, right = x / 2, ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 此时的target = x/mid，判断 mid 是否与 x/mid 相等即可
            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
