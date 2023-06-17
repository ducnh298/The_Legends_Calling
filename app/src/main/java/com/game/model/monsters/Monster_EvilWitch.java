package com.game.model.monsters;

import com.game.model.Monster;

public class Monster_EvilWitch extends Monster {
    public Monster_EvilWitch(double difficultRate) {
        super("Evil Witch", 9, 0, 1, difficultRate);
    }

    @Override
    public void loseHP(int amount) {
        monsterCurrentHP -= amount;
        if (monsterCurrentHP < 1)
            monsterCurrentHP = 1;
    }
}
