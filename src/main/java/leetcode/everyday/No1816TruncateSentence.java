package leetcode.everyday;

/**
 * @author hwang
 * @data 2021/12/6
 * @description
 */
public class No1816TruncateSentence {

    public static void main(String[] args) {
        System.out.println(truncateSentence("chopper is not a tanuki", 5));
    }


    /**
     * 给你一个句子 s和一个整数 k，请你将s截断，使截断后的句子仅含 前 k个单词。返回 截断 s 后得到的句子。
     *
     * @param s 句子s
     * @param k 整数
     * @return 截断后句子
     */
    public static String truncateSentence(String s, int k) {
        String[] strings = s.split(" ");
        if (k > strings.length) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(strings[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
