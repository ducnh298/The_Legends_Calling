package com.game.controller;

import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.game.R;
import com.game.model.Effect;
import com.game.model.Monster;
import com.game.model.Spell;
import com.game.model.Weapon;
import com.game.model.monsters.Monster_DemonGeneral;
import com.game.model.monsters.Monster_Goblin;
import com.game.model.monsters.Monster_RiverMonster;
import com.game.model.monsters.Monster_ShadowSerpent;
import com.game.model.monsters.Monster_Wolf;
import com.game.model.spells.Spell_PoisonBreeze;
import com.game.model.weapons.Weapon_Fist;
import com.game.model.weapons.Weapon_LongSword;
import com.game.model.weapons.Weapon_Trident;
import com.game.view.GameScreen;

import java.util.Random;

public class CombatManager {
    StoryManager storyManager;
    GameData gameData;
    GameScreen ui;
    SoundManager soundManager;
    private Random rand;
    private boolean encounterMonsterTurn = true;

    public CombatManager(StoryManager storyManager) {
        this.storyManager = storyManager;
        this.gameData = storyManager.gameData;
        this.ui = storyManager.ui;
        this.soundManager = ui.soundManager;
        this.rand = ui.rand;
    }

    public void encounterGoblin() {
        if (gameData.goblin == null)
            gameData.goblin = new Monster_Goblin(gameData.difficultRate);
        gameData.position = "encounterGoblin";
        encounterMonster(gameData.goblin);
    }

    public void encounterWolf() {
        if (gameData.wolf == null)
            gameData.wolf = new Monster_Wolf(gameData.difficultRate);
        if (!gameData.position.equalsIgnoreCase("encounterWolf")) {
            gameData.lastPosition = gameData.position;
            Glide.with(ui).load(R.drawable.wolf).into(ui.image);
            if(gameData.isBorrowSword)
                ui.updatePlayersWeapons(new Weapon_LongSword());
            soundManager.playBattleMusic();
            soundManager.wolf();
            Toast.makeText(ui.getApplicationContext(), "You come face to face with a menacing wolf.", Toast.LENGTH_SHORT).show();
        }
        gameData.position = "encounterWolf";

        encounterMonster(gameData.wolf);
    }

    public void encounterEvilWitch() {
        if (gameData.poisonBreeze == null) {
            gameData.poisonBreeze = new Spell_PoisonBreeze();
            gameData.poisonBreeze.setSoundEffect(soundManager.spellPoisonBreezeSoundId);
        }
        if (!gameData.position.equalsIgnoreCase("encounterEvilWitch")) {
            gameData.lastPosition = gameData.position;
            ui.image.setImageResource(R.drawable.evil_witch);
            soundManager.evilWitch();
            soundManager.spell(gameData.poisonBreeze.getSoundEffect());
            soundManager.playBattleMusic();
            Toast.makeText(ui.getApplicationContext(), "The poison breeze slowly drains your health.", Toast.LENGTH_SHORT).show();
            gameData.player.addEffect(gameData.poisonBreeze.getEffect());
        }
        gameData.position = "encounterEvilWitch";

        encounterMonster(gameData.evilWitch);
    }

    public void encounterRiverMonster() {
        if (gameData.riverMonster == null)
            gameData.riverMonster = new Monster_RiverMonster(gameData.difficultRate);
        if (!gameData.position.equalsIgnoreCase("encounterRiverMonster")) {
            gameData.lastPosition = gameData.position;
            Glide.with(ui).load(R.drawable.river_monster).into(ui.image);
            soundManager.playBattleMusic();
            soundManager.riverMonster();
            Toast.makeText(ui.getApplicationContext(), "You come face to face with a formidable river monster.", Toast.LENGTH_SHORT).show();
        }
        gameData.position = "encounterRiverMonster";

        encounterMonster(gameData.riverMonster);
    }

