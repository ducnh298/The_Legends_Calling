package com.game.controller;

import android.graphics.Color;
import android.os.Handler;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.game.R;
import com.game.model.GameData;
import com.game.model.armors.Armor;
import com.game.model.weapons.Weapon;
import com.game.model.armors.Armor_GoldenArmor;
import com.game.model.armors.Armor_IronArmor;
import com.game.model.armors.Armor_SilverArmor;
import com.game.model.monsters.Monster_EvilWitch;
import com.game.model.spells.Spell_FireStorm;
import com.game.model.spells.Spell_LightningBolt;
import com.game.model.spells.Spell_WaterSurge;
import com.game.model.weapons.Weapon_DemonSword;
import com.game.model.weapons.Weapon_Knife;
import com.game.model.weapons.Weapon_LongSword;
import com.game.controller.activity.GameScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StoryManager {
    GameScreen ui;
    GameData gameData;
    CombatManager combatManager;
    SoundManager soundManager;

    public String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    private final Random rand;
    private final Handler handler;

    public StoryManager(GameScreen gameScreen, GameData gameData) {
        this.ui = gameScreen;
        this.gameData = gameData;
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
                soundManager.stopAllSoundEffect();
                soundManager.playBackGroundMusic();
                townGate();
                ui.saveGame();
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
            case "exploreTheSurrounding3":
                exploreTheSurrounding3();
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
            case "rideCarriage":
                rideCarriage();
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
            case "proveTrustWorthy1":
                proveTrustWorthy1();
                break;
            case "proveTrustWorthy2":
                proveTrustWorthy2();
                break;
            case "theTown":
                theTown();
                break;
            case "crossRoad":
                crossRoad();
                break;
            case "blackSmithHouse":
                blackSmithHouse();
                break;
            case "talkBlackSmith1":
                talkBlackSmith1();
                break;
            case "talkBlackSmith2":
                talkBlackSmith2();
                break;
            case "acceptBlackSmithQuest":
                acceptBlackSmithQuest();
                break;
            case "takeArmor":
                takeArmor();
                break;
            case "inquireGear":
                inquireGear();
                break;
            case "armorShop":
                armorShop();
                break;
            case "buyIronArmor":
                buyArmor(gameData.ironArmor);
                break;
            case "buySilverArmor":
                buyArmor(gameData.silverArmor);
                break;
            case "buyGoldenArmor":
                buyArmor(gameData.goldenArmor);
                break;
            case "confirmSellArmor":
                confirmSellArmor();
                break;
            case "sellArmor":
                sellArmor();
                break;
            case "weaponShop":
                weaponShop();
                break;
            case "confirmSellWeapon":
                confirmSellWeapon();
                break;
            case "sellWeapon":
                sellWeapon();
                break;
            case "enhanceWeapon":
                enhanceWeapon();
                break;
            case "northField":
                northField();
                break;
            case "talkYoungMan1":
                talkYoungMan1();
                break;
            case "talkYoungMan2":
                talkYoungMan2();
                break;
            case "acceptYoungManRequest2":
                acceptYoungManRequest(false);
                break;
            case "acceptYoungManRequest3":
                acceptYoungManRequest(true);
                break;
            case "encounterWolf":
                combatManager.encounterWolf();
                break;
            case "attackWolf":
                combatManager.attackWolf(false);
                break;
            case "attackWolfWithSpell":
                combatManager.attackWolf(true);
                break;
            case "defeatWolf":
                defeatWolf();
                break;
            case "askLucasAboutTheCave":
                askLucasAboutTheCave();
                break;
            case "townSewer":
                townSewer();
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
            case "askWitchAboutTeleportation1":
                askWitchAboutTeleportation1();
                break;
            case "askWitchAboutTeleportation2":
                askWitchAboutTeleportation2();
                break;
            case "askWitchAboutReturnByDeath1":
                askWitchAboutReturnByDeath1();
                break;
            case "askWitchAboutReturnByDeath2":
                askWitchAboutReturnByDeath2();
                break;
            case "encounterFightWitch":
                encounterFightWitch();
                break;
            case "defeatTheWitch":
                defeatTheWitch();
                break;
            case "witchReward":
                witchReward();
                break;
            case "  takeWitchMoney":
                takeWitchMoney();
                break;
            case " spareTheWitch":
                spareTheWitch();
                break;
            case "finishTheWitch":
                finishTheWitch();
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
            case "examineTent":
                examineTent();
                break;
            case "takeRestAtTent":
                takeRestAtTent();
                break;
            case "investigateFurtherTent":
                investigateFurtherTent();
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
            case "consumeTheHeart1":
                consumeTheHeart1();
                break;
            case "consumeTheHeart2":
                consumeTheHeart2();
                break;
            case "destroyTheHeart":
                destroyTheHeart();
                break;
            case "restAfterDestroyTheHeart":
                restAfterDestroyTheHeart();
                break;
            case "takeTheHeart":
                takeTheHeart();
                break;
            case "takeTheHeartToRiverSide":
                takeTheHeartToRiverSide();
                break;
            case "askWitchForHelp1":
                askWitchForHelp1();
                break;
            case "askWitchForHelpOption1":
                askWitchForHelpOption1();
                break;
            case "askWitchForHelpOption2":
                askWitchForHelpOption2();
                break;
            case "askWitchKnowAboutTheReturnByDeath":
                askWitchKnowAboutTheReturnByDeath();
                break;
            case "destroyAllTownArea":
                destroyAllTownArea();
                break;
            case "wakeUpAfterDestructionTownArea":
                wakeUpAfterDestructionTownArea();
                break;
            case "endYourLifeToSaveTheTown":
                endYourLifeToSaveTheTown();
                break;
            case "endYourLife":
                endYourLife();
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
        gameData.position = "opening";
        Glide.with(ui).load(R.drawable.driving_highway).into(ui.image);
        soundManager.drivingHighWay();
        ui.displayTextSlowly("It's late in the evening, you find yourself behind the wheel on a familiar road, heading home after a long day at work.\n" +
                "It's Friday night, and the darkness envelops the surroundings, with only a scattering of streetlights casting a dim glow. ");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "getHome", "", "", "");
    }

    public void getHome() {
        ui.image.setImageResource(R.drawable.black_screen);
        soundManager.openingDoor();
        ui.displayTextSlowly("You finally arrive home and eagerly insert the key into the lock, opening the door to your haven\n" +
                "...                                                                                                  \n" +
                "You kick off your shoes, drop your bag, releasing the weight of the day.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "bedRoom", "", "", "");
    }

    public void bedRoom() {
        handler.removeCallbacksAndMessages(null);
        ui.image.setImageResource(R.drawable.bedroom);
        soundManager.bedRoom();
        ui.displayTextSlowly("Making your way to your bedroom and notice that it has started raining outside.\n" +
                "With a sense of  exhaustion washing over you, you eagerly jump onto the bed, ready to drift into a deep and restful nap.");
        ui.setChoicesAndNextPositions("Take a rest", "", "", "", "sleeping", "", "", "");
    }

    public void sleeping() {
        handler.removeCallbacksAndMessages(null);
        ui.image.setImageResource(R.drawable.black_screen);
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
        gameData.position = "windyField1";
        soundManager.windyField();
        if (gameData.isDarknessConsume) {
            Glide.with(ui).load(R.drawable.windy_field).into(ui.image);
            ui.displayTextSlowly("You find yourself back in the familiar scene.\n" +
                    "However, something feels wrong. The darkness that consumed you before does not release its hold.\n" +
                    "Instead, it engulfs you once again, shrouding you in its suffocating presence. ");
            ui.setChoicesAndNextPositions("Continue", "", "", "", "consumeTheHeart1", "", "", "");
        } else {
            if (gameData.timeLoop) {
                ui.image.setImageResource(R.drawable.black_screen);
                ui.displayTextSlowly("\"Whoa, aaaa!!!\" you scream in pain, realizing that just seconds ago you had taken a fatal blow, and now you find yourself lying in the familiar grass once again.");
                ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
            } else {
                ui.saveGame();
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
    }

    public void windyField2() {
        ui.displayTextSlowly("You find yourself in the middle of a windy field, with the soft green grass swaying under the clear blue sky.\n" +
                "A sturdy wooden fence separates the field from a winding dirt road. ");
        ui.setChoicesAndNextPositions("Try to recollect your thoughts", "Explore the surrounding", "", "", "recollectYourThoughts", "exploreTheSurrounding1", "", "");
        if (gameData.isTakenCoins)
            ui.setChoice3("Leave", "windyField3");
    }

    public void recollectYourThoughts() {
        ui.setChoicesAndNextPositions("Continue", "", "", "", "windyField2", "", "", "");
        if (gameData.timeLoop) {
            ui.displayTextSlowly("After spending a couple of minutes trying to recollect your thoughts, a realization upon you — you possess the ability to return by death.\n" +
                    "Memories flood back, and you recall the knowledge of your previous encounters and the choices that led you to this point. ");
        } else
            ui.displayTextSlowly("After spending a couple of minutes trying to recollect your thoughts, you realize that your mind is completely blank.\n" +
                    "The world around you seems unfamiliar, and you notice that your clothes have transformed into an outfit from an old era.");
    }

    public void exploreTheSurrounding1() {
        if (!gameData.isTakenKnife) {
            ui.setChoicesAndNextPositions("Take it", "Leave it", "", "", "takeKnife", "notTakeKnife", "", "");
            ui.displayTextSlowly("As you explore the surrounding area, your eyes catch a glint of metal hidden among the tall grass.\n" +
                    "You reach down and discover an old knife, its blade worn but still sharp.\n");
        } else if (!gameData.isTakenCoins) exploreTheSurrounding2();
        else exploreTheSurrounding3();
    }

    public void exploreTheSurrounding2() {
        gameData.isTakenCoins = true;
        ui.setChoicesAndNextPositions("Continue to explore", "Leave", "", "", "exploreTheSurrounding3", "windyField2", "", "");
        ui.displayTextSlowly("As you continue to explore, your eyes catch a glimmer on the ground, revealing not just one, but two shiny coins.\n" +
                "You pick them up, wonder what these coins might be used for in this mysterious world.");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.updatePlayersCoins(2);
            }
        }, 1500);
    }

    public void exploreTheSurrounding3() {
        ui.setChoicesAndNextPositions("Continue", "", "", "", "windyField2", "", "", "");
        ui.displayTextSlowly("As you continue to explore, there are nothing of value or usefulness left in the surrounding area.");
    }

    public void takeKnife() {
        ui.setChoicesAndNextPositions("Continue to explore", "Leave", "", "", "exploreTheSurrounding2", "windyField2", "", "");
        ui.continueTextSlowly("You pick up the old knife, feeling its weight in your hand. Its worn handle and rusted blade tell tales of past adventures.");
        gameData.isTakenKnife = true;
        ui.updatePlayersWeapons(new Weapon_Knife());
        if (gameData.isTakenCoins)
            nextPosition1 = "exploreTheSurrounding3";
    }

    public void notTakeKnife() {
        ui.setChoicesAndNextPositions("Continue to explore", "Leave", "", "", "exploreTheSurrounding2", "windyField2", "", "");
        ui.continueTextSlowly("You decide not to take the old knife, feeling that it may not be of much use to you.");
        if (gameData.isTakenCoins)
            nextPosition1 = "exploreTheSurrounding3";
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
        gameData.position = "meetCarriage";
        Glide.with(ui).load(R.drawable.carriage).into(ui.image);
        soundManager.windyField();
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
                if (gameData.isTakenKnife)
                    ui.setChoice4("Take control the carriage", "attackCarriage");
            }
        }, 2500);
        ui.saveGame();
    }

    public void attackCarriage() {
        ui.displayTextSlowly("With the knife in hand, you bravely attempt to seize control of the carriage.\n" +
                "However, The man reacts swiftly, drawing his sword and delivering a powerful strike on you, instantly ending your life.");
        gameData.player.setPlayerHP(0);
        ui.updatePlayersHp(0);
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
        ui.setChoicesAndNextPositions("Give him a coin", "Is this coin acceptable", "", "", "rideCarriage", "rideCarriage", "", "");
        ui.displayTextSlowly("Prioritizing your safety, you ask the man for a ride. The man requests a coin as payment for taking you with him.");
    }

    public void rideCarriage() {
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        ui.displayTextSlowly("The man takes the coin from your hand and nods, signaling for you to climb into the back of the carriage. " +
                "As the wheels begin to turn, the carriage sets off towards the direction of Rivervale town");
        ui.updatePlayersCoins(-1);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Glide.with(ui).load(R.drawable.carriage).into(ui.image);
                soundManager.horse();
                soundManager.horseWagonNear();
                ui.setChoicesAndNextPositions("Continue", "", "", "", "onCarriage1", "", "", "");
            }
        }, 2000);
    }


    public void onCarriage1() {
        ui.displayTextSlowly("As the carriage continues its journey, you seize the opportunity to ask the man a series of questions.");
        ui.setChoicesAndNextPositions("About the teleportation between worlds", "About the history of this world", "Done asking", "", "askAboutTeleportation", "askAboutHistoryOfThisWorld1", "onCarriage2", "");
        if (gameData.timeLoop)
            ui.setChoicesAndNextPositions("About the teleportation between worlds", "About the history of this world", "About the ability to return by death", "Done asking", "askAboutTeleportation", "askAboutHistoryOfThisWorld1", "askAboutAbilityToReTurnByDeath", "onCarriage2");
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
        ui.displayTextSlowly("\"Legend speaks of a legendary artifact known as the 'Bow of Light,' said to possess the power to vanquish the darkness.\n" +
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
        gameData.position = "townGate";
        ui.image.setImageResource(R.drawable.town_gate);
        soundManager.playBackGroundMusic();
        ui.setChoicesAndNextPositions("", "", "Enter town", "Leave", "", "", "talkGuard1", "crossRoad");

        if (!gameData.isAliveDemonGeneral) {
            ui.startGameUI();
            gameData.isAngryGuard = false;
            ui.displayTextSlowly("Returning to the town, you spot the familiar figure of the guard standing at his post.\n" +
                    "As you approach, he looks up and recognition flashes across his face. \"You've returned,\" he says. ");
        } else
            ui.displayTextSlowly("As you draw near to the town gate, you notice that it is tightly shut and fortified.\n" +
                    "Standing before the gate is a guard, fully equipped with armor and a sword, their attentive gaze fixed upon you.");
        if (gameData.isOpenTownGate)
            nextPosition3 = "theTown";
        if (gameData.isAngryGuard) {
            if (gameData.isOpenTownGate) {
                ui.setChoice1("Talk to angry Cedric", "talkGuard1");
                ui.setChoice2("Attack Cedric again", "attackGuard");
            }
            ui.setChoice1("Talk to the angry guard", "talkGuard1");
            ui.setChoice2("Attack the guard again", "attackGuard");
        } else {
            if (gameData.isOpenTownGate) {
                ui.setChoice1("Talk to Cedric", "talkGuard1");
                ui.setChoice2("Attack Cedric", "attackGuard");
            }
            ui.setChoice1("Talk to the guard", "talkGuard1");
            ui.setChoice2("Attack the guard", "attackGuard");
        }
    }

    public void talkGuard1() {
        Glide.with(ui).load(R.drawable.guard).into(ui.image);

        ui.setChoicesAndNextPositions("", "Leave", "", "", "", "crossRoad", "", "");

        if (!gameData.isAliveDemonGeneral) {
            ui.displayTextSlowly("\"I heard rumors of the demon general's defeat. Is it true?\"\n" +
                    "You nod, sharing the details of your epic battle and the destruction of the demon general's hideout.\n" +
                    "The guard's stern expression softens, replaced by a genuine smile.\n" +
                    "\"You've done the town a great service. We owe you our gratitude.\"");
            ui.setChoice1("Continue", "talkGuard2");
        } else if (gameData.isTakenArmor && !gameData.isAngryGuard) {
            ui.displayTextSlowly("\"Ah, I see you're donning your new armor. It suits you well. " +
                    "But you still need to prove yourself trustworthy to get in.\" ");
            ui.setChoice1("\"Thank you\"", "crossRoad");
        } else if (!gameData.isOpenTownGate) {
            if (gameData.isAngryGuard)
                ui.displayTextSlowly("The guard is clearly angry as they scold you for your attack.\n" +
                        "They look disappointed and emphasize how crucial it is to keep the town safe. Trust and redemption feel far away in this moment. ");
            else
                ui.displayTextSlowly("Guard: \"Hello, stranger! I cannot let unfamiliar faces into our town." +
                        "Prove yourself trustworthy, or find another way in.\" ");
            ui.setChoicesAndNextPositions("\"How can i prove myself?\"", "Handing him a coin", "Leave", "", "talkGuard2", "proveTrustWorthy1", "crossRoad", "");
        } else
            talkGuard2();
    }

    public void proveTrustWorthy1() {
        ui.displayTextSlowly("The guard looks at the coin you offered: \"A single coin won't be enough to prove your trustworthiness.\"");
        ui.setChoicesAndNextPositions("Give him another", "Leave", "", "", "proveTrustWorthy2", "crossRoad", "", "");
    }

    public void proveTrustWorthy2() {
        if (gameData.player.getCoins() >= 2) {
            ui.displayTextSlowly("The guard takes the two coins from your hand, examining them briefly before nodding in approval.\n" +
                    "\"Very well,\" he says. \"A small token of trust. You may pass. By the way my name is Cedric. Welcome to our town.\" then opening the door for you to pass through.");
            ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    gameData.isOpenTownGate = true;
                    ui.updatePlayersCoins(-2);
                    soundManager.townGateDoor();
                    ui.setChoicesAndNextPositions("Enter the town", "Leave", "", "", "theTown", "crossRoad", "", "");
                    ui.saveGame();
                }
            }, 2300);
        } else {
            ui.displayTextSlowly("\"Come back to me whenever you have enough coin.\"");
            ui.setChoicesAndNextPositions("Leave", "", "", "", "crossRoad", "", "", "");
        }
    }

    public void talkGuard2() {
        ui.setChoicesAndNextPositions("", "Leave", "", "", "", "crossRoad", "", "");

        if (!gameData.isAliveDemonGeneral) {
            ui.displayTextSlowly("The guard, opens the town gate wide for you. As you enter, you are greeted by the heartwarming sight of all the townspeople gathered, cheering and celebrating your victorious return. " +
                    "The joy and gratitude in their eyes fill your heart with a sense of fulfillment and purpose.");
            soundManager.crowdCheer();
            ui.setChoicesAndNextPositions("Enter the town", "Leave", "", "", "restAfterDestroyTheHeart", "crossRoad", "", "");
        } else {
            ui.displayTextSlowly("Guard: \"Lately, one of the demon general has been intruding into our land, endangering our safety. " +
                    "We urgently require a hero to safeguard our town.\"");
            if (gameData.isOpenTownGate)
                ui.setChoicesAndNextPositions("Continue", "Leave", "", "", "talkGuard3", "crossRoad", "", "");
            else ui.setChoicesAndNextPositions("Leave", "", "", "", "crossRoad", "", "", "");
        }
    }

    public void talkGuard3() {
        ui.displayTextSlowly("He advises you to visit the blacksmith in the north of the town to acquire better equipment first.");
        if (gameData.isOpenTownGate)
            ui.setChoicesAndNextPositions("\"I got it\"", "Enter town", "Leave", "", "crossRoad", "theTown", "crossRoad", "");
        else
            ui.setChoicesAndNextPositions("\"I got it\"", "Leave", "", "", "crossRoad", "crossRoad", "", "");

    }

    public void attackGuard() {
        gameData.isAngryGuard = true;
        Glide.with(ui).load(R.drawable.guard).into(ui.image);
        int hpLost = (int) Math.ceil(8 * gameData.difficultRate) - (gameData.player.getArmor() != null ? gameData.player.getArmor().getDamageReduced() : 0);
        if (ui.updatePlayersHp(-hpLost))
            ui.setChoicesAndNextPositions("\"Sorry\"", "Leave", "", "", "townGate", "crossRoad", "", "");
        ui.displayTextSlowly("As a consequence of your actions, the guard strikes you in response,\nresulting in you taking " + hpLost + " damage.");
    }

    public void theTown() {
        soundManager.stopAllSoundEffect();
        gameData.position = "theTown";
        ui.image.setImageResource(R.drawable.the_town);
        soundManager.theTown();
        ui.displayTextSlowly("As you stand in the town, you are surrounded by the lively sounds of people bustling about their daily activities.");
        ui.setChoicesAndNextPositions("Go North", "Leave", "", "", "blackSmithHouse", "townGate", "", "");
    }

    public void crossRoad() {
        gameData.position = "crossRoad";
        ui.image.setImageResource(R.drawable.cross_road);
        soundManager.playBackGroundMusic();

        ui.displayTextSlowly("You find yourself at a crossroad, standing at the intersection of multiple paths.\n" +
                "The choices laid out offering different directions to explore.");
        ui.setChoicesAndNextPositions("Go North", "Go East", "Go South", "Go West (the town gate)", "northField", "riverSide", "goblinCave", "townGate");
    }

    public void northField() {
        gameData.position = "northField";
        soundManager.playBackGroundMusic();

        ui.setChoicesAndNextPositions("Talk with the man", "Go East", "Go South", "", "talkYoungMan1", "northRiver", "crossRoad", "");
        if (gameData.isAliveWolf) {
            ui.image.setImageResource(R.drawable.north_field_with_man_wolf);
            ui.displayTextSlowly("Northeast of the town, your eyes are drawn to a peculiar sight.\n" +
                    "Behind a bush, you spot a young man observing a lone wolf standing beneath a massive, solitary tree.\n" +
                    "The man's presence seems hidden, as if he is carefully observing the wolf's behavior without being noticed. ");
        } else {
            ui.image.setImageResource(R.drawable.north_field_with_man);
            ui.displayTextSlowly("Northeast of the town,you find yourself standing in an open field with a breathtaking view of the sky.\n" +
                    "As you approach, you notice Lucas, standing beneath a majestic, solitary tree.\n" +
                    "The wolf that once posed a threat is no longer in sight, indicating that Lucas has successfully transported it back to the town.");
            ui.setChoice1("Talk with Lucas", "talkYoungMan1");
        }
        if (gameData.isKnownTownSewer)
            ui.setChoice4("Go West", "townSewer");
    }

    public void talkYoungMan1() {
        if (gameData.isAliveWolf) {
            ui.displayTextSlowly("He gestures for you to keep quiet and whispers, \"The wolf may be dangerous, but its skin and meat can be valuable resources.\"\n" +
                    "The man observes your appearance and remarks, \"You seem capable of handling that wolf easily. " +
                    "How about you take care of it, and I'll keep its body as well as reward you with 2 coins?\"");
            ui.setChoicesAndNextPositions("Accept the request", "\"2 coins? I'm not gonna do it.\"", "Leave", "", "acceptYoungManRequest2", "talkYoungMan2", "northField", "");
        } else {
            ui.displayTextSlowly("Lucas: \"Hello there! Is there anything i can help?\"");
            if (gameData.isMeetDarkCave) {
                if (!gameData.isTakenTorch)
                    ui.setChoicesAndNextPositions("Ask for a way to sneak into the town", "Ask for any light source to be able to go into the dark cave located in the south", "Leave", "", "talkYoungMan2", "askLucasAboutTheCave", "crossRoad", "");
                else
                    ui.setChoicesAndNextPositions("Ask for a way to sneak into the town", "Ask about the dark cave located in the south", "Leave", "", "talkYoungMan2", "askLucasAboutTheCave", "northField", "");
            } else
                ui.setChoicesAndNextPositions("Ask for a way to sneak into the town", "Leave", "", "", "talkYoungMan2", "northField", "", "");
        }
    }

    public void talkYoungMan2() {
        if (gameData.isAliveWolf) {
            ui.displayTextSlowly("\"Alright, I understand. I can offer you 3 coins instead for taking care of the wolf. " +
                    "It's a fair price considering the risks involved. What do you say?\"\n");
            ui.setChoicesAndNextPositions("Accept the request", "Leave", "", "", "acceptYoungManRequest3", "northField", "", "");
        } else {
            gameData.isKnownTownSewer = true;
            ui.displayTextSlowly("\"There's a large sewer system that runs beneath the streets.\n" +
                    "It's not the most pleasant path, but it should allow you to enter undetected.\n" +
                    "Just be cautious of any lurking dangers within the tunnels.\"\n");
            ui.setChoicesAndNextPositions("\"Thank you\"", "Leave", "", "", "talkYoungMan1", "northField", "", "");
        }
    }

    public void askLucasAboutTheCave() {
        String text = "\"Ah, that ancient cave. People have reported seeing a goblin enter it, but no one has been able to capture it. Be careful as you venture inside.\"\n";
        if (!gameData.isTakenTorch) {
            text += "Lucas hands you a small torch and a flint to light it, providing you with a source of light to guide your way through the cavernous depths.";
            gameData.isTakenTorch = true;
            ui.saveGame();
        }
        ui.displayTextSlowly(text);
        ui.setChoicesAndNextPositions("\"Thank you\"", "Leave", "", "", "talkYoungMan1", "northField", "", "");
    }

    public void acceptYoungManRequest(boolean dealUp) {
        if (dealUp)
            gameData.youngManRequestReward = 3;
        else gameData.youngManRequestReward = 2;
        if (gameData.player.getWeaponList().size() == 0 || (gameData.player.getWeaponList().size() == 1 && gameData.player.getWeaponList().get(0).getName().contains("Knife"))) {
            gameData.isBorrowSword = true;
            ui.continueTextSlowly("You accept the man's request.\n\"Here. I'll lend you my sword. Good luck.\"");
        }
        ui.setChoicesAndNextPositions("Encounter the wolf", "", "", "", "encounterWolf", "", "", "");

    }

    public void defeatWolf() {
        gameData.position = "defeatWolf";
        soundManager.playBackGroundMusic();
        ui.image.setImageResource(R.drawable.north_field_with_man);
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        StringBuilder text = new StringBuilder("As the wolf collapses to the ground, its threat vanquished, the man approaches, gratitude evident in his eyes.\n");
        if (gameData.isBorrowSword)
            text.append("He take back his sword and fulfills his promise, handing you the agreed-upon coins.\n");
        else
            text.append("He fulfills his promise, handing you the agreed-upon coins.\n");
        text.append("The man introduces himself as Lucas, a local with a good understanding of the area around here.");
        ui.displayTextSlowly(text.toString());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.updatePlayersCoins(gameData.youngManRequestReward);
                ui.setChoicesAndNextPositions("Continue", "", "", "", "northField", "", "", "");
            }
        }, 2500);
    }

    public void townSewer() {
        gameData.position = "townSewer";
        ui.image.setImageResource(R.drawable.town_sewer);
        soundManager.playBackGroundMusic();

        ui.displayTextSlowly("As you approach the sewer entrance, you notice that it is constructed from sturdy stone and its surprisingly cleanliness.");
        ui.setChoicesAndNextPositions("Go through the sewer", "Go East", "", "", "theTown", "northField", "", "");
    }

    public void blackSmithHouse() {
        gameData.position = "blackSmithHouse";
        Glide.with(ui).load(R.drawable.black_smith_house).into(ui.image);
        soundManager.anvil();
        soundManager.theTown();
        ui.displayTextSlowly("As you approach the blacksmith shop, the sound of hammer striking metal echoes in the air.\n" +
                "The skilled blacksmith can be seen diligently working at the forge.");
        ui.setChoicesAndNextPositions("Talk to the blacksmith", "Go South", "", "", "talkBlackSmith1", "theTown", "", "");
        if (gameData.isTakenArmor)
            ui.setChoicesAndNextPositions("Talk to Garret", "Go South", "", "", "talkBlackSmith1", "theTown", "", "");
    }

    public void talkBlackSmith1() {
        ui.setChoicesAndNextPositions("Leave", "", "", "", "blackSmithHouse", "", "", "");
        if (!gameData.blackSmithQuestActive) {
            ui.displayTextSlowly("The blacksmith, acknowledging your unfamiliar presence, kindly asks for a favor before proceeding with further conversation.\n" +
                    "He explain the troubles caused by a mischievous goblin and provide its last known location—a cave to the south.\n" +
                    "\"Return once you have successfully dealt with the.\""
            );
            ui.setChoicesAndNextPositions("Accept the request", "Leave", "", "", "acceptBlackSmithQuest", "blackSmithHouse", "", "");
        } else if (!gameData.isALiveGoblin) {
            if (!gameData.isTakenArmor) {
                ui.displayTextSlowly("\"Look like you've killed that goblin. I have a reward for you,\".");
                ui.setChoicesAndNextPositions("Take reward", "Leave", "", "", "takeArmor", "talkBlackSmith2", "", "");
            } else if (gameData.isTakenArmor) {
                ui.displayTextSlowly("Garret presents you with several options to buy, upgrade or sell your armor, your weapon.\n");
                ui.setChoicesAndNextPositions("Inquire about your gear", "Armor", "Weapon", "Leave", "inquireGear", "armorShop", "weaponShop", "talkBlackSmith2");
            }
        } else {
            ui.displayTextSlowly("The blacksmith: \"That goblin is still alive! You better hurry to defeat it before it causes more harm.\"");
        }
    }

    public void talkBlackSmith2() {
        if (gameData.isTakenArmor)
            ui.displayTextSlowly("Garret advises: \"There's one more thing you should know. " +
                    "The witch who wanders along the river is known for her trickery.\nBe cautious and stay alert when you encounter her.\"");
        else
            ui.displayTextSlowly("The blacksmith advises: \"There's one more thing you should know. " +
                    "The witch who wanders along the river is known for her trickery.\nBe cautious and stay alert when you encounter her.\"");
        ui.setChoicesAndNextPositions("\"I got it\"", "Leave", "", "", "blackSmithHouse", "crossRoad", "", "");
    }

    public void acceptBlackSmithQuest() {
        gameData.blackSmithQuestActive = true;
        gameData.isTakenTorch = true;
        ui.displayTextSlowly("The blacksmith hands you a torch along with a flint. " +
                "He warns you about the darkness inside the goblin cave and advises you to use the torch to light your way.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "blackSmithHouse", "", "", "");
        ui.saveGame();
    }

    public void takeArmor() {
        gameData.isTakenArmor = true;
        gameData.ironArmor = new Armor_IronArmor();
        gameData.silverArmor = new Armor_SilverArmor();
        gameData.goldenArmor = new Armor_GoldenArmor();
        ui.updatePlayersArmor(gameData.ironArmor);

        ui.displayTextSlowly("\"Take this " + gameData.player.getArmor().getName() + " .Maybe it could help you.\n" +
                "And my name is Garret. It's a pleasure to help you with your armor or weapon.\"");
        ui.setChoicesAndNextPositions("\"Thank you\"", "Leave", "", "", "talkBlackSmith1", "talkBlackSmith2", "", "");
        ui.saveGame();
    }

    public void inquireGear() {
        StringBuilder text = new StringBuilder("You inquire about your current gear and allow the blacksmith to examine it.\n");
        if (gameData.player.getArmor() != null)
            text.append("\"Your " + gameData.player.getArmor().getName() + " is capable of absorbing " + gameData.player.getArmor().getDamageReduced() + " damage from monster attacks.\n");
        if (gameData.player.getWeaponList().size() > 0) {
            for (Weapon weapon : gameData.player.getWeaponList()) {
                text.append("Your " + weapon.getName() + " is assessed to have a maximum damage of " + weapon.getCriticalAttackDamage());
                if (weapon.canUpgrade())
                    text.append(" and can be enhance more.");
                text.append("\n");
            }
        }
        ui.displayTextSlowly(text.toString());
    }

    public void armorShop() {
        int currentArmorValue = gameData.player.getArmor() != null ? gameData.player.getArmor().getValue() : 0;
        ui.displayTextSlowly("He offers to upgrade your current armor to a superior one for an additional fee, or you can opt to sell your current armor for a good price and buy a new one.");
        if (currentArmorValue == 0) {
            ui.setChoicesAndNextPositions("Buy Iron Armor (" + gameData.ironArmor.getValue() + " coins)", "Buy Silver Armor (+" + gameData.silverArmor.getValue() + " coins)",
                    "Buy Golden Armor Armor (+" + gameData.goldenArmor.getValue() + " coins)",
                    "Leave", "buyIronArmor", "buySilverArmor", "buyGoldenArmor", "talkBlackSmith2");
        } else if (currentArmorValue > 0) {
            ui.setChoicesAndNextPositions("Upgrade to Silver Armor (+" + (gameData.silverArmor.getValue() - currentArmorValue) + " coins)",
                    "Upgrade to Golden Armor Armor (+" + (gameData.goldenArmor.getValue() - currentArmorValue) + " coins)",
                    "Sell your " + gameData.player.getArmor().getName() + " for " + (currentArmorValue - 1) + " coins", "Leave", "buySilverArmor", "buyGoldenArmor", "confirmSellArmor", "talkBlackSmith2");
            if (currentArmorValue == gameData.silverArmor.getValue())
                ui.setChoice1("", "");
            else if (currentArmorValue == gameData.goldenArmor.getValue()) {
                ui.setChoice1("", "");
                ui.setChoice2("", "");
            }
        }
    }

    public void weaponShop() {
        Weapon currentWeapon;
        if (gameData.player.getWeaponList().size() > 0) {
            currentWeapon = gameData.player.getWeaponList().get(ui.weaponSpinner.getSelectedItemPosition());
            ui.displayTextSlowly("He offers to enhance your weapon for an additional fee, or you can opt to sell your weapon for a good price and buy a new one.");
            ui.setChoice1("Buy new weapon", "");
            ui.setChoice2("Sell your " + currentWeapon.getName() + " for " + (currentWeapon.getValue() - 1) + " coins", "confirmSellWeapon");
            if (currentWeapon.canUpgrade())
                ui.setChoice3("Enhance your " + currentWeapon.getName() + " (" + currentWeapon.getEnhanceCost() + " coins)", "enhanceWeapon");
        }
        ui.setChoice4("Leave", "talkBlackSmith1");
    }

    public void buyArmor(Armor armor) {
        if (ui.updatePlayersCoins(-(armor.getValue() - (gameData.player.getArmor() != null ? gameData.player.getArmor().getValue() : 0)))) {
            ui.updatePlayersArmor(armor);
            ui.saveGame();
        }
        armorShop();
    }

    public void confirmSellArmor() {
        ui.displayTextSlowly("Are you sure to sell your " + gameData.player.getArmor().getName() + " for " + (gameData.player.getArmor().getValue() - 1) + " coins???");
        ui.setChoicesAndNextPositions("Yes", "No", "", "", "sellArmor", "armorShop", "", "");
    }

    public void sellArmor() {
        ui.updatePlayersCoins(gameData.player.getArmor().getValue() - 1);
        gameData.player.removeArmor();
        ui.updatePlayersArmor(null);
        armorShop();
        ui.saveGame();
    }

    public void confirmSellWeapon() {
        Weapon currentWeapon = gameData.player.getWeaponList().get(ui.weaponSpinner.getSelectedItemPosition());
        ui.displayTextSlowly("Are you sure to sell your " + currentWeapon.getName() + " for " + (currentWeapon.getValue() - 1) + " coins???");
        ui.setChoicesAndNextPositions("Yes", "No", "", "", "sellWeapon", "weaponShop", "", "");
    }

    public void sellWeapon() {
        Weapon currentWeapon = gameData.player.getWeaponList().get(ui.weaponSpinner.getSelectedItemPosition());
        ui.updatePlayersCoins(currentWeapon.getValue() - 1);
        gameData.player.removeWeapon(currentWeapon);
        ui.updatePlayersWeapons(null);
        weaponShop();
        ui.saveGame();
    }

    public void enhanceWeapon() {
        Weapon currentWeapon = gameData.player.getWeaponList().get(ui.weaponSpinner.getSelectedItemPosition());
        if (ui.updatePlayersCoins(-currentWeapon.getEnhanceCost())) {
            ui.displayTextSlowly("The blacksmith enhance your" + currentWeapon.getName() + " by sharpening it and refurbishing any worn parts, thereby improving its overall effectiveness.\n" +
                    "Your " + currentWeapon.getName() + "now can deal up to " + currentWeapon.getCriticalAttackDamage() + " damage");
            ui.setChoicesAndNextPositions("Continue", "", "", "", "weaponShop", "", "", "");
            currentWeapon.enhanceWeapon();
            ui.updatePlayersWeapons(null);
            ui.saveGame();
        } else weaponShop();
    }

    public void goblinCave() {
        if (!gameData.position.equals("lightTorch"))
            gameData.isLightTorch = false;
        gameData.position = "goblinCave";
        ui.image.setImageResource(R.drawable.goblin_cave);
        soundManager.playBackGroundMusic();
        ui.displayTextSlowly("The cave is situated in the heart of a dense forest, surrounded by tall trees and vibrant green grass.\n" +
                "Approaching the entrance of the cave, you see an ancient stone tunnel that leads further into the darkness.");
        ui.setChoicesAndNextPositions("Go inside the cave", "Go North", "Go East", "", "insideGoblinCave", "crossRoad", "southRiver", "");
        if (gameData.isTakenTorch && !gameData.isLightTorch)
            ui.setChoicesAndNextPositions("Go inside the cave", "Light torch", "Go North", "Go East", "insideGoblinCave", "lightTorch", "crossRoad", "southRiver");
    }

    public void lightTorch() {
        gameData.position = "lightTorch";
        gameData.isLightTorch = true;
        soundManager.lightFire();
        Toast.makeText(ui.getApplicationContext(), "You have lit the torch", Toast.LENGTH_SHORT).show();
        goblinCave();
    }

    public void insideGoblinCave() {
        gameData.position = "insideGoblinCave";
        gameData.isMeetDarkCave = true;
        soundManager.insideCave();
        ui.displayTextSlowly("As you enter the cave, peering into the darkness of the passage that leads deeper\n" +
                "You hesitate for a moment, questioning the wisdom of venturing into such a dark cave.");
        ui.setChoicesAndNextPositions("Go deeper", "Leave", "", "", "deeperInsideGoblinCave", "goblinCave", "", "");
        if (gameData.isALiveGoblin) {
            if (gameData.isLightTorch)
                ui.image.setImageResource(R.drawable.inside_goblin_cave);
            else
                ui.image.setImageResource(R.drawable.inside_dark_goblin_cave);
        } else {
            if (gameData.isLightTorch)
                ui.image.setImageResource(R.drawable.inside_cave);
            else ui.image.setImageResource(R.drawable.inside_dark_cave);
        }
    }

    public void deeperInsideGoblinCave() {
        gameData.lastPosition = gameData.position;
        gameData.position = "deeperInsideGoblinCave";
        soundManager.insideCave();
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        if (gameData.isALiveGoblin) {
            if (gameData.isLightTorch) {
                ui.displayTextSlowly("As you explore deeper into the goblin cave, a sudden noise startles you.\n" +
                        "You catch sight of a goblin dressed in a makeshift rat costume, its eyes gleaming with malice as it wielding a small axe. " +
                        "Without hesitation, it jumps towards you. Swiftly, you ... ");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gameData.position = "encounterGoblin";
                        soundManager.goblin(false);
                        Glide.with(ui).load(R.drawable.goblin).into(ui.image);
                        soundManager.playBattleMusic();
                        ui.setChoice1("Parry its attack", "encounterGoblin");
                        ui.setChoice2("Try to run", "tryToRun");
                    }
                }, 2000);
            } else {
                ui.image.setImageResource(R.drawable.black_screen);
                ui.darkUI();
                ui.displayTextSlowly("As you venture deeper into the goblin cave, the oppressive darkness engulfs your senses.\n" +
                        "Suddenly, a creepy noise echoes through the chamber. The source of the sound is growing ever nearer.\n" +
                        "Before you can react, a swift and deadly attack strikes your throat, leaving you helpless in the depths of the cave.");
                soundManager.stopAllMusic();
                soundManager.goblin(true);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gameData.player.setPlayerHP(0);
                        ui.updatePlayersHp(0);
                    }
                }, 3000);
            }
        } else {
            if (gameData.isLightTorch) {
                ui.image.setImageResource(R.drawable.inside_cave);
                if (!gameData.isDefeatedEvilWitch && gameData.witchQuestActive && !gameData.isTakenGoblinEar) {
                    ui.displayTextSlowly("As you explore the depths of the cave, you stumble upon the lifeless body of a goblin.");
                    ui.setChoicesAndNextPositions("Take the goblin's left ear", "Leave", "", "", "takeGoblinEar", "goblinCave", "", "");
                } else if (!gameData.isTakenLongSword) {
                    ui.displayTextSlowly("As you explore the depths of the cave, you come across the lifeless body of a goblin.\n" +
                            "Something shiny catches your attention, revealing an old, weathered long sword.");
                    ui.setChoicesAndNextPositions("Take the long sword", "Leave", "", "", "takeLongSword", "goblinCave", "", "");
                } else {
                    ui.image.setImageResource(R.drawable.inside_cave_painting);
                    ui.displayTextSlowly("As you venture deeper into the cave, you come across a painting on the wall depicting a mountain." +
                            (gameData.timeLoop ? "A good place for using your ability without being seen." : ""));
                    ui.setChoicesAndNextPositions("Leave", "", "", "", "goblinCave", "", "", "");
                    if (gameData.timeLoop)
                        ui.setChoice2("End your life", "endYourLife");
                }
            } else {
                ui.displayTextSlowly("As you continue deeper into the cave, you find that there is not much to discover.\n" +
                        "The darkness surrounds you, revealing no hidden treasures or significant sights.\n" +
                        (gameData.timeLoop ? "A good place for using your ability without being seen." : ""));
                ui.setChoicesAndNextPositions("Leave", "", "", "", "goblinCave", "", "", "");
                if (gameData.timeLoop) ui.setChoice2("End your life", "endYourLife");
            }
        }
    }

    public void takeGoblinEar() {
        gameData.isTakenGoblinEar = true;
        ui.continueTextSlowly("Remembering the witch's request, you reach down to retrieve the goblin's left ear, but as you do, you notice something unexpected. " +
                "In the goblin's pocket, you find two coins tucked away. ");
        ui.updatePlayersCoins(2);
        ui.setChoicesAndNextPositions("Continue", "", "", "", "deeperInsideGoblinCave", "", "", "");
        ui.saveGame();
    }

    public void takeLongSword() {
        gameData.isTakenLongSword = true;
        ui.updatePlayersWeapons(new Weapon_LongSword());

        ui.continueTextSlowly("You pick up the long sword. Despite its worn appearance, yet it exudes a sense of strength, ready to be wielded once again.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "deeperInsideGoblinCave", "", "", "");
        ui.saveGame();
    }

    public void riverSide() {
        gameData.position = "riverSide";
        soundManager.playBackGroundMusic();
        if (!gameData.isDefeatedEvilWitch) {
            ui.image.setImageResource(R.drawable.river_side_with_witch);
            ui.displayTextSlowly("You find yourself by the riverside. In the distance, you notice a small wooden bridge that stretches across the river.\n" +
                    "A witch passes by, her long dark cloak and a pointy hat adorning her head. ");
            ui.setChoicesAndNextPositions("Talk to the Witch", "Go North", "Go East(cross the river on bridge)", "Go West", "talkWitch1", "northRiver", "jungle", "crossRoad");
            if (gameData.witchQuestActive)
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

        if (gameData.witchQuestActive) {
            if (!gameData.timeLoop)
                ui.setChoicesAndNextPositions("\"I'm on it\"", "Ask about the teleportation between worlds", "Leave", "", "riverSide", "askWitchAboutTeleportation1", "riverSide", "");
            else {
                ui.setChoice3("Ask about the ability to return by death", "askWitchAboutReturnByDeath1");
                ui.setChoice4("Leave", "riverSide");
            }
        } else {
            if (gameData.isTakenArmor)
                ui.setChoicesAndNextPositions("Accept the favor", "\"Don't try to fool me\"", "Leave", "", "acceptWitchQuest", "encounterFightWitch", "riverSide", "");
            else
                ui.setChoicesAndNextPositions("Accept the favor", "Leave", "", "", "acceptWitchQuest", "riverSide", "", "");
        }

        StringBuilder text = new StringBuilder("The witch requests that you venture into the jungle on the other side of the river and fetch her a fresh apple.\n" +
                "Additionally, she asks for a goblin's left ear.");
        if (gameData.isTakenGoblinEar)
            text.append("\n(You had the goblin's left ear)");
        if (gameData.isTakenApple)
            text.append("\n(You had the apple)");
        ui.displayTextSlowly(text.toString());

        if (gameData.isTakenGoblinEar && gameData.isTakenApple) {
            ui.setChoice1("\"Here are the items you requested.\"", "encounterFightWitch");
        }

    }

    public void acceptWitchQuest() {
        gameData.witchQuestActive = true;
        riverSide();
        ui.saveGame();
    }

    public void askWitchAboutTeleportation1() {
        ui.displayTextSlowly("She explaining that while tales of interdimensional travel exist." +
                "It is an incredibly complex and risky effort, one must possess immense knowledge and power to even attempt such a feat.");
        ui.setChoicesAndNextPositions("Continue", "Leave", "", "", "askWitchAboutTeleportation2", "riverSide", "", "");
    }

    public void askWitchAboutTeleportation2() {
        ui.continueTextSlowly("There is a rumor she has heard: In the past, heroes were summoned by the shaman council of the five countries to assist in the battle against the demon army. " +
                "These heroes possessed extraordinary powers that were not of this world, making them formidable against the forces of evil.");
        ui.setChoice1("Continue", "talkWitch2");
    }

    public void askWitchAboutReturnByDeath1() {
        ui.displayTextSlowly("She hesitates before sharing that it is a forbidden art of dark magic, steeped in legends and whispered stories." +
                "\"This is such a powerful ability but warns that it can be a curse as well.\"");
        ui.setChoicesAndNextPositions("Continue", "Leave", "", "", "askWitchAboutReturnByDeath2", "riverSide", "", "");
    }

    public void askWitchAboutReturnByDeath2() {
        ui.continueTextSlowly("\"While it provides the opportunity to correct mistakes and change outcomes, it also comes with a heavy burden and potential consequences." +
                "The repeated experience of death and the manipulation of time can take a toll on one's mind and soul.\"");
        ui.setChoice1("Continue", "talkWitch2");
    }

    public void encounterFightWitch() {
        ui.image.setImageResource(R.drawable.witch);
        soundManager.evilWitch();
        ui.setChoicesAndNextPositions("Encounter the Evil Witch", "", "", "", "encounterEvilWitch", "", "", "");

        if (gameData.witchQuestActive) {
            ui.displayTextSlowly("The witch swiftly snatches the items from your grasp.\n" +
                    "Her mocking laughter fills the air as she taunts you for your foolishness.\n" +
                    "With a flick of her staff, a spell enveloping you in a cloud of toxic poison.");
        } else
            ui.displayTextSlowly("\"Don't try to fool me,\" you assert, your weapon held high in defiance.\n" +
                    "The witch's expression shifts from arrogance to surprise as she realizes that you see through her ruse.\n" +
                    "She bursts into laughter, with a swift flick of her staff, she casts a poison spell, enveloping you in a toxic haze.");
        if (gameData.evilWitch == null)
            gameData.evilWitch = new Monster_EvilWitch(gameData.difficultRate);
    }

    public void defeatTheWitch() {
        gameData.position = "defeatTheWitch";
        ui.image.setImageResource(R.drawable.defeated_witch);
        soundManager.playBackGroundMusic();
        ui.setChoicesAndNextPositions("Spare her life", "Finish her", "Leave", "", "witchReward", "finishTheWitch", " spareTheWitch", "");

        ui.displayTextSlowly("\"Enough! Spare my life, I'll remove the spell casted on you and give you a reward,\" " +
                "she begs, desperation evident in her voice. \"No more tricks, I swear.\"");
    }

    public void witchReward() {
        ui.image.setImageResource(R.drawable.defeated_witch);
        ui.setChoicesAndNextPositions("Enhance your strength", "Learn Poison breeze", "\"Hand over all your money!\"", "Leave", "enhanceStrength", "learnPoisonBreeze", "  takeWitchMoney", "riverSide");

        ui.displayTextSlowly("\"About the reward, I can either enhance your strength, making you even more powerful,\nor teach you the secret of the poison breeze, a lethal technique.\"");
    }

    public void takeWitchMoney() {
        gameData.witchQuestActive = false;
        ui.image.setImageResource(R.drawable.defeated_witch);
        ui.displayTextSlowly("You refuse the witch's offer for power and instead demand all of her money.\n" +
                "She promptly reaches for her money pouch and turns it upside down, causing four shiny coins to spill out onto your open palm.");
        ui.setChoicesAndNextPositions("", "", "", "", " ", "", "", "");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.updatePlayersCoins(4);
                ui.setChoicesAndNextPositions("Continue", "", "", "", " spareTheWitch", "", "", "");
            }
        }, 2000);
    }

    public void spareTheWitch() {
        gameData.isSpareWitch = true;
        ui.image.setImageResource(R.drawable.river_side);
        ui.setChoicesAndNextPositions("Go North", "Go south", "Go East(cross the river on bridge)", "Go West", "northRiver", "southRiver", "jungle", "crossRoad");
        ui.displayTextSlowly("As you spare the witch's life, she quickly realizes the gravity of the situation and hastily retreats.");
        ui.saveGame();
    }

    public void finishTheWitch() {
        ui.image.setImageResource(R.drawable.river_side);
        ui.setChoicesAndNextPositions("Go North", "Go south", "Go East(cross the river on bridge)", "Go West", "northRiver", "southRiver", "jungle", "crossRoad");
        ui.displayTextSlowly("As you prepare to deliver the decisive blow.\nWith a swift motion of her hand, she unleashes a spell, creating a blinding flash of light that disorients you.\n" +
                "By the time your vision clears, the witch is nowhere to be seen.");
    }

    public void enhanceStrength() {
        gameData.witchQuestActive = false;
        gameData.player.increasePlayerMaxHP(3);
        gameData.player.increaseBaseAttack(1);
        ui.updatePlayersHp(0);
        ui.setChoicesAndNextPositions("Continue", "", "", "", " spareTheWitch", "", "", "");
        ui.continueTextSlowly("The witch enhances your strength, granting you a boost in power.\nYour maximum HP is increased by 3, and your base attack is enhanced by 1");
    }

    public void learnPoisonBreeze() {
        gameData.witchQuestActive = false;
        gameData.player.addSpell(gameData.poisonBreeze);
        ui.updatePlayersSpells();
        ui.setChoicesAndNextPositions("Continue", "", "", "", " spareTheWitch", "", "", "");
        ui.continueTextSlowly("You learn the skill of Poison Breeze from the witch.\nAcquiring the ability to unleash a toxic cloud that deal " + gameData.poisonousEffect.getDamage() + " damage each round against your enemies.");
    }

    public void northRiver() {
        soundManager.stopAllSoundEffect();
        gameData.lastPosition = gameData.position;
        gameData.position = "northRiver";
        soundManager.playBackGroundMusic();
        if (gameData.lastPosition.equalsIgnoreCase("mountain")) {
            crossTheRiver();
        } else {
            ui.image.setImageResource(R.drawable.north_river);
            ui.setChoicesAndNextPositions("Examine the tent", "Go East(swim cross the river)", "Go South", "Go West", "examineTent", "mountain", "riverSide", "northField");
            ui.displayTextSlowly("North of the river, you discover an old tent by the riverside.\n" +
                    "Resting at the tent allows you to recover 10 HP.\nThe path to the northern ahead has been blocked.\n");
        }
    }

    public void examineTent() {
        ui.setChoicesAndNextPositions("Take a rest", "Investigate further", "Leave", "", "takeRestAtTent", "investigateFurtherTent", "northRiver", "");

        ui.displayTextSlowly("Its weathered appearance as if it has been left abandoned for some time. Despite its worn condition, it still provides a suitable place for resting during your travels");
        if (!gameData.isRestAtTent)
            ui.setChoice1("Take a rest (1st allow you to recover 10 HP)", "takeRestAtTent");
    }

    public void takeRestAtTent() {
        if (gameData.isRestAtTent) {
            ui.setChoicesAndNextPositions("Continue", "Leave", "", "", "examineTent", "northRiver", "", "");
            ui.displayTextSlowly("As you rest, your fatigue begins to fade away, and you feel your strength returning.");
        } else {
            ui.updatePlayersHp(10);
            gameData.isRestAtTent = true;
            ui.setChoicesAndNextPositions("Continue", "Leave", "", "", "examineTent", "northRiver", "", "");
            ui.displayTextSlowly("As you rest, your fatigue begins to fade away, and you feel your strength returning. You regain 10 hit points,");
            ui.saveGame();
        }
    }

    public void investigateFurtherTent() {
        if (gameData.isTakenCoinsInTent) {
            ui.displayTextSlowly("As you investigate further, it seems that there is nothing of significant value to be found.");
            ui.setChoicesAndNextPositions("Continue", "Leave", "", "", "examineTent", "northRiver", "", "");
        } else {
            ui.displayTextSlowly("As you investigate further, you discover a hidden compartment within the tent, and inside it, you find 2 coins.");
            ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    gameData.isTakenCoinsInTent = true;
                    ui.updatePlayersCoins(2);
                    ui.setChoicesAndNextPositions("Investigate further", "Leave", "", "", "investigateFurtherTent", "northRiver", "", "");
                    ui.saveGame();
                }
            }, 1500);
        }
    }

    public void southRiver() {
        gameData.lastPosition = gameData.position;
        gameData.position = "southRiver";
        soundManager.playBackGroundMusic();
        if (gameData.lastPosition.equalsIgnoreCase("demonHideout")) {
            crossTheRiver();
        } else {
            ui.image.setImageResource(R.drawable.south_river);
            if (gameData.isALiveRiverMonster) {
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
        if (gameData.isALiveRiverMonster && rand.nextBoolean()) {
            ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
            ui.image.setImageResource(R.drawable.black_screen);
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
                    gameData.player.setPlayerHP(0);
                    ui.updatePlayersHp(0);
                }
            }, 2000);

        } else {
            ui.displayTextSlowly("You take the bold decision to swim across the river.\n" +
                    "The water is calm, and you manage to reach the other side without any mishaps or obstacles.");
            ui.setChoicesAndNextPositions("Continue", "", "", "", gameData.position, "", "", "");
        }
    }

    public void jungle() {
        gameData.position = "jungle";
        soundManager.stopAllSoundEffect();
        soundManager.playBackGroundMusic();
        ui.image.setImageResource(R.drawable.jungle);
        ui.displayTextSlowly("You find yourself in a peaceful forest clearing, surrounded by tall, ancient trees.\n" +
                "Shafts of sunlight casting a gentle glow on the lush grass beneath your feet.\n" +
                "You see an apple tree.");
        ui.setChoicesAndNextPositions("Hit the apple tree", "Go North", "Go South", "Go West(cross the river on bridge)", "hitTheAppleTree", "mountain", "demonHideout", "riverSide");
    }

    public void hitTheAppleTree() {
        soundManager.hitTree();
        ui.setChoicesAndNextPositions("Hit the apple tree again", "Leave", "", "", "hitTheAppleTree", "jungle", "", "");
        int c1 = rand.nextInt(4);
        if (c1 % 2 == 0 && (gameData.appleOnTree > 0 || (!gameData.isDefeatedEvilWitch && gameData.witchQuestActive && !gameData.isTakenApple))) {
            StringBuilder text = new StringBuilder("You hit the apple tree, causing a ripe apple to fall.");
            if (!gameData.isDefeatedEvilWitch && gameData.witchQuestActive && !gameData.isTakenApple) {
                text.append(" You have the option to claim the apple for the witch's request.");
                ui.setChoice1("Take the apple", "takeApple");
            }
            if (gameData.appleOnTree > 0) {
                text.append(" You have the option to consume the apple for a boost of 4 HP.");
                ui.setChoice2("Eat the apple", "eatApple");
            }
            ui.setChoice3("Leave", "jungle");
            ui.displayTextSlowly(text.toString());
        } else if (c1 == 1) {
            if (rand.nextBoolean()) {
                ui.displayTextSlowly("You hit the apple tree, angering a nearby monkey.\nIt retaliates by throwing a coin at you, causing " + (int) Math.ceil(2 * gameData.difficultRate) + " damage.");
                ui.updatePlayersCoins(1);
                gameData.coinsOnTree--;
            } else
                ui.displayTextSlowly("You hit the apple tree, angering a nearby monkey.\nIt retaliates by throwing a stick at you, causing " + (int) Math.ceil(2 * gameData.difficultRate) + " damage.");
            ui.updatePlayersHp(-(int) Math.ceil(2 * gameData.difficultRate));
        } else
            ui.displayTextSlowly("Nothing happen.");
    }

    public void takeApple() {
        gameData.isTakenApple = true;
        jungle();
        ui.saveGame();
    }

    public void eatApple() {
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        soundManager.eatingApple();
        gameData.appleOnTree--;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.updatePlayersHp(4);
                jungle();
                ui.saveGame();
            }
        }, 1000);
    }

    public void mountain() {
        gameData.lastPosition = gameData.position;
        gameData.position = "mountain";
        if (gameData.lastPosition.equalsIgnoreCase("northRiver")) {
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
        gameData.position = "mountainTop";
        ui.image.setImageResource(R.drawable.mountain_top);
        soundManager.stopAllMusic();
        soundManager.magicMountain();
        ui.displayTextSlowly("You climb the mountain, reaching the summit where a majestic stone gate awaits.\n" +
                "Passing through, you enter a sacred space surrounded by five towering stone statues, their presence exuding ancient power.");
        ui.setChoicesAndNextPositions("Touch the middle statue", "Leave", "", "", "touchStatue", "mountain", "", "");
        if (gameData.isTakenPower)
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
        gameData.isTakenPower = true;
        gameData.player.increasePlayerMaxHP(4);
        gameData.player.increaseBaseAttack(1);
        soundManager.obtainWeapon();
        ui.updatePlayersHp(0);
        ui.continueTextSlowly("You feel an overwhelming surge of strength coursing through your veins as you embrace the power of enhanced strength.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "mountainTop", "", "", "");
        ui.saveGame();
    }

    public void firePower() {
        if (gameData.fireStorm == null) {
            gameData.fireStorm = new Spell_FireStorm();
            gameData.fireStorm.setSoundEffect(soundManager.spellFireSoundId);
        }
        gameData.selectedSpell = gameData.fireStorm;
        ui.displayTextSlowly("Fire Power: Grants the traveler mastery over the element of fire. " +
                "Enabling them to unleash devastating Fire Storm that scorches your enemies, dealing a significant " + gameData.fireStorm.getDamage() + " damage.");
        ui.setChoicesAndNextPositions("Take power", "Back", "", "", "takePower", "offerPower", "", "");
    }

    public void lightningPower() {
        if (gameData.lightningBolt == null) {
            gameData.lightningBolt = new Spell_LightningBolt();
            gameData.lightningBolt.setSoundEffect(soundManager.spellLightningSoundId);
        }
        gameData.selectedSpell = gameData.lightningBolt;
        ui.displayTextSlowly("Lightning Power: Harness the electrifying energy of lightning.\n" +
                "Unleash bolts of lightning that deal " + gameData.lightningBolt.getDamage() + " damage and momentarily stun monsters, granting you the opportunity to follow up with an additional attack.");
        ui.setChoicesAndNextPositions("Take power", "Back", "", "", "takePower", "offerPower", "", "");
    }

    public void waterPower() {
        if (gameData.waterSurge == null) {
            gameData.waterSurge = new Spell_WaterSurge();
            gameData.waterSurge.setSoundEffect(soundManager.spellWaterSoundId);
        }
        gameData.selectedSpell = gameData.waterSurge;
        ui.displayTextSlowly("As the water spell surges forth, it forms a protective barrier that shields you from an impending monster attack, deflecting its harm. " +
                "Simultaneously, the restorative properties of the water envelop you, replenishing your vitality and restoring" + (-gameData.waterSurge.getDamage()) + "points of health. ");
        ui.setChoicesAndNextPositions("Take power", "Back", "", "", "takePower", "offerPower", "", "");
    }

    public void takePower() {
        gameData.isTakenPower = true;
        gameData.player.addSpell(gameData.selectedSpell);
        soundManager.obtainWeapon();
        ui.updatePlayersSpells();
        ui.continueTextSlowly("Congratulations! You have learned the formidable spell " + gameData.selectedSpell.getName());
        ui.setChoicesAndNextPositions("Continue", "", "", "", "mountainTop", "", "", "");
        ui.saveGame();
    }

    public void demonHideout() {
        gameData.lastPosition = gameData.position;
        gameData.position = "demonHideout";
        if (gameData.lastPosition.equalsIgnoreCase("southRiver")) {
            crossTheRiver();
        } else {
            if (gameData.isAliveDemonGeneral) {
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
        if (gameData.isAliveShadowSerpent)
            nextPosition1 = "encounterShadowSerpent";
        else nextPosition1 = "encounterDemonGeneral";
    }

    public void defeatDemonGeneral() {
        gameData.position = "defeatDemonGeneral";
        Glide.with(ui).load(R.drawable.explosion).into(ui.image);
        gameData.player.setPlayerHP(1);
        ui.updatePlayersHp(0);
        soundManager.explosion();
        ui.displayTextSlowly("As the final blow lands on the demon general, a powerful explosion obliterates the demon's hideout.\n" +
                "After the explosion, you are left barely alive. Exhaustion overwhelms you, and you lose consciousness, unsure of what awaits you in this dangerous situation.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "wakeUpAfterFinalBattle", "", "", "");
    }

    public void wakeUpAfterFinalBattle() {
        ui.darkUI();
        ui.image.setImageResource(R.drawable.black_screen);
        soundManager.stopAllSoundEffect();
        soundManager.windyField();
        Toast.makeText(ui.getApplicationContext(), "You have defeated the demon general!", Toast.LENGTH_SHORT).show();
        ui.displayTextSlowly("As you awaken, the aftermath of devastation surrounds you, and in your left hand, you hold the heart of the demon general.\n" +
                "Its power beckons you, promising unimaginable strength and the ability to vanquish any foe in your path.\n" +
                "Becoming an unstoppable force, capable of protecting not only yourself but also the innocent townsfolk, tempts you to consume the heart and embrace its dark power.");
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.image.setImageResource(R.drawable.demon_hideout_after_battle);
                ui.setChoicesAndNextPositions("Consume the heart", "Take the heart to find the way to deal with it.", "Destroy the heart", "", "consumeTheHeart1", "takeTheHeart", "destroyTheHeart", "");
            }
        }, 1500);
    }

    public void consumeTheHeart1() {
        gameData.position = "consumeTheHeart1";
        gameData.isDarknessConsume = true;
        ui.saveGame();
        ui.darkUI();
        ui.image.setImageResource(R.drawable.black_screen);
        soundManager.stopAllMusic();
        soundManager.darkPower();
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        ui.displayTextSlowly("A surge of dark energy courses through your veins. " +
                "You find yourself helplessly succumbing to the malevolent power within." +
                "The darkness envelops you, leaving you trapped in its ominous grip." +
                "Your consciousness slips away . . . . .\n");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Weapon> weaponList = new ArrayList<>();
                weaponList.add(new Weapon_DemonSword());
                gameData.player.setPlayerHP(gameData.player.getPlayerMaxHP());
                ui.image.setImageResource(R.drawable.blood_screen);
                ui.continueTextSlowly("You regain awareness, find yourself surrounded by chaos.\n" +
                        "The scent of fresh blood fills the air, mingling with the sounds of agonized screams echoing in your ears.");
                ui.setChoicesAndNextPositions("Continue", "", "", "", "consumeTheHeart2", "", "", "");
                soundManager.crowdScream();
                gameData.isOpenTownGate = true;
                if (gameData.timeLoop)
                    ui.setChoice2("Try to end your life", "endYourLife");
            }
        }, 4000);
    }

    public void consumeTheHeart2() {
        ui.image.setImageResource(R.drawable.blood_screen);
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        if (gameData.isOpenTownGate) {
            gameData.isOpenTownGate = false;
            ui.displayTextSlowly("\"I'm Cedric, the guard of this town,\" he declared, his voice firm and resolute as he stood in your path raising his sword. " +
                    "\"You have taken so many lives, and I cannot allow you to harm the innocent any further.\" . . .");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Glide.with(ui).load(R.drawable.bloody_face).into(ui.image);
                    soundManager.slashPeople();
                    ui.setChoicesAndNextPositions("Continue", "", "", "", "consumeTheHeart2", "", "", "");
                }
            }, 5000);
        } else if (gameData.isKnownTownSewer) {
            gameData.isKnownTownSewer = false;
            ui.displayTextSlowly("A familiar voice calls out amidst the chaos.\n\"Hey... it's me...e, your...your friend Lucas.\" " +
                    "He stammered, fear evident in his voice as he stood before you. " +
                    "\"You..you must regain control of your mind. Fight..fight the darkness within you and remember who you truly are.\" . . .");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Glide.with(ui).load(R.drawable.bloody_face).into(ui.image);
                    soundManager.slashPeople();
                    ui.setChoicesAndNextPositions("Continue", "", "", "", "consumeTheHeart2", "", "", "");
                }
            }, 5500);
        } else if (gameData.isTakenArmor) {
            gameData.isTakenArmor = false;
            ui.displayTextSlowly("\"It's me, Garret, the blacksmith." +
                    "\"Please, please control your mind. I know there is darkness within you, but you are stronger than it. " +
                    "You have the strength to overcome it. Please, I beg of you, spare the innocent and find your way back to the light.\" . . . ");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Glide.with(ui).load(R.drawable.bloody_face).into(ui.image);
                    soundManager.slashPeople();
                    ui.setChoicesAndNextPositions("Continue", "", "", "", "consumeTheHeart2", "", "", "");
                }
            }, 5500);
        } else {
            ui.image.setImageResource(R.drawable.black_screen);
            ui.displayTextSlowly("As the darkness fully consumed you, the echoing screams of innocent lives faded into the background, replaced by the sinister cawing of crows.\n" +
                    "With every step you took, the land trembled and the skies darkened, as your allegiance to darkness grew stronger.\n" +
                    "The path of redemption seemed distant, as you embraced your new role as the demon king's servant, ready to unleash havoc upon the world.");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    soundManager.crow();
                   ui.setChoicesAndNextPositions("Continue", "", "", "", "theEnd", "", "", "");
                }
            }, 2500);
        }
    }

    public void endYourLife() {
        ui.darkUI();
        ui.image.setImageResource(R.drawable.dead_screen);
        soundManager.stopAllMusic();
        soundManager.endYourLife();
        ui.displayTextSlowly("As you take your own life, hoping to utilize the ability to return by death and correct your mistake.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "windyField1", "", "", "");
    }

    public void takeTheHeart() {
        gameData.position = "takeTheHeart";
        gameData.isDarknessConsume = true;
        ui.saveGame();
        ui.image.setImageResource(R.drawable.demon_hideout_after_battle);
        ui.darkUI();
        soundManager.stopAllMusic();
        ui.displayTextSlowly("You make the decision to take the heart with you to the town.\n" +
                "It is a risky choice, but you hope that someone in the town might know how to handle such a powerful artifact. " +
                "Wrapping it carefully in cloth, you secure it on your back, make your way back, hoping for a solution and a brighter future.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "takeTheHeartToRiverSide", "", "", "");
    }

    public void takeTheHeartToRiverSide() {
        StringBuilder text = new StringBuilder("As you reach the riverside, you slowly realize that an overwhelming surge of darkness emanates from the heart you carry, engulfing your body.\n");
        if (gameData.isSpareWitch) {
            ui.image.setImageResource(R.drawable.river_side_with_witch);
            text.append("Amidst the encroaching darkness, you spot the witch whom you spared earlier.");
            ui.displayTextSlowly(text.toString());
            ui.setChoicesAndNextPositions("Try to control it and ask the witch for help", "Give up", "", "", "askWitchForHelp1", "consumeTheHeart1", "", "");
            if (gameData.timeLoop) ui.setChoice3("Try to end your life", "endYourLife");
        } else {
            ui.image.setImageResource(R.drawable.river_side);
            ui.displayTextSlowly(text.toString());
            ui.setChoicesAndNextPositions("Continue", "", "", "", "consumeTheHeart1", "", "", "");
            if (gameData.timeLoop) ui.setChoice2("Try to end your life", "endYourLife");
        }
    }

    public void askWitchForHelp1() {
        ui.continueTextSlowly("You strive to control the malevolent force within, temporarily halting its consumption. " +
                "You desperately call out to the witch, pleading for her assistance in this dire moment.\n" +
                "The witch, sensing the urgency of the situation, presents you with two options.");
        ui.setChoicesAndNextPositions("About Option 1", "About Option 2", "", "", "askWitchForHelpOption1", "", "", "");
    }

    public void askWitchForHelpOption1() {
        ui.setChoicesAndNextPositions("Choose this", "About option 2", "Let the darkness consume you", "", "destroyAllTownArea", "askWitchForHelpOption2", "consumeTheHeart1", "");
        StringBuilder text = new StringBuilder("Option one: she recognizes you as the hero the world needs and offers to save you. " +
                "However, this would result in a powerful explosion that would obliterate everything in the area, including the town.");
        if (gameData.timeLoop) {
            text.append("\"I know that you would find a better way.\"");
            ui.setChoice4("\"How could you know ???\"", "askWitchKnowAboutTheReturnByDeath");
        }
        ui.displayTextSlowly(text.toString());
    }

    public void askWitchForHelpOption2() {
        ui.setChoicesAndNextPositions("Choose this", "About option 1", "Let the darkness consume you", "", "endYourLifeToSaveTheTown", "askWitchForHelpOption1", "consumeTheHeart1", "");
        StringBuilder text = new StringBuilder("Option two: she proposes ending your life to carefully destroy the consuming darkness within you, ensuring that it doesn't spread further. " +
                "\"This option comes at no cost, except for your own life.\"\n");
        if (gameData.timeLoop) {
            text.append("\"And one more thing, your ability to return by death is intertwined with the darkness itself. " +
                    "While eradicate the darkness consuming you, that ability will be relinquished as well.\"");
            ui.setChoice4("\"How could you know ???\"", "askWitchKnowAboutTheReturnByDeath");
        }
        ui.displayTextSlowly(text.toString());
    }

    public void askWitchKnowAboutTheReturnByDeath() {
        ui.displayTextSlowly("She reveals that her keen senses and deep understanding of magic allowed her to detect the traces of your unique power. " +
                "And silently observing your actions, the way you approached challenges, the uncanny knowledge you possessed, and the mysterious aura that surrounded you were all signs that hinted at your extraordinary ability.");
    }

    public void destroyAllTownArea() {
        gameData.position = "destroyAllTownArea";
        ui.saveGame();
        ui.darkUI();
        ui.image.setImageResource(R.drawable.black_screen);

        ui.displayTextSlowly("Understanding the importance of your role as the world's hero, you accept the witch's offer to save you. " +
                "The fate of the world rests on your shoulders, and you are determined to fulfill your destiny, even if it means sacrificing everything else.");
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Glide.with(ui).load(R.drawable.explosion).into(ui.image);
                soundManager.explosion();
                ui.continueTextSlowly("The witch harnesses her magic and channels a powerful spell to remove the darkness consuming you. " +
                        "In a blinding explosion of energy, everything around you is obliterated, leaving only you lie fainted amidst the devastation.");
                ui.setChoicesAndNextPositions("Continue", "", "", "", "wakeUpAfterDestructionTownArea", "", "", "");
            }
        }, 4500);
    }

    public void wakeUpAfterDestructionTownArea() {
        ui.image.setImageResource(R.drawable.town_area_after_explosion);
        ui.displayTextSlowly("As the force of the blast sends you into unconsciousness, you lose track of time. " +
                "When you finally awaken, you find yourself in a desolate landscape. The town you once knew is no more, reduced to ruins and ashes. " +
                "The sacrifice you made to save the world came at a great cost, and you must now find a way to navigate this new reality and rebuild what was lost.");
        ui.setChoicesAndNextPositions("Continue your journey", "", "", "", "theEnd", "", "", "");
        if (gameData.timeLoop) ui.setChoice2("Kill yourself to find a better way", "endYourLife");
    }

    public void endYourLifeToSaveTheTown() {
        gameData.position = "endYourLifeToSaveTheTown";
        ui.saveGame();
        ui.displayTextSlowly("Recognizing the dire consequences of the darkness consuming you, you trust the witch to end your life and destroy the darkness within. " +
                "You understand that this sacrifice is necessary to protect the world from further harm. " +
                "With a heavy heart, you accept your fate, knowing that your ultimate act of sacrifice will save countless lives.");
        ui.setChoicesAndNextPositions("Continue", "", "", "", "theEnd", "", "", "");
    }

    public void destroyTheHeart() {
        gameData.position = "destroyTheHeart";
        gameData.isDarknessConsume = true;
        ui.saveGame();

        ui.darkUI();
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        ui.displayTextSlowly("With little strength remaining, you made the courageous choice to destroy the heart of the demon general rather than succumbing to its dark allure.\n" +
                "As you cut the heart in half, you felt a surge of liberation and returned to the town, determined to bring an end to the darkness that had plagued the land.");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.setChoicesAndNextPositions("Continue", "", "", "", "townGate", "", "", "");
                soundManager.slashPeople();
            }
        }, 2000);
    }

    public void restAfterDestroyTheHeart() {
        ui.darkUI();
        ui.image.setImageResource(R.drawable.black_screen);
        ui.displayTextSlowly("To celebrate your triumph, the town threw a lively party where you indulged in excessive drinking.");
        ui.setChoicesAndNextPositions("", "", "", "", "", "", "", "");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                soundManager.stopAllMusic();
                ui.continueTextSlowly("As you lie on the bed now, you feel the familiar embrace of darkness once more. " +
                        "Memories of the moment you cleaved the demon heart in half resurface, realizing that wiping away its blood from your left hand was not enough to sever the connection.");
                ui.setChoicesAndNextPositions("Continue", "", "", "", "consumeTheHeart1", "", "", "");
            }
        }, 2000);
    }

    public void theEnd() {
        gameData.position = "theEnd";
        Glide.with(ui).load(R.drawable.the_end).into(ui.image);
        ui.darkUI();
        soundManager.stopAllSoundEffect();
        soundManager.playTheEndMusic();
        ui.displayTextSlowly("Thank you for playing The Legend's Calling!\n\n" +
                "Well done on your remarkable journey and accomplishments!\n" +
                "I appreciate your support, and I hope to see you again in the future when the game is further developed.\n\n" +
                "Stay tuned for more updates and exciting adventures ahead!");
        ui.setChoicesAndNextPositions("Play again", "Quit game", "", "", "start", "quit", "", "");
    }

    public void deadScreen() {
        gameData.position = "timeLoop";
        ui.saveGame();
        soundManager.stopAllMusic();
        soundManager.stopAllSoundEffect();
        ui.image.setImageResource(R.drawable.dead_screen);
        ui.darkUI();
        ui.displayTextSlowly("YOU DIED!!!!");
        ui.setChoicesAndNextPositions("Try again", "Quit game", "", "", "timeLoop", "quit", "", "");
    }
}
