package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/17
 * @description
 */
public class No010 {

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {

        // 跳跃次数
        int jumpTimes = 0;
        // 可达最远下标
        int maxIndex = 0;
        // 当前跳跃下最远下标
        int endIndex = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);

            // 当前跳跃结束
            if (i == endIndex) {
                endIndex = maxIndex;
                jumpTimes++;
            }
        }

        return jumpTimes;
    }
}
