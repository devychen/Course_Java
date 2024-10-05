package dsa2_st9;

import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class BinaryTreeTest extends TestCase {

    private BinaryTree<String> buildBinaryTree() {
    
        // Build your tree, order matters
		BinaryTree<String> s, np1, d1, n1, nn1, vp, v, np2, d2, n2, nn2;

        d1 = new BinaryTree<String>("D");
        nn1 = new BinaryTree<String>("NN");
        v = new BinaryTree<>("V");
        d2 = new BinaryTree<>("D");
        nn2 = new BinaryTree<>("NN");

        n2 = new BinaryTree<>("N", nn2, null);
        np2 = new BinaryTree<>("NP", d2, n2);
        vp = new BinaryTree<>("VP", v, np2);
        n1 = new BinaryTree<String>("N", nn1, null);
        np1 = new BinaryTree<String>("NP", d1, n1);
        s = new BinaryTree<String>("S", np1, vp);
		
		return s;
    }
    
    /**
     * Test toString method of the BinaryTree class.
     */
    public void testBinaryTreeToString() {
        BinaryTree<String> tree = buildBinaryTree();

        String expected, actual;
        expected = "[S [NP D [N NN]] [VP V [NP D [N NN]]]]";
        actual = tree.toString();
        assertEquals(expected, actual);
    }
    
    /**
     * Test toString method of the BinaryTree class.
     */
    public void testBinaryTreeMirror() {
        BinaryTree<String> tree = buildBinaryTree();
        tree.mirror();

        String expected, actual;
        expected = "[S [VP [NP [N NN] D] V] [NP [N NN] D]]";
        actual = tree.toString();
        assertEquals(expected, actual);
    }
}
