package com.example.aman.game_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Aman on 21/03/2018.
 */

public class TimeImageUtil {
    private static HashMap<Integer,Integer> setImageTime;
    private static ArrayList<Integer> selectedImageArray;
    private static ArrayList<Integer> matchedImagesArrayList;
    public static int images;
    public static int time;
    public static int semi[];

    public static void setSemi(int[] semi) {
        TimeImageUtil.semi = semi;
    }

    public static int[] getSemi() {
        return semi;
    }

    public static void setSetImageTime(HashMap<Integer, Integer> setImageTime) {
        TimeImageUtil.setImageTime = setImageTime;
    }

    public static void setSetSelectedImageArray(ArrayList<Integer> selectedImageArray) {
        TimeImageUtil.selectedImageArray = selectedImageArray;
    }

    public static void setImages(int images) {
        TimeImageUtil.images = images;
    }

    public static void setTime(int time) {
        TimeImageUtil.time = time;
    }

    public static int getImages() {
        return images;
    }

    public static int getTime() {
        return time;
    }

    public static boolean attentionAtStart(){
        for (Integer key : selectedImageArray){
            if (setImageTime.get(key)==(Integer)1){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> getMatchedImagesArrayList(){
        matchedImagesArrayList = new ArrayList<>();
        for (Integer selectedImages : selectedImageArray){
            if(setImageTime.containsKey(selectedImages)){
                matchedImagesArrayList.add(setImageTime.get(selectedImages));
            }
        }
        Collections.sort(matchedImagesArrayList);
        return matchedImagesArrayList;
    }
}
