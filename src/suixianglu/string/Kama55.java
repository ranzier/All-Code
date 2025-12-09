package suixianglu.string;

import java.util.Scanner;

public class Kama55 {
    public static void main(String[] args) {
        String s;
        int k;
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        s = sc.next();
        System.out.println(reverseRight1(s, k));
    }

    // 使用StringBuilder()
    public static String reverseRight(String s, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(s.length() - k, s.length())).append(s.substring(0, s.length() - k));
        return sb.toString();
    }

    // 三次反转
    public static String reverseRight1(String s, int k) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, s.length() - 1);
        reverse(chars, 0, k - 1);
        reverse(chars, k, s.length() - 1);
        return new String(chars);

    }

    public static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
