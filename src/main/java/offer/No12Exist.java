package offer;

/**
 * @author hwang
 * @data 2023/9/5
 * @description
 */
public class No12Exist {
    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用
     * (回溯法)
     *
     * @param board 字符矩阵
     * @param word  给定字符串
     * @return 是否存在
     */
    public boolean exist(char[][] board, String word) {
        // 数据校验
        if (null == board || null == word || board.length < 1 || board[0].length < 1) {
            return false;
        }

        // 将字符串转化为字符数组
        char[] wordArray = word.toCharArray();

        // 矩阵中任意一个位置都可以作为起点，这里从左上角开始作为起点进行遍历
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existJudge(board, wordArray, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean existJudge(char[][] board, char[] wordArray, int i, int j, int k) {
        // 行i大于矩阵行数或小于0，说明行已找完
        // 列j大于矩阵列数或小于0，说明列已找完
        // 矩阵当前位置字符与word的k位置字符不一致，说明不符合
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != wordArray[k]) {
            return false;
        }

        // k位置来到word最后一个字符，说明已经找到符合要求的字符串
        if (k == wordArray.length - 1) {
            return true;
        }

        // 因为字符不能重复使用，所以对于此次查找，找过的位置标记为空字符串，
        board[i][j] = '\0';

        // 继续查找下一个字符，分别从当前字符的上下左右四个位置查找
        // 只要有一个方向满足即可
        boolean res = existJudge(board, wordArray, i - 1, j, k + 1)
                || existJudge(board, wordArray, i + 1, j, k + 1)
                || existJudge(board, wordArray, i, j - 1, k + 1)
                || existJudge(board, wordArray, i, j + 1, k + 1);

        // 上下左右四个位置查找完成后，将当前位置字符还原，之后查找可能还会用到
        board[i][j] = wordArray[k];

        return res;
    }
}
