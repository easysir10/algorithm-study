/**
 * 双指针算法题
 *
 * @author hu.wang
 * @date 2026-03-03
 */
public class DoublePointerMain {

    public String compressString(String S) {
        if (null == S || S.length() <= 1) {
            return S;
        }
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                sb.append(S.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        if (sb.length() <= S.length()) {
            sb.append(S.charAt(S.length() - 1)).append(count);
            return sb.toString();
        } else {
            return S;
        }
    }

}
