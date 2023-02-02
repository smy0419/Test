package leetcode;

public class 翻转二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode res = invertTreeNode(root);
        System.out.println(res);
    }

    public static TreeNode invertTreeNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTreeNode(root.left);
        invertTreeNode(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
