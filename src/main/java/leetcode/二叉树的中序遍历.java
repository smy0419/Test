package leetcode;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的中序遍历 {
    public static void main(String[] args) {

    }

    /**
     * 通过递归中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorder1(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        accessTree(root, res);
        return res;
    }

    private static void accessTree(TreeNode<Integer> root, List<Integer> res) {
        if (root == null) {
            return;
        }
        accessTree(root.left, res);
        res.add(root.val);
        accessTree(root.right, res);
    }

    /**
     * 通过循环+栈中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorder2(TreeNode<Integer> root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

}
