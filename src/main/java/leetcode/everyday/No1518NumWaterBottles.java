package leetcode.everyday;

/**
 * @author hwang
 * @date 2021/12/17
 * @description 换酒问题
 */
public class No1518NumWaterBottles {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(2, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        while (numBottles >= numExchange) {
            result += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return result;
    }
}
