package suixianglu.hashtable;

import java.util.HashSet;
import java.util.Set;

public class L202 {

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    // 2,4,16,37,58,89,145,42,20,4
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (n == 1)
                return true;
            if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
                n = getSum(n);
            }
        }
    }

    // 获取每个数的平方和
    public static int getSum(int n) {
        int sum = 0;

        while (n > 9) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }

        sum += n * n;
        return sum;
    }
}
