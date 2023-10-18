package leetcode.classic150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hwang
 * @data 2023/10/18
 * @description
 */
public class No016 {


    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while (j < k && nums[j] == nums[++j]) ;
                    while (j < k && nums[k] == nums[--k]) ;
                } else if (sum < 0) {
                    while (j < k && nums[j] == nums[++j]) ;
                } else {
                    while (j < k && nums[k] == nums[--k]) ;
                }
            }
        }

        return res;
    }
}
