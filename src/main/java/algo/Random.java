package algo;

import java.util.List;

public final class Random {

	/**
	 * Generates a random evaluation by selecting a random child node
	 * and returning its data.
	 *
	 * @param position TreeNode containing a list of child nodes
	 * @return A random Integer value from the child nodes
	 */
	public static Integer random(TreeNode<Integer> position) {
		List<TreeNode<Integer>> children = position.getChildren();

		// If no children exist, return the current position's data
		if (children == null || children.isEmpty()) {
			return position.getData();
		}

		// Generate random index and return random child's data
		int randomIndex = (int) (Math.random() * children.size());
		return children.get(randomIndex).getData();
	}
}