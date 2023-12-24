package design;

import java.util.Objects;
import java.util.Stack;

class BSTIterator {
    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (Objects.isNull(root)) return;
        stack.push(root);
        TreeNode treeNode = root;
        while (treeNode.left != null) {
            stack.push(treeNode.left);
            treeNode = treeNode.left;
        }
    }

    public int next() {
        TreeNode treeNode = stack.pop();
        int output = treeNode.val;
        if (treeNode.right != null) {
            stack.push(treeNode.right);
            treeNode = treeNode.right;
            while (treeNode.left != null) {
                stack.push(treeNode.left);
                treeNode = treeNode.left;
            }
        }
        return output;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

//  Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
