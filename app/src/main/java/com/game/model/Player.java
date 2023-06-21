package com.game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player implements Serializable {
    private int playerHP;
    private int playerMaxHP;
    private int baseAttack = 0;
    private List<Weapon> weaponList = new ArrayList<>();
    private Armor armor;
    private List<Spell> spellList = new ArrayList<>();
    private List<Effect> effectList = new LinkedList<>();
    private int coins = 0;

    public Player(int playerMaxHP) {
        this.playerMaxHP = this.playerHP = playerMaxHP;
    }

    public Player(int playerMaxHP, int baseAttack) {
        this.playerMaxHP = this.playerHP = playerMaxHP;
        this.baseAttack = baseAttack;
        this.spellList = null;
        this.armor = null;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public int getPlayerMaxHP() {
        return playerMaxHP;
    }

    public void increasePlayerMaxHP(int hpIncrease) {
        playerHP += hpIncrease;
        playerMaxHP += hpIncrease;
    }

    public void restoreHP(int amount) {
        playerHP += amount;
        if (playerHP > playerMaxHP)
            playerHP = playerMaxHP;
    }

    public void loseHP(int amount) {
        playerHP -= amount;
        if (playerHP < 0)
            playerHP = 0;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void increaseBaseAttack(int baseAttackIncreased) {
        baseAttack += baseAttackIncreased;
    }

    public List<Weapon> getWeaponList() {
        return weaponList;
    }

    public void removeWeapon(Weapon weapon) {
        weaponList.remove(weapon);
    }

    public void addWeapon(Weapon weapon) {
        weaponList.add(weapon);
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void removeArmor() {
        this.armor = null;
    }

    public List<Spell> getSpellList() {
        return spellList;
    }

    public void addSpell(Spell spell) {
        spellList.add(spell);
    }

    public List<Effect> getEffectList() {
        return effectList;
    }

    public void addEffect(Effect effect) {
        effectList.add(effect);
    }

    public void removeEffect(Effect effect) {
        this.effectList.remove(effect);
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int numberOfCoins) {
        coins += numberOfCoins;
    }

    public boolean removeCoins(int numberOfCoins) {
        if (coins >= numberOfCoins) {
            coins -= numberOfCoins;
            return true;
        } else return false;
    }
}
