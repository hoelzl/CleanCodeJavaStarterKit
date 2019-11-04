package de.mhoelzl.dice;

public interface Dice {
    /// Roll the dice and return the result
    int roll();

    /// Return the minimal value that roll() can return
    int minValue();

    /// Return the maximal value that roll() can return
    int maxValue();
}
