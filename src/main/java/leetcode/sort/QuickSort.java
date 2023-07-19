package leetcode.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author hwang
 * @data 2023/7/12
 * @description
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 9, 2, 3, 7, 4, 6, 5, 1, 8, 5};

        process(arr, 0, 10);
        System.out.println(Arrays.toString(arr));
    }

    private static void process(int[] arr, int l, int r) {
        if (l < r) {
            // 使用数组中随机位置的值作为基准值
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);

            // 获取等于区的左右边界值
            int[] p = partition(arr, l, r);

            // 递归处理大于区和小于区的数据
            process(arr, 0, p[0] - 1);
            process(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int low = l - 1;
        int high = r;

        while (l < high) {
            if (arr[l] < arr[r]) {
                swap(arr, l++, ++low);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --high);
            } else {
                l++;
            }
        }

        // 最后一个值为基准值，需要把基准值交换至等于区
        swap(arr, high, r);

        return new int[]{++low, high};
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
