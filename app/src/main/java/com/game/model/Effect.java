package com.game.model;

import java.io.Serializable;

public abstract class Effect implements Serializable {
    protected String name;
    protected int remain;
    protected int damage;
    protected String descriptionToMonster;
    protected String descriptionToPlayer;

    protected Effect(String name, int remain, int damage) {
        this.name = name;
        this.remain = remain;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getRemain() {
        return remain;
    }

    public void reduceRemain() {
        remain--;
    }

    public int getDamage() {
        return damage;
    }

    public String getDescriptionToMonster() {
        return descriptionToMonster;
    }

    public String getDescriptionToPlayer() {
        return descriptionToPlayer;
    }
}
