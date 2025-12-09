1. Why does inorder traversal of a BST return elements in sorted order?
Inorder traversal visits nodes in the order: Left → Root → Right. 
In a Binary Search Tree, all values in the left subtree are smaller than the node's value, 
and all values in the right subtree are larger. By visiting the left subtree first, then the node,
then the right subtree, we naturally visit smaller values before larger values. This pattern holds 
recursively at every level, resulting in values being visited in ascending (sorted) order.

2. Give an example of an insertion order that produces a highly unbalanced BST. What does the inorder traversal look like for that tree?
Example insertion order: 1, 2, 3, 4, 5
This creates a tree that looks like a linked list
The inorder traversal of this tree is: [1, 2, 3, 4, 5] — still sorted, 
but the tree is completely unbalanced (all nodes have only right children).

3. explain the differences between:
Recursive vs Iterative Traversal
Recursive: Uses the call stack automatically. Each function call handles one node and recursively calls itself on children. 
Simpler to write and understand, but uses more memory (one stack frame per node in the worst case).
Iterative: Uses an explicit data structure (stack or queue) to manage nodes instead of relying on function calls.
More memory-efficient in some cases and avoids potential stack overflow, but requires more code to manage the data structure manually.

Depth-First vs Breadth-First Traversal
Depth-First (DFS): Explores as far down one branch as possible before backtracking. 
Uses a stack. Examples: preorder, inorder, postorder. Good for problems where you need to process 
entire paths or parent-child relationships.
Breadth-First (BFS): Explores all nodes at the current level before moving to the next level.
Uses a queue. Examples: level-order traversal. Good for finding shortest paths, processing nodes by 
distance from root, or level-based problems.

4. When might you prefer a breadth-first traversal in a real application?
Level-by-level processing — like printing a tree level by level, or finding the width of a tree
Searching for nodes at a specific depth — you can stop once you reach that level
Network broadcasting — spreading information to nearest nodes first before farther ones
Social networks — finding people at a specific degree of separation from a user