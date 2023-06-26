package com.game.controller.gameManager;

import android.content.Context;
import android.util.Log;

import com.game.model.GameData;
import com.game.controller.GameScreen;
import com.game.controller.TitleScreen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GameSaveManager {

    GameScreen gameScreen;
    TitleScreen titleScreen;
    Context context;

    public GameSaveManager(TitleScreen titleScreen) {
        this.titleScreen = titleScreen;
        this.context = titleScreen.getApplicationContext();
    }

    public GameSaveManager(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        this.context = gameScreen.getApplicationContext();
    }

    public boolean saveGame() {
        try {
            FileOutputStream fileOut = context.openFileOutput("game_data.ser", Context.MODE_PRIVATE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(gameScreen.gameData);
            objectOut.close();
            fileOut.close();
            return true;
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
            return false;
        }
    }

    public GameData loadGame() {
        GameData gameData;
        try {
            FileInputStream fileIn = context.openFileInput("game_data.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            gameData = (GameData) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            Log.d("SaveGame", "Game data loaded.");
            if (gameData != null) {
                return gameData;
            } else return null;
        } catch (IOException e) {
            Log.e("IOException", e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            Log.e("ClassNotFoundException", e.getMessage());
            return null;
        }
    }
}
