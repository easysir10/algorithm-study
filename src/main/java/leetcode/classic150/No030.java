package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/24
 * @description
 */
public class No030 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;

        int left = 0;
        int leftMax = 0;
        int right = height.length - 1;
        int rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left++];
            } else {
                res += rightMax - height[right--];
            }
        }

        return res;
    }
}
