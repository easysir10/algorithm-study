package offer;

/**
 * @author hwang
 * @data 2023/9/4
 * @description
 */
public class No11MinArray {

    public static void main(String[] args) {
        No11MinArray no11MinArray = new No11MinArray();
        int[] nums = new int[]{2, 2, 2, 0, 1};
        System.out.println(no11MinArray.minArray(nums));
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
     * 请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
     *
     * @param numbers 给定数组
     * @return 最小元素
     */
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                int min = left;
                for (int i = left + 1; i < right; i++) {
                    if (numbers[i] < numbers[min]) {
                        min = i;
                    }
                }
                return numbers[min];
            }
        }

        return numbers[left];
    }
}
