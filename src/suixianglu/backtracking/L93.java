package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class L93 {
    public static void main(String[] args) {
        String s = "25525511135";
        restoreIpAddresses(s);
        System.out.println(res);
    }

    static List<String> res;
    static List<String> list;

    public static List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtracking(s, 0);
        return res;
    }

    public static void backtracking(String s, int start) {
        if (list.size() == 4 && start == s.length()) { // 四个IP，并且遍历到最后一个字符了
            StringBuilder sb = new StringBuilder();
            for (String string : list)
                sb.append(string).append(".");
            sb.deleteCharAt(sb.length() - 1);
            res.add(new String(sb));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String string = s.substring(start, i + 1);
            if (isIP(string)) {
                list.add(string);
                backtracking(s, i + 1);
                list.removeLast();
            }
        }
    }

    public static boolean isIP(String s) {
        // 长度超过 3，一定非法
        if (s.length() > 3) return false;

        // 前导 0 处理
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}
