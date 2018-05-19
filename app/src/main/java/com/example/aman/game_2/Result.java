package com.example.aman.game_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    ArrayList<Integer> sortedImageAraryList;
    int resultCount =0, size, consecutiveCount=0, nonConsecutiveCount=0;
    double intentData, time,averageAttentionSpan;
    TextView atten, rightImages, recall;
    Button buttonU;
    final String levelunlockKey = "aman";
    boolean unlock ;
    private LevelUnlock levelUnlock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle bundle = getIntent().getExtras();
        atten = (TextView)findViewById(R.id.textView4);
        rightImages =(TextView)findViewById(R.id.textView5);
        recall = (TextView)findViewById(R.id.textView6);
        buttonU = (Button)findViewById(R.id.level_2);
        levelUnlock = new LevelUnlock(this);
        intentData = bundle.getDouble("totalRecallTime");
        time = intentData/1000;
        sortedImageAraryList = TimeImageUtil.getMatchedImagesArrayList();
        size = TimeImageUtil.getMatchedImagesArrayList().size();
        for(int i=0; i<size; i++){
            if (i==size-1){
                nonConsecutiveCount += 1;
                break;
            }else if ((sortedImageAraryList.get(i)+1)!=sortedImageAraryList.get(i+1)){
                nonConsecutiveCount+=1;
            }

            while ((sortedImageAraryList.get(i)+1)==sortedImageAraryList.get(i+1)){
                i++;
                if (i==size-1){
                    consecutiveCount+=1;
                    break;
                }else if ((sortedImageAraryList.get(i)+1)!=sortedImageAraryList.get(i+1)){
                    consecutiveCount+=1;
                    break;
                }
            }
        }

        averageAttentionSpan = (size * (TimeImageUtil.getTime()/1000))/(consecutiveCount+nonConsecutiveCount);


        if (averageAttentionSpan==Scores.levelOneHighScore){
            unlock = getPreferences(MODE_PRIVATE).getBoolean(levelunlockKey,true);
            if (unlock){
                getPreferences(MODE_PRIVATE).edit().putBoolean(levelunlockKey,false).apply();
                levelUnlock.setUnlock_2(true);
                startActivity(new Intent(this,LevelSelection.class));
            }
        }

        if (TimeImageUtil.attentionAtStart()){
            atten.setText(Double.toString(averageAttentionSpan));
            rightImages.setText(Integer.toString(size));
            recall.setText(Double.toString(time));
          //  Toast.makeText(getApplicationContext(),"Average attention "+ averageAttentionSpan+" right images "+size+"recall time"+time,Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"start from beginning",Toast.LENGTH_LONG).show();
        }

    }
}
