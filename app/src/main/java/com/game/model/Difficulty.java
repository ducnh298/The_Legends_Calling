package com.game.model;

public enum Difficulty {

    EASY(1),

    MEDIUM(1.2),

    HARD(1.5),

    EXTREMEHARD(2);

    private final double value;

    Difficulty(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
