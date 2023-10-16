package offer;

import entity.TreeNode;

/**
 * @author hwang
 * @data 2023/9/8
 * @description
 */
public class No27MirrorTree {

    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * @param root 树根节点
     * @return 镜像树根节点
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) return null;

        mirrorTreeCore(root);

        return root;
    }

    public void mirrorTreeCore(TreeNode root) {
        if (null != root) {
            // 交换左右子树
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;

            // 处理左子树
            mirrorTreeCore(root.left);
            // 处理右子树
            mirrorTreeCore(root.right);
        }
    }
}
