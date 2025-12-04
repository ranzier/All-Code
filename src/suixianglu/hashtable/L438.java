package suixianglu.hashtable;

import java.util.*;

public class L438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> list = findAnagrams(s, p);
        for (Integer index : list)
            System.out.print(index + ",");
    }


    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int start = p.length();
        char[] charsP = p.toCharArray();
        Arrays.sort(charsP);

        for (int i = start; i <= s.length(); i++) {
            String str = s.substring(i - p.length(), i);

            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            if (Arrays.equals(chars, charsP)) {
                list.add(i - p.length());
            }
        }
        return list;
    }


    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        // 1. 统计 p 中每个字符的出现次数
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 2. 滑动窗口
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;  // 记录满足 need 的字符个数

        while (right < s.length()) {
            // 3. 扩大窗口
            char c = s.charAt(right);
            right++;

            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 4. 当窗口大小 == p.length()时，开始判断并收缩
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }

                char d = s.charAt(left);
                left++;

                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }


}
