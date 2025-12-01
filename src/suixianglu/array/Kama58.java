package suixianglu.array;

import java.util.Scanner;

public class Kama58 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[n];
        int[] preSum = new int[n];

        // 前缀和
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            preSum[i] = array[i];
            if (i > 0) {
                preSum[i] = preSum[i - 1] + array[i];
            }
        }

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum;
            if (a == 0) {
                sum = preSum[b];
            } else {
                sum = preSum[b] - preSum[a - 1];
            }
            System.out.println(sum);
        }
    }
}
