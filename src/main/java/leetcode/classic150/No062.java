package leetcode.classic150;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hwang
 * @data 2023/11/23
 * @description
 */
public class No062 {

    public static void main(String[] args) {
        No062 no062 = new No062();
        int[] in = new int[]{9, 3, 15, 20, 7};
        int[] post = new int[]{9, 15, 7, 20, 3};

        no062.buildTree(in, post);
    }

    private static final Map<Integer, Integer> INDEX_MAP = new HashMap<>();

    /**
     * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;

        for (int i = 0; i < len; i++) {
            INDEX_MAP.put(inorder[i], i);
        }

        return buildTreeFunc(inorder, postorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode buildTreeFunc(int[] inorder, int[] postorder,
                                   int inLeft, int inRight, int postLeft, int postRight) {
        if (postLeft > postRight) {
            return null;
        }

        // 后序最后一个节点为根节点,中序通过map找到位置
        int inRootIndex = INDEX_MAP.get(postorder[postRight]);

        // 右子树的数量
        int rightChildren = inRight - inRootIndex;

        // 构建根节点
        TreeNode root = new TreeNode(postorder[postRight]);

        // 构建左子树
        root.left = buildTreeFunc(inorder, postorder,
                inLeft, inRootIndex - 1, postLeft, postRight - rightChildren - 1);
        // 构建右子树
        root.right = buildTreeFunc(inorder, postorder,
                inRootIndex + 1, inRight, postRight - rightChildren, postRight - 1);
        return root;
    }

}
