package com.game.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.game.R;
import com.game.model.GameData;
import com.game.controller.gameManager.GameSaveManager;
import com.game.controller.gameManager.SoundManager;
import com.game.controller.gameManager.StoryManager;
import com.game.model.armors.Armor;
import com.game.model.spells.Spell;
import com.game.model.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameScreen extends AppCompatActivity {
    public ImageView image;
    public ConstraintLayout baseLayout;
    public TableLayout tableLayout;
    public TextView textView, hpLabel, armorLabel, goldLabel;
    public Button choice1, choice2, choice3, choice4;
    public Spinner weaponSpinner, spellSpinner;
    public GameScreen gameScreen;
    public StoryManager storyManager;
    public GameData gameData;
    public GameSaveManager gameSaveManager;
    public SoundManager soundManager;
    public final Handler textingHandler = new Handler();
    public final Handler handler = new Handler();
    public final Random rand = new Random();
    private boolean finishTexting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        gameData = (GameData) getIntent().getSerializableExtra("gameData");
        soundManager = new SoundManager(this);
        storyManager = new StoryManager(this, gameData);

        baseLayout = findViewById(R.id.baseLayout);
        tableLayout = findViewById(R.id.tableLayout);
        tableLayout.setVisibility(View.INVISIBLE);

        hpLabel = findViewById(R.id.hpLabel);
        hpLabel.getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        Drawable img = getResources().getDrawable(R.drawable.heart);
                        img.setBounds(0, 0, img.getIntrinsicWidth() * hpLabel.getMeasuredHeight() / img.getIntrinsicHeight() - 2, hpLabel.getMeasuredHeight() - 2);
                        hpLabel.setCompoundDrawables(img, null, null, null);
                        hpLabel.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
        armorLabel = findViewById(R.id.armorLabel);
        armorLabel.setVisibility(View.INVISIBLE);
        armorLabel.getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        Drawable img = getResources().getDrawable(R.drawable.armor);
                        img.setBounds(10, 10, img.getIntrinsicWidth() * armorLabel.getMeasuredHeight() / img.getIntrinsicHeight(), armorLabel.getMeasuredHeight());
                        armorLabel.setCompoundDrawables(img, null, null, null);
                        armorLabel.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
        goldLabel = findViewById(R.id.goldLabel);
        goldLabel.setVisibility(View.INVISIBLE);
        goldLabel.getViewTreeObserver()
                .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        Drawable img = getResources().getDrawable(R.drawable.coin);
                        img.setBounds(0, 0, img.getIntrinsicWidth() * goldLabel.getMeasuredHeight() / img.getIntrinsicHeight() - 2, goldLabel.getMeasuredHeight() - 2);
                        goldLabel.setCompoundDrawables(img, null, null, null);
                        goldLabel.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
        weaponSpinner = findViewById(R.id.weaponSpinner);
        weaponSpinner.setVisibility(View.INVISIBLE);
        spellSpinner = findViewById(R.id.spellSpinner);
        spellSpinner.setVisibility(View.INVISIBLE);

        image = findViewById(R.id.gameImageView);
        textView = findViewById(R.id.gameTextView);
        choice1 = findViewById(R.id.choiceButton1);
        choice2 = findViewById(R.id.choiceButton2);
        choice3 = findViewById(R.id.choiceButton3);
        choice4 = findViewById(R.id.choiceButton4);

        this.gameScreen = this;
        gameSaveManager = new GameSaveManager(this);

        loadingScreen(gameData.position);
    }


    public void loadingScreen(String nextPosition) {
        darkUI();
        Glide.with(this).load(R.drawable.loading_screen).into(image);
        displayText("\n\nGame is loading...\n\n" +
                "The game includes an auto-save feature, ensuring that your progress is saved automatically at certain checkpoints. " +
                "You can focus on enjoying the game without worrying about manually saving your progress.");
        setChoicesAndNextPositions("", "", "", "", "", "", "", "");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (nextPosition == null || nextPosition.equals("opening")) {
                    storyManager.opening();
                } else {
                    if (nextPosition.equals("timeLoop") || nextPosition.equals("windyField1") || nextPosition.equals("meetCarriage") || nextPosition.equals("rideCarriage")) {
                        baseLayout.setBackgroundColor(Color.parseColor("#aab865"));
                    } else startGameUI();
                    storyManager.selectPosition(nextPosition);
                }
            }
        }, 4000);
    }


    public void restartGame() {
        Intent intent = new Intent(this, TitleScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void saveGame() {
        gameSaveManager.saveGame();
    }

    public void quitGame() {
        gameSaveManager.saveGame();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gameScreen.finishAffinity();
                System.exit(0);
            }
        }, 500);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm Exit");
        builder.setMessage("Are you sure you want to exit the game?");
        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gameSaveManager.saveGame();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gameScreen.finishAffinity();
                        System.exit(0);
                    }
                }, 500);
            }
        });
        builder.setNegativeButton("Cancel", null);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void timeLoop() {
        gameData.setup(true, gameData.isMeetDarkCave, gameData.isKnownTownSewer);
        darkUI();
    }

    public void darkUI() {
        tableLayout.setVisibility(View.INVISIBLE);
        baseLayout.setBackgroundColor(Color.parseColor("#000000"));
        textView.setTextColor(Color.parseColor("#FFFFFF"));
    }

    public void startGameUI() {
        gameSaveManager.saveGame();
        textView.setTextColor(Color.parseColor("#000000"));
        baseLayout.setBackgroundColor(Color.parseColor("#FFEDE9C1"));
        tableLayout.setVisibility(View.VISIBLE);
        updatePlayersHp(0);
        updatePlayersWeapons(null);
        updatePlayersCoins(0);
        updatePlayersArmor(null);
        updatePlayersSpells();
    }

    public void clickButton1(View view) {
        soundManager.click();
        storyManager.selectPosition(storyManager.nextPosition1);
    }

    public void clickButton2(View view) {
        soundManager.click();
        storyManager.selectPosition(storyManager.nextPosition2);
    }

    public void clickButton3(View view) {
        soundManager.click();
        storyManager.selectPosition(storyManager.nextPosition3);
    }

    public void clickButton4(View view) {
        soundManager.click();
        storyManager.selectPosition(storyManager.nextPosition4);
    }

    public boolean updatePlayersHp(int hpAmount) {
        if (hpAmount <= 0)
            gameData.player.loseHP(-hpAmount);
        else {
            soundManager.healthUp();
            gameData.player.restoreHP(hpAmount);
        }
        hpLabel.setText(gameData.player.getPlayerHP() + "/" + gameData.player.getPlayerMaxHP());
        if (gameData.player.getPlayerHP() == 0) {
            setChoicesAndNextPositions("Continue", "", "", "", "deadScreen", "", "", "");
            return false;
        }
        return true;
    }

    public void updatePlayersWeapons(Weapon weaponObtain) {
        int selectedItemPosition;
        if (weaponObtain != null) {
            soundManager.obtainWeapon();
            gameData.player.addWeapon(weaponObtain);
            Toast.makeText(getApplicationContext(), "You obtained the " + weaponObtain.getName() + "!!!", Toast.LENGTH_SHORT).show();
        }
        if (gameData.player.getWeaponList().size() > 0) {
            if (weaponSpinner.getVisibility() == View.INVISIBLE)
                weaponSpinner.setVisibility(View.VISIBLE);
            if (weaponObtain != null)
                selectedItemPosition = gameData.player.getWeaponList().size() - 1;
            else {
                if (weaponSpinner.getSelectedItemPosition() > (gameData.player.getWeaponList().size() - 1))
                    selectedItemPosition = gameData.player.getWeaponList().size() - 1;
                else selectedItemPosition = weaponSpinner.getSelectedItemPosition();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    R.layout.spinner_item, gameData.player.getWeaponList().stream().map(weapon -> weapon.getName()).collect(Collectors.toList()));
            adapter.setDropDownViewResource(R.layout.spinner_item);
            weaponSpinner.setAdapter(adapter);
            weaponSpinner.setSelection(selectedItemPosition);
        } else {
            weaponSpinner.setAdapter(null);
            weaponSpinner.setVisibility(View.INVISIBLE);
        }
    }

    public void updatePlayersSpells() {
        int selectedItemPosition = spellSpinner.getSelectedItemPosition();
        if (!gameData.player.getSpellList().isEmpty()) {
            if (spellSpinner.getVisibility() == View.INVISIBLE)
                spellSpinner.setVisibility(View.VISIBLE);
            List<String> spellList = new ArrayList<>();
            for (int i = 0; i < gameData.player.getSpellList().size(); i++) {
                Spell spell = gameData.player.getSpellList().get(i);
                if (spell.getCoolDownRemain() == 0)
                    spellList.add(spell.getName() + " (Ready)");
                else spellList.add(spell.getName() + " (CD: " + spell.getCoolDownRemain() + ")");
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    R.layout.spinner_item, spellList);
            adapter.setDropDownViewResource(R.layout.spinner_item);
            spellSpinner.setAdapter(adapter);
            spellSpinner.setSelection(selectedItemPosition);
        }
    }

    public void updatePlayersArmor(Armor armor) {
        if (gameData.player.getArmor() != null) {
            if (armorLabel.getVisibility() == View.INVISIBLE)
                armorLabel.setVisibility(View.VISIBLE);
            gameData.player.setArmor(armor);
            armorLabel.setText(armor.getName());
            armorLabel.setTextColor(Color.parseColor(armor.getHexColorCode()));
        }
    }

    public boolean updatePlayersCoins(int coins) {
        if (goldLabel.getVisibility() == View.INVISIBLE)
            goldLabel.setVisibility(View.VISIBLE);
        if (coins <= 0) {
            if (!gameData.player.removeCoins(-coins)) {
                Toast.makeText(getApplicationContext(), "You do not have enough coins to do that!", Toast.LENGTH_SHORT).show();
                return false;
            }
        } else
            gameData.player.addCoins(coins);
        goldLabel.setText("Coins: " + gameData.player.getCoins());
        if (coins != 0) soundManager.coins();
        return true;
    }

    public void setChoicesAndNextPositions(String choice1, String choice2, String choice3, String choice4, String nextPosition1, String nextPosition2, String nextPosition3, String nextPosition4) {
        this.choice1.setText(choice1);
        storyManager.nextPosition1 = nextPosition1;
        this.choice2.setText(choice2);
        storyManager.nextPosition2 = nextPosition2;
        this.choice3.setText(choice3);
        storyManager.nextPosition3 = nextPosition3;
        this.choice4.setText(choice4);
        storyManager.nextPosition4 = nextPosition4;
        setChoiceVisibility();
    }

    public void setChoice1(String textChoice, String nextPosition) {
        choice1.setText(textChoice);
        storyManager.nextPosition1 = nextPosition;
        if (textChoice.equals("")) {
            choice1.setVisibility(View.INVISIBLE);
        } else choice1.setVisibility(View.VISIBLE);
    }

    public void setChoice2(String textChoice, String nextPosition) {
        choice2.setText(textChoice);
        storyManager.nextPosition2 = nextPosition;
        if (textChoice.equals("")) {
            choice2.setVisibility(View.INVISIBLE);
        } else
            choice2.setVisibility(View.VISIBLE);
    }

    public void setChoice3(String textChoice, String nextPosition) {
        choice3.setText(textChoice);
        storyManager.nextPosition3 = nextPosition;
        if (textChoice.equals("")) {
            choice3.setVisibility(View.INVISIBLE);
        } else choice3.setVisibility(View.VISIBLE);
    }

    public void setChoice4(String textChoice, String nextPosition) {
        choice4.setText(textChoice);
        storyManager.nextPosition4 = nextPosition;
        if (textChoice.equals("")) {
            choice4.setVisibility(View.INVISIBLE);
        } else choice4.setVisibility(View.VISIBLE);
    }

    public void setChoiceVisibility() {
        if (choice1.getText().equals(""))
            choice1.setVisibility(View.INVISIBLE);
        else
            choice1.setVisibility(View.VISIBLE);
        if (choice2.getText().equals(""))
            choice2.setVisibility(View.INVISIBLE);
        else
            choice2.setVisibility(View.VISIBLE);
        if (choice3.getText().equals(""))
            choice3.setVisibility(View.INVISIBLE);
        else
            choice3.setVisibility(View.VISIBLE);
        if (choice4.getText().equals(""))
            choice4.setVisibility(View.INVISIBLE);
        else
            choice4.setVisibility(View.VISIBLE);
    }

    public void displayText(String text) {
        textingHandler.removeCallbacksAndMessages(null);
        textView.setText(text);
    }

    public void continueDisplayText(String text) {
        textingHandler.removeCallbacksAndMessages(null);
        textView.append(text);
    }

    public void displayTextSlowly(String text) {
        textingHandler.removeCallbacksAndMessages(null);
        textView.setText("");
        finishTexting = false;
        textingHandler.postDelayed(new Runnable() {
            int currentIndex = 0;

            @Override
            public void run() {
                if (finishTexting) {
                    textView.setText(text);
                    finishTexting = false;
                } else if (currentIndex < text.length()) {
                    String currentChar = Character.toString(text.charAt(currentIndex));
                    textView.append(currentChar);
                    currentIndex++;
                    textingHandler.postDelayed(this, 5);
                }
            }
        }, 5);
    }

    public void finishTexting(View view) {
        finishTexting = true;
    }

    public void continueTextSlowly(String text) {
        finishTexting = true;
        String previousText = textView.getText().toString();

        textingHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finishTexting = false;
                textView.append("\n");
            }
        }, 100);

        textingHandler.postDelayed(new Runnable() {
            int currentIndex = 0;

            @Override
            public void run() {
                if (finishTexting) {
                    textView.setText(previousText + "\n" + text);
                    finishTexting = false;
                } else if (currentIndex < text.length()) {
                    String currentChar = Character.toString(text.charAt(currentIndex));
                    textView.append(currentChar);
                    currentIndex++;
                    textingHandler.postDelayed(this, 5);
                }
            }
        }, 200);
    }
}