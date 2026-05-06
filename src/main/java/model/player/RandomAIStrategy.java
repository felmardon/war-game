package model.player;

import model.map.Board;
import java.util.Random;

/**
 * A simple AI strategy that makes random moves.
 */
public class RandomAIStrategy implements AIStrategy {

    private final Random rand;

    public RandomAIStrategy() {
        this.rand = new Random();
    }

    @Override
    public Board calculateNextMove(Board board, int playerId) {
        return board;
    }

    @Override
    public String getStrategyName() {
        return "Random";
    }
}
