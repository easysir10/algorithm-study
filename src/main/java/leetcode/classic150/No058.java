package leetcode.classic150;

/**
 * @author hwang
 * @data 2023/11/22
 * @description
 */
public class No058 {

    /**
     * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if ((p == null || q == null) || p.val != q.val) return false;

        return isSameTree(p.left, q.left) & isSameTree(p.right, q.right);
    }
}
