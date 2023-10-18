package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/18
 * @description
 */
public class No015 {

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;

        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }

        return res;
    }
}
