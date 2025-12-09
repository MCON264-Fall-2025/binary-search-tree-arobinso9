package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private TreeNode<T> insertRecursive(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }
        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = insertRecursive(node.left, value);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, value);
        }
        // ignore duplicates for this assignment
        return node;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    // --------- Recursive Traversals ----------

    public List<T> preorderRecursive() {
        List<T> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }

    private void preorderRecursive(TreeNode<T> node, List<T> out) {
        // TODO: implement Preorder: Root -> Left -> Right
        // hint: check for null, then visit node, then recurse on left and right
        if (node == null) return;           // Stop if we hit a null node
        out.add(node.value);                // 1. Visit the current node FIRST
        preorderRecursive(node.left, out);  // 2. Then go left
        preorderRecursive(node.right, out); // 3. Then go right
    }

    public List<T> inorderRecursive() {
        List<T> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(TreeNode<T> node, List<T> out) {
        // TODO: implement Inorder: Left -> Root -> Right
        if (node == null) return;
        inorderRecursive(node.left, out);   // 1. Go left first
        out.add(node.value);                // 2. Visit the current node in the MIDDLE
        inorderRecursive(node.right, out);  // 3. Then go right
    }

    public List<T> postorderRecursive() {
        List<T> result = new ArrayList<>();
        postorderRecursive(root, result);
        return result;
    }

    private void postorderRecursive(TreeNode<T> node, List<T> out) {
        // TODO: implement Postorder: Left -> Right -> Root
        if (node == null) return;
        postorderRecursive(node.left, out);
        postorderRecursive(node.right, out);
        out.add(node.value);
    }

    // --------- Level-order (Breadth-First) ----------

    public List<T> levelOrder() {
        List<T> result = new ArrayList<>();
        // TODO: implement level-order using a Queue<TreeNode<T>>
        // 1. if root is null, return empty list
        // 2. enqueue root
        // 3. while queue not empty:
        //      - dequeue node
        //      - add node.value to result
        //      - enqueue children if not null (left then right)
        if (root == null) return result;

        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root); // Start by adding the root to the queue

        while (!queue.isEmpty()) {          // Keep going while queue has nodes
            TreeNode<T> node = queue.poll(); // Remove the FIRST node from queue
            result.add(node.value);          // Process it (add to result)
            if (node.left != null) queue.add(node.left);    // Add left child to BACK of queue
            if (node.right != null) queue.add(node.right);  // Add right child to BACK of queue
        }

        return result;
    }

    // --------- Unified API via TraversalType ----------

    public List<T> getByTraversal(TraversalType type) {
        // TODO: dispatch based on traversal type
        return switch (type) {
            case PREORDER -> preorderRecursive();
            case INORDER -> inorderRecursive();
            case POSTORDER -> postorderRecursive();
            case LEVEL_ORDER -> levelOrder();
        };
    }
}