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
            isBorrowSword, isKnownTownSewer, isRestAtTent, isTakenCoinsInTent, isTakenLongSword, isTakenPower,
            blackSmithQuestActive, isTakenTorch, isLightTorch, isTakenArmor,
            witchQuestActive, isTakenGoblinEar, isTakenApple, isSpareWitch, isDarknessConsume,
            isAliveWolf, isALiveGoblin, isALiveRiverMonster, isDefeatedEvilWitch, isAliveShadowSerpent, isAliveDemonGeneral;
    public int youngManRequestReward, appleOnTree, coinsOnTree;

    public GameData(double difficultRate) {
        this.difficultRate = difficultRate;
        setup(false, false, false);
    }

    public void setup(boolean timeLoop, boolean isMeetDarkCave, boolean isKnownTownSewer) {
        this.timeLoop = timeLoop;
        this.isMeetDarkCave = isMeetDarkCave;
        this.isKnownTownSewer = isKnownTownSewer;
        player = new Player(25);

        isTakenKnife = isTakenCoins = isTakenTorch = isTakenLongSword = isTakenArmor = isTakenCoinsInTent = isTakenGoblinEar = isTakenApple = isTakenPower = false;
        isAngryGuard = isOpenTownGate = isLightTorch = isBorrowSword = isRestAtTent = false;
        blackSmithQuestActive = witchQuestActive = isDefeatedEvilWitch = isSpareWitch = isDarknessConsume = false;
        isAliveWolf = isALiveGoblin = isALiveRiverMonster = isAliveShadowSerpent = isAliveDemonGeneral = true;
        youngManRequestReward = 0;
        appleOnTree = 3;
        coinsOnTree = 2;
    }
}
