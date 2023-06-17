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
    private SoundPool soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
    public MediaPlayer titleMusic;
    private MediaPlayer bgMusic, battleMusic, drivingHighWaySound, openDoorSound, rainingSound, windySound, insideCaveSound, demonHideoutSound;
    private int[] battleMusicList = {R.raw.battle_music_1, R.raw.battle_music_2};
    private int[] backGroundMusicList = {R.raw.back_ground_music_1, R.raw.back_ground_music_2};
    private int positionBgMusic = 0, positionBattleMusic = 0;
    public Integer clickSoundId, obtainWeaponSoundId, healthUpSoundId,
            takeShoeOffSoundId, dropBagSoundId, lyingBedSoundId, wakeUpVoiceId,
            horseWagonSoundId, runningInGrassSoundId, horseSoundId,
            anvilSoundId, underWaterSoundId, hitTreeSoundId, eatingAppleSoundId, magicMountainSoundId, explosionSoundId,
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

        takeShoeOffSoundId = soundPool.load(gameScreen, R.raw.shoes_take_off, 1);
        dropBagSoundId = soundPool.load(gameScreen, R.raw.drop_bag, 1);
        lyingBedSoundId = soundPool.load(gameScreen, R.raw.lying_on_bed, 1);
        wakeUpVoiceId = soundPool.load(gameScreen, R.raw.wake_up_voice, 1);
        horseWagonSoundId = soundPool.load(gameScreen, R.raw.carriage, 1);
        runningInGrassSoundId = soundPool.load(gameScreen, R.raw.running_in_grass, 1);
        horseSoundId = soundPool.load(gameScreen, R.raw.horse_stop, 1);

        anvilSoundId = soundPool.load(gameScreen, R.raw.anvil_sound, 1);
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

        goblinSoundId = soundPool.load(gameScreen, R.raw.goblin_roar, 1);
        riverMonsterSoundId = soundPool.load(gameScreen, R.raw.river_monster_roar, 1);
        evilWitchSoundId = soundPool.load(gameScreen, R.raw.evil_witch_laugh, 1);
        shadowSerpentSoundId = soundPool.load(gameScreen, R.raw.shadow_serpent_sound, 1);
        demonGeneralSoundId = soundPool.load(gameScreen, R.raw.demon_general_laugh, 1);
        explosionSoundId = soundPool.load(gameScreen, R.raw.explosion, 1);

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
        stopAllMusic();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                bgMusic.seekTo(positionBgMusic);
                bgMusic.start();
            }
        }, 500);
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
        if (rainingSound.isPlaying())
            rainingSound.stop();
        if (windySound.isPlaying())
            windySound.stop();
        if (insideCaveSound.isPlaying())
            insideCaveSound.stop();
        if (demonHideoutSound.isPlaying())
            demonHideoutSound.stop();
    }

    public void click() {
        soundPool.play(clickSoundId, 0.4f, 0.4f, 1, 0, 0.7f);
    }

    public void obtainWeapon() {
        soundPool.play(obtainWeaponSoundId, 0.7f, 0.7f, 1, 0, 1f);
    }

    public void healthUp() {
        soundPool.play(healthUpSoundId, 0.8f, 0.8f, 1, 0, 1f);
    }

    public void drivingHighWay() {
        drivingHighWaySound.start();
    }

    public void openingDoor() {
        if (drivingHighWaySound.isPlaying())
            drivingHighWaySound.stop();
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
            openDoorSound.stop();
        stopAllSoundEffect();
        rainingSound.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                soundPool.play(lyingBedSoundId, 1.6f, 1.6f, 1, 0, 0.6f);
            }
        }, 5000);
    }

    public void raining() {
        if (rainingSound.isPlaying())
            rainingSound.stop();
        else rainingSound.start();
    }

    public void windyField() {
        if (windySound.isPlaying())
            windySound.stop();
        else
            windySound.start();
    }

    public void wakeUpVoice() {
        soundPool.play(wakeUpVoiceId, 0.6f, 0.6f, 1, 0, 1f);
    }

    public void horseWagonFar() {
        playingSoundEffect.put(horseWagonSoundId, soundPool.play(horseWagonSoundId, 0.3f, 0.3f, 1, -1, 1f));
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

    public void anvil() {
        if (playingSoundEffect.get(anvilSoundId) == null)
            playingSoundEffect.put(anvilSoundId, soundPool.play(anvilSoundId, 0.1f, 0.1f, 1, -1, 0.66f));
    }

    public void underWater() {
        playingSoundEffect.put(underWaterSoundId, soundPool.play(underWaterSoundId, 1f, 1f, 1, -1, 1f));
    }

    public void hitTree() {
        soundPool.play(hitTreeSoundId, 0.6f, 0.6f, 1, 0, 1f);
    }

    public void eatingApple() {
        soundPool.play(eatingAppleSoundId, 1.0f, 1.0f, 1, 1, 1.3f);
    }

    public void magicMountain() {
        if (playingSoundEffect.get(magicMountainSoundId) == null)
            playingSoundEffect.put(magicMountainSoundId, soundPool.play(magicMountainSoundId, 1f, 1f, 1, -1, 1f));
    }

    public void insideCave() {
        stopAllMusic();
        if (!insideCaveSound.isPlaying())
            insideCaveSound.start();
    }

    public void demonHideout() {
        stopAllMusic();
        if (!demonHideoutSound.isPlaying())
            demonHideoutSound.start();
    }

    public void goblin(boolean loop) {
        if (loop) {
            playingSoundEffect.put(goblinSoundId, soundPool.play(goblinSoundId, 1.0f, 1.0f, 1, -1, 1f));
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
