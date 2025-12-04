package suixianglu.hashtable;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class L349 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1,3,5}, nums2 = {2,2};
        int[] res=intersection(nums1,nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+",");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        // 使用HashSet集合去重
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        // 找出set1集合中在set2集合中没有的元素，并删除它
        Iterator<Integer> it = set1.iterator();
        while (it.hasNext()) {
            Integer num = it.next();
            if (!set2.contains(num)) {
                it.remove();
            }
        }

        int[] res = new int[set1.size()];
        int i = 0;
        for (Integer num : set1) {
            res[i] = num;
            i++;
        }
        return res;
    }
}
