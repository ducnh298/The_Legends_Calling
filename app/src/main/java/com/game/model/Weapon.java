package com.game.model;

import java.io.Serializable;

public abstract class Weapon implements Serializable {
    private String name;
    private int attackDamage;
    private int criticalAttackDamage;
    private int value;
    private int enhanceCost;
    private boolean canUpgrade = true;

    protected Weapon(String name, int attackDamage, int criticalAttackDamage, int value) {
        this.name = name;
        this.attackDamage = attackDamage;
        this.criticalAttackDamage = criticalAttackDamage;
        this.canUpgrade = false;
    }

    protected Weapon(String name, int attackDamage, int criticalAttackDamage, int value, int enhanceCost) {
        this.name = name;
        this.attackDamage = attackDamage;
        this.criticalAttackDamage = criticalAttackDamage;
        this.enhanceCost = enhanceCost;
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

    public int getValue() {
        return value;
    }

    public int getEnhanceCost() {
        return enhanceCost;
    }

    public boolean canUpgrade() {
        return canUpgrade;
    }

    public void enhanceWeapon() {
        if (canUpgrade) {
            canUpgrade = false;
            this.name = this.name + "+";
            this.attackDamage++;
            this.criticalAttackDamage++;
            this.value += enhanceCost;
        }
    }
}
