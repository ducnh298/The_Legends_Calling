package com.game.model;

import java.io.Serializable;

public abstract class Armor implements Serializable {
    private String name;
    private int damageReduced;
    private String hexColorCode;

    protected Armor(String name, int damageReduced, String hexColor) {
        this.name = name;
        this.damageReduced = damageReduced;
        this.hexColorCode = hexColor;
    }

    public String getName() {
        return name;
    }

    public int getDamageReduced() {
        return damageReduced;
    }

    public String getHexColorCode() {
        return hexColorCode;
    }
}