    public void encounterShadowSerpent() {
        if (gameData.shadowSerpent == null)
            gameData.shadowSerpent = new Monster_ShadowSerpent(gameData.difficultRate);
        if (!gameData.position.equalsIgnoreCase("encounterShadowSerpent")) {
            gameData.lastPosition = gameData.position;
            Glide.with(ui).load(R.drawable.shadow_serpent).into(ui.image);
            soundManager.playBattleMusic();
            soundManager.shadowSerpent();
            Toast.makeText(ui.getApplicationContext(), "You come face to face with a menacing shadow serpent.", Toast.LENGTH_SHORT).show();
        }
        gameData.position = "encounterShadowSerpent";

        encounterMonster(gameData.shadowSerpent);
    }

    public void encounterDemonGeneral() {
        if (gameData.demonGeneral == null)
            gameData.demonGeneral = new Monster_DemonGeneral(gameData.difficultRate);
        if (!gameData.position.equalsIgnoreCase("encounterDemonGeneral")) {
            gameData.lastPosition = gameData.position;
            Glide.with(ui).load(R.drawable.demon_general).into(ui.image);
            soundManager.playBattleMusic();
            soundManager.demonGeneral();
            Toast.makeText(ui.getApplicationContext(), "You confront the demon general, standing face-to-face with one of the mightiest warriors in the demon king's army.", Toast.LENGTH_LONG).show();
        }
        gameData.position = "encounterDemonGeneral";

        encounterMonster(gameData.demonGeneral);
    }

    public void attackGoblin(boolean useSpell) {
        if (gameData.goblin.getMonsterCurrentHP() > 0) {
            attackMonster(gameData.goblin, useSpell);
            encounterMonster(gameData.goblin);
        } else {
            soundManager.insideCave();
            Toast.makeText(ui.getApplicationContext(), "You have defeated the goblin!", Toast.LENGTH_SHORT).show();
            gameData.isALiveGoblin = false;
            gameData.goblin = null;
            storyManager.deeperInsideGoblinCave();
            ui.saveGame();
        }
    }

    public void attackWolf(boolean useSpell) {
        if (gameData.wolf.getMonsterCurrentHP() > 0) {
            attackMonster(gameData.wolf, useSpell);
            encounterMonster(gameData.wolf);
        } else {
            soundManager.playBackGroundMusic();
            Toast.makeText(ui.getApplicationContext(), "You have defeated the wolf!", Toast.LENGTH_SHORT).show();
            gameData.isAliveWolf = false;
            gameData.wolf = null;
            if(gameData.isBorrowSword) {
                gameData.player.removeWeapon("Long sword");
                ui.updatePlayersWeapons(null);
            }
            storyManager.defeatWolf();
            ui.saveGame();
        }
    }

    public void attackEvilWitch(boolean useSpell) {
        if (gameData.evilWitch.getMonsterCurrentHP() > 1) {
            attackMonster(gameData.evilWitch, useSpell);
            encounterMonster(gameData.evilWitch);
        } else {
            soundManager.playBackGroundMusic();
            gameData.evilWitch.setMonsterCurrentHP(1);
            ui.displayTextSlowly(gameData.evilWitch.getName() + "'s HP: " + gameData.evilWitch.getMonsterCurrentHP() + "/" + gameData.evilWitch.getMonsterMaxHP());
            Toast.makeText(ui.getApplicationContext(), "You have defeated the Evil Witch!", Toast.LENGTH_SHORT).show();

            for (Effect effect : gameData.player.getEffectList()) {
                if (effect.getName().equalsIgnoreCase("Poisonous")) {
                    gameData.player.removeEffect(effect);
                    break;
                }
            }

            gameData.isDefeatedEvilWitch = true;
            gameData.evilWitch = null;
            storyManager.defeatTheWitch();
            ui.saveGame();
        }
    }

