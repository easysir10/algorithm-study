package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/16
 * @description
 */
public class No004 {


    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int p1 = 1, p2 = 2;

        while (p2 < nums.length) {
            if (nums[p2] != nums[p1] || (nums[p2] == nums[p1] && nums[p2] != nums[p1 - 1])) {
                nums[++p1] = nums[p2];
            }
            p2++;
        }

        return p1 + 1;
    }
}
