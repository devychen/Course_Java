import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * @author mkz (ex source code)
 * TASK: complet the missing codes based on Class BinaryTreeNode and source code
 * 
 */


public class BinaryTree<T> {

    BinaryTreeNode<T> root;

    /**
     * Creates an empty binary tree.
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Creates a binary tree with a binary tree node as its root
     *
     * @param aRoot the root of the tree
     */
    BinaryTree(BinaryTreeNode<T> aRoot) {
        root = aRoot;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the root of the new tree
     */
    public BinaryTree(T element) {
        root = new BinaryTreeNode<T>(element);
    }

    /**
     * Constructs a binary tree from the two specified binary trees.
     *
     * @param element      the root of the new tree
     * @param leftSubtree  the left branch
     * @param rightSubtree the right branch
     */
    public BinaryTree(T element, BinaryTree<T> leftSubtree,
                      BinaryTree<T> rightSubtree) {

        root = new BinaryTreeNode<T>(element);

        if (leftSubtree != null) {
            root.left = leftSubtree.root;
        } else {
            root.left = null;
        }

        if (rightSubtree != null) {
            root.right = rightSubtree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * Removes the left subtree of this binary tree.
     */
    public void removeLeftSubtree() {
        if (root != null) {
            root.left = null;
        }
    }

    /**
     * Removes the right subtree of this binary tree.
     */
    public void removeRightSubtree() {
        if (root != null) {
            root.right = null;
        }
    }

    /**
     * Deletes all nodes from this binary tree.
     */
    public void removeAllElements() {
        root = null;
    }

    /**
     * Check if the tree is empty.
     *
     * @return true if this binary tree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Turn this tree into a mirror image of itself
     */
    public void mirror() {
        mirror(root);
    }

    /**
     * Helper method for mirror().
     *
     * @param node the node to be mirrored
     */
    private void mirror(BinaryTreeNode<T> node) {

        if (node == null) {
            return;
        }

        // mirror left and right subtrees
        mirror(node.left);
        mirror(node.right);

        // swap left and right subtrees
        BinaryTreeNode<T> tmp = node.left; // note: 中转保存leftSubtree的值
        node.left = node.right;
        node.right = tmp;
    }

    /**
     * Check if the tree contains the target element.
     *
     * @param targetElement the element to look for
     * @return true if this tree contains the target element
     */
    public boolean contains(T targetElement) {
        return findNode(root, targetElement) != null;
    }

    /**
     * Find and return an element in the tree.
     *
     * @param targetElement the element to look for
     * @return a reference to the specified target element if it is found in this binary tree.
     * @throws NoSuchElementException if the target element is not found in the binary tree.
     */
    public T find(T targetElement) throws NoSuchElementException {
        BinaryTreeNode<T> foundNode = findNode(root, targetElement);
        if (foundNode == null) {
            throw new NoSuchElementException();
        }
        return foundNode.element;
    }

    /**
     * A common helper method to find a node containing the target element.
     *
     * @param node          the current node to start searching from
     * @param targetElement the element to look for
     * @return the BinaryTreeNode that contains the target element, or null if not found
     */
    private BinaryTreeNode<T> findNode(BinaryTreeNode<T> node, T targetElement) {
        // Base case: the node is null, return null (element not found)
        if (node == null) {
            return null;
        }

        // If current node has the target element, return the node
        if (node.element.equals(targetElement)) {
            return node;
        }

        // Recursively search in left subtree
        BinaryTreeNode<T> leftResult = findNode(node.left, targetElement);
        if (leftResult != null) { // If the target is found in the left subtree, return the leftResult
            return leftResult;
        }

        // Recursively search in right subtree if not found in left subtree
        return findNode(node.right, targetElement); // Return the result of searching in the right subtree
    }

    /**
     * Generate a string representation of the tree
     * as a bracketed expression
     *
     * @return a bracketed representation of this binary tree.
     */
    public String toString() {
        return substructureToString(root);
    }

    /**
     * Helper method for generating a bracketed representation of a BinaryTreeNode and its child nodes.
     */
    private String substructureToString(BinaryTreeNode<T> top) {
        if (top == null) {
            return "";
        }

        StringBuilder representation = new StringBuilder();

        if (top.isLeaf()) {
            // It's a leaf. Just add the element to the string
            representation.append(" " + top.element);
        } else {
            // It's an internal node. Add a left parenthesis,
            // then the children (left then right),
            // then the right parenthesis
            representation.append(
                    " [" + top.element
                            + " " + substructureToString(top.left)
                            + " " + substructureToString(top.right)
                            + "]"
            );
        }

        //removes additional whitespace characters of nodes that have only a single child node
        return representation.toString().replace(" ]", "]");
    }

    /*
     Order: D B E A C F
     1. STACK [A,B,D] -> POP D(CUR=Null) -> RETURN D -> STACK[A,B]
     2.               -> POP B(CUR=E)    -> RETURN B -> STACK[A]
     3. PUSH E        -> POP E(CUR=Null) -> RETURN E -> STACK[A]
     4.               -> POP A(CUR=C)    -> RETURN A -> STACK[]
     5. PUSH C        -> POP C(CUR=F)    -> RETURN C -> STACK[]
     6. PUSH F        -> POP F(CUR=Null) -> RETURN C -> STACK[]
     ITERATION ENDS.
     */

    /**
     * Creates an iterator which performs an in-order traversal on this binary tree.
     *
     * @return an in-order iterator on this tree.
     */
    public Iterator<T> iteratorInOrder() {
        // todo
        return new Iterator<T>() {
            private Stack<BinaryTreeNode<T>> stack = new Stack<>();
            private BinaryTreeNode<T> cur = root; // iterate starting from root

            @Override
            public boolean hasNext() {
                // there still is unvisited nodes
                return cur != null || !stack.isEmpty();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException(); // no more nodes
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left; // stop until find the leftest node
                }
                cur = stack.pop(); // null时开始弹出
                BinaryTreeNode<T> node = cur; // store this popped value
                cur = cur.right;
                return node.element;
            }

        };
    }
    /*
    Order: A B D E C F
    1. STACK[A]     -> CUR/POP=A -> PUSH C,B -> RETURN A
    2. STACK[C,B]   -> CUR/POP=B -> PUSH E,D -> RETURN B
    3. STACK[C,E,D] -> CUR/POP D -> X PUSH -> RETURN D
    4.              -> CUR/POP E -> X PUSH -> RETURN E
    5.              -> CUR/POP C -> PUSH F -> RETURN C
    6. STACK[F]     -> CUR/POP F -> X PUSH -> RETURN F
    ITERATION ENDS.
     */


    /**
     * Creates an iterator which performs a pre-order traversal on this binary tree.
     *
     * @return a pre-order iterator on this tree.
     */
    public Iterator<T> iteratorPreOrder() {
        // todo
        return new Iterator<T>() {

            Stack<BinaryTreeNode<T>> stack = new Stack<>();

            // start with root
            {
                if (root != null) stack.push(root);
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                BinaryTreeNode<T> cur = stack.pop();
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);

                return cur.element;
            }

        };
    }
    /**
     * Creates an iterator which performs a post-order traversal on this binary tree.
     *
     * @return a post-order iterator on this tree.
     */
    public Iterator<T> iteratorPostOrder() {
        // todo
        return new Iterator<T>() {
            private Stack<BinaryTreeNode<T>> stack = new Stack<>();
            private BinaryTreeNode<T> lastVisitedNode = null;
            private BinaryTreeNode<T> cur = root;

            @Override
            public boolean hasNext() {
                return cur != null || !stack.isEmpty();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();

                while (hasNext()) {
                    if (cur != null) {
                        stack.push(cur);
                        cur = cur.left;
                    } else {
                        BinaryTreeNode<T> peek = stack.peek();
                        if (peek.right != null && lastVisitedNode != peek.right)
                            cur = peek.right;
                        else {
                            stack.pop();
                            lastVisitedNode = peek;
                            return peek.element;
                        }
                    }
                }
                throw new NoSuchElementException();
            }
        };
    }
}
