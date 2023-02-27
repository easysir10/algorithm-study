package leetcode.sort;

import java.util.Arrays;

/**
 * description
 *
 * @author Hu.Wang 2019/09/19 8:37
 */
public class Sort {

    public static void main(String[] args) {
        int[] array = {3, 6, 9, 0, 2, 5, 1, 4, 8, 7};
        //System.out.println("冒泡排序：");
        //System.out.println(Arrays.toString(bubbleSort(array)));

        //System.out.println("选择排序：");
        //System.out.println(Arrays.toString(selectionSort(array)));

        //System.out.println("插入排序：");
        //System.out.println(Arrays.toString(insertionSort(array)));

        //System.out.println("希尔排序：");
        //System.out.println(Arrays.toString(shellSort(array)));

        // 快速排序
        //quickSort(array, 0, 9);
        //System.out.println(Arrays.toString(array));

        // 归并排序
        mergeSort(array, 0, 9);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 冒泡排序
     *
     * @param array 输入数组
     * @return int[]
     * @author Hu.Wang 2019-09-19 9:04
     */
    private static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序
     *
     * @param array 输入数组
     * @return int[]
     * @author Hu.Wang 2019-09-19 9:04
     */
    private static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array 输入数组
     * @return int[]
     * @author Hu.Wang 2019-09-19 9:04
     */
    private static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int index = i;
            while (index >= 0 && current < array[i]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = current;
        }
        return array;
    }

    /**
     * 归并排序：分而治之，分组排序后再合并结果
     *
     * @param arr  原始数组
     * @param low  开始位置
     * @param high 结束位置
     */
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
        int[] tmpArr = new int[high - low + 1];
        int i = 0;
        int p1 = low;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= high) {
            tmpArr[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
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
    }

    /**
     * 希尔排序
     *
     * @param array 输入数组
     * @return int[]
     * @author Hu.Wang 2019-09-19 9:04
     */
    private static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    /**
     * 快速排序
     *
     * @param arr  数组
     * @param low  数组开始位置
     * @param high 数组结束位置
     */
    private static void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, high);
        }

    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        // 返回tmp的正确位置
        return low;
    }
}
