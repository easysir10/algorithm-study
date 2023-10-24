package leetcode.classic150;

import java.util.logging.Level;

/**
 * @author hwang
 * @data 2023/10/23
 * @description
 */
public class No027 {

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * <p>
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * <p>
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        if (null == nums || nums.length == 0) return new int[0];

        int len = nums.length;

        int[] res = new int[len];
        res[0] = 1;

        // 计算下三角
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int tmp = 1;
        // 计算上三角
        for (int i = len - 2; i >= 0; i--) {
            tmp *= nums[i + 1];
            res[i] *= tmp;
        }

        return res;
    }
}
