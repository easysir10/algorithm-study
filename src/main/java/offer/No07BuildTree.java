package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hwang
 * @data 2023/9/4
 * @description
 */
public class No07BuildTree {

    /**
     * 先序遍历数组
     */
    int[] preorder;

    /**
     * 中序遍历位置字典
     */
    Map<Integer, Integer> indexMap = new HashMap<>();


    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder 先序
     * @param inorder  中序
     * @return 根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return recur(0, 0, inorder.length - 1);
    }

    public TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }

        TreeNode rootNode = new TreeNode(preorder[root]);
        int i = indexMap.get(preorder[root]);
        rootNode.left = recur(root + 1, left, i - 1);
        rootNode.right = recur(root + (i - left) + 1, i + 1, right);

        return rootNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
