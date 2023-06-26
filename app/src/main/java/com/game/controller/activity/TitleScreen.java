package com.game.controller.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.game.R;
import com.game.model.GameData;
import com.game.controller.GameSaveManager;
import com.game.controller.SoundManager;
import com.game.model.Difficulty;

public class TitleScreen extends AppCompatActivity {
    SoundManager soundManager;
    GameSaveManager gameSaveManager;
    GameData gameData;
    ImageView imageView, cloudImageView;
    Button titleButton1, titleButton2;
    Spinner difficultySpinner;
    Difficulty[] difficulties = new Difficulty[]{Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD, Difficulty.EXTREMEHARD};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        imageView = findViewById(R.id.titleImageView);
        Glide.with(this).load(R.drawable.adventurer).into(imageView);
        cloudImageView = findViewById(R.id.cloudImageView);
        Glide.with(this).load(R.drawable.cloud).into(cloudImageView);

        difficultySpinner = findViewById(R.id.difficultySpinner);
        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<>(this,
                R.layout.title_spinner_item, difficulties);
        adapter.setDropDownViewResource(R.layout.title_spinner_item);
        difficultySpinner.setAdapter(adapter);

        titleButton1 = findViewById(R.id.titleButton1);
        titleButton2 = findViewById(R.id.titleButton2);

        soundManager = new SoundManager(this);
        gameSaveManager = new GameSaveManager(this);
        gameData = gameSaveManager.loadGame();
        if (gameData != null && gameData.position != null) {
            titleButton1.setText("Continue");
            titleButton2.setVisibility(View.VISIBLE);
        }
    }

    public void toGameScreen1(View view) {
        soundManager.click();
        soundManager.titleMusic.stop();
        Intent gameScreen = new Intent(TitleScreen.this, GameScreen.class);
        if (gameData == null)
            gameData = new GameData(((Difficulty) difficultySpinner.getSelectedItem()).getValue());
        gameScreen.putExtra("gameData", gameData);
        startActivity(gameScreen);
    }

    public void toGameScreen2(View view) {
        soundManager.click();
        soundManager.titleMusic.stop();
        Intent gameScreen = new Intent(TitleScreen.this, GameScreen.class);
        gameData = new GameData(((Difficulty) difficultySpinner.getSelectedItem()).getValue());
        gameScreen.putExtra("gameData", gameData);
        startActivity(gameScreen);
    }
}