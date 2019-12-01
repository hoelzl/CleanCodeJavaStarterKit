package de.mhoelzl.training.ox.game;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;

class GameTest {

    // What test seems to be missing here?
    @Test
    @DisplayName("startNewGame() sets the game state to 'In Progress'")
    void startNewGameSetsGameState() {
        Game unit = new Game(null);
        unit.startNewGame();
        assertThat(unit.getGameState(), equalTo(GameState.IN_PROGRESS));
    }

    @Test
    @DisplayName("step() causes ...")
    @Disabled
    void step() {
        // What tests should we write for step()?
        fail();
    }

    @Test
    @DisplayName("isGameDecided() returns false when game is not yet started.")
    @Disabled
    void isGameDecided() {
        Game unit = new Game(null);
        assertThat(unit.isGameDecided(), equalTo(false));
    }
}