package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/10/16
 * @description
 */
public class No002 {

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int res = nums.length;

        int cur = 0;

        while (cur < res) {
            if (nums[cur] == val) {
                nums[cur] = nums[res - 1];
                res--;
            } else {
                cur++;
            }
        }

        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
