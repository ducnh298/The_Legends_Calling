package com.game.model.spells;

import com.game.model.effect.Effect_Paralyzed;

public class Spell_LightningBolt extends Spell {
    public Spell_LightningBolt() {
        super("Lightning Bolt", 2, 3);
        description = "Deal " + damage + " damage and momentarily stun the monster.";
        activeEffect();
    }

    @Override
    public void activeEffect() {
        effect = new Effect_Paralyzed();
    }
}
