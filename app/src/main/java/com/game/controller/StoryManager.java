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
            case "startGame":
                ui.startGameUI();
                townGate();
                break;
            case "quit":
                System.exit(0);
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
            case "stopCarriage":
                stopCarriage();
                break;
            case "talkCarriageOwner1":
                talkCarriageOwner1();
                break;
            case "talkCarriageOwner2":
                talkCarriageOwner2();
                break;
            case "talkCarriageOwner3":
                talkCarriageOwner3();
                break;
            case "talkCarriageOwner4":
                talkCarriageOwner4();
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
            case "insideGoblinCave":
                insideGoblinCave();
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
            case "encounterShadowSerpent":
                combatManager.encounterShadowSerpent();
                break;
            case "attackShadowSerpent":
                combatManager.attackShadowSerpent(false);
                break;
            case "attackShadowSerpentWithSpell":
                combatManager.attackShadowSerpent(true);
                break;
            case "encounterDemonKing":
                combatManager.encounterDemonKing();
                break;
            case "attackDemonKing":
                combatManager.attackDemonKing(false);
                break;
            case "attackDemonKingWithSpell":
                combatManager.attackDemonKing(true);
                break;
            case "defeatDemonKing":
                defeatDemonKing();
                break;
            case "wakeUpAfterFinalBattle":
                wakeUpAfterFinalBattle();
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
        ui.displayTextSlowly("It's late in the evening, you find yourself behind the wheel on a familiar road, heading home after a long day at work. " +
                "It's Friday night, and the darkness envelops the surroundings, with only a scattering of streetlights casting a dim glow. " +
                "The rhythmic hum of the engine and the gentle breeze through the cracked window create a sense of calm amidst the solitude of the late hour. " +
                "Thoughts of relaxation, weekend plans, and the comfort of home fill your mind.");
        ui.setChoicesAndNextPositions(new String[]{"Continue", "", "", "", "getHome", "", "", ""});
    }

    public void getHome() {
        ui.image.setVisibility(View.INVISIBLE);
        soundManager.openingDoor();
        ui.displayTextSlowly("You finally arrive home and eagerly insert the key into the lock, opening the door to your haven\n" +
                "...                                                                                                  \n" +
                "......                                                                                                  \n" +
                "With a sense of relief, you kick off your shoes, savoring the freedom of being barefoot on your familiar floors. " +
                "As you step further inside, you drop your bag with a thud, releasing the weight of the day and embracing the tranquility of your own space.");
        ui.setChoicesAndNextPositions(new String[]{"Continue", "", "", "", "bedRoom", "", "", ""});
    }

    public void bedRoom() {
        handler.removeCallbacksAndMessages(null);
        ui.image.setVisibility(View.VISIBLE);
        ui.image.setImageResource(R.drawable.bedroom);
        soundManager.bedRoom();
        ui.displayTextSlowly("You make your way to your bedroom and notice that it has started raining outside. " +
                "The gentle pitter-patter of raindrops against the window creates a serene atmosphere. " +
                "With a sense of tranquility washing over you, you eagerly jump onto the bed, ready to drift into a deep and restful nap, accompanied by the soothing melody of the rain.");
        ui.setChoicesAndNextPositions(new String[]{"Continue", "", "", "", "sleeping", "", "", ""});
    }

    public void sleeping() {
        handler.removeCallbacksAndMessages(null);
        ui.image.setVisibility(View.INVISIBLE);
        ui.displayTextSlowly("z...z...Z...Z\n                               \nz......z......Z......Z\n                               \nz.........z.........Z.........Z");
        ui.setChoicesAndNextPositions(new String[]{"", "", "", "", "", "", "", ""});
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                soundManager.windyField();
                soundManager.wakeUpVoice();
                ui.setChoicesAndNextPositions(new String[]{"Wake up", "Continue to sleep", "", "", "wakeUp", "sleeping", "", ""});
            }
        }, 1500);
    }

    public void wakeUp() {
        handler.removeCallbacksAndMessages(null);
        ui.displayTextSlowly("\"Where am I?\" The gentle breeze caresses your face, carrying the familiar scent of grass, while the warm touch of sunlight dances upon your skin. " +
                "As nature's elements embrace you, a sense of both disorientation and wonder envelops your thoughts");
        ui.setChoicesAndNextPositions(new String[]{"Continue", "", "", "", "windyField1", "", "", ""});
    }

    public void windyField1() {
        ui.setChoicesAndNextPositions(new String[]{"", "", "", "", "", "", "", ""});
        ui.displayTextSlowly("As you slowly open your eyes, a wave of disbelief washes over you. " +
                "Instead of the familiar sight of your bedroom, you find yourself lying on the soft grass under an open sky. Doubt fills your mind as you question the reality of this peculiar situation. " +
                "Could it be a mere dream, or has something truly extraordinary occurred?");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Glide.with(ui).load(R.drawable.windy_field).into(ui.image);
                ui.baseLayout.setBackgroundColor(Color.parseColor("#aab865"));
                ui.image.setVisibility(View.VISIBLE);
                ui.setChoicesAndNextPositions(new String[]{"Continue", "", "", "", "windyField2", "", "", ""});
            }
        }, 2000);
    }

    public void windyField2() {
        ui.displayTextSlowly("You find yourself in the middle of a windy field, with the soft green grass swaying under the clear blue sky. " +
                "A sturdy wooden fence separates the field from a winding dirt road, inviting you to explore further. " +
                "The gentle rustling of the wind and the peaceful ambiance of the surroundings create a serene atmosphere.");
        ui.setChoicesAndNextPositions(new String[]{"Try to recollect your thoughts", "Explore the surrounding", "Leave", "", "recollectYourThoughts", "exploreTheSurrounding1", "windyField3", ""});
    }

    public void recollectYourThoughts() {
        ui.setChoicesAndNextPositions(new String[]{"Continue", "", "", "", "windyField2", "", "", ""});
        ui.displayTextSlowly("After spending a couple of minutes trying to recollect your thoughts, you realize that your mind is completely blank. ");
    }

    public void exploreTheSurrounding1() {
        if (!gameModel.isTakenKnife) {
            ui.setChoicesAndNextPositions(new String[]{"Take it", "Leave it", "", "", "takeKnife", "notTakeKnife", "", ""});
            ui.displayTextSlowly("As you explore the surrounding area, your eyes catch a glint of metal hidden among the tall grass. " +
                    "Curiosity piqued, you reach down and discover an old, weathered knife, its blade worn but still sharp.");
        } else exploreTheSurrounding2();
    }

    public void exploreTheSurrounding2() {
        ui.setChoicesAndNextPositions(new String[]{"Continue", "", "", "", "windyField2", "", "", ""});
        ui.displayTextSlowly("As you continue to explore, there are nothing of value or usefulness left in the surrounding area.");
    }

    public void takeKnife() {
        ui.setChoicesAndNextPositions(new String[]{"Continue to explore", "Leave", "", "", "exploreTheSurrounding2", "windyField2", "", ""});
        ui.finishTexting(ui.getCurrentFocus());
        ui.continueTextSlowly("You pick up the old knife, feeling its weight in your hand. Its worn handle and rusted blade tell tales of past adventures.");
        if (gameModel.knife == null)
            gameModel.knife = new Weapon_Knife();
        ui.obtainWeapon(gameModel.knife);
        gameModel.isTakenKnife = true;
    }

    public void notTakeKnife() {
        ui.setChoicesAndNextPositions(new String[]{"Continue to explore", "Leave", "", "", "exploreTheSurrounding2", "windyField2", "", ""});
        ui.finishTexting(ui.getCurrentFocus());
        ui.continueTextSlowly("You decide not to take the old knife, feeling that it may not be of much use to you.");
    }

    public void windyField3() {
        ui.setChoicesAndNextPositions(new String[]{"", "", "", "", "", "", "", ""});
        Glide.with(ui).load(R.drawable.windy_field_with_carriage).into(ui.image);
        ui.displayTextSlowly("As you cross over the wooden fence, a distant sound of a carriage catches your attention. " +
                "The rhythmic clip-clop of horse hooves and the creaking of wheels echo through the air, growing louder with each passing moment.");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                soundManager.horseWagonFar();
                ui.setChoicesAndNextPositions(new String[]{"Approach the carriage", "", "", "", "windyField4", "", "", ""});
            }
        }, 1000);
    }

    public void windyField4() {
        ui.setChoicesAndNextPositions(new String[]{"", "", "", "", "", "", "", ""});
        ui.displayTextSlowly("Without a moment's hesitation, you sprint towards the carriage. \n" +
                "...                                                                     \n" +
                "As it draws nearer, you take in the sight of the small wooden carriage. " +
                "On the driver's seat, a man dressed in a blue jacket and hood guides the horse pulling the carriage.");
        soundManager.runningInGrass();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.setChoicesAndNextPositions(new String[]{"Stop the carriage", "", "", "", "stopCarriage", "", "", ""});
            }
        }, 2000);
    }

    public void stopCarriage() {
        Glide.with(ui).load(R.drawable.carriage).into(ui.image);
        soundManager.horseWagonNear();
        ui.setChoicesAndNextPositions(new String[]{"", "", "", "", "", "", "", ""});
        ui.displayTextSlowly("You manage to reach the carriage and urgently call out to the driver to stop. " +
                "The sound of your voice echoes through the air, catching the attention of the man, who looks back in surprise. " +
                "The horse slows down, and the carriage gradually comes to a stop.");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ui.image.setImageResource(R.drawable.carriage);
                soundManager.stopAllSoundEffect();
                soundManager.horse();
                ui.setChoicesAndNextPositions(new String[]{"Ask about your current state.", "", "", "", "talkCarriageOwner1", "", "", ""});
            }
        }, 4500);
    }

    public void talkCarriageOwner1() {
        ui.displayTextSlowly("You approach the carriage's owner, \"Excuse me, but can you tell me where I am?\" " +
                "He looks at you with a puzzled expression before replying, \"You're in the outskirts of a small town called Rivervale. Is everything alright?\" " +
                "Confusion fills your mind as you have no recollection of this town.");
        ui.setChoicesAndNextPositions(new String[]{"Continue", "", "", "", "talkCarriageOwner2", "", "", ""});
    }

    public void talkCarriageOwner2() {
        ui.displayTextSlowly("He elaborates further: \"You should not be here alone, as there have been numerous reports of increased monster activity due to the expanding territory of the Demon King.\" " +
                "\nIn your mind, you question, \"Monsters? Demons? Where on earth am I?\" Confusion and disbelief fill your thoughts as you try to comprehend the strange situation you find yourself in. " +
                "Prioritizing your safety, you contemplate asking the man for a ride and gather more information about the current state of affairs. ");
        ui.setChoicesAndNextPositions(new String[]{"Ask him for a ride", "", "", "", "talkCarriageOwner3", "", "", ""});
    }

    public void talkCarriageOwner3() {
        ui.setChoicesAndNextPositions(new String[]{"", "", "", "", "", "", "", ""});
        ui.displayTextSlowly("The man agrees to take you with. " +
                "With gratitude, you thank him before quickly getting on the carriage and setting off on your journey. " +
                "As the wheels begin to turn, the carriage sets off towards the direction of Rivervale town");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Glide.with(ui).load(R.drawable.carriage).into(ui.image);
                soundManager.horse();
                soundManager.horseWagonNear();
                ui.setChoicesAndNextPositions(new String[]{"Continue", "", "", "", "talkCarriageOwner4", "", "", ""});
            }
        }, 3000);
    }

    public void talkCarriageOwner4() {
        ui.displayTextSlowly("As you observe the man's attire and the carriage closely, it dawns on you that you might have traveled back in time to a medieval era. " +
                "Seeking confirmation, you engage the man in conversation, asking several questions that confirm your suspicions. " +
                "Overwhelmed by the strangeness of the situation, you instinctively slap your own face, hoping to wake up from what feels like an inexplicable dream.");
        ui.setChoicesAndNextPositions(new String[]{"Continue", "", "", "", "startGame", "", "", ""});
    }


    public void townGate() {
        gameModel.position = "townGate";
        ui.image.setImageResource(R.drawable.town_gate);
        ui.setChoicesAndNextPositions(new String[]{"", "", "Enter town", "Leave", "", "", "talkGuard1", "crossRoad"});

        if (!gameModel.isAliveDemonKing) {
            gameModel.isAngryGuard = false;
            ui.displayTextSlowly("Returning to the town, you spot the familiar figure of the guard standing at his post. " +
                    "As you approach, he looks up and recognition flashes across his face. \"You've returned,\" he says with a mix of surprise and relief. ");
        } else
            ui.displayTextSlowly("As you draw near to the town gate, you notice that it is tightly shut and fortified, clearly designed to keep potential dangers at bay. " +
                    "Standing before the gate is a guard, fully equipped with armor and a sword, their attentive gaze fixed upon you. " +
                    "They carefully evaluate your presence, their eyes alert and watchful.");
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

        ui.setChoicesAndNextPositions(new String[]{"", "Leave", "", "", "", "crossRoad", "", ""});

        if (!gameModel.isAliveDemonKing) {
            ui.displayTextSlowly("\"I heard rumors of the demon king's defeat. Is it true?\" " +
                    "You nod, sharing the details of your epic battle and the destruction of the demon king's hideout. " +
                    "The guard's stern expression softens, replaced by a genuine smile. " +
                    "\"You've done the town a great service. We owe you our gratitude.\"");
            ui.setChoice1("\"Can i enter the town now?\"", "talkGuard2");
        } else if (gameModel.isTakenArmor && !gameModel.isAngryGuard) {
            ui.displayTextSlowly("The guard who notices your newly acquired armor: \"Ah, I see you're donning your new armor. It suits you well. " +
                    "There is something else you should know. Legend has it that to the north-east of here, atop the mountain, lies a sacred place. " +
                    "It is said that those who possess great courage and are recognized as the chosen hero can harness their heroic blood and choose a power that suits them.\"");
            ui.setChoice1("\"I'll have it a try\"", "crossRoad");
        } else {
            if (gameModel.isAngryGuard)
                ui.displayTextSlowly("The guard is clearly angry as they scold you for your attack. " +
                        "They look disappointed and emphasize how crucial it is to keep the town safe. Trust and redemption feel far away in this moment. " +
                        "You quickly apologize and clarify that you're a traveler looking for your brother, following clues that led you here.");
            else
                ui.displayTextSlowly("Guard: \"Hello, stranger! I cannot let unfamiliar faces into our town. " +
                        "Prove yourself trustworthy, or find another way in.\" " +
                        "You explain your purpose as a traveler searching for your brother, guided by the clues that brought you here. " +
                        "Seeking assistance, you inquire about gaining entry, hoping for guidance to reach your destination.");
            ui.setChoice1("\"How can i enter the town?\"", "talkGuard2");
        }
    }

    public void talkGuard2() {
        gameModel.position = "talkGuard2";
        ui.setChoicesAndNextPositions(new String[]{"", "Leave", "", "", "", "crossRoad", "", ""});

        if (!gameModel.isAliveDemonKing) {
            ui.displayTextSlowly("The guard, now aware of your heroic triumph, opens the town gate for you without hesitation.");
            ui.setChoice1("Enter the town", "theEnd");
        } else {
            ui.displayTextSlowly("Guard: \"Lately, the demon king has been intruding into our land, endangering our safety. " +
                    "We urgently require a hero to safeguard our town. " +
                    "If you can defeat the demon king and repel the threat, I will allow you to enter.\"");
            ui.setChoice1("\"How am i supposed to do that\"", "talkGuard3");
        }
    }

    public void talkGuard3() {
        gameModel.position = "talkGuard3";

        ui.displayTextSlowly("The guard notices that your current gear is not sufficient to defeat the Demon King. " +
                "They hand you a map with the location of the demon king's hideout marked and advise you to visit the blacksmith in the north to acquire better equipment.");
        ui.setChoicesAndNextPositions(new String[]{"\"Ok! Thank you.\"", "Leave", "", "", "crossRoad", "crossRoad", "", ""});
    }

    public void attackGuard() {
        gameModel.position = "attackGuard";
        gameModel.isAngryGuard = true;
        Glide.with(ui).load(R.drawable.guard).into(ui.image);
        int hpLost = (int) Math.ceil(4 * gameModel.difficultRate);
        if (!ui.updatePlayerHp(-hpLost))
            return;
        if (gameModel.player.getPlayerHP() > 0) {
            ui.displayTextSlowly("As a consequence of your actions, the guard retaliates and strikes you in response. " +
                    "Their response is quick and powerful, resulting in you taking " + (int) Math.ceil(4 * gameModel.difficultRate) + " damage.");
            ui.setChoicesAndNextPositions(new String[]{"\"Sorry\"", "Leave", "", "", "townGate", "crossRoad", "", ""});
        }
    }

    public void crossRoad() {
        soundManager.stopAllSoundEffect();
        gameModel.position = "crossRoad";
        ui.image.setImageResource(R.drawable.cross_road);

        ui.displayTextSlowly("You find yourself at a crossroad, standing at the intersection of multiple paths. " +
                "The choices laid out offering different directions to explore.\nWhere would you go?");
        ui.setChoicesAndNextPositions(new String[]{"Go North", "Go East", "Go South", "Go West (the town)", "blackSmithHouse", "riverSide", "goblinCave", "townGate"});
    }

    public void blackSmithHouse() {
        gameModel.position = "blackSmithHouse";
        Glide.with(ui).load(R.drawable.black_smith_house).into(ui.image);
        soundManager.anvil();
        ui.displayTextSlowly("As you approach the blacksmith shop, the sound of hammer striking metal echoes in the air. " +
                "The skilled blacksmith can be seen diligently working at the forge, their expertise showcased by each precise strike.");
        ui.setChoicesAndNextPositions(new String[]{"Talk to the blacksmith", "Go East", "Go South", "", "talkBlackSmith", "northRiver", "crossRoad", ""});
    }

    public void talkBlackSmith() {
        gameModel.position = "talkBlackSmith";
        ui.setChoicesAndNextPositions(new String[]{"", "Leave", "", "", "", "blackSmithHouse", "", ""});

        if (!gameModel.blackSmithQuestActive) {
            ui.displayTextSlowly("The blacksmith, acknowledging your unfamiliar presence, kindly asks for a favor before proceeding with further conversation. " +
                    "They explain the troubles caused by a mischievous goblin and provide its last known location—a cave to the south. " +
                    "They request that you return once you have successfully dealt with the goblin."
            );
            ui.setChoice1("Accept the request", "acceptBlackSmithQuest");
        } else if (!gameModel.isALiveGoblin) {
            if (!gameModel.isTakenArmor) {
                ui.displayTextSlowly("\"Look like you've killed that goblin. Thank you,\" they acknowledge with gratitude. " +
                        "Their attention then turns to your quest to repulse the Demon King. " +
                        "\"You're on the way to repulse the Demon King, huh? I have a reward for you,\" they reveal, a glimmer of excitement in their voice. ");
                ui.setChoice1("Take reward", "takeArmor");
            } else if (gameModel.isTakenArmor) {
                ui.displayTextSlowly("They believe in your ability to overcome the challenge and offer their unwavering support. " +
                        "The blacksmith advises, \"There's one more thing you should know. " +
                        "The witch who wanders along the river near the goblin cave is known for her trickery. Be cautious and stay alert when you encounter her.\"");
                ui.setChoice1("\"Thank you\"", "blackSmithHouse");
            }
        } else {
            ui.displayTextSlowly("The blacksmith: \"That goblin is still alive! You better hurry to defeat it before it causes more harm.\"");
        }
    }

    public void acceptBlackSmithQuest() {
        gameModel.blackSmithQuestActive = true;
        selectPosition("talkBlackSmith");
    }

    public void takeArmor() {
        if (gameModel.armors == null)
            gameModel.armors = new Armor[]{new Armor_IronArmor(), new Armor_SilverArmor(), new Armor_GoldenArmor()};

        Armor armor = gameModel.armors[rand.nextInt(3)];
        gameModel.player.setArmor(armor);
        ui.armorLabel.setVisibility(View.VISIBLE);
        ui.armorLabel.setText("+" + armor.getName());
        ui.armorLabel.setTextColor(Color.parseColor(armor.getHexColorCode()));

        gameModel.isTakenArmor = true;
        ui.displayTextSlowly("The BlackSmith: \"Take this " + armor.getName() + ".Maybe it could help you.\"" +
                "It seems that they have prepared a special armor, recognizing the importance of your mission and the need for enhanced protection.");
        ui.setChoicesAndNextPositions(new String[]{"\"Thank you\"", "Leave", "", "", "talkBlackSmith", "blackSmithHouse", "", ""});
    }

    public void goblinCave() {
        gameModel.position = "goblinCave";
        ui.image.setImageResource(R.drawable.goblin_cave);

        ui.displayTextSlowly("As you approach the entrance of the goblin cave, you see an ancient stone tunnel that leads further into the darkness. " +
                "The cave is situated in the heart of a dense forest, surrounded by tall trees and vibrant green grass adorned with a few delicate flowers. " +
                "A curious small stone catches your attention, resting mysteriously in front of the cave's entrance.");
        ui.setChoicesAndNextPositions(new String[]{"Go inside the cave", "Go North", "Go East", "", "insideGoblinCave", "crossRoad", "southRiver", ""});
    }

    public void insideGoblinCave() {
        gameModel.position = "insideGoblinCave";
        ui.image.setImageResource(R.drawable.inside_goblin_cave);
        ui.setChoicesAndNextPositions(new String[]{"", "Leave", "", "", "", "goblinCave", "", ""});

        if (gameModel.isALiveGoblin) {
            ui.displayTextSlowly("As you explore deeper into the goblin cave, a sudden noise startles you. You come face-to-face with a goblin, dressed in a makeshift rat costume and brandishing a knife. " +
                    "It lunges at you with fierce determination, ready to attack.");
            ui.setChoice1("Encounter goblin", "encounterGoblin");
        } else if (!gameModel.isDefeatedEvilWitch && gameModel.witchQuestActive && !gameModel.isTakenGoblinEar) {
            ui.displayTextSlowly("As you explore the depths of the cave, you stumble upon the lifeless body of a goblin. " +
                    "Remembering the witch's request, you reach down to retrieve the goblin's left ear.");
            ui.setChoice1("Take the goblin's left ear", "takeGoblinEar");
        } else if (!gameModel.isTakenLongSword) {
            ui.displayTextSlowly("As you explore the depths of the cave, you come across the lifeless body of a goblin. " +
                    "In the dim light, something shiny catches your attention, revealing an old, weathered long sword.  " +
                    "Despite its worn appearance, yet it exudes a sense of strength, ready to be wielded once again.");
            ui.setChoice1("Take the long sword", "takeLongSword");
        } else {
            ui.displayTextSlowly("As you continue deeper into the cave, you find that there is not much to discover. " +
                    "The darkness surrounds you, revealing no hidden treasures or significant sights. " +
                    "It appears that this part of the cave holds no remarkable secrets, prompting you to continue your exploration elsewhere.");
        }
    }

    public void takeGoblinEar() {
        gameModel.isTakenGoblinEar = true;
        insideGoblinCave();
    }

    public void takeLongSword() {
        gameModel.isTakenLongSword = true;
        if (gameModel.longSword == null)
            gameModel.longSword = new Weapon_LongSword();
        ui.obtainWeapon(gameModel.longSword);
        insideGoblinCave();
    }

    public void riverSide() {
        gameModel.position = "riverSide";
        if (!gameModel.isDefeatedEvilWitch) {
            ui.image.setImageResource(R.drawable.river_side_with_witch);

            ui.displayTextSlowly("You find yourself by the riverside, where the gentle flow of the water creates a serene ambiance. " +
                    "As you admire the tranquil scene, a witch passes by, her long dark cloak billowing in the breeze, and a pointy hat adorning her head. " +
                    "In the distance, you notice a small wooden bridge that stretches across the river.");
            ui.setChoicesAndNextPositions(new String[]{"Talk to the Witch", "Go North", "Go East(cross the river on bridge)", "Go West", "talkWitch1", "northRiver", "jungle", "crossRoad"});
            if (gameModel.witchQuestActive)
                nextPosition1 = "talkWitch2";
        } else {
            ui.image.setImageResource(R.drawable.river_side);

            ui.displayTextSlowly("You find yourself at the edge of a river, its calm current gently winding through the landscape. " +
                    "The soothing sound of flowing water creates a peaceful atmosphere as you notice a small wooden bridge spanning across the river.");
            ui.setChoicesAndNextPositions(new String[]{"Go North", "Go East(cross the river on bridge)", "Go South", "Go West", "northRiver", "jungle", "southRiver", "crossRoad"});
        }
    }

    public void talkWitch1() {
        gameModel.position = "talkWitch1";
        ui.image.setImageResource(R.drawable.witch);

        ui.displayTextSlowly("\"Hey there, young man,\" the witch addresses you, her gaze filled with curiosity. " +
                "\"You seem strong and capable. If you do me a favor, I'll be sure to reward you handsomely." +
                "\" Her offer hangs in the air, tempting you with the promise of a worthy prize.");
        ui.setChoicesAndNextPositions(new String[]{"Ask about the favor", "Leave", "", "", "talkWitch2", "riverSide", "", ""});
    }

    public void talkWitch2() {
        gameModel.position = "talkWitch2";
        ui.image.setImageResource(R.drawable.witch);

        if (gameModel.witchQuestActive)
            ui.setChoicesAndNextPositions(new String[]{"\"I'm on it\"", "Leave", "", "", "riverSide", "riverSide", "", ""});
        else
            ui.setChoicesAndNextPositions(new String[]{"Accept the favor", "\"Don't try to fool me\"", "Leave", "", "acceptWitchQuest", "talkWitch3", "riverSide", ""});

        StringBuilder text = new StringBuilder("As you inquire about the favor, the witch requests that you venture into the jungle on the other side of the river and fetch her a fresh apple. " +
                "Additionally, she asks for a goblin's left ear, explaining that it holds powerful magical properties.");
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
        gameModel.position = "talkWitch3";

        ui.image.setImageResource(R.drawable.witch);
        ui.setChoicesAndNextPositions(new String[]{"Encounter the Evil Witch", "", "", "", "encounterEvilWitch", "", "", ""});

        if (gameModel.witchQuestActive)
            ui.displayTextSlowly("The witch swiftly snatches the items from your grasp, a sinister grin spreading across her face. " +
                    "Her mocking laughter fills the air as she taunts you for your foolishness. " +
                    "With a flick of her staff, she raises it menacingly, casting a spell enveloping you in a cloud of toxic poison.");
        else
            ui.displayTextSlowly("\"Don't try to fool me,\" you assert, your weapon held high in defiance. " +
                    "The witch's expression shifts from arrogance to surprise as she realizes that you see through her ruse. " +
                    "She bursts into laughter, a wicked sound that echoes through the air. " +
                    "With a swift flick of her staff, she casts a powerful poison spell, enveloping you in a toxic haze.");
        if (gameModel.evilWitch == null)
            gameModel.evilWitch = new Monster_EvilWitch(gameModel.difficultRate);
    }

    public void talkWitch4() {
        gameModel.position = "talkWitch4";

        ui.image.setImageResource(R.drawable.defeated_witch);
        ui.setChoicesAndNextPositions(new String[]{"Spare her life", "Finish her", "Leave", "", "talkWitch5", "talkWitch7", "talkWitch6", ""});

        ui.displayTextSlowly("\"Enough! Spare my life, I'll remove the poison spell casted on you and give you a reward,\" " +
                "she begs, desperation evident in her voice. \"No more tricks, I swear.\"");
    }

    public void talkWitch5() {
        gameModel.position = "talkWitch5";

        ui.image.setImageResource(R.drawable.defeated_witch);
        ui.setChoicesAndNextPositions(new String[]{"Enhance your strength", "Learn Poison breeze", "Leave", "", "enhanceStrength", "learnPoisonBreeze", "riverSide", ""});

        ui.displayTextSlowly("\"About the reward, I can either enhance your strength, making you even more powerful, or teach you the secret of the poison breeze, a lethal technique.\"");
    }

    public void talkWitch6() {
        gameModel.position = "talkWitch6";

        ui.image.setImageResource(R.drawable.river_side);
        ui.setChoicesAndNextPositions(new String[]{"Go North", "Go south", "Go East(cross the river on bridge)", "Go West", "northRiver", "southRiver", "jungle", "crossRoad"});
        ui.displayTextSlowly("As you spare the witch's life, she quickly realizes the gravity of the situation and hastily retreats, no longer posing a threat to your journey. " +
                "The path to the south of the river is now clear, allowing you to continue your adventure unhindered.");
    }

    public void talkWitch7() {
        gameModel.position = "talkWitch7";

        ui.image.setImageResource(R.drawable.river_side);
        ui.setChoicesAndNextPositions(new String[]{"Go North", "Go south", "Go East(cross the river on bridge)", "Go West", "northRiver", "southRiver", "jungle", "crossRoad"});
        ui.displayTextSlowly("As you prepare to deliver the decisive blow, the witch's eyes gleam with a mixture of fear and cunning. " +
                "With a swift motion of her hand, she unleashes a powerful spell, creating a blinding flash of light that disorients you. " +
                "By the time your vision clears, the witch is nowhere to be seen, leaving you standing alone");
    }

    public void enhanceStrength() {
        gameModel.witchQuestActive = false;
        gameModel.player.increasePlayerMaxHP(3);
        gameModel.player.increaseBaseAttack(1);
        ui.updatePlayerHp(0);

        Toast.makeText(ui.getApplicationContext(), "The witch enhances your strength, granting you a boost in power. Your maximum HP is increased by 3, and your base attack is enhanced by 1", Toast.LENGTH_SHORT).show();
        talkWitch6();
    }

    public void learnPoisonBreeze() {
        gameModel.witchQuestActive = false;
        gameModel.poisonBreeze = new Spell_PoisonBreeze();
        gameModel.player.addSpell(gameModel.poisonBreeze);

        Toast.makeText(ui.getApplicationContext(), "You learn the skill of Poison Breeze from the witch, acquiring the ability to unleash a toxic and debilitating attack against your enemies.", Toast.LENGTH_SHORT).show();
        ui.updateSpellStatus();
        talkWitch6();
    }

    public void northRiver() {
        soundManager.stopAllSoundEffect();
        if (gameModel.position.equalsIgnoreCase("mountain") && !crossTheRiver())
            return;

        gameModel.position = "northRiver";
        ui.image.setImageResource(R.drawable.north_river);
        ui.setChoicesAndNextPositions(new String[]{"", "Go East(swim cross the river)", "Go South", "Go West", "", "mountain", "riverSide", "blackSmithHouse"});

        if (!gameModel.isRestAtTent) {
            ui.displayTextSlowly("North of the river, you discover a cozy fireplace and an old tent by the riverside. " +
                    "Resting at the tent allows you to recover 10 HP. " +
                    "Unfortunately, the path ahead has been blocked, denying any further progress in that direction.");
            ui.setChoice1("Take a rest", "takeRest");
        } else {
            ui.displayTextSlowly("North of the river, you discover a cozy fireplace and an old tent by the riverside. " +
                    "Unfortunately, the path ahead has been blocked, denying any further progress in that direction.");
            ui.setChoice1("", "");
        }
    }

    public void takeRest() {
        Toast.makeText(ui.getApplicationContext(), "Resting at a tent, you regain 10 HP.", Toast.LENGTH_SHORT).show();
        ui.updatePlayerHp(10);
        gameModel.isRestAtTent = true;
        northRiver();
    }

    public void southRiver() {
        if (gameModel.position.equalsIgnoreCase("demonHideout") && !crossTheRiver())
            return;

        gameModel.position = "southRiver";
        ui.image.setImageResource(R.drawable.south_river);
        ui.setChoicesAndNextPositions(new String[]{"", "Go North", "Go East(swim cross the river)", "Go West", "", "riverSide", "demonHideout", "goblinCave"});

        if (gameModel.isALiveRiverMonster) {
            ui.displayTextSlowly("South of the river, a strange vortex captivates your gaze from the center of the water. " +
                    "However, progress along the southern path is halted by a waterfall, blocking any further advancement.");
            ui.setChoice1("Throw a rock into it", "encounterRiverMonster");
        } else {
            ui.displayTextSlowly("South of the river, a waterfall creates an impassable barrier, preventing any further advancement along the southern path.");
            ui.setChoice1("", "");
        }
    }

    public boolean crossTheRiver() {
        if (gameModel.isALiveRiverMonster)
            if (rand.nextBoolean()) {
                combatManager.encounterRiverMonster();
                return false;
            }
        return true;
    }

    public void jungle() {
        gameModel.position = "jungle";
        ui.image.setImageResource(R.drawable.jungle);
        ui.displayTextSlowly("You find yourself in a peaceful forest clearing, surrounded by tall, ancient trees. " +
                "Shafts of sunlight filter through the dense foliage, casting a gentle glow on the lush grass beneath your feet.\n" +
                "You see an apple tree.");
        ui.setChoicesAndNextPositions(new String[]{"Hit the apple tree", "Go North", "Go South", "Go West(cross the river on bridge)", "hitTheAppleTree", "mountain", "demonHideout", "riverSide"});
    }

    public void hitTheAppleTree() {
        soundManager.hitTree();
        gameModel.lastPosition = gameModel.position;
        gameModel.position = "hitTheAppleTree";
        ui.setChoicesAndNextPositions(new String[]{"Hit the apple tree again", "Leave", "", "", "hitTheAppleTree", "jungle", "", ""});
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
            ui.displayText(text.toString());
        } else if (c1 == 1)
            ui.displayTextSlowly("You hit the apple tree, angering a nearby monkey. It retaliates by throwing a stick at you, causing " + (int) Math.ceil(2 * gameModel.difficultRate) + " damage.");
        else
            ui.displayTextSlowly("Nothing happen.");
    }

    public void takeApple() {
        gameModel.isTakenApple = true;
        jungle();
    }

    public void eatApple() {
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
        if (gameModel.position.equalsIgnoreCase("northRiver") && !crossTheRiver())
            return;

        gameModel.position = "mountain";
        ui.image.setImageResource(R.drawable.mountain);
        ui.displayTextSlowly("As you approach the towering mountain, your gaze is drawn to the peculiar sight atop its peak. " +
                "Clusters of massive rock hover in the air, defying the natural laws of gravity. " +
                "You feel an irresistible pull to ascend the mountain and uncover the secrets hidden within the realm of the floating rocks.");
        ui.setChoicesAndNextPositions(new String[]{"Climb to the top", "Go South", "Go West(swim cross the river)", "", "mountainTop", "jungle", "northRiver", ""});
    }

    public void mountainTop() {
        gameModel.position = "mountainTop";
        ui.image.setImageResource(R.drawable.mountain_top);
        ui.displayTextSlowly("You climb the mountain, reaching the summit where a majestic stone gate awaits. " +
                "Passing through, you enter a sacred space surrounded by five towering stone statues, their presence exuding ancient power.");
        ui.setChoicesAndNextPositions(new String[]{"Touch the middle statue", "Leave", "", "", "touchStatue", "mountain", "", ""});
        if (gameModel.isTakenPower)
            nextPosition1 = "";
    }

    public void touchStatue() {
        gameModel.position = "touchStatue";
        ui.displayTextSlowly("The statues grant power to the traveler as a tribute to their courage. " +
                "Recognized as the chosen hero, the traveler's heroic blood resonates with the statues, allowing them to choose a power that suits their strengths and upcoming challenges.");
        ui.setChoicesAndNextPositions(new String[]{"...", "Leave", "", "", "offerPower", "mountain", "", ""});
    }

    public void offerPower() {
        gameModel.position = "offerPower";
        ui.displayTextSlowly("A mystical voice fills the air, carrying ancient wisdom and a sense of reverence. " +
                "\"Knowing the heroic blood that flows within you, we offer you a choice,\" the voice declares. " +
                "\"Embrace the path of strength, wield the power of scorching fire, command the paralyzing force of lightning, or harness the soothing energy of healing water.\"");
        ui.setChoicesAndNextPositions(new String[]{"Strength", "Fire power", "Lightning power", "Water power", "strengthPower", "firePower", "lightningPower", "waterPower"});
    }

    public void strengthPower() {
        ui.displayTextSlowly("Strength Power: This power enhances the traveler's physical capabilities by increasing their HP and base attack.\n" +
                "Tap into your inner strength and experience a surge of power. " +
                "Your maximum HP is increased by 3, fortifying your resilience and granting you the endurance to withstand greater challenges. " +
                "Additionally, your base attack is enhanced by 2, empowering your strikes and making your every blow more impactful.");
        ui.setChoicesAndNextPositions(new String[]{"Take power", "Back", "", "", "takeStrengthPower", "offerPower", "", ""});
    }

    public void takeStrengthPower() {
        gameModel.isTakenPower = true;
        gameModel.player.increasePlayerMaxHP(3);
        gameModel.player.increaseBaseAttack(2);
        ui.updatePlayerHp(0);
        Toast.makeText(ui.getApplicationContext(), "You feel an overwhelming surge of strength coursing through your veins as you embrace the power of enhanced strength.", Toast.LENGTH_SHORT).show();

        mountainTop();
    }

    public void firePower() {
        if (gameModel.fireStorm == null) gameModel.fireStorm = new Spell_FireStorm();
        gameModel.selectedSpell = gameModel.fireStorm;
        ui.displayTextSlowly("Fire Power: This power grants the traveler mastery over the element of fire, enabling them to unleash devastating Fire Storm that inflict immense damage upon their enemies.\n" +
                "Unleash a mighty magic Fire Storm that scorches your enemies, dealing a significant " + gameModel.fireStorm.getDamage() + " damage.");
        ui.setChoicesAndNextPositions(new String[]{"Take power", "Back", "", "", "takePower", "offerPower", "", ""});
    }

    public void lightningPower() {
        if (gameModel.lightningBolt == null) {
            gameModel.lightningBolt = new Spell_LightningBolt();
        }
        gameModel.selectedSpell = gameModel.lightningBolt;
        ui.displayTextSlowly("Lightning Power: Harness the electrifying energy of lightning to deal substantial damage to your foes, while also stunning them in their tracks.\n" +
                "Unleash bolts of lightning that deal " + gameModel.lightningBolt.getDamage() + " damage and momentarily stun monsters, granting you the opportunity to follow up with an additional attack.");
        ui.setChoicesAndNextPositions(new String[]{"Take power", "Back", "", "", "takePower", "offerPower", "", ""});
    }

    public void waterPower() {
        if (gameModel.waterSurge == null) gameModel.waterSurge = new Spell_WaterSurge();
        gameModel.selectedSpell = gameModel.waterSurge;
        ui.displayTextSlowly("As the water spell surges forth, it forms a protective barrier that shields you from an impending monster attack, deflecting its harm. " +
                "Simultaneously, the restorative properties of the water envelop you, replenishing your vitality and restoring 7 points of health. ");
        ui.setChoicesAndNextPositions(new String[]{"Take power", "Back", "", "", "takePower", "offerPower", "", ""});
    }

    public void takePower() {
        gameModel.isTakenPower = true;
        gameModel.player.addSpell(gameModel.selectedSpell);
        ui.updateSpellStatus();
        Toast.makeText(ui.getApplicationContext(), "Congratulations! You have learned the formidable spell " + gameModel.selectedSpell.getName(), Toast.LENGTH_SHORT).show();
        mountainTop();
    }

    public void demonHideout() {
        if (gameModel.position.equalsIgnoreCase("southRiver") && !crossTheRiver()) {
            return;
        }
        gameModel.position = "demonHideout";
        ui.setChoicesAndNextPositions(new String[]{"", "Go North", "Go West (swim across the river)", "", "", "jungle", "southRiver", ""});

        if (gameModel.isAliveDemonKing) {
            ui.image.setImageResource(R.drawable.demon_hideout);
            ui.displayTextSlowly("As you approach the demon's hideout, the landscape turns singm.isTer and dark. " +
                    "The eerie atmosphere swallows the sunlight, the entrance to the demon's lair stands before you, and you steel yourself for the impending battle, preparing to face the horrors that await within.");
            ui.setChoice1("Enter", "");
            if (gameModel.isAliveShadowSerpent)
                nextPosition1 = "encounterShadowSerpent";
            else nextPosition1 = "encounterDemonKing";
        } else {
            ui.image.setImageResource(R.drawable.demon_hideout_after_battle);
            ui.displayTextSlowly("The battlefield, once ruled by the evil presence of the demon king, now lies destroyed and desolate. " +
                    "Debris and remnants of the intense battle are scattered across the ground, a reminder of the epic clash that took place.");
            ui.setChoice1("", "");
        }
    }

    public void insideDemonHideout() {
        gameModel.position = "insideDemonHideout";
        ui.image.setImageResource(R.drawable.demon_hideout);
        ui.displayTextSlowly("With the shadow serpent defeated, you continue your journey, venturing deeper into the heart of the demon's hideout. " +
                "The air becomes thick and oppressive, a haunting silence fills the surroundings, increasing the feeling of imminent danger. " +
                "With each step, you draw nearer to the final showdown with the formidable demon king");
        ui.setChoicesAndNextPositions(new String[]{"Go deeper", "Leave", "", "", "encounterDemonKing", "demonHideout", "", ""});
    }

    public void defeatDemonKing() {
        gameModel.position = "defeatDemonKing";
        ui.image.setImageResource(R.drawable.explosion);
        ui.displayTextSlowly("As the final blow lands on the demon king, a powerful explosion obliterates the demon's hideout. " +
                "After the battle, you are left barely alive, drained of strength. " +
                "Exhaustion overwhelms you, and you lose consciousness, unsure of what awaits you in this dangerous situation.");
        ui.setChoicesAndNextPositions(new String[]{"...", "......", "", "", "wakeUpAfterFinalBattle", "wakeUpAfterFinalBattle", "", ""});
    }

    public void wakeUpAfterFinalBattle() {
        gameModel.position = "wakeUpAfterFinalBattle";
        ui.image.setImageResource(R.drawable.demon_hideout_after_battle);
        ui.displayTextSlowly("As you slowly wake up, your eyes open to a scene of complete destruction. " +
                "The battlefield, previously controlled by the demon king, now lies in ruins. Among the debris, you spot a shining object—the demon sword. " +
                "Feeling disoriented and weakened, you make an effort to gather your surroundings and evaluate the aftermath of the intense battle.");
        gameModel.player.setPlayerHP(1);
        ui.updatePlayerHp(0);
        Toast.makeText(ui.getApplicationContext(), "You have defeated the demon king!", Toast.LENGTH_SHORT).show();
        if (gameModel.demonSword == null)
            gameModel.demonSword = new Weapon_DemonSword();
        ui.obtainWeapon(gameModel.demonSword);
        ui.setChoicesAndNextPositions(new String[]{"Leave", "", "", "", "townGate", "", "", ""});
    }

    public void theEnd() {
        ui.image.setImageResource(R.drawable.the_end);
        ui.displayTextSlowly("Congratulations! You have successfully completed the game and overcome numerous challenges to emerge victorious. " +
                "Well done on your remarkable journey and accomplishments!");
        ui.setChoicesAndNextPositions(new String[]{"Play again", "Quit game", "", "", "start", "quit", "", ""});
    }

    public void deadScreen() {
        ui.image.setImageResource(R.drawable.dead_screen);
        ui.displayTextSlowly("YOU DIED!!!!");
        ui.setChoicesAndNextPositions(new String[]{"Try again", "Quit game", "", "", "start", "quit", "", ""});
    }
}
