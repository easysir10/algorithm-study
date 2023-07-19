package leetcode.sort;

/**
 * @author hwang
 * @data 2023/7/12
 * @description 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {

    }

    private static void radixSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    /**
     * 计算数组中最大值有几位数
     *
     * @param arr 给定数组
     * @return 位数
     */
    private static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE;

        // 找出数组中最大值
        for (int num : arr) {
            max = Math.max(max, num);
        }

        // 计算最大值位数
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }

        return res;
    }

    private static void radixSort(int[] arr, int l, int r, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        int[] bucket = new int[r - l + 1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = l; i <= r; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }

            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for (i = r; i >= l; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            for (i = l, j = 0; i <= r; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    private static int getDigit(int num, int d) {
        return ((num / ((int) Math.pow(10, d - 1))) % 10);
    }
}
