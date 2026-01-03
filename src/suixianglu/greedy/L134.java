package suixianglu.greedy;

public class L134 {
    public static void main(String[] args) {
        int[] gas = {2,3,4}, cost = {3,4,3};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;   // 全局油量差
        int cur = 0;     // 当前起点的剩余油量
        int start = 0;   // 候选起点

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            cur += diff;

            // 当前起点失败
            if (cur < 0) {
                start = i + 1;  // 起点只能在后面
                cur = 0;
            }
        }

        // 总油量不够，一定无解
        return total >= 0 ? start : -1;
    }
}
