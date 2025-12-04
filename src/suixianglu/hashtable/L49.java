package suixianglu.hashtable;

import java.util.*;

public class L49 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);

        for (List<String> list : res) {
            for (String str : list) {
                System.out.print(str + ",");
            }
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        // map存储：<字符串，与该字符串相同的所有字母异位词>
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // 对字符串排序，方便比较是否相同
            String sortStr = new String(chars);

            if (map.containsKey(sortStr)) {
                List<String> list = map.get(sortStr);
                list.add(str);
            } else {
                List<String> list1 = new ArrayList<>();
                list1.add(str);
                map.put(sortStr, list1);
            }
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
