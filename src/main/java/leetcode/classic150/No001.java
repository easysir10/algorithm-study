package leetcode.classic150;

import java.util.Arrays;

/**
 * @author hwang
 * @data 2023/10/16
 * @description
 */
public class No001 {

    public static void main(String[] args) {
        No001 no001 = new No001();

        int[] num1 = new int[]{0};
        int[] num2 = new int[]{1};
        no001.merge(num1, 0, num2, 1);
        System.out.println(Arrays.toString(num1));
    }

    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
     * 分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
     * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
     * nums2 的长度为 n 。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums1.length);
            return;
        }

        int cur = nums1.length - 1;
        m--;
        n--;

        int tmp;
        while (n >= 0) {
            tmp = nums1[cur];
            while (m >= 0 && nums1[m] > nums2[n]) {
                nums1[cur] = nums1[m];
                nums1[m] = tmp;
                m--;
                cur--;
            }
            nums1[cur] = nums2[n];
            nums2[n] = tmp;
            n--;
            cur--;
        }
    }

}
