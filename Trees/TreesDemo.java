class TreesDemo {
    TreeNode root;

    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;

        if (p.val < node.val && q.val < node.val) {
            return lowestCommonAncestor(node.left, p, q);
        } else if (p.val > node.val && q.val > node.val) {
            return lowestCommonAncestor(node.right, p, q);
        }

        return node;
    }

    public static void main(String[] args) {
        TreesDemo tree = new TreesDemo();
        tree.root = new TreeNode(6);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(0);
        tree.root.left.right = new TreeNode(4);
        tree.root.right.left = new TreeNode(7);
        tree.root.right.right = new TreeNode(9);

        TreeNode p = tree.root.left;
        TreeNode q = tree.root.left.right;

        TreeNode lca = tree.lowestCommonAncestor(tree.root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
