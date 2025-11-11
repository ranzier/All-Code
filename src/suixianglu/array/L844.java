package suixianglu.array;

public class L844 {

    public static void main(String[] args) {
        String s = "ab##", t = "ad##";
        System.out.println(backspaceCompare(s, t));
    }


    /*
    输入：s = "ab#c", t = "ad#c"
输出：true
解释：s 和 t 都会变成 "ac"。
     */

    // 使用双指针从后往前遍历 + 计数退格符的方式模拟最终字符
    public static boolean backspaceCompare(String s, String t) {

        int countS = 0, countT = 0; // 记录 s、t 中待删除的字符数量
        int pointS = s.length() - 1, pointT = t.length() - 1; // 分别指向两个字符串的尾部

        // 不断向前移动两个指针，直到比较结束
        while (true) {

            // 处理字符串 s
            while (pointS >= 0) {
                if (s.charAt(pointS) == '#') {
                    countS++; // 遇到退格符，待删除字符数量增加
                    pointS--; // 指针左移
                } else {
                    if (countS > 0) { // 遇到普通字符，但前面有退格符未处理，就跳过该字符
                        pointS--;
                        countS--; // 消耗一个退格符
                    } else break; // 没有退格符可用，说明当前字符是有效字符，停止处理 s
                }
            }

            // 处理字符串 t
            while (pointT >= 0) {
                if (t.charAt(pointT) == '#') {
                    countT++;
                    pointT--;
                } else {
                    if (countT > 0) {
                        pointT--;
                        countT--;
                    } else break;
                }
            }

            // 两个指针同时到头，说明两个字符串同时结束 → 匹配成功
            if (pointS < 0 && pointT < 0)
                break;

            // 一个结束一个没结束 → 不相等
            if ((pointS < 0 && pointT >= 0) || (pointS >= 0 && pointT < 0))
                return false;

            // 比较两个当前有效字符是否相同
            if (s.charAt(pointS) != t.charAt(pointT))
                return false;
            else {
                // 若相同，继续往前比较
                pointS--;
                pointT--;
            }
        }

        // 最终检查两个指针是否都走到 -1
        if (pointS == -1 && pointT == -1)
            return true;
        return false;
    }

}
