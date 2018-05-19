package com.example.aman.game_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    final String tutorialKey = "Brainalyse";;
    Boolean toLaunchTutorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        toLaunchTutorial = getPreferences(MODE_PRIVATE).getBoolean(tutorialKey,true);
        init();
    }

    private void init() {
        final Intent tutorialIntent = new Intent(this,Tutorial.class);
//        final Intent levelSelectionIntent = new Intent(this,LevelSelection.class);
//        final Thread timer = new Thread(){
//            public void run(){
//                try {
//                    sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }finally {
//                    if (toLaunchTutorial){
//                        getPreferences(MODE_PRIVATE).edit().putBoolean(tutorialKey,false).apply();
//                        startActivity(tutorialIntent);
//                    }else {
//                        startActivity(levelSelectionIntent);
//                    }
//                    finish();
//                }
//            }
//        };
//        timer.start();

        final Thread timer = new Thread(){
          public void run(){
              try {
                  sleep(5000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }finally {
                  startActivity(tutorialIntent);
                  finish();
              }
          }
        };

        timer.start();
    }
}
