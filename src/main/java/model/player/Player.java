package model.player;

import model.map.Board;
import java.util.Random;

public class Player {
    private int id;
    private String name;
    private Board.Color color;
    private AIStrategy aiStrategy;

    private static final String[] RANDOM_NAMES = {
        "Alex", "Jordan", "Taylor", "Morgan", "Casey",
        "Riley", "Quinn", "Avery", "Blake", "Skyler"
    };

    public Player() {
        Random rand = new Random();
        this.id = rand.nextInt(10000);
        this.name = RANDOM_NAMES[rand.nextInt(RANDOM_NAMES.length)];
        this.color = Board.Color.values()[rand.nextInt(Board.Color.values().length)];
        this.aiStrategy = new RandomAIStrategy();
    }

    public Player(int id, String name, Board.Color color, AIStrategy aiStrategy) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.aiStrategy = aiStrategy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board.Color getColor() {
        return color;
    }

    public void setColor(Board.Color color) {
        this.color = color;
    }

    public AIStrategy getAiStrategy() {
        return aiStrategy;
    }

    public void setAiStrategy(AIStrategy aiStrategy) {
        this.aiStrategy = aiStrategy;
    }
}
