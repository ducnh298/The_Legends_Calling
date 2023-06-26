package com.game.model.monsters;

public class Monster_EvilWitch extends Monster {
    public Monster_EvilWitch(double difficultRate) {
        super("Evil Witch", 8, 0, 1, difficultRate);
    }

    @Override
    public void loseHP(int amount) {
        monsterCurrentHP -= amount;
        if (monsterCurrentHP < 1)
            monsterCurrentHP = 1;
    }
}
