package com.game.controller;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;

import com.game.R;
import com.game.view.GameScreen;
import com.game.view.TitleScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SoundManager {
    private GameScreen gameScreen;
    private SoundPool soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
    public MediaPlayer titleMusic;
    private MediaPlayer bgMusic, battleMusic, drivingHighWaySound, openDoorSound, rainingSound, windySound;
    private int[] battleMusicList = {R.raw.battle_music_1, R.raw.battle_music_2};
    private int[] backGroundMusicList = {R.raw.back_ground_music_1, R.raw.back_ground_music_2};
    private int positionBgMusic = 0, positionBattleMusic = 0;
    public Integer clickSoundId, obtainWeaponSoundId, healthUpSoundId,
            takeShoeOffSoundId, dropBagSoundId, lyingBedSoundId, wakeUpVoiceId,
            horseWagonSoundId, runningInGrassSoundId, horseSoundId,
            anvilSoundId, hitTreeSoundId, eatingAppleSoundId,
            goblinSoundId, riverMonsterSoundId, evilWitchSound;
    private List<Integer> playingSoundEffect = new ArrayList<>();
    private Map<Integer, Boolean> soundEffectState = new HashMap<>();
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
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getHome();
                    }
                }, 1000);
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

        battleMusic = MediaPlayer.create(gameScreen, battleMusicList[rand.nextInt(battleMusicList.length)]);
        battleMusic.setLooping(true);
        battleMusic.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                battleMusic = MediaPlayer.create(gameScreen, battleMusicList[rand.nextInt(battleMusicList.length)]);
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
        hitTreeSoundId = soundPool.load(gameScreen, R.raw.hit_tree, 1);
        eatingAppleSoundId = soundPool.load(gameScreen, R.raw.eating_apple, 1);
        goblinSoundId = soundPool.load(gameScreen, R.raw.goblin_roar, 1);
        riverMonsterSoundId = soundPool.load(gameScreen, R.raw.river_monster_roar, 1);
        evilWitchSound = soundPool.load(gameScreen, R.raw.evil_witch_laugh, 1);

        soundEffectState.put(anvilSoundId, false);
    }

    public void playBackGroundMusic() {
        if (battleMusic.isPlaying()) {
            battleMusic.pause();
            positionBattleMusic = battleMusic.getCurrentPosition();
        } else if (rainingSound.isPlaying())
            rainingSound.stop();
        else if (windySound.isPlaying())
            windySound.stop();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                bgMusic.seekTo(positionBgMusic);
                bgMusic.start();
            }
        }, 500);
    }

    public void playBattleMusic() {
        if (bgMusic.isPlaying()) {
            bgMusic.pause();
            positionBgMusic = bgMusic.getCurrentPosition();
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                battleMusic.seekTo(positionBattleMusic);
                battleMusic.start();
            }
        }, 500);
    }

    public void click() {
        soundPool.play(clickSoundId, 0.5f, 0.5f, 1, 0, 0.7f);
    }

    public void obtainWeapon() {
        soundPool.play(obtainWeaponSoundId, 0.8f, 0.8f, 1, 0, 1f);
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
        }, 2500);
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

    public void windyField() {
        stopAllSoundEffect();
        windySound.start();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rainingSound.stop();
            }
        }, 2000);
    }

    public void wakeUpVoice() {
        soundPool.play(wakeUpVoiceId, 0.5f, 0.5f, 1, 0, 1f);
    }

    public void horseWagonFar() {
        playingSoundEffect.add(soundPool.play(horseWagonSoundId, 0.3f, 0.3f, 1, -1, 1f));
    }

    public void horseWagonNear() {
        playingSoundEffect.add(soundPool.play(horseWagonSoundId, 1f, 1f, 1, -1, 1f));
    }

    public void runningInGrass() {
        playingSoundEffect.add(soundPool.play(runningInGrassSoundId, 1f, 1f, 1, -1, 1f));
    }

    public void horse() {
        soundPool.play(horseSoundId, 1f, 1f, 1, 0, 1f);
    }

    public void anvil() {
        if (!soundEffectState.get(anvilSoundId)) {
            playingSoundEffect.add(soundPool.play(anvilSoundId, 0.3f, 0.3f, 1, -1, 0.66f));
            soundEffectState.put(anvilSoundId, true);
        }
    }

    public void hitTree() {
        soundPool.play(hitTreeSoundId, 1.0f, 1.0f, 1, 0, 1f);
    }

    public void eatingApple() {
        soundPool.play(eatingAppleSoundId, 1.0f, 1.0f, 1, 1, 1.3f);
    }

    public void goblin() {
        soundPool.play(goblinSoundId, 1.0f, 1.0f, 1, 0, 1f);
    }

    public void riverMonster() {
        soundPool.play(riverMonsterSoundId, 1.0f, 1.0f, 1, 0, 1f);
    }

    public void evilWitch() {
        soundPool.play(evilWitchSound, 1.0f, 1.0f, 1, 0, 1f);
    }

    public void stopSoundEffect(Integer id) {
        soundPool.stop(id);
        soundEffectState.put(id, false);
        playingSoundEffect.remove(id);
    }

    public void stopAllSoundEffect() {
        for (Integer id : playingSoundEffect) {
            soundPool.stop(id);
            soundEffectState.put(id, false);
        }
        playingSoundEffect.clear();
    }


}
