import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @desc
 * @auth hwang
 * @date 2025/4/22 20:20
 */
public class TestMain {
    public static void main(String[] args) {

    }

    /**
     * 最长回文子串
     * @param s 原字符串
     * @return 最长的回文子串
     */
    public String longestPalindrome(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int start = 0;
        int maxLen = 1;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i + 1) < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    /**
     * 寻找两个正序数组的中位数
     * @param nums1 nums1
     * @param nums2 nums2
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (null == nums1 || null == nums2) {
            return 0;
        }
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int l1 = nums1.length;
        int l2 = nums2.length;
        int leftTotal = (l1 + l2 + 1) / 2;

        int left = 0;
        int right = l1;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = leftTotal - i;

            int num1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
            int num1RightMin = i == l1 ? Integer.MAX_VALUE : nums1[i];
            int num2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
            int num2RightMin = j == l2 ? Integer.MAX_VALUE : nums2[j];

            if (num1LeftMax <= num2RightMin && num2LeftMax <= num1RightMin) {
                if ((l1 + l2) % 2 == 0) {
                    return (Math.max(num1LeftMax, num2LeftMax) + Math.min(num1RightMin, num2RightMin)) / 2.0;
                } else {
                    return Math.max(num1LeftMax, num2LeftMax);
                }
            } else if (num1LeftMax > num2RightMin) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        throw new IllegalArgumentException("输入数组不合法");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                map.put(nums[i], new LinkedList<>());
            }
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[] {map.get(nums[start]).pop(), map.get(nums[end]).pop()};
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[2];
    }
}
