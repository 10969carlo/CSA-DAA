# TreesDemo - Lowest Common Ancestor in a Binary Search Tree

## Overview

This Java program demonstrates how to find the **Lowest Common Ancestor (LCA)** of two nodes in a **Binary Search Tree (BST)**. The **LCA** of two nodes `p` and `q` is defined as the lowest node in the tree that has both `p` and `q` as descendants.

### Key Methods

1. **lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q)**:
   - This method finds the lowest common ancestor of nodes `p` and `q` in the binary search tree. It does so by leveraging the properties of a BST where:
     - All nodes to the left of a node have smaller values.
     - All nodes to the right of a node have larger values.
   - The algorithm compares the values of `p`, `q`, and the current node:
     - If both `p` and `q` are smaller than the current node, the LCA must be in the left subtree.
     - If both `p` and `q` are larger than the current node, the LCA must be in the right subtree.
     - If one node is smaller and the other is larger, the current node is the LCA.

2. **main(String[] args)**:
   - This method creates a sample binary search tree and finds the lowest common ancestor of two specific nodes (`p` and `q`).

## Algorithm

### Lowest Common Ancestor (LCA) Algorithm:

1. **Input**: A binary search tree with a root node, and two nodes `p` and `q`.
2. **Process**:
   - Start from the root node.
   - If both `p` and `q` are smaller than the current node, the LCA lies in the left subtree, so recursively search the left subtree.
   - If both `p` and `q` are larger than the current node, the LCA lies in the right subtree, so recursively search the right subtree.
   - If one of `p` or `q` is smaller and the other is larger, the current node is the LCA.
3. **Output**: The lowest common ancestor node.

### Example Walkthrough

1. **Binary Search Tree Construction**:
   The binary search tree is constructed as follows:
         6
       /   \
      2     8
     / \   / \
    0   4 7   9
1- Root node is 6.
- Left child of 6 is 2.
- Right child of 6 is 8.
- Left child of 2 is 0.
- Right child of 2 is 4.
- Left child of 8 is 7.
- Right child of 8 is 9.

2. **Finding the LCA of nodes 2 and 4**:
- Starting from the root node 6:
  - 2 is smaller than 6, so move to the left child (node 2).
  - 4 is larger than 2, so move to the right child of 2 (node 4).
  - Since 2 and 4 are descendants of node 2, the LCA is node 2.

The output will be:

## Code

```java
class TreeNode {
 int val;
 TreeNode left, right;

 // Constructor to initialize a tree node
 TreeNode(int val) {
     this.val = val;
     this.left = this.right = null;
 }
}

class TreesDemo {
 TreeNode root;

 // Method to find the lowest common ancestor of nodes p and q
 public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
     if (node == null) return null;
     
     // If both p and q are smaller, LCA is in the left subtree
     if (p.val < node.val && q.val < node.val) {
         return lowestCommonAncestor(node.left, p, q);
     } 
     // If both p and q are larger, LCA is in the right subtree
     else if (p.val > node.val && q.val > node.val) {
         return lowestCommonAncestor(node.right, p, q);
     }

     // If one is smaller and the other is larger, we found the LCA
     return node;
 }

 // Main method to test the LCA functionality
 public static void main(String[] args) {
     TreesDemo tree = new TreesDemo();
     
     // Creating a sample binary search tree
     tree.root = new TreeNode(6);
     tree.root.left = new TreeNode(2);
     tree.root.right = new TreeNode(8);
     tree.root.left.left = new TreeNode(0);
     tree.root.left.right = new TreeNode(4);
     tree.root.right.left = new TreeNode(7);
     tree.root.right.right = new TreeNode(9);

     // Nodes to find the LCA of
     TreeNode p = tree.root.left; // Node 2
     TreeNode q = tree.root.left.right; // Node 4

     // Finding and printing the LCA of nodes 2 and 4
     TreeNode lca = tree.lowestCommonAncestor(tree.root, p, q);
     System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
 }
}
