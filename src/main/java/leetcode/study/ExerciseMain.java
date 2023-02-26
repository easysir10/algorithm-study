package leetcode.study;

/**
 * @author hwang
 * @data 2023/2/26
 * @description
 */
public class ExerciseMain {

    public static void main(String[] args) {
        System.out.println(getMax(new int[]{3, 6, 8, 2, 0, 4, 9, 5}, 0, 7));
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
}
