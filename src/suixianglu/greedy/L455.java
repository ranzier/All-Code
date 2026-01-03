package suixianglu.greedy;

import java.util.Arrays;

public class L455 {
    public static void main(String[] args) {
        int[] g = {1, 2}, s = {1, 2, 3};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = g.length - 1;
        int j = s.length - 1;
        int count = 0;

        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) { // 满足条件
                count++;
                i--;
                j--;
            } else {
                i--; // 当前孩子太贪，只能换小一点的孩子
            }
        }
        return count;
    }

}
