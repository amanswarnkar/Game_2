package com.example.aman.game_2;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.IncompleteAnnotationException;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ImageView imageView;

    int imageIndex,progressStatus = 0,imageTimeCount=0;
    public HashMap<Integer,Integer> imageTime;
    int gameArray[] = new int[30];
    Handler handler;
    final int[] imageArray = {
            R.drawable.number_1,
            R.drawable.random_34,
            R.drawable.random_3,
            R.drawable.random_33,
            R.drawable.random_32,
            R.drawable.animal_13,
            R.drawable.animal_1,
            R.drawable.animal_12,
            R.drawable.animal_6,
            R.drawable.animal_2,
            R.drawable.animal_3,
            R.drawable.animal_4,
            R.drawable.animal_5,
            R.drawable.animal_7,
            R.drawable.animal_8,
            R.drawable.animal_9,
            R.drawable.animal_10,
            R.drawable.animal_11,
            R.drawable.animal_14,
            R.drawable.number_7,
            R.drawable.number_8,
            R.drawable.number_14,
            R.drawable.chair_10,
            R.drawable.chair_11,
            R.drawable.chair_13,
            R.drawable.chair_16,
            R.drawable.city_1,
            R.drawable.phone_1,
            R.drawable.computer_1,
            R.drawable.eggs_1,
            R.drawable.automobile,
            R.drawable.libra,
            R.drawable.lock_1,
            R.drawable.letter_1,
            R.drawable.key_1,
            R.drawable.random_1,
            R.drawable.random_15,
            R.drawable.random_31,
            R.drawable.random_2,
            R.drawable.random_4,
            R.drawable.random_5,
            R.drawable.random_6,
            R.drawable.random_7,
            R.drawable.random_8,
            R.drawable.random_9,
            R.drawable.random_10,
            R.drawable.random_11,
            R.drawable.random_12,
            R.drawable.random_13,
            R.drawable.random_14,
            R.drawable.random_17,
            R.drawable.random_18,
            R.drawable.random_19,
            R.drawable.random_20,
            R.drawable.random_21,
            R.drawable.random_22,
            R.drawable.random_23,
            R.drawable.random_24,
            R.drawable.random_25,
            R.drawable.random_26,
            R.drawable.random_27,
            R.drawable.random_28,
            R.drawable.random_29,
            R.drawable.random_30,
            R.drawable.random_35,
            R.drawable.skyscrapper_1,
            R.drawable.random_36,
            R.drawable.random_37,
            R.drawable.random_38,
            R.drawable.random_39,
            R.drawable.random_40,
            R.drawable.heart,
            R.drawable.random_41,
            R.drawable.random_42,
            R.drawable.random_43,
            R.drawable.random_44,
            R.drawable.shelf_4,
            R.drawable.eggs_4,
            R.drawable.tunning_3,
            R.drawable.zombie_1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progressBar3);
        imageView = (ImageView)findViewById(R.id.imageView);

        imageTime = new HashMap<>();
        randomizeArray(imageArray, imageArray.length);
        imageIndex = 0;
        handler = new Handler();

        createDialogueBox();
    }

    private void createDialogueBox() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogue_box);
        dialog.setTitle("custom");
        Button button = (Button)dialog.findViewById(R.id.button2);
        TextView textView = (TextView)dialog.findViewById(R.id.textView8);
        button.setEnabled(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                runnable.run();
            }
        });
        dialog.show();
    }

    private void randomizeArray(int[] array, int length){
        Random r = new Random();
        for(int i=length-1; i>0; i--){
            int j = r.nextInt(i);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public int[] semiArray(){
        for (int i=0;i<30; i++){
            gameArray[i] = imageArray[i];
        }
        return gameArray;
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (imageIndex<=(TimeImageUtil.getImages()-1)){
                toChangePicture();
                handler.postDelayed(runnable,TimeImageUtil.getTime());
            }else {
                stopTask();
            }
        }
    };

    private void stopTask() {
        handler.removeCallbacks(runnable);
        TimeImageUtil.setSemi(semiArray());
        TimeImageUtil.setSetImageTime(imageTime);
        Intent intent = new Intent(MainActivity.this,ImageGrid.class);
        startActivity(intent);
    }

    private void toChangePicture() {
        imageTimeCount++;
        imageTime.put(imageArray[imageIndex],imageTimeCount);
        imageView.setImageResource(imageArray[imageIndex]);
        progressStatus+=(100/TimeImageUtil.getImages());
        handler.post(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(progressStatus);
            }
        });
        imageIndex++;
    }
}
