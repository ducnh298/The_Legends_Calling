package com.game.model.spells;

import com.game.model.Spell;

public class Spell_FireStorm extends Spell {
    public Spell_FireStorm() {
        super("Fire Storm", 7, 3);
        description = "Scorching the monster, deal " + damage + " damage.";
    }

    @Override
    public void activeEffect() {
    }
}
