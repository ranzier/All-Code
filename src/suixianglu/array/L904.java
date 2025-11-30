package suixianglu.array;

import java.util.HashMap;
import java.util.Map;

public class L904 {
    public static void main(String[] args) {
        int[] fruits = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(totalFruit(fruits));
    }


    // 找一个最长连续子数组，满足子数组中至多有两种数字
    public static int totalFruit(int[] fruits) {
        // 哈希表存储<水果的种类, 该种类的个数>
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0, res = 0;

        // 滑动窗口用结束位置(窗口的右边界)做循环
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // 此时种类大于2个，就要重新确定开始位置(窗口的左边界)
            while (map.size() > 2) {
                res = Math.max(res, right - left);

                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]); // 移除表中个数为0的种类，让哈希表中只有两个种类
                }
                left++;
            }
        }
        res = Math.max(res, fruits.length - left);
        return res;
    }

}
