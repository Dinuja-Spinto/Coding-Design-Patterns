package codingPatterns;

public class TreeDepthFirstSearch {
    public void preorderDFS(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.value + " "); // Process the current node

        preorderDFS(root.left); // Recursive DFS on the left subtree
        preorderDFS(root.right); // Recursive DFS on the right subtree
    }

    public static void main(String[] args) {
        TreeDepthFirstSearch dfs = new TreeDepthFirstSearch();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.print("Preorder DFS: ");
        dfs.preorderDFS(root);
    }
}
