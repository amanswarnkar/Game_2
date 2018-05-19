package com.example.aman.game_2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Aman on 03/04/2018.
 */

public class LevelUnlock {
    private SharedPreferences sharedPreferences;
    private  SharedPreferences.Editor editor;
    private Context mContext;
    final private String key = "aman";

    public LevelUnlock(Context mContext) {
        this.mContext = mContext;
        sharedPreferences = mContext.getSharedPreferences("myapp",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setUnlock_2(boolean unlock_2){
        editor.putBoolean(key,unlock_2);
        editor.commit();
    }

    public boolean getUnlock_2(){
        return sharedPreferences.getBoolean(key,false);
    }

    public void setUnlock_3(boolean unlock_3){
        editor.putBoolean(key,unlock_3);
        editor.commit();
    }

    public boolean getUnlock_3(){
        return sharedPreferences.getBoolean(key,false);
    }
}
