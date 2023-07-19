package leetcode.sort;

import sun.security.util.Length;

import java.util.Arrays;

/**
 * @author hwang
 * @data 2023/2/26
 * @description
 */
public class ExerciseMain {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 7, 2, 5, 9, 0, 8};
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

    private static Integer getLeftMax(int[] arr, int num) {
        int l = 0;
        int r = arr.length - 1;

        int result = -1;

        while (l < r) {
            // 中点，这种方式可以防止溢出
            int mid = l + ((r - l) >> 1);
            if (arr[mid] >= num) {
                result = mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    private static Integer getPartMin(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        // 起点满足，直接返回
        if (arr[l] < arr[l + 1]) {
            return l;
        }
        // 中点满足，直接返回
        if (arr[r] < arr[r - 1]) {
            return r;
        }

        int result = -1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > arr[mid - 1]) {
                r = mid;
            } else if (arr[mid] > arr[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return result;
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

    private static int getOddNum(int[] array) {
        int err = 0;
        for (int i : array) {
            err = err ^ i;
        }
        return err;
    }

    private static int getOddNum2(int[] array) {
        int err = 0, err2 = 0;
        for (int i : array) {
            err = err ^ i;
        }
        // 取最右边的1的位置
        int rightOne = err & (~err + 1);
        // 对数组中这个位置上是0的值进行异或，得到其中一个数
        for (int i : array) {
            if ((i & rightOne) == 0) {
                err2 = err2 ^ i;
            }
        }
        System.out.println("err:" + (err ^ err2));
        return err2;
    }
}
