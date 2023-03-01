package leetcode.study;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * @author hwang
 * @data 2023/2/26
 * @description
 */
public class ExerciseMain {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 8, 2, 0, 4, 9, 5};
        mergeSort(arr, 0, 7);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 递归方式获取数组最大值
     * master公式：T(N) = a * T(N/b) + O(N^d)
     *
     * @param arr 数组
     * @param l   左边下标
     * @param r   右边下标
     * @return 最大值
     */
    private static int getMax(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        // 中点，这种方式可以防止溢出
        int mid = l + ((r - l) >> 1);
        // 中点左边最大值
        int leftMax = getMax(arr, l, mid);
        // 中点右边最大值
        int rightMax = getMax(arr, mid + 1, r);

        return Math.max(leftMax, rightMax);
    }

    private static int[] bubbleSort(int[] array) {
        if (null == array || array.length < 2) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }

    private static int[] selectionSort(int[] array) {
        if (null == array || array.length < 2) {
            return array;
        }

        for (int i = 0; i < array.length; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int tmp = array[min];
            array[min] = array[i];
            array[i] = tmp;
        }

        return array;
    }

    private static int[] insertionSort(int[] array) {
        if (null == array || array.length < 2) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];
            int index = i;
            while (index >= 0 && current < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = current;
        }

        return array;
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }

        int mid = low + ((high - low) >> 1);

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];

        int i = 0;
        int p1 = low;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= high) {
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            tmp[i++] = arr[p1++];
        }

        while (p2 <= high) {
            tmp[i++] = arr[p2++];
        }

        for (i = 0; i < tmp.length; i++) {
            arr[low + i] = tmp[i];
        }
    }
}
