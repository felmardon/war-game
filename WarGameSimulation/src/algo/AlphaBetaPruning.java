package algo;

import java.util.List;

public final class AlphaBetaPruning {
	public static Integer alphabetapruning(int currentDepth, int depth, boolean isMax, TreeNode<Integer> position, int alpha, int beta) {
		
		// Reached depth of evaluation.
		if (currentDepth == depth)
			return position.getData();
		
		List<TreeNode<Integer>> children = position.getChildren();
		
		// Iterate through list of children nodes, and determine which is optimal for maximizing player.
		if (isMax) {
			int maxEval = Integer.MIN_VALUE;
			
			int eval = 0;
			
			for (TreeNode<Integer> child : children) {
				eval = alphabetapruning(currentDepth + 1, depth, false, child, alpha, beta);
				maxEval = Math.max(maxEval, alpha);
				alpha = Math.max(alpha, eval);
				
				if (beta <= alpha)
					break;
				
			}
			
			return maxEval;
		}
		
		// Iterate through list of children nodes, and determine which is optimal for minimizing player.
		else {
			int minEval = Integer.MAX_VALUE;
						
			int eval = 0;
			
			for (TreeNode<Integer> child : children) {
				eval = alphabetapruning(currentDepth + 1, depth, true, child, alpha, beta);
				minEval = Math.min(minEval, eval);
				beta = Math.min(beta, eval);
			}

			return minEval;
		}
	}
}