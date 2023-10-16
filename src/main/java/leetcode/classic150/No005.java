package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/16
 * @description
 */
public class No005 {

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * (摩尔投票)
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int all = 0;
        int res = nums[0];

        for (int n : nums) {
            if (all == 0) {
                res = n;
            }
            all = all + (res == n ? 1 : -1);
        }

        return res;
    }
}
