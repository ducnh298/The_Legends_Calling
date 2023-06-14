package com.game.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public abstract class Monster implements Serializable {
    protected String name;
    protected int monsterMaxHP;
    protected int monsterCurrentHP;
    protected int attackDamage;
    protected int criticalAttackDamage;
    protected List<Effect> effectList = new LinkedList<>();

    protected Monster(String name, int monsterMaxHP, int attackDamage, int criticalAttackDamage, double difficultRate) {
        this.name = name;
        this.monsterMaxHP = this.monsterCurrentHP = (int) Math.ceil(monsterMaxHP * difficultRate);
        this.attackDamage = (int) Math.ceil(attackDamage * difficultRate);
        this.criticalAttackDamage = (int) Math.ceil(criticalAttackDamage * difficultRate);
    }

    public String getName() {
        return name;
    }

    public int getMonsterMaxHP() {
        return monsterMaxHP;
    }

    public void setMonsterCurrentHP(int monsterCurrentHP) {
        this.monsterCurrentHP = monsterCurrentHP;
    }

    public void restoreHP(int amount) {
        monsterCurrentHP += amount;
        if (monsterCurrentHP > monsterMaxHP)
            monsterCurrentHP = monsterMaxHP;
    }

    public void loseHP(int amount) {
        monsterCurrentHP -= amount;
        if (monsterCurrentHP < 0)
            monsterCurrentHP = 0;
    }

    public int getMonsterCurrentHP() {
        return monsterCurrentHP;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getCriticalAttackDamage() {
        return criticalAttackDamage;
    }

    public List<Effect> getEffectList() {
        return effectList;
    }

    public void addEffect(Effect effect) {
        this.effectList.add(effect);
    }

    public void removeEffect(Effect effect) {
        this.effectList.remove(effect);
    }
}
