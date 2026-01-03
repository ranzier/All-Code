package suixianglu.greedy;

import java.util.Arrays;

public class L135 {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        Arrays.fill(candys, 1);
        int sum = 0;

        // 只要右边比左边大，右边的糖果=左边 + 1
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candys[i] = candys[i - 1] + 1;
        }

        // 只要左边比右边大，左边的糖果应该取本身的糖果数（符合比它左边大）和右边糖果数 + 1 二者的最大值
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candys[i] = Math.max(candys[i], candys[i + 1] + 1);
        }

        for (int i = 0; i < candys.length; i++) {
            sum += candys[i];
        }
        return sum;
    }
}
