package algo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for TreeNode generic tree class.
 *
 * @author Test Suite
 */
public class TreeNodeTest {

    private TreeNode<String> rootNode;
    private TreeNode<String> childNode1;
    private TreeNode<String> childNode2;

    @Before
    public void setUp() {
        rootNode = new TreeNode<>("Root");
        childNode1 = new TreeNode<>("Child1");
        childNode2 = new TreeNode<>("Child2");
    }

    @Test
    public void testTreeNodeInitialization() {
        assertNotNull(rootNode);
        assertEquals("Root", rootNode.getData());
        assertNull(rootNode.getParent());
        assertNotNull(rootNode.getChildren());
        assertTrue(rootNode.getChildren().isEmpty());
    }

    @Test
    public void testTreeNodeWithParent() {
        TreeNode<String> parent = new TreeNode<>("Parent");
        TreeNode<String> child = new TreeNode<>("Child", parent);

        assertEquals("Child", child.getData());
        assertEquals(parent, child.getParent());
        assertFalse(child.isRoot());
    }

    @Test
    public void testIsRoot() {
        // Nodes without parents are roots
        assertTrue(rootNode.isRoot());
        assertTrue(childNode1.isRoot());

        // After setting a parent, it's no longer a root
        childNode1.setParent(rootNode);
        assertFalse(childNode1.isRoot());
    }

    @Test
    public void testSetAndGetData() {
        rootNode.setData("NewRoot");
        assertEquals("NewRoot", rootNode.getData());
    }

    @Test
    public void testSetAndGetParent() {
        childNode1.setParent(rootNode);
        assertEquals(rootNode, childNode1.getParent());
    }

    @Test
    public void testAddChildren() {
        rootNode.getChildren().add(childNode1);
        rootNode.getChildren().add(childNode2);

        assertEquals(2, rootNode.getChildren().size());
        assertTrue(rootNode.getChildren().contains(childNode1));
        assertTrue(rootNode.getChildren().contains(childNode2));
    }

    @Test
    public void testSetChildren() {
        java.util.List<TreeNode<String>> children = new java.util.ArrayList<>();
        children.add(childNode1);
        children.add(childNode2);

        rootNode.setChildren(children);

        assertEquals(2, rootNode.getChildren().size());
        assertEquals(childNode1, rootNode.getChildren().get(0));
        assertEquals(childNode2, rootNode.getChildren().get(1));
    }

    @Test
    public void testTreeStructure() {
        // Create a complete tree structure
        rootNode.getChildren().add(childNode1);
        rootNode.getChildren().add(childNode2);

        TreeNode<String> grandChild = new TreeNode<>("GrandChild", childNode1);
        childNode1.getChildren().add(grandChild);

        // Verify structure
        assertEquals(2, rootNode.getChildren().size());
        assertEquals(1, childNode1.getChildren().size());
        assertEquals(0, childNode2.getChildren().size());
        assertEquals(childNode1, grandChild.getParent());
    }

    @Test
    public void testGenericType() {
        TreeNode<Integer> intNode = new TreeNode<>(42);
        assertEquals(Integer.valueOf(42), intNode.getData());

        TreeNode<Double> doubleNode = new TreeNode<>(3.14);
        assertEquals(Double.valueOf(3.14), doubleNode.getData());
    }

    @Test
    public void testNullData() {
        TreeNode<String> nullNode = new TreeNode<>();
        assertNull(nullNode.getData());

        nullNode.setData("SetValue");
        assertEquals("SetValue", nullNode.getData());
    }
}

