package de.mhoelzl.training.ox;

import de.mhoelzl.training.ox.game.Dictionary;
import de.mhoelzl.training.ox.game.Game;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = null;
        Game game = new Game(dictionary);

        System.out.println("Starting a new game.");
        game.startNewGame();
        do {
            game.step();
        } while (!game.isGameDecided());
        System.out.println("Done.");
    }
}
