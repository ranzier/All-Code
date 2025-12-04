package suixianglu.hashtable;

import java.util.*;

public class L350 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1, 3, 5}, nums2 = {2, 2};
        int[] res = intersect(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + ",");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Integer num : map1.keySet()) {
            if (map2.containsKey(num)) {
                int sum = Math.min(map1.get(num), map2.get(num));
                while (sum > 0) {
                    list.add(num);
                    sum--;
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        // 统计 nums1 频次
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        // 遍历 nums2，直接在 map 中“消耗”
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
