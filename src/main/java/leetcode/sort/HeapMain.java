package leetcode.sort;

import java.util.*;

/**
 * @author hwang
 * @data 2023/7/12
 * @description 堆操作
 */
public class HeapMain {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 3, 7, 5};

        kProcess(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     */
    private static void heapSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }

        // 调整数组为大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        // 调整数组为大根堆，比上面方式快
        //for (int i = arr.length - 1; i >= 0; i++) {
        //    heapIfy(arr, i, arr.length);
        //}

        int heapSize = arr.length;
        // 将最大值根节点放末尾，并将heapSize减一
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            // 调整剩余元素为大根堆
            heapIfy(arr, 0, heapSize);
            // 将最大值根节点放末尾，并将heapSize减一
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元
     * 素移动的距离可以不超过k,并且k相对于数组来说比较小。请选择一个合适的
     * 排序算法针对这个数据进行排序。
     */
    private static void kProcess(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int index = 0;
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }

        int i = 0;
        for (; index < arr.length; i++, index++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }

        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }

    }

    /**
     * 调整index位置的元素位置
     *
     * @param arr   原数组
     * @param index 待调整元素位置
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapIfy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
