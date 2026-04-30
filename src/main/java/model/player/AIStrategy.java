package model.player;

import model.map.Board;

/**
 * Interface for AI strategies that can be used by players in the war game.
 * Different AI algorithms (Minimax, Alpha-Beta Pruning, Random, etc.) should implement this interface.
 */
public interface AIStrategy {
    
    /**
     * Determines the next move for the AI player based on the current board state.
     * 
     * @param board The current game board state
     * @param playerId The ID of the player making the move
     * @return The chosen move or board position
     */
    Board calculateNextMove(Board board, int playerId);
    
    /**
     * Returns the name of this AI strategy.
     * 
     * @return The strategy name
     */
    String getStrategyName();
}
