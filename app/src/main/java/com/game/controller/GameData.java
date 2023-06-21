package com.game.controller;

import com.game.model.Armor;
import com.game.model.Effect;
import com.game.model.Monster;
import com.game.model.Player;
import com.game.model.Spell;
import com.game.model.Weapon;
import com.game.model.effect.Effect_Paralyzed;
import com.game.model.effect.Effect_Poisonous;

import java.io.Serializable;

public class GameData implements Serializable {
    double difficultRate = 1;
    public Player player;
    public Weapon fist;
    public Armor ironArmor, silverArmor, goldenArmor;
    public Spell selectedSpell, fireStorm, lightningBolt, waterSurge, poisonBreeze;
    public Effect paralyzedEffect = new Effect_Paralyzed();
    public Effect poisonousEffect = new Effect_Poisonous();

    public Monster goblin, wolf, evilWitch, riverMonster, shadowSerpent, demonGeneral;

    public String position, lastPosition;
    public boolean timeLoop, isTakenKnife, isTakenCoins, isAngryGuard, isOpenTownGate, isMeetDarkCave,
            isBorrowSword, isKnownTownSewer,  isRestAtTent, isTakenCoinsInTent, isTakenLongSword, isTakenPower,
            blackSmithQuestActive, isTakenTorch, isLightTorch, isTakenArmor,
            witchQuestActive, isTakenGoblinEar, isTakenApple,
            isAliveWolf, isALiveGoblin, isALiveRiverMonster, isDefeatedEvilWitch, isAliveShadowSerpent, isAliveDemonGeneral;
    public int youngManRequestReward, appleOnTree, coinsOnTree;

    public GameData(double difficultRate) {
        this.difficultRate = difficultRate;
        setup(false);
    }

    public void setup(boolean timeLoop) {
        this.timeLoop = timeLoop;
        player = new Player(25);

        isTakenKnife = isTakenCoins = isAngryGuard = isOpenTownGate = isMeetDarkCave = isBorrowSword = isKnownTownSewer = isTakenLongSword = isTakenPower = false;
        isRestAtTent = isTakenCoinsInTent = blackSmithQuestActive = isTakenTorch = isLightTorch = isTakenArmor = false;
        witchQuestActive = isTakenGoblinEar = isTakenApple = isDefeatedEvilWitch = false;
        isAliveWolf = isALiveGoblin = isALiveRiverMonster = isAliveShadowSerpent = isAliveDemonGeneral = true;
        youngManRequestReward = 0;
        appleOnTree = 3;
        coinsOnTree = 2;
    }
}
