package leetcode.sort;

import java.time.Period;

/**
 * @author hwang
 * @data 2023/2/28
 * @description 小和问题
 */
public class SmallSum {

    public static void main(String[] args) {
        System.out.println(process(new int[]{1, 3, 4, 2, 5}, 0, 4));
    }

    private static int process(int[] arr, int low, int high) {
        if (low == high) {
            return 0;
        }

        int mid = low + ((high - low) >> 1);

        return process(arr, low, mid)
                + process(arr, mid + 1, high)
                + merge(arr, low, mid, high);
    }

    private static int merge(int[] arr, int low, int mid, int high) {
        int[] tmpArr = new int[high - low + 1];
        int i = 0;
        int p1 = low;
        int p2 = mid + 1;
        int sum = 0;

        while (p1 <= mid && p2 <= high) {
            sum += arr[p1] < arr[p2] ? (high - p2 + 1) * arr[p1] : 0;
            tmpArr[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            tmpArr[i++] = arr[p1++];
        }
        while (p2 <= high) {
            tmpArr[i++] = arr[p2++];
        }

        for (i = 0; i < tmpArr.length; i++) {
            arr[low + i] = tmpArr[i];
        }

        return sum;
    }
}
