package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/25
 * @description
 */
public class No039 {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int a = 0, b = 0;
        int sum;

        for (int num : nums) {
            sum = Math.max(b, a + num);
            a = b;
            b = sum;
        }
        return b;
    }
}
