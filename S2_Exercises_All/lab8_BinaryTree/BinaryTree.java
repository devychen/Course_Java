import java.util.Iterator;
import java.util.NoSuchElementException;


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
     * @param aRoot the root of the tree
     */
    BinaryTree(BinaryTreeNode<T> aRoot) {
        root = aRoot;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     * @param element the root of the new tree
     */
    public BinaryTree (T element) {
        root = new BinaryTreeNode<T> (element);
    }

    /**
     * Constructs a binary tree from the two specified binary trees.
     * @param element the root of the new tree
     * @param leftSubtree the left branch
     * @param rightSubtree the right branch
	 */
    public BinaryTree (T element, BinaryTree<T> leftSubtree,
                       BinaryTree<T> rightSubtree) {

        root = new BinaryTreeNode<T> (element);
      
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
        BinaryTreeNode<T> tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    /**
     * Check if the tree contains the target element.
     * @param targetElement the element to look for
     * @return true if this tree contains the target element
     */
    public boolean contains (T targetElement) {
        
 
    }
   
    /**
     * Find and return an element in the tree
     * @param targetElement the element to look for
     * @return a reference to the specified target element if it is
     * found in this binary tree.
     * @throws NoSuchElementException if the target element is not found
     * in the binary tree.
     */
    public T find(T targetElement) throws NoSuchElementException {

    }

    
   
    /**
     * Generate a string representation of the tree
     * as a bracketed expression
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
        }
        else {
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

    /**
     * Creates an iterator which performs an in-order traversal on this binary tree.
     * @return an in-order iterator on this tree.
     */
    public Iterator<T> iteratorInOrder() {
    
    }

    

    /**
     * Creates an iterator which performs a pre-order traversal on this binary tree.
     * @return a pre-order iterator on this tree.
     */
    public Iterator<T> iteratorPreOrder() {
    
    }

    
    /**
     * Creates an iterator which performs a post-order traversal on this binary tree.
     * @return a post-order iterator on this tree.
     */
    public Iterator<T> iteratorPostOrder() {
    
    }
}

