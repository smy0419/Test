/**
 * @author sunmengyuan
 * @date 2021-08-31
 * 给定一个二叉搜索树(BST)，找到树中第 K 小的节点。
 */
public class GetTreeNode {
    public static int getKFromTreeNode(TreeNode<Integer> treeNode, int k) {
        TreeNode<Integer> currentNode = treeNode;

        return -1;
    }

    public static TreeNode generateTreeNode() {
        TreeNode<Integer> treeNode = new TreeNode<>(3);
        TreeNode<Integer> treeNode1 = new TreeNode<>(2);
        TreeNode<Integer> treeNode2 = new TreeNode<>(4);
        TreeNode<Integer> treeNode3 = new TreeNode<>(1);
        TreeNode<Integer> treeNode4 = new TreeNode<>(5);
        TreeNode<Integer> treeNode5 = new TreeNode<>(6);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode4.right = treeNode5;
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode<Integer> treeNode = generateTreeNode();
        int nodeValue = getKFromTreeNode(treeNode, 1);
        System.out.println(nodeValue);
    }
}
