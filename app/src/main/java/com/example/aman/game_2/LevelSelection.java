package com.example.aman.game_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LevelSelection extends AppCompatActivity {

    Button level1,level2,level3,level4,level5,level6,level7,level8,level9,level10,level11,level12,level13,level14,level15;

    Intent intent;
    private LevelUnlock levelUnlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        level1 = (Button)findViewById(R.id.level_1);
        level2 = (Button)findViewById(R.id.level_2);
        level3 = (Button)findViewById(R.id.level_3);
        level4 = (Button)findViewById(R.id.level_4);
        level5 = (Button)findViewById(R.id.level_5);
        level6 = (Button)findViewById(R.id.level_6);
        level7 = (Button)findViewById(R.id.level_7);
        level8 = (Button)findViewById(R.id.level_8);
        level9 = (Button)findViewById(R.id.level_9);
        level10 = (Button)findViewById(R.id.level_10);
        level11 = (Button)findViewById(R.id.level_11);
        level12 = (Button)findViewById(R.id.level_12);
        level13 = (Button)findViewById(R.id.level_13);
        level14 = (Button)findViewById(R.id.level_14);
        level15 = (Button)findViewById(R.id.level_15);

        levelUnlock = new LevelUnlock(this);
        intent = new Intent(LevelSelection.this,MainActivity.class);
        init();
    }

    private void init() {
        if (levelUnlock.getUnlock_2()){
            level2.setEnabled(true);
        }
    }

    public void buttonOne(View view){
        TimeImageUtil.setImages(10);
        TimeImageUtil.setTime(2000);
        startActivity(intent);
    }

    public void buttonTwo(View view){
        TimeImageUtil.setImages(15);
        TimeImageUtil.setTime(1333);
        startActivity(intent);
    }

    public void buttonThree(View view){
        TimeImageUtil.setImages(15);
        TimeImageUtil.setTime(1000);
        startActivity(intent);
    }

    public void buttonFour(View view){
        TimeImageUtil.setImages(10);
        TimeImageUtil.setTime(3000);
        startActivity(intent);
    }

    public void buttonFive(View view){
        TimeImageUtil.setImages(15);
        TimeImageUtil.setTime(2000);
        startActivity(intent);
    }

    public void buttonSix(View view){
        TimeImageUtil.setImages(20);
        TimeImageUtil.setTime(1500);
        startActivity(intent);
    }

    public void buttonSeven(View view){
        TimeImageUtil.setImages(10);
        TimeImageUtil.setTime(4000);
        startActivity(intent);
    }

    public void buttonEight(View view){
        TimeImageUtil.setImages(15);
        TimeImageUtil.setTime(2666);
        startActivity(intent);
    }

    public void buttonNine(View view){
        TimeImageUtil.setImages(20);
        TimeImageUtil.setTime(2000);
        startActivity(intent);
    }

    public void buttonTen(View view){
        TimeImageUtil.setImages(10);
        TimeImageUtil.setTime(5000);
        startActivity(intent);
    }

    public void buttonEleven(View view){
        TimeImageUtil.setImages(15);
        TimeImageUtil.setTime(3999);
        startActivity(intent);
    }

    public void buttonTwelve(View view){
        TimeImageUtil.setImages(20);
        TimeImageUtil.setTime(2500);
        startActivity(intent);
    }

    public void buttonThirteen(View view){
        TimeImageUtil.setImages(10);
        TimeImageUtil.setTime(6000);
        startActivity(intent);
    }

    public void buttonFourteen(View view){
        TimeImageUtil.setImages(15);
        TimeImageUtil.setTime(4000);
        startActivity(intent);
    }

    public void buttonFifteen(View view){
        TimeImageUtil.setImages(20);
        TimeImageUtil.setTime(3000);
        startActivity(intent);
    }

}
