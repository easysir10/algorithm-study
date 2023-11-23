package leetcode.classic150;

import java.util.Stack;

/**
 * @author hwang
 * @data 2023/11/23
 * @description
 */
public class No064 {


    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * <p>
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode oldRight = root.right;
                root.right = root.left;
                root.left = null;

                TreeNode tmpNode = root.right;
                while (tmpNode.right != null) {
                    tmpNode = tmpNode.right;
                }
                tmpNode.right = oldRight;
            }
            root = root.right;
        }
    }
}
