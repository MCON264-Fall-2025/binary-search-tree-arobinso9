package bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TraversalExercises {

    // Iterative preorder using a stack
    public static <T extends Comparable<T>> List<T> preorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        //root, left, right
        // TODO: implement iterative preorder using Deque as a stack
        // Hint: push root; while stack not empty:
        //   pop node, visit it, then push right child, then left child
        if (root == null) return result;

        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop();
            result.add(node.value);
            // Push right first so left is processed first (LIFO)
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return result;
    }

    // Iterative inorder using a stack
    public static <T extends Comparable<T>> List<T> inorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // Order: Left → Root → Right
        // TODO: implement iterative inorder
        // Hint: use a pointer 'curr' and a stack:
        //   while (curr != null || !stack.isEmpty()) { ...}
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> curr = root;
        while (curr != null || !stack.isEmpty()) {
            // Go to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // curr is now null, pop from stack
            curr = stack.pop();
            result.add(curr.value);
            // Visit the right subtree
            curr = curr.right;
        }
        return result;
    }

    // Optional / challenge: iterative postorder
    public static <T extends Comparable<T>> List<T> postorderIterative(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO (challenge): implement iterative postorder
        // You may use two stacks, or one stack with a previous-node pointer.
        if (root == null) return result;

        Deque<TreeNode<T>> stack1 = new ArrayDeque<>();
        Deque<TreeNode<T>> stack2 = new ArrayDeque<>();

        stack1.push(root);
        // Fill stack2 with postorder sequence
        while (!stack1.isEmpty()) {
            TreeNode<T> node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        // Pop from stack2 to get postorder
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().value);
        }
        return result;
    }

    // Practice version of level-order
    public static <T extends Comparable<T>> List<T> levelOrderUsingQueue(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        // TODO: implement BFS using a Queue<TreeNode<T>>
        if (root == null) return result;

        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<T> node = queue.poll();
            result.add(node.value);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;

    }
}

