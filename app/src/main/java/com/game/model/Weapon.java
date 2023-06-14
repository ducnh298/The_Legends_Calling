package com.game.model;

import java.io.Serializable;

public abstract class Weapon implements Serializable {
    private String name;
    private int attackDamage;
    private int criticalAttackDamage;

    protected Weapon(String name, int attackDamage, int criticalAttackDamage) {
        this.name = name;
        this.attackDamage = attackDamage;
        this.criticalAttackDamage = criticalAttackDamage;
    }

    public String getName() {
        return name;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getCriticalAttackDamage() {
        return criticalAttackDamage;
    }
}
