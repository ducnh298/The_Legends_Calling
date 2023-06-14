package com.game.controller;

import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.game.R;
import com.game.model.Effect;
import com.game.model.Monster;
import com.game.model.Spell;
import com.game.model.Weapon;
import com.game.model.monsters.Monster_DemonKing;
import com.game.model.monsters.Monster_Goblin;
import com.game.model.monsters.Monster_RiverMonster;
import com.game.model.monsters.Monster_ShadowSerpent;
import com.game.model.spells.Spell_PoisonBreeze;
import com.game.model.weapons.Weapon_Trident;
import com.game.view.GameScreen;

import java.util.Random;

public class CombatManager {
    StoryManager storyManager;
    GameModel gameModel;
    GameScreen ui;
    SoundManager soundManager;
    private Random rand;
    private boolean encounterMonsterTurn = true;

    public CombatManager(StoryManager storyManager) {
        this.storyManager = storyManager;
        this.gameModel = storyManager.gameModel;
        this.ui = storyManager.ui;
        this.soundManager = ui.soundManager;
        this.rand = ui.rand;
    }

    public void encounterGoblin() {
        if (gameModel.goblin == null)
            gameModel.goblin = new Monster_Goblin(gameModel.difficultRate);
        if (!gameModel.position.equalsIgnoreCase("encounterGoblin")) {
            gameModel.lastPosition = gameModel.position;
            soundManager.playBattleMusic();
            soundManager.goblin();
        }
        gameModel.position = "encounterGoblin";
        Glide.with(ui).load(R.drawable.goblin).into(ui.image);
        encounterMonster(gameModel.goblin);
    }

    public void encounterEvilWitch() {
        if (gameModel.poisonBreeze == null) {
            gameModel.poisonBreeze = new Spell_PoisonBreeze();
        }
        if (!gameModel.position.equalsIgnoreCase("encounterEvilWitch")) {
            gameModel.lastPosition = gameModel.position;
            soundManager.evilWitch();
            soundManager.playBattleMusic();
            Toast.makeText(ui.getApplicationContext(), "The poison breeze slowly drains your health.", Toast.LENGTH_SHORT).show();
            gameModel.poisonBreeze.activeEffect();
            gameModel.player.addEffect(gameModel.poisonBreeze.getEffect());
        }
        gameModel.position = "encounterEvilWitch";
        ui.image.setImageResource(R.drawable.evil_witch);

        encounterMonster(gameModel.evilWitch);
    }

    public void encounterRiverMonster() {
        if (gameModel.riverMonster == null)
            gameModel.riverMonster = new Monster_RiverMonster(gameModel.difficultRate);
        if (!gameModel.position.equalsIgnoreCase("encounterRiverMonster")) {
            gameModel.lastPosition = gameModel.position;
            soundManager.playBattleMusic();
            soundManager.riverMonster();
            Toast.makeText(ui.getApplicationContext(), "You come face to face with a formidable river monster.", Toast.LENGTH_SHORT).show();
        }
        gameModel.position = "encounterRiverMonster";
        Glide.with(ui).load(R.drawable.river_monster).into(ui.image);

        encounterMonster(gameModel.riverMonster);
    }

    public void encounterShadowSerpent() {
        if (gameModel.shadowSerpent == null)
            gameModel.shadowSerpent = new Monster_ShadowSerpent(gameModel.difficultRate);
        if (!gameModel.position.equalsIgnoreCase("encounterShadowSerpent")) {
            gameModel.lastPosition = gameModel.position;
            soundManager.playBattleMusic();
            Toast.makeText(ui.getApplicationContext(), "You come face to face with a menacing shadow serpent.", Toast.LENGTH_SHORT).show();
        }
        gameModel.position = "encounterShadowSerpent";
        Glide.with(ui).load(R.drawable.shadow_serpent).into(ui.image);

        encounterMonster(gameModel.shadowSerpent);
    }

    public void encounterDemonKing() {
        if (gameModel.demonKing == null)
            gameModel.demonKing = new Monster_DemonKing(gameModel.difficultRate);
        if (!gameModel.position.equalsIgnoreCase("encounterDemonKing")) {
            gameModel.lastPosition = gameModel.position;
            soundManager.playBattleMusic();
            Toast.makeText(ui.getApplicationContext(), "You finally confront the demon king, standing face-to-face with the embodiment of evil itself.", Toast.LENGTH_SHORT).show();
        }
        gameModel.position = "encounterDemonKing";
        Glide.with(ui).load(R.drawable.demon_king).into(ui.image);

        encounterMonster(gameModel.demonKing);
    }

