package suixianglu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class L17 {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    static List<String> res;
    static List<Character> list;
    static String[] digitsStr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtracking(digits, 0);
        return res;
    }

    public static void backtracking(String digits, int start) {
        // 终止条件
        if (digits.length() == list.size()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : list) {
                sb.append(c);
            }
            res.add(new String(sb));
            return;
        }

        String string = digitsStr[digits.charAt(start) - '2'];

        // abc是第一层，def是第二层
        for (int i = 0; i < string.length(); i++) { // abc依次for遍历
            list.add(string.charAt(i));
            backtracking(digits, start + 1); // 递归到下一层def
            list.removeLast(); // 回溯
        }
    }
}
