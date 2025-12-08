package suixianglu.string;

import java.util.Scanner;

public class Kama54 {

    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        System.out.println(reverseNumber(s));
    }

    public static String reverseNumber(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
                StringBuilder sb1 = new StringBuilder(sb.substring(0, i));
                StringBuilder sb2 = new StringBuilder(sb.substring(i + 1, sb.length()));
                sb = sb1.append("number").append(sb2);
                i += 5;
            }
        }
        return sb.toString();
    }


}
