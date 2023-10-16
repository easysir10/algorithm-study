package offer;

import entity.TreeNode;

/**
 * @author hwang
 * @data 2023/9/8
 * @description
 */
public class No26IsSubStructure {

    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * @param A A树
     * @param B B树
     * @return B是否是A的子树
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) return false;

        boolean res = false;

        // 根节点值相同，向下比较
        if (A.val == B.val) {
            res = isSubCore(A, B);
        }

        // 根节点值不同，比较左子树
        if (!res) {
            res = isSubStructure(A.left, B);
        }

        // 根节点值不同，且左子树不符合，比较右子树
        if (!res) {
            res = isSubStructure(A.right, B);
        }

        return res;
    }

    public boolean isSubCore(TreeNode A, TreeNode B) {
        if (null == B) return true;
        if (null == A || (A.val != B.val)) return false;

        return isSubCore(A.left, B.left) && isSubCore(A.right, B.right);
    }
}
