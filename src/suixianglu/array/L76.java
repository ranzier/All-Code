package suixianglu.array;

import java.util.HashMap;
import java.util.Map;

public class L76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    /**
     * 滑动窗口：先移动右边界，当条件满足时，再缩小左边界
     * 使用两个哈希表分别存放字符串 t 和 滑动窗口的字符串 window
     */
    public static String minWindow(String s, String t) {
        int len = Integer.MAX_VALUE, left = 0, flag = 0, resLeft = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 初始化 map 为 t 中字符出现次数
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(map.get(c))) {
                    flag++; // 当前字符满足要求
                }
            }

            // 尝试收缩左边界
            while (flag == map.size()) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    resLeft = left;
                }

                char d = s.charAt(left);
                if (map.containsKey(d)) {
                    if (window.get(d).equals(map.get(d))) {
                        flag--; // 当前字符不再满足
                    }
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(resLeft, resLeft + len);
    }


}
