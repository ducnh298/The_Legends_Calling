package com.game.model.effect;

import com.game.model.Effect;

public class Effect_Paralyzed extends Effect {
    public Effect_Paralyzed() {
        super("Paralyzed", 1, 0);
        descriptionToMonster = "The lightning power courses through the monster, leaving it paralyzed and unable to launch any further attacks against you.";
    }
}
