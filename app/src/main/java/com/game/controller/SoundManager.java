package com.game.controller;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;

import com.game.R;
import com.game.view.GameScreen;
import com.game.view.TitleScreen;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SoundManager {
    private GameScreen gameScreen;
    private SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    public MediaPlayer titleMusic;
    private MediaPlayer bgMusic, battleMusic, drivingHighWaySound, openDoorSound, rainingSound, windySound, theTownSound, insideCaveSound, demonHideoutSound;
    private int[] battleMusicList = {R.raw.battle_music_1, R.raw.battle_music_2};
    private int[] backGroundMusicList = {R.raw.back_ground_music_1, R.raw.back_ground_music_2};
    private int[] swordSounds;
    private int positionBgMusic = 0, positionBattleMusic = 0;
    public Integer clickSoundId, obtainWeaponSoundId, healthUpSoundId, coinsSoundId,
            takeShoeOffSoundId, dropBagSoundId, lyingBedSoundId, wakeUpVoiceId,
            horseWagonSoundId, runningInGrassSoundId, horseSoundId,
            townGateDoorSoundId, anvilSoundId, lightFireSoundId, underWaterSoundId, hitTreeSoundId, eatingAppleSoundId, magicMountainSoundId, explosionSoundId,
            sword1soundId, sword2soundId, sword3soundId, sword4soundId, spellFireSoundId, spellLightningSoundId, spellWaterSoundId, spellPoisonBreezeSoundId,
            goblinSoundId, riverMonsterSoundId, evilWitchSoundId, shadowSerpentSoundId, demonGeneralSoundId;
    private Map<Integer, Integer> playingSoundEffect = new HashMap<>();
    private Random rand;
    private Handler handler;

    public SoundManager(TitleScreen titleScreen) {
        titleMusic = MediaPlayer.create(titleScreen, R.raw.title_music);
        titleMusic.setLooping(true);
        clickSoundId = soundPool.load(titleScreen, R.raw.click, 1);
        titleMusic.start();
    }

    public SoundManager(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.handler = gameScreen.handler;
        this.rand = gameScreen.rand;

        drivingHighWaySound = MediaPlayer.create(gameScreen, R.raw.driving_highway);
        drivingHighWaySound.setLooping(true);
        openDoorSound = MediaPlayer.create(gameScreen, R.raw.open_door);
        openDoorSound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                getHome();
            }
        });
        rainingSound = MediaPlayer.create(gameScreen, R.raw.raining);
        rainingSound.setLooping(true);

        windySound = MediaPlayer.create(gameScreen, R.raw.wind_blow);
        windySound.setLooping(true);

        bgMusic = MediaPlayer.create(gameScreen, backGroundMusicList[rand.nextInt(backGroundMusicList.length)]);
        bgMusic.setLooping(true);
        bgMusic.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                bgMusic = MediaPlayer.create(gameScreen, backGroundMusicList[rand.nextInt(backGroundMusicList.length)]);

            }
        });

        clickSoundId = soundPool.load(gameScreen, R.raw.click, 1);
        obtainWeaponSoundId = soundPool.load(gameScreen, R.raw.obtain_weapon, 1);
        healthUpSoundId = soundPool.load(gameScreen, R.raw.health_up, 1);
        coinsSoundId = soundPool.load(gameScreen, R.raw.coin, 1);

        takeShoeOffSoundId = soundPool.load(gameScreen, R.raw.shoes_take_off, 1);
        dropBagSoundId = soundPool.load(gameScreen, R.raw.drop_bag, 1);
        lyingBedSoundId = soundPool.load(gameScreen, R.raw.lying_on_bed, 1);
        wakeUpVoiceId = soundPool.load(gameScreen, R.raw.wake_up_voice, 1);
        horseWagonSoundId = soundPool.load(gameScreen, R.raw.carriage, 1);
        runningInGrassSoundId = soundPool.load(gameScreen, R.raw.running_in_grass, 1);
        horseSoundId = soundPool.load(gameScreen, R.raw.horse_stop, 1);

        townGateDoorSoundId = soundPool.load(gameScreen, R.raw.town_gate_door, 1);
        theTownSound = MediaPlayer.create(gameScreen, R.raw.the_town);
        theTownSound.setLooping(true);

        anvilSoundId = soundPool.load(gameScreen, R.raw.anvil_sound, 1);
        lightFireSoundId = soundPool.load(gameScreen, R.raw.light_fire, 1);
        underWaterSoundId = soundPool.load(gameScreen, R.raw.underwater, 1);
        hitTreeSoundId = soundPool.load(gameScreen, R.raw.hit_tree, 1);
        eatingAppleSoundId = soundPool.load(gameScreen, R.raw.eating_apple, 1);
        magicMountainSoundId = soundPool.load(gameScreen, R.raw.magic_mountain, 1);

        battleMusic = MediaPlayer.create(gameScreen, battleMusicList[rand.nextInt(battleMusicList.length)]);
        battleMusic.setLooping(true);
        battleMusic.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                battleMusic = MediaPlayer.create(gameScreen, battleMusicList[rand.nextInt(battleMusicList.length)]);
            }
        });
        insideCaveSound = MediaPlayer.create(gameScreen, R.raw.inside_cave);
        insideCaveSound.setLooping(true);
        demonHideoutSound = MediaPlayer.create(gameScreen, R.raw.demon_hideout);
        demonHideoutSound.setLooping(true);

        sword1soundId = soundPool.load(gameScreen, R.raw.sword_1, 1);
        sword2soundId = soundPool.load(gameScreen, R.raw.sword_2, 1);
        sword3soundId = soundPool.load(gameScreen, R.raw.sword_3, 1);
        sword4soundId = soundPool.load(gameScreen, R.raw.sword_4, 1);
        swordSounds = new int[]{sword1soundId, sword2soundId, sword3soundId, sword4soundId};

        goblinSoundId = soundPool.load(gameScreen, R.raw.goblin_roar, 1);
        riverMonsterSoundId = soundPool.load(gameScreen, R.raw.river_monster_roar, 1);
        evilWitchSoundId = soundPool.load(gameScreen, R.raw.evil_witch_laugh, 1);
        shadowSerpentSoundId = soundPool.load(gameScreen, R.raw.shadow_serpent_sound, 1);
        demonGeneralSoundId = soundPool.load(gameScreen, R.raw.demon_general_laugh, 1);
        explosionSoundId = soundPool.load(gameScreen, R.raw.explosion, 1);

        spellFireSoundId = soundPool.load(gameScreen, R.raw.spell_fire, 1);
        spellLightningSoundId = soundPool.load(gameScreen, R.raw.spell_lightning, 1);
        spellWaterSoundId = soundPool.load(gameScreen, R.raw.spell_water, 1);
        spellPoisonBreezeSoundId = soundPool.load(gameScreen, R.raw.spell_poison_breeze, 1);

        titleMusic = MediaPlayer.create(gameScreen, R.raw.title_music);
        titleMusic.setLooping(true);
    }

    public void pauseBackGroundMusic() {
        if (bgMusic.isPlaying()) {
            bgMusic.pause();
            positionBgMusic = battleMusic.getCurrentPosition();
        }
    }

    public void playBackGroundMusic() {
        if (!bgMusic.isPlaying()) {
            stopAllMusic();
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    bgMusic.seekTo(positionBgMusic);
                    bgMusic.start();
                }
            }, 300);
        }
    }

    public void playBattleMusic() {
        stopAllMusic();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                battleMusic.seekTo(positionBattleMusic);
                battleMusic.start();
            }
        }, 300);
    }

    public void playTheEndMusic() {
        stopAllMusic();
        titleMusic.start();
    }

    public void stopAllMusic() {
        if (battleMusic.isPlaying()) {
            battleMusic.pause();
            positionBattleMusic = battleMusic.getCurrentPosition();
        }
        if (bgMusic.isPlaying()) {
            bgMusic.pause();
            positionBgMusic = bgMusic.getCurrentPosition();
        }
        if (titleMusic.isPlaying())
            titleMusic.pause();
        if (rainingSound.isPlaying())
            rainingSound.pause();
        if (windySound.isPlaying())
            windySound.pause();
        if (theTownSound.isPlaying())
            theTownSound.pause();
        if (insideCaveSound.isPlaying())
            insideCaveSound.pause();
        if (demonHideoutSound.isPlaying())
            demonHideoutSound.pause();
    }

    public void click() {
        soundPool.play(clickSoundId, 0.5f, 0.5f, 1, 0, 1.5f);
    }

    public void obtainWeapon() {
        soundPool.play(obtainWeaponSoundId, 1f, 1f, 1, 0, 1f);
    }

    public void healthUp() {
        soundPool.play(healthUpSoundId, 1f, 1f, 1, 0, 1f);
    }

    public void coins() {
        soundPool.play(coinsSoundId, 1f, 1f, 1, 0, 1f);
    }

    public void spell(int id) {
        soundPool.play(id, 1f, 1f, 1, 0, 1f);
    }

    public void sword() {
        soundPool.play(swordSounds[rand.nextInt(swordSounds.length)], 1f, 1f, 1, 0, 1f);
    }

    public void drivingHighWay() {
        drivingHighWaySound.start();
    }

    public void openingDoor() {
        if (drivingHighWaySound.isPlaying())
            drivingHighWaySound.pause();
        openDoorSound.start();
    }

    public void getHome() {
        soundPool.play(takeShoeOffSoundId, 1f, 1f, 1, 0, 1.2f);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                soundPool.play(dropBagSoundId, 1f, 1f, 1, 0, 1f);
            }
        }, 2000);
    }

    public void bedRoom() {
        if (openDoorSound.isPlaying())
            openDoorSound.pause();
        stopAllSoundEffect();
        rainingSound.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                soundPool.play(lyingBedSoundId, 2f, 2f, 1, 0, 0.6f);
            }
        }, 5000);
    }

    public void raining() {
        if (rainingSound.isPlaying())
            rainingSound.pause();
        else rainingSound.start();
    }

    public void windyField() {
        if (windySound.isPlaying())
            windySound.pause();
        else
            windySound.start();
    }

    public void wakeUpVoice() {
        soundPool.play(wakeUpVoiceId, 1f, 1f, 1, 0, 1f);
    }

    public void horseWagonFar() {
        playingSoundEffect.put(horseWagonSoundId, soundPool.play(horseWagonSoundId, 0.6f, 0.6f, 1, -1, 1f));
    }

    public void horseWagonNear() {
        playingSoundEffect.put(horseWagonSoundId, soundPool.play(horseWagonSoundId, 1f, 1f, 1, -1, 1f));
    }

    public void runningInGrass() {
        playingSoundEffect.put(runningInGrassSoundId, soundPool.play(runningInGrassSoundId, 1f, 1f, 1, -1, 1f));
    }

    public void horse() {
        soundPool.play(horseSoundId, 1f, 1f, 1, 0, 1f);
    }

    public void townGateDoor() {
        soundPool.play(townGateDoorSoundId, 1f, 1f, 1, 0, 1f);
    }

    public void theTown() {
        if (!theTownSound.isPlaying()) {
            stopAllMusic();
            theTownSound.start();
        }
    }

    public void anvil() {
        if (playingSoundEffect.get(anvilSoundId) == null)
            playingSoundEffect.put(anvilSoundId, soundPool.play(anvilSoundId, 0.4f, 0.4f, 1, -1, 0.66f));
    }

    public void lightFire() {
        soundPool.play(lightFireSoundId, 1f, 1f, 1, 0, 1f);
    }

    public void underWater() {
        playingSoundEffect.put(underWaterSoundId, soundPool.play(underWaterSoundId, 1f, 1f, 1, -1, 1f));
    }

    public void hitTree() {
        soundPool.play(hitTreeSoundId, 1f, 0.6f, 1, 0, 1f);
    }

    public void eatingApple() {
        soundPool.play(eatingAppleSoundId, 1.0f, 1.0f, 1, 1, 1.3f);
    }

    public void magicMountain() {
        if (playingSoundEffect.get(magicMountainSoundId) == null)
            playingSoundEffect.put(magicMountainSoundId, soundPool.play(magicMountainSoundId, 1f, 1f, 1, -1, 1f));
    }

    public void insideCave() {
        if (!insideCaveSound.isPlaying()) {
            stopAllMusic();
            insideCaveSound.start();
        }
    }

    public void demonHideout() {
        if (!demonHideoutSound.isPlaying()) {
            stopAllMusic();
            demonHideoutSound.start();
        }
    }

    public void goblin(boolean loop) {
        if (loop) {
            soundPool.play(goblinSoundId, 1.0f, 1.0f, 1, 2, 1.3f);
        } else
            soundPool.play(goblinSoundId, 1.0f, 1.0f, 1, 0, 1f);
    }

    public void riverMonster() {
        soundPool.play(riverMonsterSoundId, 1.0f, 1.0f, 1, 0, 1f);
    }

    public void evilWitch() {
        soundPool.play(evilWitchSoundId, 1.0f, 1.0f, 1, 0, 1f);
    }

    public void shadowSerpent() {
        soundPool.play(shadowSerpentSoundId, 1.0f, 1.0f, 1, 1, 1f);
    }

    public void demonGeneral() {
        soundPool.play(demonGeneralSoundId, 1.0f, 1.0f, 1, 1, 1f);
    }

    public void explosion() {
        soundPool.play(explosionSoundId, 1.0f, 1.0f, 1, 0, 0.6f);
    }

    public void stopSoundEffect(Integer id) {
        soundPool.stop(playingSoundEffect.get(id));
        playingSoundEffect.remove(id);
    }

    public void stopAllSoundEffect() {
        for (Map.Entry<Integer, Integer> entry : playingSoundEffect.entrySet()) {
            soundPool.stop(entry.getValue());
        }
        playingSoundEffect.clear();
    }


}