    public void attackRiverMonster(boolean useSpell) {
        if (gameData.riverMonster.getMonsterCurrentHP() > 0) {
            attackMonster(gameData.riverMonster, useSpell);
            encounterMonster(gameData.riverMonster);
        } else {
            soundManager.playBackGroundMusic();
            ui.displayTextSlowly(gameData.riverMonster.getName() + "'s HP: " + gameData.riverMonster.getMonsterCurrentHP() + "/" + gameData.riverMonster.getMonsterMaxHP());
            Toast.makeText(ui.getApplicationContext(), "Victorious against the river monster, you claim a gleaming trident as your reward.", Toast.LENGTH_SHORT).show();

            ui.updatePlayersWeapons(new Weapon_Trident());

            gameData.isALiveRiverMonster = false;
            gameData.riverMonster = null;
            storyManager.selectPosition(gameData.lastPosition);
            ui.saveGame();
        }
    }

    public void attackShadowSerpent(boolean useSpell) {
        if (gameData.shadowSerpent.getMonsterCurrentHP() > 0) {
            attackMonster(gameData.shadowSerpent, useSpell);
            encounterMonster(gameData.shadowSerpent);
        } else {
            soundManager.playBackGroundMusic();
            ui.displayTextSlowly(gameData.shadowSerpent.getName() + "'s HP: " + gameData.shadowSerpent.getMonsterCurrentHP() + "/" + gameData.shadowSerpent.getMonsterMaxHP());
            Toast.makeText(ui.getApplicationContext(), "You have defeated the shadow serpent!", Toast.LENGTH_SHORT).show();

            gameData.isAliveShadowSerpent = false;
            gameData.shadowSerpent = null;
            storyManager.insideDemonHideout();
            ui.saveGame();
        }
    }

    public void attackDemonGeneral(boolean useSpell) {
        if (gameData.demonGeneral.getMonsterCurrentHP() > 0) {
            attackMonster(gameData.demonGeneral, useSpell);
            encounterMonster(gameData.demonGeneral);
        } else {
            gameData.isAliveDemonGeneral = false;
            gameData.demonGeneral = null;
            storyManager.defeatDemonGeneral();
            soundManager.stopAllMusic();
            ui.saveGame();
        }
    }

    public void encounterMonster(Monster monster) {
        ui.setChoicesAndNextPositions("Fight", "Try to run", "", "", gameData.lastPosition, "tryToRun", "", "");
        if (monster.equals(gameData.wolf)) {
            storyManager.nextPosition1 = "attackWolf";
            if (!gameData.player.getSpellList().isEmpty()) {
                ui.updatePlayersSpells();
                ui.setChoice2("Use spell", "attackWolfWithSpell");
                ui.setChoice3("Try to run", "tryToRun");
            }
        }else if (monster.equals(gameData.goblin)) {
            storyManager.nextPosition1 = "attackGoblin";
            if (!gameData.player.getSpellList().isEmpty()) {
                ui.updatePlayersSpells();
                ui.setChoice2("Use spell", "attackGoblinWithSpell");
                ui.setChoice3("Try to run", "tryToRun");
            }
        } else if (monster.equals(gameData.riverMonster)) {
            storyManager.nextPosition1 = "attackRiverMonster";
            if (!gameData.player.getSpellList().isEmpty()) {
                ui.updatePlayersSpells();
                ui.setChoice2("Use spell", "attackRiverMonsterWithSpell");
                ui.setChoice3("Try to run", "tryToRun");
            }
        } else if (monster.equals(gameData.shadowSerpent)) {
            storyManager.nextPosition1 = "attackShadowSerpent";
            if (!gameData.player.getSpellList().isEmpty()) {
                ui.updatePlayersSpells();
                ui.setChoice2("Use spell", "attackShadowSerpentWithSpell");
                ui.setChoice3("Try to run", "tryToRun");
            }
        } else if (monster.equals(gameData.demonGeneral)) {
            storyManager.nextPosition1 = "attackDemonGeneral";
            if (!gameData.player.getSpellList().isEmpty()) {
                ui.updatePlayersSpells();
                ui.setChoice2("Use spell", "attackDemonGeneralWithSpell");
                ui.setChoice3("Try to run", "tryToRun");
            }
        } else if (monster.equals(gameData.evilWitch)) {
            storyManager.nextPosition1 = "attackEvilWitch";
            if (!gameData.player.getSpellList().isEmpty()) {
                ui.updatePlayersSpells();
                ui.setChoice2("Use spell", "attackEvilWitchWithSpell");
                ui.setChoice3("Try to run", "tryToRun");
            }
        }

        if (encounterMonsterTurn) {
            StringBuilder monsterStatus = new StringBuilder(monster.getName() + "'s HP: " + monster.getMonsterCurrentHP() + "/" + monster.getMonsterMaxHP());
            if (!monster.getEffectList().isEmpty())
                for (Effect effect : monster.getEffectList()) {
                    monsterStatus.append("\n" + monster.getName() + " is " + effect.getName());
                    if (effect.getRemain() > 1) {
                        monsterStatus.append(" (Remain: " + effect.getRemain() + ")");
                    }
                }
            ui.displayText(monsterStatus.toString() + "\n");
        } else {
            encounterMonsterTurn = true;
            ui.choice1.setText("Continue");
            ui.choice2.setText("");
            ui.choice3.setText("");

            if (ui.updatePlayersHp(0) && monster.getMonsterCurrentHP() > 0 || (gameData.evilWitch != null && gameData.evilWitch.getMonsterCurrentHP() > 1)) {
                storyManager.nextPosition1 = gameData.position;
            }
        }
        ui.setChoiceVisibility();
    }

