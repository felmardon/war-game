package algo;

import java.util.List;

import model.map.Board;

public final class Minimax {
	public static Integer minimax(int currentDepth, int depth, boolean isMax, TreeNode<Board> position) {

		// Reached depth of evaluation
		if (currentDepth == depth)
			return position.getData().hashCode();
		
		List<TreeNode<Board>> children = position.getChildren();

		// Iterate through list of children nodes, and determine which is optimal for maximizing player.
		if (isMax) {
			int maxEval = Integer.MIN_VALUE;
			
			int eval = 0;

			for (TreeNode<Board> child : children) {
				eval = minimax(currentDepth + 1, depth, false, child);
				maxEval = Math.max(maxEval, eval);
			}
			
			return maxEval;
		}
		
		// Iterate through list of children nodes, and determine which is optimal for minimizing player.
		else {
			int minEval = Integer.MAX_VALUE;

			int eval = 0;

			for (TreeNode<Board> child : children) {
				eval =  minimax(currentDepth + 1, depth, true, child);
				minEval = Math.min(minEval, eval);
			}
			
			return minEval;
		}
	}
}