    public void attackGoblin(boolean useSpell) {
        if (encounterMonsterTurn && gameModel.goblin.getMonsterCurrentHP() > 0 && attackMonster(gameModel.goblin, useSpell)) {
            encounterMonster(gameModel.goblin);
        } else {
            soundManager.playBackGroundMusic();
            Toast.makeText(ui.getApplicationContext(), "You have defeated the goblin!", Toast.LENGTH_SHORT).show();
            gameModel.isALiveGoblin = false;
            gameModel.goblin = null;
            storyManager.insideGoblinCave();
        }
    }

    public void attackEvilWitch(boolean useSpell) {
        if (encounterMonsterTurn && gameModel.evilWitch.getMonsterCurrentHP() > 1 && attackMonster(gameModel.evilWitch, useSpell))
            encounterMonster(gameModel.evilWitch);
        else {
            soundManager.playBackGroundMusic();
            gameModel.evilWitch.setMonsterCurrentHP(1);
            ui.displayTextSlowly(gameModel.evilWitch.getName() + "'s HP: " + gameModel.evilWitch.getMonsterCurrentHP() + "/" + gameModel.evilWitch.getMonsterMaxHP());
            Toast.makeText(ui.getApplicationContext(), "You have defeated the Evil Witch!", Toast.LENGTH_SHORT).show();

            for (Effect effect : gameModel.player.getEffectList()) {
                if (effect.getName().equalsIgnoreCase("Poisonous")) {
                    gameModel.player.removeEffect(effect);
                    break;
                }
            }

            gameModel.isDefeatedEvilWitch = true;
            gameModel.evilWitch = null;
            storyManager.talkWitch4();
        }
    }

    public void attackRiverMonster(boolean useSpell) {
        if (encounterMonsterTurn && gameModel.riverMonster.getMonsterCurrentHP() > 0 && attackMonster(gameModel.riverMonster, useSpell))
            encounterMonster(gameModel.riverMonster);
        else {
            soundManager.playBackGroundMusic();
            ui.displayTextSlowly(gameModel.riverMonster.getName() + "'s HP: " + gameModel.riverMonster.getMonsterCurrentHP() + "/" + gameModel.riverMonster.getMonsterMaxHP());
            Toast.makeText(ui.getApplicationContext(), "Victorious against the river monster, you claim a gleaming trident as your reward.", Toast.LENGTH_SHORT).show();

            if (gameModel.trident == null)
                gameModel.trident = new Weapon_Trident();
            ui.obtainWeapon(gameModel.trident);

            gameModel.isALiveRiverMonster = false;
            gameModel.riverMonster = null;
            storyManager.selectPosition(gameModel.lastPosition);
        }
    }

    public void attackShadowSerpent(boolean useSpell) {
        if (encounterMonsterTurn && gameModel.shadowSerpent.getMonsterCurrentHP() > 0 && attackMonster(gameModel.shadowSerpent, useSpell))
            encounterMonster(gameModel.shadowSerpent);
        else {
            soundManager.playBackGroundMusic();
            ui.displayTextSlowly(gameModel.shadowSerpent.getName() + "'s HP: " + gameModel.shadowSerpent.getMonsterCurrentHP() + "/" + gameModel.shadowSerpent.getMonsterMaxHP());
            Toast.makeText(ui.getApplicationContext(), "You have defeated the shadow serpent!", Toast.LENGTH_SHORT).show();

            gameModel.isAliveShadowSerpent = false;
            gameModel.shadowSerpent = null;
            storyManager.insideDemonHideout();
        }
    }

    public void attackDemonKing(boolean useSpell) {
        if (encounterMonsterTurn && gameModel.demonKing.getMonsterCurrentHP() > 0 && attackMonster(gameModel.demonKing, useSpell))
            encounterMonster(gameModel.demonKing);
        else {
            soundManager.playBackGroundMusic();
            gameModel.isAliveDemonKing = false;
            gameModel.demonKing = null;
            storyManager.defeatDemonKing();
        }
    }

