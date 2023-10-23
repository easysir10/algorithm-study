package leetcode.study;

import java.io.*;

/**
 * @author hwang
 * @data 2023/8/3
 * @description
 */
public class TestMain {
    public static void main(String[] args) throws IOException {

        int f1 = 0, f2 = 1, f3 = 1;

        while (true) {
            if (800 >= f1 * f2 && 800 < f2 * f3) {
                System.out.println(f1 + "," + f2);
                break;
            }
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }


    }
}
