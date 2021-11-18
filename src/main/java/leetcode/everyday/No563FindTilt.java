package leetcode.everyday;

/**
 * @author hwang
 * @date 2021/11/18
 * @description 二叉树的坡度
 */
public class No563FindTilt {
    private static int ans = 0;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node1, node2);
        System.out.println(findTilt(root));
    }

    /**
     * 计算二叉树的坡度
     * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
     *
     * @param root 根节点
     * @return 二叉树的坡度
     */
    public static int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    public static int dfs(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int sumLeft = dfs(node.left);
        int sumRight = dfs(node.right);
        ans += Math.abs(sumLeft - sumRight);
        return sumLeft + sumRight + node.val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}