    public void encounterMonster(Monster monster) {
        ui.setChoicesAndNextPositions(new String[]{"Fight", "", "Try to run", "", gameModel.lastPosition, "", "tryToRun", ""});
        if (monster.equals(gameModel.goblin)) {
            storyManager.nextPosition1 = "attackGoblin";
            if (!gameModel.player.getSpellList().isEmpty()) {
                ui.updateSpellStatus();
                ui.choice2.setText("Use spell");
                storyManager.nextPosition2 = "attackGoblinWithSpell";
            }
        } else if (monster.equals(gameModel.riverMonster)) {
            storyManager.nextPosition1 = "attackRiverMonster";
            if (!gameModel.player.getSpellList().isEmpty()) {
                ui.updateSpellStatus();
                ui.choice2.setText("Use spell");
                storyManager.nextPosition2 = "attackRiverMonsterWithSpell";
            }
        } else if (monster.equals(gameModel.shadowSerpent)) {
            storyManager.nextPosition1 = "attackShadowSerpent";
            if (!gameModel.player.getSpellList().isEmpty()) {
                ui.updateSpellStatus();
                ui.choice2.setText("Use spell");
                storyManager.nextPosition2 = "attackShadowSerpentWithSpell";
            }
        } else if (monster.equals(gameModel.demonKing)) {
            storyManager.nextPosition1 = "attackDemonKing";
            if (!gameModel.player.getSpellList().isEmpty()) {
                ui.updateSpellStatus();
                ui.choice2.setText("Use spell");
                storyManager.nextPosition2 = "attackDemonKingWithSpell";
            }
        } else if (monster.equals(gameModel.evilWitch)) {
            storyManager.nextPosition1 = "attackEvilWitch";
            if (!gameModel.player.getSpellList().isEmpty()) {
                ui.updateSpellStatus();
                ui.choice2.setText("Use spell");
                storyManager.nextPosition2 = "attackEvilWitchWithSpell";
            }
        }

        if (encounterMonsterTurn) {
            StringBuilder monsterStatus = new StringBuilder(monster.getName() + "'s HP: " + monster.getMonsterCurrentHP() + "/" + monster.getMonsterMaxHP() + "\n");
            if (!monster.getEffectList().isEmpty())
                for (Effect effect : monster.getEffectList()) {
                    monsterStatus.append(monster.getName() + " is " + effect.getName());
                    if (effect.getRemain() > 1) {
                        monsterStatus.append(" (Remain: " + effect.getRemain() + ")");
                    }
                    monsterStatus.append("\n");
                }
            ui.displayText(monsterStatus.toString());
        } else {
            encounterMonsterTurn = true;
            ui.choice1.setText("Continue");
            ui.choice2.setText("");
            ui.choice3.setText("");
            if (monster.getMonsterCurrentHP() > 0 || (gameModel.evilWitch != null && gameModel.evilWitch.getMonsterCurrentHP() > 1)) {
                storyManager.nextPosition1 = gameModel.position;
            }
        }
        ui.setChoiceVisibility();
    }

