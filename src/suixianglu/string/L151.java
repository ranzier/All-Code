package suixianglu.string;

public class L151 {

    public static void main(String[] args) {
        String s = " the  sky is blue ";
        System.out.println(reverseWords(s));
    }


    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        String[] strings = new String[s.length()];
        int left = 0, right = 0, i = 0, j = 0;

        // 找出每个字符串存入到strings[]数组中
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            left = i;
            while (i < s.length() && s.charAt(i) != ' ') {
                right = i;
                i++;
            }
            String word = sb.substring(left, right + 1);
            strings[j] = word;
            j++;
        }

        // 从后往前拼接结果的字符串
        sb = new StringBuilder();
        for (int k = j - 1; k >= 0; k--) {
            sb.append(strings[k]);
            if (k != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
