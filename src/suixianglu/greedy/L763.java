package suixianglu.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L763 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i); // 记录每个字母最后一次出现的位置
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int curLast = map.get(c);
            end = Math.max(end, curLast); // 随时更新最终地址索引
            if (i == end) { // 到达最终地址索引
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
