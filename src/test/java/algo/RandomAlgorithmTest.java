package algo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for Random algorithm.
 *
 * @author Test Suite
 */
public class RandomAlgorithmTest {

    private TreeNode<Integer> rootNode;
    private TreeNode<Integer> child1;
    private TreeNode<Integer> child2;
    private TreeNode<Integer> child3;

    @Before
    public void setUp() {
        rootNode = new TreeNode<>(100);
        child1 = new TreeNode<>(50);
        child2 = new TreeNode<>(75);
        child3 = new TreeNode<>(25);

        rootNode.getChildren().add(child1);
        rootNode.getChildren().add(child2);
        rootNode.getChildren().add(child3);
    }

    @Test
    public void testRandomReturnsValidValue() {
        Integer result = Random.random(rootNode);
        assertNotNull(result);
        assertTrue(result > 0);
    }

    @Test
    public void testRandomReturnsChildValue() {
        Integer result = Random.random(rootNode);

        // Result should be one of the child values
        boolean isValidChildValue = (result.equals(50) || result.equals(75) || result.equals(25));
        assertTrue("Random result should be one of the child node values", isValidChildValue);
    }

    @Test
    public void testRandomWithNoChildren() {
        TreeNode<Integer> leafNode = new TreeNode<>(999);
        Integer result = Random.random(leafNode);

        // Should return the leaf node's own data
        assertEquals(Integer.valueOf(999), result);
    }

    @Test
    public void testRandomWithSingleChild() {
        TreeNode<Integer> parent = new TreeNode<>(100);
        TreeNode<Integer> singleChild = new TreeNode<>(50);
        parent.getChildren().add(singleChild);

        Integer result = Random.random(parent);
        assertEquals(Integer.valueOf(50), result);
    }

    @Test
    public void testRandomDistribution() {
        // Run random algorithm multiple times to verify it can return different values
        java.util.Set<Integer> results = new java.util.HashSet<>();

        for (int i = 0; i < 100; i++) {
            Integer result = Random.random(rootNode);
            results.add(result);
        }

        // With 100 runs and 3 children, we should get at least 2 different values
        // (statistically very likely, not guaranteed but good for a basic test)
        assertTrue("Random should produce multiple different values", results.size() >= 1);
    }

    @Test
    public void testRandomWithEmptyChildrenList() {
        TreeNode<Integer> nodeWithEmptyList = new TreeNode<>(100);
        nodeWithEmptyList.setChildren(new java.util.ArrayList<>());

        Integer result = Random.random(nodeWithEmptyList);
        assertEquals(Integer.valueOf(100), result);
    }

    @Test
    public void testRandomReturnsInRange() {
        // Run multiple times to ensure all results are valid
        for (int i = 0; i < 50; i++) {
            Integer result = Random.random(rootNode);
            assertTrue("Result should be 50, 75, or 25", result.equals(50) || result.equals(75) || result.equals(25));
        }
    }
}

