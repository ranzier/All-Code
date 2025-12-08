package suixianglu.string;

public class L541 {
    public static void main(String[] args) {
        String s = "abcdefg";
        String res = reverseStr(s, 2);
        System.out.println(res);
    }


    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        for (int start = 0; start < s.length(); start += 2 * k) {
            int left = start, right = 0;
            if (s.length() - start < k)
                right = s.length() - 1;
            else right = start + k - 1;

            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }


}
