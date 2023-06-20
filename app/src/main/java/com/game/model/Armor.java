package com.game.model;

import java.io.Serializable;

public abstract class Armor implements Serializable {
    private String name;
    private int damageReduced;
    private String hexColorCode;
    private int value;

    protected Armor(String name, int damageReduced, int value, String hexColor) {
        this.name = name;
        this.damageReduced = damageReduced;
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
