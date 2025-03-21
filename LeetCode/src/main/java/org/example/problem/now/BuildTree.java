package org.example.problem.now;

import org.example.problem.common.TreeNode;

import java.util.HashMap;

public class BuildTree {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    /**
     * 递归创建二叉树
     * @param root 需要构建的树的前序序列的根节点下标
     * @param left 需要构建的树的中序遍历的序列起始下标
     * @param right 需要构建的树的中序遍历的序列结束下标
     * @return 构建好的树
     */
    TreeNode recur(int root, int left, int right) {
        if (left > right)
            return null; // 递归终止
        TreeNode node = new TreeNode(preorder[root]); // 建立根节点
        int i = dic.get(preorder[root]); // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1); // 开启左子树递归
        node.right = recur(root + (i - left) + 1, i + 1, right); // 开启右子树递归 (加上(i-left)是为了跳过左子树的元素，加一就是下一个子树的root)
        return node; // 回溯返回根节点
    }
}
