package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/24
 * @description
 */
public class No029 {

    /**
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     * <p>
     * 你需要按照以下要求，给这些孩子分发糖果：
     * <p>
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int len = ratings.length;

        int[] left = new int[len];

        // 从左向右分，右大于左，则右边比左边多一个
        for (int i = 0; i < len; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int res = 0;
        int right = 0;
        // 从右向左分
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            res += Math.max(left[i], right);
        }

        return res;
    }
}
