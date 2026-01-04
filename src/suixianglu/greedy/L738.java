package suixianglu.greedy;

import java.util.ArrayList;
import java.util.List;

public class L738 {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(332));
    }

    public static int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int mark = chars.length;

        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] < chars[i - 1]) { // 如果前一个位数大于后一个位数，前者-1，后者置为9
                chars[i - 1]--;
                mark = i;
            }
        }

        for (int i = mark; i < chars.length; i++) {
            chars[i] = '9';
        }

        return Integer.parseInt(new String(chars));
    }

}
