package com.game.controller;

import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.game.R;
import com.game.model.Armor;
import com.game.model.armors.Armor_GoldenArmor;
import com.game.model.armors.Armor_IronArmor;
import com.game.model.armors.Armor_SilverArmor;
import com.game.model.monsters.Monster_EvilWitch;
import com.game.model.spells.Spell_FireStorm;
import com.game.model.spells.Spell_LightningBolt;
import com.game.model.spells.Spell_PoisonBreeze;
import com.game.model.spells.Spell_WaterSurge;
import com.game.model.weapons.Weapon_DemonSword;
import com.game.model.weapons.Weapon_Knife;
import com.game.model.weapons.Weapon_LongSword;
import com.game.view.GameScreen;

import java.util.Random;

public class StoryManager {
    GameScreen ui;
    GameModel gameModel;
    CombatManager combatManager;
    SoundManager soundManager;

    public String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    private final Random rand;
    private final Handler handler;

    public StoryManager(GameScreen gameScreen, GameModel gameModel) {
        this.ui = gameScreen;
        this.gameModel = gameModel;
        this.combatManager = new CombatManager(this);
        this.soundManager = gameScreen.soundManager;
        this.handler = gameScreen.handler;
        this.rand = gameScreen.rand;
    }

    public void selectPosition(String nextPosition) {
        switch (nextPosition) {
            case "start":
                soundManager.stopAllMusic();
                ui.restartGame();
                break;
            case "startGameUI":
                ui.startGameUI();
                townGate();
                break;
            case "timeLoop":
                ui.timeLoop();
                windyField1();
                break;
            case "quit":
                ui.quitGame();
                break;
            case "opening":
                opening();
                break;
            case "getHome":
                getHome();
                break;
            case "bedRoom":
                bedRoom();
                break;
            case "sleeping":
                sleeping();
                break;
            case "wakeUp":
                wakeUp();
                break;
            case "windyField1":
                windyField1();
                break;
            case "windyField2":
                windyField2();
                break;
            case "windyField3":
                windyField3();
                break;
            case "windyField4":
                windyField4();
                break;
            case "recollectYourThoughts":
                recollectYourThoughts();
                break;
            case "exploreTheSurrounding1":
                exploreTheSurrounding1();
                break;
            case "exploreTheSurrounding2":
                exploreTheSurrounding2();
                break;
            case "takeKnife":
                takeKnife();
                break;
            case "notTakeKnife":
                notTakeKnife();
                break;
            case "meetCarriage":
                meetCarriage();
                break;
            case "attackCarriage":
                attackCarriage();
                break;
            case "askAboutLocation":
                askAboutLocation();
                break;
            case "askForARide":
                askForARide();
                break;
            case "askAboutEra":
                askAboutEra();
                break;
            case "onCarriage1":
                onCarriage1();
                break;
            case "onCarriage2":
                onCarriage2();
                break;
            case "askAboutTeleportation":
                askAboutTeleportation();
                break;
            case "askAboutMagic":
                askAboutMagic();
                break;
            case "askAboutHistoryOfThisWorld1":
                askAboutHistoryOfThisWorld1();
                break;
            case "askAboutHistoryOfThisWorld2":
                askAboutHistoryOfThisWorld2();
                break;
            case "askAboutHistoryOfThisWorld3":
                askAboutHistoryOfThisWorld3();
                break;
            case "askAboutHistoryOfThisWorld4":
                askAboutHistoryOfThisWorld4();
                break;
            case "askAboutAbilityToReTurnByDeath":
                askAboutAbilityToReTurnByDeath();
                break;
            case "townGate":
                townGate();
                break;
            case "talkGuard1":
                talkGuard1();
                break;
            case "talkGuard2":
                talkGuard2();
                break;
            case "talkGuard3":
                talkGuard3();
                break;
            case "attackGuard":
                attackGuard();
                break;
            case "crossRoad":
                crossRoad();
                break;
            case "blackSmithHouse":
                blackSmithHouse();
                break;
            case "talkBlackSmith":
                talkBlackSmith();
                break;
            case "acceptBlackSmithQuest":
                acceptBlackSmithQuest();
                break;
            case "takeArmor":
                takeArmor();
                break;
            case "goblinCave":
                goblinCave();
                break;
            case "lightTorch":
                lightTorch();
                break;
            case "insideGoblinCave":
                insideGoblinCave();
                break;
            case "deeperInsideGoblinCave":
                deeperInsideGoblinCave();
                break;
            case "takeGoblinEar":
                takeGoblinEar();
                break;
            case "takeLongSword":
                takeLongSword();
                break;
            case "encounterGoblin":
                combatManager.encounterGoblin();
                break;
            case "attackGoblin":
                combatManager.attackGoblin(false);
                break;
            case "attackGoblinWithSpell":
                combatManager.attackGoblin(true);
                break;
            case "riverSide":
                riverSide();
                break;
            case "talkWitch1":
                talkWitch1();
                break;
            case "talkWitch2":
                talkWitch2();
                break;
            case "talkWitch3":
                talkWitch3();
                break;
            case "talkWitch4":
                talkWitch4();
                break;
            case "talkWitch5":
                talkWitch5();
                break;
            case "talkWitch6":
                talkWitch6();
                break;
            case "talkWitch7":
                talkWitch7();
                break;
            case "talkWitch8":
                talkWitch8();
                break;
            case "acceptWitchQuest":
                acceptWitchQuest();
                break;
            case "encounterEvilWitch":
                combatManager.encounterEvilWitch();
                break;
            case "attackEvilWitch":
                combatManager.attackEvilWitch(false);
                break;
            case "attackEvilWitchWithSpell":
                combatManager.attackEvilWitch(true);
                break;
            case "enhanceStrength":
                enhanceStrength();
                break;
            case "learnPoisonBreeze":
                learnPoisonBreeze();
                break;
            case "northRiver":
                northRiver();
                break;
            case "takeRest":
                takeRest();
                break;
            case "southRiver":
                southRiver();
                break;
            case "encounterRiverMonster":
                combatManager.encounterRiverMonster();
                break;
            case "attackRiverMonster":
                combatManager.attackRiverMonster(false);
                break;
            case "attackRiverMonsterWithSpell":
                combatManager.attackRiverMonster(true);
                break;
            case "tryToRun":
                combatManager.tryToRun();
                break;
            case "jungle":
                jungle();
                break;
            case "hitTheAppleTree":
                hitTheAppleTree();
                break;
            case "takeApple":
                takeApple();
                break;
            case "eatApple":
                eatApple();
                break;
            case "mountain":
                mountain();
                break;
            case "mountainTop":
                mountainTop();
                break;
            case "touchStatue":
                touchStatue();
                break;
            case "offerPower":
                offerPower();
                break;
            case "strengthPower":
                strengthPower();
                break;
            case "firePower":
                firePower();
                break;
            case "lightningPower":
                lightningPower();
                break;
            case "waterPower":
                waterPower();
                break;
            case "takeStrengthPower":
                takeStrengthPower();
                break;
            case "takePower":
                takePower();
                break;
            case "demonHideout":
                demonHideout();
                break;
            case "insideDemonHideout":
                insideDemonHideout();
                break;
            case "encounterShadowSerpent":
                combatManager.encounterShadowSerpent();
                break;
            case "attackShadowSerpent":
                combatManager.attackShadowSerpent(false);
                break;
            case "attackShadowSerpentWithSpell":
                combatManager.attackShadowSerpent(true);
                break;
            case "encounterDemonGeneral":
                combatManager.encounterDemonGeneral();
                break;
            case "attackDemonGeneral":
                combatManager.attackDemonGeneral(false);
                break;
            case "attackDemonGeneralWithSpell":
                combatManager.attackDemonGeneral(true);
                break;
            case "defeatDemonGeneral":
                defeatDemonGeneral();
                break;
            case "wakeUpAfterFinalBattle":
                wakeUpAfterFinalBattle();
                break;
            case "deadScreen":
                deadScreen();
                break;
            case "theEnd":
                theEnd();
                break;
        }
    }