    public void attackMonster(Monster monster, boolean useSpell) {
        boolean monsterAbleToAttack = true;
        Spell spell = null;
        StringBuilder text = new StringBuilder("");
        //PLAYER ATTACK
        if (useSpell) {
            spell = gameData.player.getSpellList().get(ui.spellSpinner.getSelectedItemPosition());
            if (spell.getCoolDownRemain() > 0) {
                Toast.makeText(ui.getApplicationContext(), spell.getName() + " is not ready!", Toast.LENGTH_SHORT).show();
                encounterMonster(monster);
                return;
            }
            soundManager.spell(spell.getSoundEffect());
            text.append("\nYou cast " + spell.getName() + ". " + spell.getDescription());
            if (spell.getDamage() > 0) {
                monster.loseHP(spell.getDamage());
                text.append(" -> " + monster.getName() + "'s HP: " + monster.getMonsterCurrentHP() + "/" + monster.getMonsterMaxHP() + "\n");
            }
            if (spell.getEffect() != null) {
                spell.activeEffect();
                monster.addEffect(spell.getEffect());
            }
            if (spell.equals(gameData.waterSurge)) {
                ui.updatePlayersHp(-spell.getDamage());
                monsterAbleToAttack = false;
            }
        } else {
            Weapon currentWeapon;
            if (gameData.player.getWeaponList().size() > 0) {
                currentWeapon = gameData.player.getWeaponList().get(ui.weaponSpinner.getSelectedItemPosition());
                soundManager.sword();
            }
            else{
                if(gameData.fist == null)
                    gameData.fist = new Weapon_Fist();
                currentWeapon = gameData.fist;
                soundManager.hitTree();
            }
            int playerDamage = gameData.player.getBaseAttack() + rand.nextInt(currentWeapon.getCriticalAttackDamage() - currentWeapon.getAttackDamage()) + currentWeapon.getAttackDamage();
            text.append("\nYou attacked with " + currentWeapon.getName() + " and gave " + playerDamage + " damage!");
            monster.loseHP(playerDamage);
            text.append(" -> " + monster.getMonsterCurrentHP() + "/" + monster.getMonsterMaxHP() + "\n");
        }

        if (!gameData.player.getSpellList().isEmpty()) {
            for (Spell sp : gameData.player.getSpellList()) {
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
                    text.append(" -> " + monster.getMonsterCurrentHP() + "/" + monster.getMonsterMaxHP());
                }

                if (effect.getName().equalsIgnoreCase(gameData.paralyzedEffect.getName()))
                    monsterAbleToAttack = false;

                if (spell == null || (spell != null && !spell.getEffect().getName().equals(effect.getName()))) {
                    effect.reduceRemain();
                    if (effect.getRemain() == 0)
                        monster.removeEffect(effect);
                }
                text.append("\n");
            }
        monsterAttackTurn(monster, monsterAbleToAttack, text);
    }