    public boolean attackMonster(Monster monster, boolean useSpell) {
        boolean monsterAbleToAttack = true;
        Spell spell = null;
        StringBuilder text = new StringBuilder("");
        //PLAYER ATTACK
        if (useSpell) {
            spell = gameModel.player.getSpellList().get(ui.spellSpinner.getSelectedItemPosition());
            if (spell.getCoolDownRemain() > 0) {
                Toast.makeText(ui.getApplicationContext(), spell.getName() + " is not ready!", Toast.LENGTH_SHORT).show();
                encounterMonster(monster);
                return true;
            }

            text.append("You cast " + spell.getName() + ". " + spell.getDescription());
            if (spell.getDamage() > 0) {
                monster.loseHP(spell.getDamage());
                text.append(" -> " + monster.getName() + "'s HP: " + monster.getMonsterCurrentHP() + "/" + monster.getMonsterMaxHP());
            }
            if (spell.getEffect() != null) {
                spell.activeEffect();
                monster.addEffect(spell.getEffect());
            }
            if (spell.equals(gameModel.waterSurge)) {
                ui.updatePlayerHp(-spell.getDamage());
                monsterAbleToAttack = false;
            }
        } else {
            Weapon currentWeapon = gameModel.player.getWeaponList().get(ui.weaponSpinner.getSelectedItemPosition());
            int playerDamage = gameModel.player.getBaseAttack() + rand.nextInt(currentWeapon.getCriticalAttackDamage() - currentWeapon.getAttackDamage()) + currentWeapon.getAttackDamage();
            text.append("You attacked the " + monster.getName() + " with " + currentWeapon.getName() + " and gave " + playerDamage + " damage!");
            monster.loseHP(playerDamage);
            text.append(" -> " + monster.getName() + "'s HP: " + monster.getMonsterCurrentHP() + "/" + monster.getMonsterMaxHP());
        }

        if (!gameModel.player.getSpellList().isEmpty()) {
            for (Spell sp : gameModel.player.getSpellList()) {
                if (spell != null && sp.getName().equals(spell.getName()))
                    sp.resetCoolDown();
                else
                    sp.decreaseCoolDown();
            }
        }

        if (!monster.getEffectList().isEmpty())
            for (Effect effect : monster.getEffectList()) {
                text.append("\n" + effect.getDescriptionToMonster());

                if (effect.getDamage() > 0) {
                    monster.loseHP(effect.getDamage());
                    text.append(" -> " + monster.getName() + "'s HP: " + monster.getMonsterCurrentHP() + "/" + monster.getMonsterMaxHP());
                }

                if (effect.getName().equalsIgnoreCase(gameModel.paralyzedEffect.getName()))
                    monsterAbleToAttack = false;

                if (spell == null || (spell != null && !spell.getEffect().getName().equals(effect.getName()))) {
                    effect.reduceRemain();
                    if (effect.getRemain() == 0)
                        monster.removeEffect(effect);
                }
            }

        return monsterAttackTurn(monster, monsterAbleToAttack, text);
    }

    private boolean monsterAttackTurn(Monster monster, boolean monsterAbleToAttack, StringBuilder text) {
        //MONSTER ATTACK
        if (!gameModel.player.getEffectList().isEmpty())
            for (Effect effect : gameModel.player.getEffectList()) {
                text.append("\n" + effect.getDescriptionToPlayer() + " (Remain: " + effect.getRemain() + ")");

                if (effect.getDamage() > 0)
                    gameModel.player.loseHP((int) Math.floor(effect.getDamage() * gameModel.difficultRate));

                effect.reduceRemain();
                if (effect.getRemain() == 0)
                    gameModel.player.removeEffect(effect);
            }

        int monsterDamage = 0;
        if (monsterAbleToAttack) {
            monsterDamage = rand.nextInt(monster.getCriticalAttackDamage() - monster.getAttackDamage()) + monster.getAttackDamage() - (gameModel.player.getArmor() != null ? gameModel.player.getArmor().getDamageReduced() : 0);
            text.append("\nThe " + monster.getName() + " attacked you." + (gameModel.player.getArmor() != null ? (" With " + gameModel.player.getArmor().getName()) : "") + " you took " + (monsterDamage > 0 ? monsterDamage : 0) + " damage!");
        }

        ui.continueTextSlowly(text.toString());
        encounterMonsterTurn = false;
        return ui.updatePlayerHp(-monsterDamage);
    }

    public void tryToRun() {
        if (gameModel.position.equalsIgnoreCase("encounterEvilWitch") || gameModel.position.equalsIgnoreCase("talkWitch3")) {
            Toast.makeText(ui.getApplicationContext(), "Escape from the clutches of the witch proves futile as she blocks your path.", Toast.LENGTH_LONG).show();
            encounterMonster(gameModel.evilWitch);
        } else if (rand.nextBoolean()) {
            soundManager.playBackGroundMusic();
            Toast.makeText(ui.getApplicationContext(), "With a swift dodge, you evade the monster's attack and successfully escape, fleeing to safety.", Toast.LENGTH_LONG).show();
            storyManager.selectPosition(gameModel.lastPosition);
        } else {
            int damageTaken = (int) Math.ceil(2 * gameModel.difficultRate) - (gameModel.player.getArmor() != null ? gameModel.player.getArmor().getDamageReduced() : 0);
            Toast.makeText(ui.getApplicationContext(), "You were unable to evade the monster's pursuit and suffered a blow, losing " + (damageTaken > 0 ? damageTaken : 0) + " points of health.", Toast.LENGTH_LONG).show();

            if (ui.updatePlayerHp(-damageTaken))
                storyManager.selectPosition(gameModel.position);
        }
    }
}
