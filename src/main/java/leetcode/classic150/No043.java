package leetcode.classic150;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author hwang
 * @data 2023/11/9
 * @description
 */
public class No043 {

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     * 「快乐数」 定义为：
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n == 1) return true;

        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        while (true) {
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }

            if (sum == 1) return true;

            if (set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
                n = sum;
            }
        }
    }

}
