import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @desc
 * @auth hwang
 * @date 2025/4/22 20:20
 */
public class TestMain {
    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        System.out.println(Arrays.toString(testMain.searchRange(new int[] {1}, 1)));
    }

    /**
     * 最长公共子序列
     * @param text1 text1
     * @param text2 text2
     * @return 最长 公共子序列 的长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        return 0;
    }

    /**
     * 判断子序列
     */
    public boolean isSubsequence(String s, String t) {
        if (null == s || s.isEmpty()) {
            return true;
        }
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = t.indexOf(s.charAt(0));
        for (int i = 1; i < n; i++) {
            dp[i] = -1;
        }

        for (int i = 1; i < n; i++) {
            if (dp[i - 1] == -1) {
                return false;
            }
            char c = s.charAt(i);
            for (int j = dp[i - 1] + 1; j < t.length(); j++) {
                if (t.charAt(j) == c) {
                    dp[i] = j;
                    break;
                }
            }
        }
        return dp[n - 1] != -1;
    }

    /**
     * 最小路径和
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);

            }
        }

        return dp[n - 1];
    }

    /**
     * 不同路径2
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }

    /**
     * 打家劫舍
     * @param nums 房间金额
     * @return 最高金额
     */
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = Math.max(dp[1], nums[2] + dp[0]);

        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return Math.max(dp[nums.length - 1], dp[nums.length - 2]);
    }

    /**
     * 使用最小花费爬楼梯
     * @param cost 每一级台阶花费
     * @return 最小花费
     */
    public int minCostClimbingStairs(int[] cost) {
        int one = cost[0];
        int two = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int cur = Math.min(one, two) + cost[i];
            one = two;
            two = cur;
        }
        return Math.min(one, two);
    }

    /**
     * 爬楼梯
     * @param n 楼梯数
     * @return 爬楼梯的方案数
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 不同路径
     * @param m 网格长
     * @param n 网格宽
     * @return 路径数
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }

    /**
     * 二叉树中序遍历
     * @param root 根节点
     * @return 遍历结果
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    /**
     * 在排序数组中查找元素的第一个和最后一个值位置
     * @param nums 数组
     * @param target 目标值
     * @return 第一个和最后一个值位置
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[] {-1, -1};
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                for (int i = mid; i >= left; i--) {
                    if (nums[i] != target) {
                        break;
                    }
                    res[0] = i;
                }
                for (int i = mid; i <= right; i++) {
                    if (nums[i] != target) {
                        break;
                    }
                    res[1] = i;
                }
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    /**
     * 删除排序链表中的重复元素
     * @param head 链表头节点
     * @return 删除后的链表头节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 二分查找
     * @param x 数字
     * @return 舍去小数部分的算数平方根
     */
    public int mySqrt(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (x / mid == mid) {
                return mid;
            } else if (x / mid > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    /**
     * 搜索插入的位置
     * @param nums 数字数组
     * @param target 目标值
     * @return 插入的位置索引
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 电话号码的字母组合
     * @param digits 数字字符串
     * @return 所有的组合
     */
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (null == digits || digits.isEmpty()) {
            return res;
        }
        letterCombinationsBack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void letterCombinationsBack(String digits, int index, StringBuilder sb, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = phoneMap.get(digits.charAt(index));
        for (char c : letters.toCharArray()) {
            sb.append(c);
            letterCombinationsBack(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static final Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    /**
     * 最接近的三数之和
     * @param nums 数字数组
     * @param target 目标值
     * @return 与目标值最接近的三个数的和
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

    /**
     * 括号生成
     * @param n 括号对数
     * @return 可能生成的括号情况
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesisBack(res, new StringBuilder(), n, n);
        return res;
    }

    private void generateParenthesisBack(List<String> res, StringBuilder sb, int lNum, int rNum) {
        if (lNum == 0 && rNum == 0) {
            res.add(sb.toString());
            return;
        }
        if (lNum > 0) {
            sb.append('(');
            generateParenthesisBack(res, sb, lNum - 1, rNum);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (rNum > lNum) {
            sb.append(')');
            generateParenthesisBack(res, sb, lNum, rNum - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 四数之和
     * @param nums 数字数组
     * @param target 目标值
     * @return 满足条件的数组
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int m = j + 1;
                int n = nums.length - 1;
                while (m < n) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[m] + (long)nums[n];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while (m < n && nums[m] == nums[++m])
                            ;
                        while (m < n && nums[n] == nums[--n])
                            ;
                    } else if (sum < target) {
                        while (m < n && nums[m] == nums[++m])
                            ;
                    } else {
                        while (m < n && nums[n] == nums[--n])
                            ;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 两两交换链表中的节点
     * @param head 头节点
     * @return 交换后的头节点
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode tmpNode = head.next.next;
        head.next.next = head;
        head.next = swapPairs(tmpNode);

        return newHead;
    }

    /**
     * 字符串转换整数
     * @param s 字符串
     * @return 转换后的整数
     */
    public int myAtoi(String s) {
        // 去除前后空格
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();

        // 判断符号
        int flag = 1;
        int i = 0;
        char first = chars[0];
        if (first == '-' || first == '+') {
            i = 1;
            flag = first == '-' ? -1 : 1;
        }

        int res = 0;
        for (; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }
            int num = chars[i] - '0';
            if (res > (Integer.MAX_VALUE - num) / 10) {
                return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + num;
        }

        return flag * res;
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
