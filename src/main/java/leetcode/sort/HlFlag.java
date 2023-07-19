package leetcode.sort;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 *
 * @author hwang
 * @data 2023/7/12
 * @description
 */
public class HlFlag {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 9, 2, 3, 7, 4, 6, 5, 1, 8, 5};

        process(arr, 5);
        System.out.println(Arrays.toString(arr));
    }


    private static void process(int[] arr, int num) {
        // 遍历指针位置
        int i = 0;
        int len = arr.length - 1;
        // 小于区当前指针位置
        int low = i - 1;
        // 大于区当前指针位置
        int high = len + 1;

        while (i < high) {
            if (arr[i] < num) {// 当前值小于基准值，当前值与小于区下一个值交换，当前指针右移
                swap(arr, i++, ++low);
            } else if (arr[i] > num) {// 当前值大于基准值，当前值与小于区下一个值交换，当前指针不动
                swap(arr, i, --high);
            } else {// 当前值等于基准值，不做交换，当前指针右移
                i++;
            }
        }
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
