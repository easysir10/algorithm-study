package leetcode.everyday;

/**
 * @author hu.wang
 * @date 2025-11-17
 */
public class No136 {

    public static void main(String[] args) {
        No136 no136 = new No136();
        System.out.println(no136.singleNumber(new int[] {2, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
