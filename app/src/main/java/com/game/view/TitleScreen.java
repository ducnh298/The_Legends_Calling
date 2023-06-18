package com.game.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.game.R;
import com.game.controller.GameModel;
import com.game.controller.SoundManager;
import com.game.model.Difficulty;

public class TitleScreen extends AppCompatActivity {
    GameModel gameModel;
    SoundManager soundManager;
    ImageView imageView, cloudImageView;
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

        soundManager = new SoundManager(this);
    }

    public void toGameScreen(View view) {
        soundManager.click();
        soundManager.titleMusic.stop();
        Intent gameScreen = new Intent(TitleScreen.this, GameScreen.class);
        gameModel = new GameModel(((Difficulty) difficultySpinner.getSelectedItem()).getValue());
        gameScreen.putExtra("gameModel", gameModel);
        startActivity(gameScreen);
    }
}