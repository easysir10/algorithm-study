package offer;

import entity.TreeNode;

/**
 * @author hwang
 * @data 2023/9/8
 * @description
 */
public class No28IsSymmetric {

    /**
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。
     * 如果一棵二叉树和它的镜像一样，那么它是对称的。
     *
     * @param root 根节点
     * @return 是否对称树
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricCore(root, root);
    }

    public boolean isSymmetricCore(TreeNode rootA, TreeNode rootB) {
        if (null == rootA && null == rootB) return true;

        if ((null == rootA || null == rootB) || (rootA.val != rootB.val)) return false;

        return isSymmetricCore(rootA.left, rootB.right) && isSymmetricCore(rootA.right, rootB.left);
    }
}
