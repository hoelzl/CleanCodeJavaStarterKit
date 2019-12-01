package de.mhoelzl.training.ox.game;

public class Game {
    public Game(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    private Dictionary dictionary;

    public GameState getGameState() {
        return GameState.IN_PROGRESS;
    }

    public void startNewGame() {
    }

    public void step() {
    }

    public boolean isGameDecided() {
        return true;
    }
}
