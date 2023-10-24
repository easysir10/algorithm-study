package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/24
 * @description
 */
public class No028 {


    /**
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * <p>
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * <p>
     * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        int index = 0;

        // 油箱余量
        int remain = 0;
        // 油箱最大亏空
        int minRemain = Integer.MAX_VALUE;

        // 寻找油箱最大亏空的地方即为出发点
        for (int i = 0; i < len; i++) {
            remain += gas[i] - cost[i];

            if (remain < minRemain) {
                minRemain = remain;
                index = i;
            }
        }

        // 油箱的油一直够用，则返回0
        if (minRemain > 0) return 0;

        return remain < 0 ? -1 : (index + 1) % len;
    }
}
