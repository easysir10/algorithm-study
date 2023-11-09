package leetcode.classic150;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hwang
 * @data 2023/11/9
 * @description
 */
public class No045 {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int res = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int curRes = 1;
                while (set.contains(n + 1)) {
                    n++;
                    curRes++;
                }
                res = Math.max(res, curRes);
            }
        }

        return res;
    }
}
