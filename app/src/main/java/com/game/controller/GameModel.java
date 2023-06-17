package com.game.controller;

import com.game.model.Armor;
import com.game.model.Effect;
import com.game.model.Monster;
import com.game.model.Player;
import com.game.model.Spell;
import com.game.model.Weapon;
import com.game.model.effect.Effect_Paralyzed;
import com.game.model.effect.Effect_Poisonous;
import com.game.model.weapons.Weapon_Fist;

import java.io.Serializable;

public class GameModel implements Serializable {
    double difficultRate = 1;
    public Player player;
    public Weapon fist, knife, longSword, trident, demonSword;
    public Armor[] armors;
    public Spell selectedSpell, fireStorm, lightningBolt, waterSurge, poisonBreeze;
    public Effect paralyzedEffect = new Effect_Paralyzed();
    public Effect poisonousEffect = new Effect_Poisonous();

    public Monster goblin, evilWitch, riverMonster, shadowSerpent, demonGeneral;

    public String position, lastPosition;
    public boolean timeLoop, isTakenKnife, isAngryGuard, isRestAtTent, isTakenLongSword, isTakenPower,
            blackSmithQuestActive, isTakenTorch, isLightTorch, isTakenArmor,
            witchQuestActive, isTakenGoblinEar, isTakenApple,
            isALiveRiverMonster, isALiveGoblin, isDefeatedEvilWitch, isAliveShadowSerpent, isAliveDemonGeneral;
    public int appleOnTree;

    public GameModel(double difficultRate) {
        this.difficultRate = difficultRate;
        setup(false);
    }

    public void setup(boolean timeLoop) {
        this.timeLoop = timeLoop;
        player = new Player(25);

        if (fist == null)
            fist = new Weapon_Fist();
        player.addWeapon(fist);

        isTakenKnife = isAngryGuard = isRestAtTent = isTakenLongSword = isTakenPower = false;
        blackSmithQuestActive = isTakenTorch = isLightTorch = isTakenArmor = false;
        witchQuestActive = isTakenGoblinEar = isTakenApple = isDefeatedEvilWitch = false;
        isALiveRiverMonster = isALiveGoblin = isAliveShadowSerpent = isAliveDemonGeneral = true;
        appleOnTree = 3;
    }
}
