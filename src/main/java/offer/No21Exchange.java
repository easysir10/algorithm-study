package offer;

/**
 * @author hwang
 * @data 2023/9/7
 * @description
 */
public class No21Exchange {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     *
     * @param nums 整数数组
     * @return 调整后数组
     */
    public int[] exchange(int[] nums) {

        if (null == nums || nums.length == 0) return new int[0];

        // 当前判定位置
        int cur = 0;
        // 奇数区终止位置
        int left = cur - 1;
        // 偶数区起始位置
        int right = nums.length;

        while (cur < right) {
            // 当前数为奇数，将当前值与奇数区后一位交换，当前指针后移
            if ((nums[cur] & 1) == 1) {
                swap(nums, cur++, ++left);
            }
            // 当前数为偶数，将当前值与偶数区前一位交换，当前指针不动
            else {
                swap(nums, cur, --right);
            }
        }

        return nums;
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

}
