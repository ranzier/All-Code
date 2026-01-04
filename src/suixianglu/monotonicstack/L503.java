package suixianglu.monotonicstack;

import java.util.*;

public class L503 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] res = nextGreaterElements(nums);
        for (int i : res)
            System.out.print(i + ",");
    }

    public static int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        Arrays.fill(result, -1);//默认全部初始化为-1
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < 2 * size; i++) {
            while (!st.empty() && nums[i % size] > nums[st.peek()]) {
                result[st.peek()] = nums[i % size];
                st.pop();
            }
            st.push(i % size);
        }

        return result;
    }
}
