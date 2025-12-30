package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class L131 {
    public static void main(String[] args) {
        String s = "abb";
        partition(s);
        for (List<String> list1 : res)
            System.out.println(list1);
    }

    static List<List<String>> res;
    static List<String> list;

    public static List<List<String>> partition(String s) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtracking(s, 0);
        return res;
    }

    public static void backtracking(String s, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String string = s.substring(start, i + 1);
            if (isHuiwen(string)) { // 是回文串才添加
                list.add(string);
                backtracking(s, i + 1);
                list.removeLast();
            }
        }
    }

    public static boolean isHuiwen(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        return true;
    }
}