    private void monsterAttackTurn(Monster monster, boolean monsterAbleToAttack, StringBuilder text) {
        //MONSTER ATTACK
        if (!gameData.player.getEffectList().isEmpty()) {
            for (Effect effect : gameData.player.getEffectList()) {
                text.append("\n" + effect.getDescriptionToPlayer() + " (Remain: " + effect.getRemain() + ")");

                if (effect.getDamage() > 0) {
                    gameData.player.loseHP((int) Math.floor(effect.getDamage() * gameData.difficultRate));
                    text.append(" -> " + gameData.player.getPlayerHP() + "/" + gameData.player.getPlayerMaxHP());
                }
                effect.reduceRemain();
                if (effect.getRemain() == 0)
                    gameData.player.removeEffect(effect);
            }
            text.append("\n");
        }

        int monsterDamage;
        if (monsterAbleToAttack) {
            monsterDamage = rand.nextInt(monster.getCriticalAttackDamage() - monster.getAttackDamage()) + monster.getAttackDamage() - (gameData.player.getArmor() != null ? gameData.player.getArmor().getDamageReduced() : 0);
            text.append("\nThe " + monster.getName() + " attacked you." + (gameData.player.getArmor() != null ? (" With " + gameData.player.getArmor().getName()) : "") + " you took " + (monsterDamage > 0 ? monsterDamage : 0) + " damage!");
            if (monsterDamage > 0) {
                gameData.player.loseHP(monsterDamage);
                text.append(" -> " + gameData.player.getPlayerHP() + "/" + gameData.player.getPlayerMaxHP() + "\n");
            }
        }
        ui.continueDisplayText(text.toString());
        encounterMonsterTurn = false;
    }

    public void tryToRun() {
        if (gameData.position.equalsIgnoreCase("encounterEvilWitch") || gameData.position.equalsIgnoreCase("talkWitch3")) {
            ui.continueTextSlowly("Escape from the clutches of the witch proves futile as she blocks your path.");
            ui.setChoicesAndNextPositions("Continue", "", "", "", "encounterEvilWitch", "", "", "");
        } else if (rand.nextBoolean()) {
            soundManager.playBackGroundMusic();
            ui.continueTextSlowly("With a swift dodge, you evade the monster's attack and successfully escape, fleeing to safety.");
            ui.setChoicesAndNextPositions("Continue", "", "", "", gameData.lastPosition, "", "", "");
        } else {
            int damageTaken = (int) Math.ceil(2 * gameData.difficultRate) - (gameData.player.getArmor() != null ? gameData.player.getArmor().getDamageReduced() : 0);
            ui.continueTextSlowly("You were unable to evade the monster's pursuit and suffered a blow, losing " + (damageTaken > 0 ? damageTaken : 0) + " points of health.");
            if (ui.updatePlayersHp(-damageTaken))
                ui.setChoicesAndNextPositions("Continue", "", "", "", gameData.position, "", "", "");
            else
                Toast.makeText(ui.getApplicationContext(), "You were unable to evade the monster's pursuit and suffered a blow, losing " + (damageTaken > 0 ? damageTaken : 0) + " points of health.", Toast.LENGTH_LONG).show();
        }
    }
}
