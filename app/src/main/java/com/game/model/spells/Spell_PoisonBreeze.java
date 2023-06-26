package com.game.model.spells;

import com.game.model.effect.Effect_Poisonous;

public class Spell_PoisonBreeze extends Spell {
    public Spell_PoisonBreeze() {
        super("Poison Breeze", 0, 5);
        description = "The monster is now afflicted by poison, its health gradually deteriorating as the venom courses through its body.";
        activeEffect();
    }

    @Override
    public void activeEffect() {
        effect = new Effect_Poisonous();
    }
}
