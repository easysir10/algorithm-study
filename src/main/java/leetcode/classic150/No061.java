package leetcode.classic150;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hwang
 * @data 2023/11/23
 * @description
 */
public class No061 {
    private static final Map<Integer, Integer> INDEX_MAP = new HashMap<>();

    /**
     * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;

        for (int i = 0; i < len; i++) {
            INDEX_MAP.put(inorder[i], i);
        }

        return buildTreeFunc(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private TreeNode buildTreeFunc(int[] preorder, int[] inorder,
                                   int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // 先序第一个节点为根节点,中序通过map找到位置
        int inRootIndex = INDEX_MAP.get(preorder[preLeft]);

        // 左子树的数量
        int leftChildren = inRootIndex - inLeft;

        // 构建根节点
        TreeNode root = new TreeNode(preorder[preLeft]);

        // 构建左子树
        root.left = buildTreeFunc(preorder, inorder,
                preLeft + 1, preLeft + leftChildren, inLeft, inRootIndex - 1);
        // 构建右子树
        root.right = buildTreeFunc(preorder, inorder,
                preLeft + leftChildren + 1, preRight, inRootIndex + 1, inRight);
        return root;
    }
}