    public void opening() {
        gameModel.position = "opening";
        Glide.with(ui).load(R.drawable.driving_highway).into(ui.image);
        soundManager.drivingHighWay();
        ui.displayTextSlowly("It's late in the evening, you find yourself behind the wheel on a familiar road, heading home after a long day at work.\n" +
                "It's Friday night, and the darkness envelops the surroundings, with only a scattering of streetlights casting a dim glow. ");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "getHome", "", "", "");
    }

    public void getHome() {
        gameModel.position = "getHome";
        ui.image.setImageResource(R.drawable.dark_screen);
        soundManager.openingDoor();
        ui.displayTextSlowly("You finally arrive home and eagerly insert the key into the lock, opening the door to your haven\n" +
                "...                                                                                                  \n" +
                "You kick off your shoes, drop your bag, releasing the weight of the day.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "bedRoom", "", "", "");
    }

    public void bedRoom() {
        gameModel.position = "bedRoom";
        handler.removeCallbacksAndMessages(null);
        ui.image.setImageResource(R.drawable.bedroom);
        soundManager.bedRoom();
        ui.displayTextSlowly("Making your way to your bedroom and notice that it has started raining outside.\n" +
                "With a sense of  exhaustion washing over you, you eagerly jump onto the bed, ready to drift into a deep and restful nap.");
        ui.setChoicesAndNextPositions("Take a rest", "", "", "", "sleeping", "", "", "");
    }

    public void sleeping() {
        handler.removeCallbacksAndMessages(null);
        ui.image.setImageResource(R.drawable.dark_screen);
        ui.displayTextSlowly("z...z...Z...Z\n                               \nz......z......Z......Z\n                               \nz.........z.........Z.........Z");
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                soundManager.raining();
                soundManager.windyField();
                soundManager.wakeUpVoice();
                ui.setChoicesAndNextPositions("Wake up", "Continue to sleep", "", "", "wakeUp", "sleeping", "", "");
            }
        }, 1500);
    }

    public void wakeUp() {
        handler.removeCallbacksAndMessages(null);
        ui.displayTextSlowly("\"Where am I?\" The gentle breeze caresses your face, carrying the scent of grass,\nwhile the warm touch of sunlight dances upon your skin. ");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "windyField1", "", "", "");
    }

    public void windyField1() {
        if (gameModel.timeLoop) {
            ui.image.setImageResource(R.drawable.dark_screen);
            soundManager.windyField();
            ui.displayTextSlowly("\"Whoa, aaaa!!!\" you scream in pain, realizing that just seconds ago you had taken a fatal blow, and now you find yourself lying in the familiar grass once again.");
            ui.setChoicesAndNextPositions("Continue", "", "", "", "windyField1", "", "", "");
        } else {
            gameModel.position = "windyField";
            ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
            ui.displayTextSlowly("As you slowly open your eyes, a wave of disbelief washes over you. " +
                    "Instead of the familiar sight of your bedroom, you find yourself lying on the soft grass under an open sky. ");
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Glide.with(ui).load(R.drawable.windy_field).into(ui.image);
                ui.baseLayout.setBackgroundColor(Color.parseColor("#aab865"));
                ui.setChoicesAndNextPositions("Continue", "", "", "", "windyField2", "", "", "");
            }
        }, 2000);
    }

    public void windyField2() {
        ui.displayTextSlowly("You find yourself in the middle of a windy field, with the soft green grass swaying under the clear blue sky.\n" +
                "A sturdy wooden fence separates the field from a winding dirt road. ");
        ui.setChoicesAndNextPositions("Try to recollect your thoughts", "Explore the surrounding", "Leave", "", "recollectYourThoughts", "exploreTheSurrounding1", "windyField3", "");
    }

    public void recollectYourThoughts() {
        ui.setChoicesAndNextPositions("Continue", "", "", "", "windyField2", "", "", "");
        if (gameModel.timeLoop) {
            ui.displayTextSlowly("After spending a couple of minutes trying to recollect your thoughts, a realization upon you — you possess the ability to return by death.\n" +
                    "Memories flood back, and you recall the knowledge of your previous encounters and the choices that led you to this point. ");
        } else
            ui.displayTextSlowly("After spending a couple of minutes trying to recollect your thoughts, you realize that your mind is completely blank. ");
    }

    public void exploreTheSurrounding1() {
        if (!gameModel.isTakenKnife) {
            ui.setChoicesAndNextPositions("Take it", "Leave it", "", "", "takeKnife", "notTakeKnife", "", "");
            ui.displayTextSlowly("As you explore the surrounding area, your eyes catch a glint of metal hidden among the tall grass.\n" +
                    "You reach down and discover an old, weathered knife, its blade worn but still sharp.\n");
        } else exploreTheSurrounding2();
    }

    public void exploreTheSurrounding2() {
        ui.updatePlayersCoins(3);
        ui.setChoicesAndNextPositions("Continue", "", "", "", "windyField2", "", "", "");
        ui.displayTextSlowly("As you continue to explore, there are nothing of value or usefulness left in the surrounding area.");
    }

    public void takeKnife() {
        ui.setChoicesAndNextPositions("Continue to explore", "Leave", "", "", "exploreTheSurrounding2", "windyField2", "", "");
        ui.continueTextSlowly("You pick up the old knife, feeling its weight in your hand. Its worn handle and rusted blade tell tales of past adventures.");
        if (gameModel.knife == null)
            gameModel.knife = new Weapon_Knife();
        ui.obtainWeapon(gameModel.knife);
        gameModel.isTakenKnife = true;
    }

    public void notTakeKnife() {
        ui.setChoicesAndNextPositions("Continue to explore", "Leave", "", "", "exploreTheSurrounding2", "windyField2", "", "");
        ui.continueTextSlowly("You decide not to take the old knife, feeling that it may not be of much use to you.");
    }

    public void windyField3() {
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        Glide.with(ui).load(R.drawable.windy_field_with_carriage).into(ui.image);
        ui.displayTextSlowly("As you cross over the wooden fence, a distant sound of a carriage catches your attention.\n" +
                "The rhythmic clip-clop of horse hooves and the creaking of wheels echo through the air, growing louder with each passing moment.");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                soundManager.horseWagonFar();
                ui.setChoicesAndNextPositions("Approach the carriage", "Ignore it", "", "", "windyField4", "windyField2", "", "");
            }
        }, 1000);
    }

    public void windyField4() {
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        ui.displayTextSlowly("You sprint towards the carriage. \n" +
                "...                                                                     \n" +
                "As it draws nearer, you take in the sight of the small wooden carriage.\n" +
                "On the driver's seat, a man dressed in a blue jacket and hood guides the horse pulling the carriage.");
        soundManager.runningInGrass();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.setChoicesAndNextPositions("Stop the carriage", "", "", "", "meetCarriage", "", "", "");
            }
        }, 2000);
    }

    public void meetCarriage() {
        gameModel.position = "meetCarriage";
        Glide.with(ui).load(R.drawable.carriage).into(ui.image);
        soundManager.stopAllSoundEffect();
        soundManager.horseWagonNear();
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        ui.displayTextSlowly("You manage to get closer the carriage and urgently call out to the driver to stop.\n" +
                "Catching the attention of the man, the horse slows down, and the carriage gradually comes to a stop. ");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.image.setImageResource(R.drawable.carriage);
                soundManager.stopAllSoundEffect();
                soundManager.horse();
                ui.setChoicesAndNextPositions("\"Excuse me, but can you tell me where I am?\"", "Ask about your current era", "Ask for a ride", "", "askAboutLocation", "askAboutEra", "askForARide", "");
                if (gameModel.isTakenKnife)
                    ui.setChoice4("Take control the carriage", "attackCarriage");
            }
        }, 2500);
    }

    public void attackCarriage() {
        ui.displayTextSlowly("With the knife in hand, you bravely attempt to seize control of the carriage.\n" +
                "However, The man reacts swiftly, drawing his sword and delivering a powerful strike on you, instantly ending your life.");
        gameModel.player.setPlayerHP(0);
        ui.updatePlayerHp(0);
    }

    public void askAboutLocation() {
        ui.displayTextSlowly("\"You're in the outskirts of a small town called Rivervale.\n" +
                "You should not be here alone, as there have been numerous reports of increased monster activity due to the expanding territory of the demon general.\"");
    }

    public void askAboutEra() {
        ui.displayTextSlowly("Seeking information about current era, you engage the man in conversation, asking several questions.\n" +
                "You realize that you might have traveled back in time to a medieval era or an alternate reality.");
    }

    public void askForARide() {
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        ui.displayTextSlowly("Prioritizing your safety, you ask the man for a ride.\n" +
                "The man agrees to take you with. As the wheels begin to turn, the carriage sets off towards the direction of Rivervale town");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Glide.with(ui).load(R.drawable.carriage).into(ui.image);
                soundManager.horse();
                soundManager.horseWagonNear();
                ui.setChoicesAndNextPositions("Continue", "", "", "", "onCarriage1", "", "", "");
            }
        }, 4000);
    }

    public void onCarriage1() {
        ui.displayTextSlowly("As the carriage continues its journey, you seize the opportunity to ask the man a series of questions.");
        ui.setChoicesAndNextPositions("About the teleportation between worlds", "About the history of this world", "Done asking", "", "askAboutTeleportation", "askAboutHistoryOfThisWorld1", "onCarriage2", "");
        if (gameModel.timeLoop)
            ui.setChoicesAndNextPositions("About the teleportation between worlds", "About the history of this world", "Done asking", "About the ability to return by death", "askAboutTeleportation", "askAboutHistoryOfThisWorld1", "onCarriage2", "askAboutAbilityToReTurnByDeath");
    }

    public void askAboutTeleportation() {
        ui.displayTextSlowly("\"Teleportation between worlds? I'm afraid I haven't heard of such a thing.\n" +
                "But there are rumors of ancient magic and hidden portals in these lands.\n" +
                "Perhaps seeking guidance from a wise mage or exploring ancient ruins could reveal more.\"");
        ui.setChoicesAndNextPositions("About the existence of magic", "", "", "", "askAboutMagic", "", "", "");
    }

    public void askAboutMagic() {
        ui.displayTextSlowly("He explains that only a select few individuals possess the innate ability to wield magic,\nusing it either to enhance their daily lives or to engage in formidable battles against the forces of darkness.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "onCarriage1", "", "", "");
    }

    public void askAboutHistoryOfThisWorld1() {
        ui.displayTextSlowly("\"In this world's ancient history, humans and monsters have coexisted and clashed for thousands of years.\n" +
                "Every 500 years, a new demon king is born, commanding a powerful army, grow stronger each passing generation\"");
        ui.setChoicesAndNextPositions("\"How can humanity defeat such a formidable enemy?\"", "\"Is there a specific method or weapon to defeat the demon king and his army?\"", "\"What about the previous heroes who fought against the demon army?\"", "Ask another", "askAboutHistoryOfThisWorld2", "askAboutHistoryOfThisWorld3", "askAboutHistoryOfThisWorld4", "onCarriage1");
    }

    public void askAboutHistoryOfThisWorld2() {
        ui.displayTextSlowly("\"A chosen hero emerges every 500 years. " +
                "This hero, blessed with unique abilities and unwavering courage, leads the united armies of the five kingdoms against the demon army.\n" +
                "Through their valor and strategic prowess, they bring about peace and protect humanity for the next five hundred years.\"");
    }

    public void askAboutHistoryOfThisWorld3() {
        ui.displayTextSlowly("\"Legend speaks of a legendary artifact known as the 'Sword of Light,' said to possess the power to vanquish the darkness.\n" +
                "However, its whereabouts are unknown, and only a chosen hero, guided by destiny, can wield its true power.\"");
    }

    public void askAboutHistoryOfThisWorld4() {
        ui.displayTextSlowly("\"The previous heroes were legendary figures, their names etched in the annals of history.\n" +
                "They led armies, inspired hope, and faced the demon army with unwavering resolve. \"");
    }

    public void askAboutAbilityToReTurnByDeath() {
        ui.displayTextSlowly("\"What a nonsense\" he dismisses, but then he adds a cautionary note:\n" +
                "\"If the power of rewinding time and altering one's fate really exist, it comes at a great cost and is often accompanied by unimaginable suffering.\"");
    }

    public void onCarriage2() {
        ui.displayTextSlowly("After a few hours of travel, the carriage finally arrives at the town gate.\n" +
                "The man kindly drops you off and bids you farewell before continuing his own journey. ");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "startGameUI", "", "", "");
    }

    public void townGate() {
        gameModel.position = "townGate";
        ui.image.setImageResource(R.drawable.town_gate);
        ui.setChoicesAndNextPositions("", "", "Enter town", "Leave", "", "", "talkGuard1", "crossRoad");

        if (!gameModel.isAliveDemonGeneral) {
            gameModel.isAngryGuard = false;
            ui.displayTextSlowly("Returning to the town, you spot the familiar figure of the guard standing at his post.\n" +
                    "As you approach, he looks up and recognition flashes across his face. \"You've returned,\" he says. ");
        } else
            ui.displayTextSlowly("As you draw near to the town gate, you notice that it is tightly shut and fortified.\n" +
                    "Standing before the gate is a guard, fully equipped with armor and a sword, their attentive gaze fixed upon you.");
        if (gameModel.isAngryGuard) {
            ui.setChoice1("Talk to the angry guard", "talkGuard1");
            ui.setChoice2("Attack the guard again", "attackGuard");
        } else {
            ui.setChoice1("Talk to the guard", "talkGuard1");
            ui.setChoice2("Attack the guard", "attackGuard");
        }
    }

    public void talkGuard1() {
        gameModel.position = "talkGuard1";
        Glide.with(ui).load(R.drawable.guard).into(ui.image);

        ui.setChoicesAndNextPositions("", "Leave", "", "", "", "crossRoad", "", "");

        if (!gameModel.isAliveDemonGeneral) {
            ui.displayTextSlowly("\"I heard rumors of the demon general's defeat. Is it true?\"\n" +
                    "You nod, sharing the details of your epic battle and the destruction of the demon general's hideout.\n" +
                    "The guard's stern expression softens, replaced by a genuine smile.\n" +
                    "\"You've done the town a great service. We owe you our gratitude.\"");
            ui.setChoice1("\"Can i enter the town now?\"", "talkGuard2");
        } else if (gameModel.isTakenArmor && !gameModel.isAngryGuard) {
            ui.displayTextSlowly("\"Ah, I see you're donning your new armor. It suits you well. " +
                    "But you still need to prove yourself trustworthy to get in.\" ");
            ui.setChoice1("\"Thank you\"", "crossRoad");
        } else {
            if (gameModel.isAngryGuard)
                ui.displayTextSlowly("The guard is clearly angry as they scold you for your attack.\n" +
                        "They look disappointed and emphasize how crucial it is to keep the town safe. Trust and redemption feel far away in this moment. ");
            else
                ui.displayTextSlowly("Guard: \"Hello, stranger! I cannot let unfamiliar faces into our town." +
                        "Prove yourself trustworthy, or find another way in.\" ");
            ui.setChoice1("\"How can i prove myself?\"", "talkGuard2");
        }
    }

    public void talkGuard2() {
        gameModel.position = "talkGuard2";
        ui.setChoicesAndNextPositions("", "Leave", "", "", "", "crossRoad", "", "");

        if (!gameModel.isAliveDemonGeneral) {
            ui.displayTextSlowly("The guard, now aware of your heroic triumph, opens the town gate for you without hesitation.");
            ui.setChoice1("Enter the town", "theEnd");
        } else {
            ui.displayTextSlowly("Guard: \"Lately, one of the demon general has been intruding into our land, endangering our safety. " +
                    "We urgently require a hero to safeguard our town.\"");
            ui.setChoice1("\"How am i supposed to do that\"", "talkGuard3");
        }
    }

    public void talkGuard3() {
        gameModel.position = "talkGuard3";

        ui.displayTextSlowly("He advises you to visit the blacksmith in the north to acquire better equipment first.");
        ui.setChoicesAndNextPositions("\"I got it\"", "Leave", "", "", "crossRoad", "crossRoad", "", "");
    }

    public void attackGuard() {
        gameModel.position = "attackGuard";
        gameModel.isAngryGuard = true;
        Glide.with(ui).load(R.drawable.guard).into(ui.image);
        int hpLost = (int) Math.ceil(8 * gameModel.difficultRate) - (gameModel.player.getArmor() != null ? gameModel.player.getArmor().getDamageReduced() : 0);
        if (ui.updatePlayerHp(-hpLost))
            ui.setChoicesAndNextPositions("\"Sorry\"", "Leave", "", "", "townGate", "crossRoad", "", "");
        ui.displayTextSlowly("As a consequence of your actions, the guard strikes you in response,\nresulting in you taking " + hpLost + " damage.");
    }

    public void crossRoad() {
        soundManager.stopAllSoundEffect();
        gameModel.position = "crossRoad";
        ui.image.setImageResource(R.drawable.cross_road);

        ui.displayTextSlowly("You find yourself at a crossroad, standing at the intersection of multiple paths.\n" +
                "The choices laid out offering different directions to explore.");
        ui.setChoicesAndNextPositions("Go North", "Go East", "Go South", "Go West (the town)", "blackSmithHouse", "riverSide", "goblinCave", "townGate");
    }

    public void blackSmithHouse() {
        gameModel.position = "blackSmithHouse";
        Glide.with(ui).load(R.drawable.black_smith_house).into(ui.image);
        soundManager.anvil();
        ui.displayTextSlowly("As you approach the blacksmith shop, the sound of hammer striking metal echoes in the air.\n" +
                "The skilled blacksmith can be seen diligently working at the forge.");
        ui.setChoicesAndNextPositions("Talk to the blacksmith", "Go East", "Go South", "", "talkBlackSmith", "northRiver", "crossRoad", "");
    }

    public void talkBlackSmith() {
        gameModel.position = "talkBlackSmith";
        ui.setChoicesAndNextPositions("Leave", "", "", "", "blackSmithHouse", "", "", "");

        if (!gameModel.blackSmithQuestActive) {
            ui.displayTextSlowly("The blacksmith, acknowledging your unfamiliar presence, kindly asks for a favor before proceeding with further conversation.\n" +
                    "He explain the troubles caused by a mischievous goblin and provide its last known location—a cave to the south.\n" +
                    "\"Return once you have successfully dealt with the.\""
            );
            ui.setChoicesAndNextPositions("Accept the request", "Leave", "", "", "acceptBlackSmithQuest", "blackSmithHouse", "", "");
        } else if (!gameModel.isALiveGoblin) {
            if (!gameModel.isTakenArmor) {
                ui.displayTextSlowly("\"Look like you've killed that goblin. I have a reward for you,\"  ");
                ui.setChoicesAndNextPositions("Take reward", "Leave", "", "", "takeArmor", "blackSmithHouse", "", "");
            } else if (gameModel.isTakenArmor) {
                ui.displayTextSlowly("They believe in your ability to overcome the challenge. " +
                        "The blacksmith advises, \"There's one more thing you should know. " +
                        "The witch who wanders along the river is known for her trickery.\nBe cautious and stay alert when you encounter her.\"");
                ui.setChoicesAndNextPositions("\"Thank you\"", "Leave", "", "", "blackSmithHouse", "blackSmithHouse", "", "");
            }
        } else {
            ui.displayTextSlowly("The blacksmith: \"That goblin is still alive! You better hurry to defeat it before it causes more harm.\"");
        }
    }

    public void acceptBlackSmithQuest() {
        gameModel.blackSmithQuestActive = true;
        gameModel.isTakenTorch = true;
        ui.displayTextSlowly("The blacksmith hands you a torch along with a fire stone. " +
                "He warns you about the darkness inside the goblin cave and advises you to use the torch to light your way.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "talkBlackSmith", "", "", "");
    }

    public void takeArmor() {
        if (gameModel.armors == null)
            gameModel.armors = new Armor[]{new Armor_IronArmor(), new Armor_SilverArmor(), new Armor_GoldenArmor()};

        Armor armor = gameModel.armors[rand.nextInt(3)];
        gameModel.player.setArmor(armor);
        ui.armorLabel.setVisibility(View.VISIBLE);
        ui.armorLabel.setText(armor.getName());
        ui.armorLabel.setTextColor(Color.parseColor(armor.getHexColorCode()));

        gameModel.isTakenArmor = true;
        ui.displayTextSlowly("The BlackSmith: \"Take this " + armor.getName() + " .Maybe it could help you.\"");
        ui.setChoicesAndNextPositions("\"Thank you\"", "Leave", "", "", "talkBlackSmith", "blackSmithHouse", "", "");
    }

    public void goblinCave() {
        if (gameModel.position.equals("insideGoblinCave") || gameModel.position.equals("deeperInsideGoblinCave"))
            soundManager.playBackGroundMusic();
        if (!gameModel.position.equals("lightTorch"))
            gameModel.isLightTorch = false;
        gameModel.position = "goblinCave";
        ui.image.setImageResource(R.drawable.goblin_cave);
        ui.displayTextSlowly("The cave is situated in the heart of a dense forest, surrounded by tall trees and vibrant green grass.\n" +
                "Approaching the entrance of the goblin cave, you see an ancient stone tunnel that leads further into the darkness.");
        ui.setChoicesAndNextPositions("Go inside the cave", "Go North", "Go East", "", "insideGoblinCave", "crossRoad", "southRiver", "");
        if (gameModel.isTakenTorch && !gameModel.isLightTorch)
            ui.setChoicesAndNextPositions("Go inside the cave", "Light torch", "Go North", "Go East", "insideGoblinCave", "lightTorch", "crossRoad", "southRiver");
    }

    public void lightTorch() {
        gameModel.position = "lightTorch";
        gameModel.isLightTorch = true;
        soundManager.lightFire();
        Toast.makeText(ui.getApplicationContext(), "You have lit the torch", Toast.LENGTH_SHORT).show();
        goblinCave();
    }

    public void insideGoblinCave() {
        gameModel.position = "insideGoblinCave";
        soundManager.insideCave();
        ui.displayTextSlowly("As you enter the goblin cave, peering into the darkness of the passage that leads deeper, you hesitate for a moment.");
        ui.setChoicesAndNextPositions("Go deeper", "Leave", "", "", "deeperInsideGoblinCave", "goblinCave", "", "");
        if (gameModel.isALiveGoblin) {
            if (gameModel.isLightTorch)
                ui.image.setImageResource(R.drawable.inside_goblin_cave);
            else
                ui.image.setImageResource(R.drawable.inside_dark_goblin_cave);
        } else {
            if (gameModel.isLightTorch)
                ui.image.setImageResource(R.drawable.inside_cave);
            else ui.image.setImageResource(R.drawable.inside_dark_cave);
        }
    }

    public void deeperInsideGoblinCave() {
        gameModel.lastPosition = gameModel.position;
        gameModel.position = "deeperInsideGoblinCave";
        soundManager.insideCave();
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        if (gameModel.isALiveGoblin) {
            if (gameModel.isLightTorch) {
                ui.displayTextSlowly("As you explore deeper into the goblin cave, a sudden noise startles you.\n" +
                        "You catch sight of a goblin dressed in a makeshift rat costume, its eyes gleaming with malice as it wielding a small axe. " +
                        "Without hesitation, it jumps towards you. Swiftly, you ... ");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gameModel.position = "encounterGoblin";
                        soundManager.goblin(false);
                        Glide.with(ui).load(R.drawable.goblin).into(ui.image);
                        soundManager.playBattleMusic();
                        ui.setChoice1("Parry its attack", "encounterGoblin");
                        ui.setChoice2("Try to run", "tryToRun");
                    }
                }, 2000);
            } else {
                ui.setChoice2("", "");
                ui.darkUI();
                ui.displayTextSlowly("As you venture deeper into the goblin cave, the oppressive darkness engulfs your senses.\n" +
                        "Suddenly, a creepy noise echoes through the chamber. The source of the sound is growing ever nearer.\n" +
                        "Before you can react, a swift and deadly attack strikes your throat, leaving you helpless in the depths of the cave.");
                soundManager.pauseBackGroundMusic();
                soundManager.goblin(true);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gameModel.player.setPlayerHP(0);
                        ui.updatePlayerHp(0);
                    }
                }, 3000);
            }
        } else {
            if (gameModel.isLightTorch) {
                ui.image.setImageResource(R.drawable.inside_cave);
                if (!gameModel.isDefeatedEvilWitch && gameModel.witchQuestActive && !gameModel.isTakenGoblinEar) {
                    ui.displayTextSlowly("As you explore the depths of the cave, you stumble upon the lifeless body of a goblin.");
                    ui.setChoicesAndNextPositions("Take the goblin's left ear", "Leave", "", "", "takeGoblinEar", "goblinCave", "", "");
                } else if (!gameModel.isTakenLongSword) {
                    ui.displayTextSlowly("As you explore the depths of the cave, you come across the lifeless body of a goblin.\n" +
                            "Something shiny catches your attention, revealing an old, weathered long sword.\n" +
                            "");
                    ui.setChoicesAndNextPositions("Take the long sword", "Leave", "", "", "takeLongSword", "goblinCave", "", "");
                } else {
                    ui.image.setImageResource(R.drawable.inside_cave_painting);
                    ui.displayTextSlowly("As you venture deeper into the cave, you come across a painting on the wall depicting a mountain.");
                    ui.setChoicesAndNextPositions("Leave", "", "", "", "goblinCave", "", "", "");
                }
            } else {
                ui.displayTextSlowly("As you continue deeper into the cave, you find that there is not much to discover.\n" +
                        "The darkness surrounds you, revealing no hidden treasures or significant sights.");
                ui.setChoicesAndNextPositions("Leave", "", "", "", "goblinCave", "", "", "");
            }
        }
    }

    public void takeGoblinEar() {
        gameModel.isTakenGoblinEar = true;
        ui.continueTextSlowly("Remembering the witch's request, you reach down to retrieve the goblin's left ear.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "deeperInsideGoblinCave", "", "", "");
    }

    public void takeLongSword() {
        gameModel.isTakenLongSword = true;
        if (gameModel.longSword == null)
            gameModel.longSword = new Weapon_LongSword();
        ui.obtainWeapon(gameModel.longSword);

        ui.continueTextSlowly("You pick up the long sword. Despite its worn appearance, yet it exudes a sense of strength, ready to be wielded once again.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "deeperInsideGoblinCave", "", "", "");
    }

    public void riverSide() {
        gameModel.position = "riverSide";
        if (!gameModel.isDefeatedEvilWitch) {
            ui.image.setImageResource(R.drawable.river_side_with_witch);
            ui.displayTextSlowly("You find yourself by the riverside. In the distance, you notice a small wooden bridge that stretches across the river.\n" +
                    "A witch passes by, her long dark cloak and a pointy hat adorning her head. ");
            ui.setChoicesAndNextPositions("Talk to the Witch", "Go North", "Go East(cross the river on bridge)", "Go West", "talkWitch1", "northRiver", "jungle", "crossRoad");
            if (gameModel.witchQuestActive)
                nextPosition1 = "talkWitch2";
        } else {
            ui.image.setImageResource(R.drawable.river_side);
            ui.displayTextSlowly("You find yourself by the riverside. In the distance, you notice a small wooden bridge that stretches across the river.");
            ui.setChoicesAndNextPositions("Go North", "Go East(cross the river on bridge)", "Go South", "Go West", "northRiver", "jungle", "southRiver", "crossRoad");
        }
    }

    public void talkWitch1() {
        ui.image.setImageResource(R.drawable.witch);

        ui.displayTextSlowly("\"Hey there, young man, You seem strong and capable. " +
                "If you do me a favor, I'll be sure to reward you handsomely.\"");
        ui.setChoicesAndNextPositions("Ask about the favor", "Leave", "", "", "talkWitch2", "riverSide", "", "");
    }

    public void talkWitch2() {
        ui.image.setImageResource(R.drawable.witch);

        if (gameModel.witchQuestActive)
            ui.setChoicesAndNextPositions("\"I'm on it\"", "Leave", "", "", "riverSide", "riverSide", "", "");
        else {
            if (gameModel.isTakenArmor)
                ui.setChoicesAndNextPositions("Accept the favor", "\"Don't try to fool me\"", "Leave", "", "acceptWitchQuest", "talkWitch3", "riverSide", "");
            else
                ui.setChoicesAndNextPositions("Accept the favor", "Leave", "", "", "acceptWitchQuest", "riverSide", "", "");
        }
        StringBuilder text = new StringBuilder("The witch requests that you venture into the jungle on the other side of the river and fetch her a fresh apple.\n" +
                "Additionally, she asks for a goblin's left ear.");
        if (gameModel.isTakenGoblinEar)
            text.append("\n(You had the goblin's left ear)");
        if (gameModel.isTakenApple)
            text.append("\n(You had the apple)");
        ui.displayTextSlowly(text.toString());

        if (gameModel.isTakenGoblinEar && gameModel.isTakenApple) {
            ui.setChoice1("\"Here are the items you requested.\"", "talkWitch3");
        }
    }

    public void acceptWitchQuest() {
        gameModel.witchQuestActive = true;
        selectPosition("riverSide");
    }

    public void talkWitch3() {
        ui.image.setImageResource(R.drawable.witch);
        soundManager.evilWitch();
        ui.setChoicesAndNextPositions("Encounter the Evil Witch", "", "", "", "encounterEvilWitch", "", "", "");

        if (gameModel.witchQuestActive) {
            ui.displayTextSlowly("The witch swiftly snatches the items from your grasp.\n" +
                    "Her mocking laughter fills the air as she taunts you for your foolishness.\n" +
                    "With a flick of her staff, a spell enveloping you in a cloud of toxic poison.");
        } else
            ui.displayTextSlowly("\"Don't try to fool me,\" you assert, your weapon held high in defiance.\n" +
                    "The witch's expression shifts from arrogance to surprise as she realizes that you see through her ruse.\n" +
                    "She bursts into laughter, with a swift flick of her staff, she casts a poison spell, enveloping you in a toxic haze.");
        if (gameModel.evilWitch == null)
            gameModel.evilWitch = new Monster_EvilWitch(gameModel.difficultRate);
    }

    public void talkWitch4() {
        ui.image.setImageResource(R.drawable.defeated_witch);
        ui.setChoicesAndNextPositions("Spare her life", "Finish her", "Leave", "", "talkWitch5", "talkWitch8", "talkWitch7", "");

        ui.displayTextSlowly("\"Enough! Spare my life, I'll remove the spell casted on you and give you a reward,\" " +
                "she begs, desperation evident in her voice. \"No more tricks, I swear.\"");
    }

    public void talkWitch5() {
        ui.image.setImageResource(R.drawable.defeated_witch);
        ui.setChoicesAndNextPositions("Enhance your strength", "Learn Poison breeze", "Why not both?", "Leave", "enhanceStrength", "learnPoisonBreeze", "talkWitch6", "riverSide");

        ui.displayTextSlowly("\"About the reward, I can either enhance your strength, making you even more powerful,\nor teach you the secret of the poison breeze, a lethal technique.\"");
    }

    public void talkWitch6() {
        ui.image.setImageResource(R.drawable.defeated_witch);
        ui.setChoicesAndNextPositions("Continue", "", "", "", "talkWitch5", "", "", "");

        ui.displayTextSlowly("\"No I can't. With such a little of power left, i can just give you one.\"");
    }

    public void talkWitch7() {
        ui.image.setImageResource(R.drawable.river_side);
        ui.setChoicesAndNextPositions("Go North", "Go south", "Go East(cross the river on bridge)", "Go West", "northRiver", "southRiver", "jungle", "crossRoad");
        ui.displayTextSlowly("As you spare the witch's life, she quickly realizes the gravity of the situation and hastily retreats.");
    }

    public void talkWitch8() {
        ui.image.setImageResource(R.drawable.river_side);
        ui.setChoicesAndNextPositions("Go North", "Go south", "Go East(cross the river on bridge)", "Go West", "northRiver", "southRiver", "jungle", "crossRoad");
        ui.displayTextSlowly("As you prepare to deliver the decisive blow.\nWith a swift motion of her hand, she unleashes a spell, creating a blinding flash of light that disorients you.\n" +
                "By the time your vision clears, the witch is nowhere to be seen.");
    }

    public void enhanceStrength() {
        gameModel.witchQuestActive = false;
        gameModel.player.increasePlayerMaxHP(3);
        gameModel.player.increaseBaseAttack(1);
        ui.updatePlayerHp(0);
        ui.setChoicesAndNextPositions("Continue", "", "", "", "talkWitch7", "", "", "");
        ui.continueTextSlowly("The witch enhances your strength, granting you a boost in power.\nYour maximum HP is increased by 3, and your base attack is enhanced by 1");
    }

    public void learnPoisonBreeze() {
        gameModel.witchQuestActive = false;
        gameModel.poisonBreeze = new Spell_PoisonBreeze();
        gameModel.poisonousEffect = gameModel.poisonBreeze.getEffect();
        gameModel.player.addSpell(gameModel.poisonBreeze);
        ui.updateSpellStatus();
        ui.setChoicesAndNextPositions("Continue", "", "", "", "talkWitch7", "", "", "");
        ui.continueTextSlowly("You learn the skill of Poison Breeze from the witch.\nAcquiring the ability to unleash a toxic cloud that deal " + gameModel.poisonousEffect.getDamage() + " damage each round against your enemies.");
    }

    public void northRiver() {
        soundManager.stopAllSoundEffect();
        gameModel.lastPosition = gameModel.position;
        gameModel.position = "northRiver";
        if (gameModel.lastPosition.equalsIgnoreCase("mountain")) {
            crossTheRiver();
        } else {
            ui.image.setImageResource(R.drawable.north_river);
            ui.setChoicesAndNextPositions("", "Go East(swim cross the river)", "Go South", "Go West", "", "mountain", "riverSide", "blackSmithHouse");

            if (!gameModel.isRestAtTent) {
                ui.displayTextSlowly("North of the river, you discover a cozy fireplace and an old tent by the riverside.\n" +
                        "Resting at the tent allows you to recover 10 HP.\nThe path to the northern ahead has been blocked.");
                ui.setChoicesAndNextPositions("Take a rest", "Go East(swim cross the river)", "Go South", "Go West", "takeRest", "mountain", "riverSide", "blackSmithHouse");

            } else {
                ui.displayTextSlowly("North of the river, you discover a cozy fireplace and an old tent by the riverside.\nThe path to the northern ahead has been blocked.");
                ui.setChoicesAndNextPositions("", "Go East(swim cross the river)", "Go South", "Go West", "", "mountain", "riverSide", "blackSmithHouse");
            }
        }
    }

    public void takeRest() {
        ui.updatePlayerHp(10);
        gameModel.isRestAtTent = true;
        ui.setChoicesAndNextPositions("Continue", "", "", "", "northRiver", "", "", "");
        ui.continueTextSlowly("Resting at a tent, you regain 10 HP.");
    }

    public void southRiver() {
        gameModel.lastPosition = gameModel.position;
        gameModel.position = "southRiver";
        if (gameModel.lastPosition.equalsIgnoreCase("demonHideout")) {
            crossTheRiver();
            soundManager.playBackGroundMusic();
        } else {
            ui.image.setImageResource(R.drawable.south_river);
            if (gameModel.isALiveRiverMonster) {
                ui.displayTextSlowly("South of the river, a strange vortex from the center of the water.\n" +
                        "Progress along the southern path is halted by a waterfall.");
                ui.setChoicesAndNextPositions("Throw a rock into it", "Go North", "Go East(swim cross the river)", "Go West", "encounterRiverMonster", "riverSide", "demonHideout", "goblinCave");
            } else {
                ui.displayTextSlowly("South of the river, a waterfall creates an impassable barrier, preventing any further advancement along the southern path.");
                ui.setChoicesAndNextPositions("Go North", "Go East(swim cross the river)", "Go West", "", "riverSide", "demonHideout", "goblinCave", "");
            }
        }
    }

    public void crossTheRiver() {
        if (gameModel.isALiveRiverMonster && rand.nextBoolean()) {
            ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
            ui.image.setImageResource(R.drawable.dark_screen);
            ui.darkUI();
            soundManager.stopAllMusic();
            ui.displayTextSlowly("You bravely swim across the river.\n" +
                    "Reaching the middle, a swirling vortex forms around you, and you feel a powerful force pulling you downwards.\n" +
                    "Before you can react, you are bitten by something formidable, dragging you deeper into the dark depths of the water.");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    soundManager.underWater();
                    soundManager.riverMonster();
                    gameModel.player.setPlayerHP(0);
                    ui.updatePlayerHp(0);
                }
            }, 2000);

        } else {
            ui.displayTextSlowly("You take the bold decision to swim across the river.\n" +
                    "The water is calm, and you manage to reach the other side without any mishaps or obstacles.");
            ui.setChoicesAndNextPositions("Continue", "", "", "", gameModel.position, "", "", "");
        }
    }

    public void jungle() {
        if (gameModel.position.equals("demonHideout"))
            soundManager.playBackGroundMusic();
        gameModel.position = "jungle";
        soundManager.stopAllSoundEffect();
        ui.image.setImageResource(R.drawable.jungle);
        ui.displayTextSlowly("You find yourself in a peaceful forest clearing, surrounded by tall, ancient trees.\n" +
                "Shafts of sunlight casting a gentle glow on the lush grass beneath your feet.\n" +
                "You see an apple tree.");
        ui.setChoicesAndNextPositions("Hit the apple tree", "Go North", "Go South", "Go West(cross the river on bridge)", "hitTheAppleTree", "mountain", "demonHideout", "riverSide");
    }

    public void hitTheAppleTree() {
        soundManager.hitTree();
        gameModel.position = "hitTheAppleTree";
        ui.setChoicesAndNextPositions("Hit the apple tree again", "Leave", "", "", "hitTheAppleTree", "jungle", "", "");
        int c1 = rand.nextInt(4);
        if (c1 % 2 == 0 && (gameModel.appleOnTree > 0 || (!gameModel.isDefeatedEvilWitch && gameModel.witchQuestActive && !gameModel.isTakenApple))) {
            StringBuilder text = new StringBuilder("You hit the apple tree, causing a ripe apple to fall.");
            if (!gameModel.isDefeatedEvilWitch && gameModel.witchQuestActive && !gameModel.isTakenApple) {
                text.append(" You have the option to claim the apple for the witch's request.");
                ui.setChoice1("Take the apple", "takeApple");
            }
            if (gameModel.appleOnTree > 0) {
                text.append(" You have the option to consume the apple for a boost of 4 HP.");
                ui.setChoice2("Eat the apple", "eatApple");
            }
            ui.setChoice3("Leave", "jungle");
            ui.displayTextSlowly(text.toString());
        } else if (c1 == 1) {
            ui.displayTextSlowly("You hit the apple tree, angering a nearby monkey.\nIt retaliates by throwing a stick at you, causing " + (int) Math.ceil(2 * gameModel.difficultRate) + " damage.");
            ui.updatePlayerHp(-(int) Math.ceil(2 * gameModel.difficultRate));
        } else
            ui.displayTextSlowly("Nothing happen.");
    }

    public void takeApple() {
        gameModel.isTakenApple = true;
        jungle();
    }

    public void eatApple() {
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        soundManager.eatingApple();
        gameModel.appleOnTree--;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.updatePlayerHp(4);
                jungle();
            }
        }, 1000);
    }

    public void mountain() {
        gameModel.lastPosition = gameModel.position;
        gameModel.position = "mountain";
        if (gameModel.lastPosition.equalsIgnoreCase("northRiver")) {
            crossTheRiver();
        } else {
            ui.image.setImageResource(R.drawable.mountain);
            soundManager.stopAllSoundEffect();
            soundManager.playBackGroundMusic();
            ui.displayTextSlowly("As you approach the towering mountain, your gaze is drawn to the peculiar sight atop its peak.\n" +
                    "Clusters of massive rock hover in the air, defying the natural laws of gravity.");
            ui.setChoicesAndNextPositions("Climb to the top", "Go South", "Go West(swim cross the river)", "", "mountainTop", "jungle", "northRiver", "");
        }
    }

    public void mountainTop() {
        gameModel.position = "mountainTop";
        ui.image.setImageResource(R.drawable.mountain_top);
        soundManager.pauseBackGroundMusic();
        soundManager.magicMountain();
        ui.displayTextSlowly("You climb the mountain, reaching the summit where a majestic stone gate awaits.\n" +
                "Passing through, you enter a sacred space surrounded by five towering stone statues, their presence exuding ancient power.");
        ui.setChoicesAndNextPositions("Touch the middle statue", "Leave", "", "", "touchStatue", "mountain", "", "");
        if (gameModel.isTakenPower)
            ui.setChoicesAndNextPositions("Leave", "", "", "", "mountain", "", "", "");
    }

    public void touchStatue() {
        ui.displayTextSlowly("The statues grant power to the traveler as a tribute to their courage. " +
                "Recognized as the chosen hero, the traveler's heroic blood resonates with the statues, allowing them to choose a power that suits their strengths and upcoming challenges.");
        ui.setChoicesAndNextPositions("Continue", "Leave", "", "", "offerPower", "mountain", "", "");
    }

    public void offerPower() {
        ui.displayTextSlowly("A mystical voice fills the air, carrying ancient wisdom and a sense of reverence. \n" +
                "\"Knowing the heroic blood that flows within you, we offer you a choice.\"\n" +
                "\"Embrace the path of strength, wield the power of scorching fire, command the paralyzing force of lightning, or harness the soothing energy of healing water.\"");
        ui.setChoicesAndNextPositions("Strength", "Fire power", "Lightning power", "Water power", "strengthPower", "firePower", "lightningPower", "waterPower");
    }

    public void strengthPower() {
        ui.displayTextSlowly("Strength Power: This power enhances the traveler's physical capabilities.\n" +
                "Tap into your inner strength and experience a surge of power. \n" +
                "Your maximum HP is increased by 4 and your base attack is enhanced by 1.");
        ui.setChoicesAndNextPositions("Take power", "Back", "", "", "takeStrengthPower", "offerPower", "", "");
    }

    public void takeStrengthPower() {
        gameModel.isTakenPower = true;
        gameModel.player.increasePlayerMaxHP(4);
        gameModel.player.increaseBaseAttack(1);
        soundManager.obtainWeapon();
        ui.updatePlayerHp(0);
        ui.continueTextSlowly("You feel an overwhelming surge of strength coursing through your veins as you embrace the power of enhanced strength.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "mountainTop", "", "", "");
    }

    public void firePower() {
        if (gameModel.fireStorm == null) gameModel.fireStorm = new Spell_FireStorm();
        gameModel.selectedSpell = gameModel.fireStorm;
        ui.displayTextSlowly("Fire Power: Grants the traveler mastery over the element of fire. " +
                "Enabling them to unleash devastating Fire Storm that scorches your enemies, dealing a significant " + gameModel.fireStorm.getDamage() + " damage.");
        ui.setChoicesAndNextPositions("Take power", "Back", "", "", "takePower", "offerPower", "", "");
    }

    public void lightningPower() {
        if (gameModel.lightningBolt == null) {
            gameModel.lightningBolt = new Spell_LightningBolt();
        }
        gameModel.selectedSpell = gameModel.lightningBolt;
        ui.displayTextSlowly("Lightning Power: Harness the electrifying energy of lightning.\n" +
                "Unleash bolts of lightning that deal " + gameModel.lightningBolt.getDamage() + " damage and momentarily stun monsters, granting you the opportunity to follow up with an additional attack.");
        ui.setChoicesAndNextPositions("Take power", "Back", "", "", "takePower", "offerPower", "", "");
    }

    public void waterPower() {
        if (gameModel.waterSurge == null) gameModel.waterSurge = new Spell_WaterSurge();
        gameModel.selectedSpell = gameModel.waterSurge;
        ui.displayTextSlowly("As the water spell surges forth, it forms a protective barrier that shields you from an impending monster attack, deflecting its harm. " +
                "Simultaneously, the restorative properties of the water envelop you, replenishing your vitality and restoring" + (-gameModel.waterSurge.getDamage()) + "points of health. ");
        ui.setChoicesAndNextPositions("Take power", "Back", "", "", "takePower", "offerPower", "", "");
    }

    public void takePower() {
        gameModel.isTakenPower = true;
        gameModel.player.addSpell(gameModel.selectedSpell);
        soundManager.obtainWeapon();
        ui.updateSpellStatus();
        ui.continueTextSlowly("Congratulations! You have learned the formidable spell " + gameModel.selectedSpell.getName());
        ui.setChoicesAndNextPositions("Continue", "", "", "", "mountainTop", "", "", "");
    }

    public void demonHideout() {
        gameModel.lastPosition = gameModel.position;
        gameModel.position = "demonHideout";
        if (gameModel.lastPosition.equalsIgnoreCase("southRiver")) {
            crossTheRiver();
        } else {
            if (gameModel.isAliveDemonGeneral) {
                ui.image.setImageResource(R.drawable.demon_hideout);
                soundManager.demonHideout();
                ui.displayTextSlowly("As you approach the demon's hideout, the landscape turns sinister and dark. " +
                        "The eerie atmosphere swallows the sunlight, the entrance to the demon's lair stands before you, and you steel yourself for the impending battle, preparing to face the horrors that await within.");
                ui.setChoicesAndNextPositions("Enter", "Go North", "Go West (swim across the river)", "", "insideDemonHideout", "jungle", "southRiver", "");
            } else {
                ui.image.setImageResource(R.drawable.demon_hideout_after_battle);
                ui.displayTextSlowly("The battlefield, once ruled by the demon general, now lies destroyed and desolate. " +
                        "Debris and remnants of the intense battle are scattered across the ground, a reminder of the epic clash that took place.");
                ui.setChoicesAndNextPositions("Go North", "Go West (swim across the river)", "", "", "jungle", "southRiver", "", "");
            }
        }
    }

    public void insideDemonHideout() {
        ui.displayTextSlowly("Venturing deeper into the heart of the demon's hideout. " +
                "The air becomes thick and oppressive, a haunting silence fills the surroundings.");
        ui.setChoicesAndNextPositions("Go deeper", "Leave", "", "", "", "demonHideout", "", "");
        if (gameModel.isAliveShadowSerpent)
            nextPosition1 = "encounterShadowSerpent";
        else nextPosition1 = "encounterDemonGeneral";
    }

    public void defeatDemonGeneral() {
        ui.image.setImageResource(R.drawable.explosion);
        soundManager.explosion();
        ui.displayTextSlowly("As the final blow lands on the demon general, a powerful explosion obliterates the demon's hideout.\n" +
                "After the explosion, you are left barely alive. " +
                "Exhaustion overwhelms you, and you lose consciousness, unsure of what awaits you in this dangerous situation.");
        ui.setChoicesAndNextPositions("...", "......", "", "", "wakeUpAfterFinalBattle", "wakeUpAfterFinalBattle", "", "");
    }

    public void wakeUpAfterFinalBattle() {
        ui.image.setImageResource(R.drawable.demon_hideout_after_battle);
        ui.displayTextSlowly("As you slowly wake up, your eyes open to a scene of complete destruction.\n" +
                "Among the debris, you spot a shining object—the demon sword.\n" +
                "Feeling disoriented and weakened, you make an effort to get back to the town.");
        gameModel.player.setPlayerHP(1);
        ui.updatePlayerHp(0);
        Toast.makeText(ui.getApplicationContext(), "You have defeated the demon general!", Toast.LENGTH_SHORT).show();
        if (gameModel.demonSword == null)
            gameModel.demonSword = new Weapon_DemonSword();
        ui.obtainWeapon(gameModel.demonSword);
        ui.setChoicesAndNextPositions("Leave", "", "", "", "townGate", "", "", "");
    }

    public void theEnd() {
        Glide.with(ui).load(R.drawable.the_end).into(ui.image);
        ui.darkUI();
        soundManager.playTheEndMusic();
        ui.displayTextSlowly("Thank you for playing the first version of the game!\n" +
                "Well done on your remarkable journey and accomplishments!\n" +
                "I appreciate your support, and I hope to see you again in the future when the game is further developed.\n" +
                "Stay tuned for more updates and exciting adventures ahead!");
        ui.setChoicesAndNextPositions("Play again", "Quit game", "", "", "start", "quit", "", "");
    }

    public void deadScreen() {
        soundManager.stopAllMusic();
        soundManager.stopAllSoundEffect();
        ui.image.setImageResource(R.drawable.dead_screen);
        ui.lightUI();
        ui.displayTextSlowly("YOU DIED!!!!");
        ui.setChoicesAndNextPositions("Try again", "Quit game", "", "", "timeLoop", "quit", "", "");
    }
}
