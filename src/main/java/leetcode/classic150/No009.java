package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/17
 * @description
 */
public class No009 {

    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     * (找到可以跳到的最远位置)
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        // 可以到达的最远位置
        int maxIndex = 0;

        // 遍历找出可达的最远位置
        for (int i = 0; i < nums.length; i++) {

            if (i > maxIndex) return false;

            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return true;
    }
}
