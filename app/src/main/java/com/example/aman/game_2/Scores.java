package com.example.aman.game_2;

/**
 * Created by Aman on 03/04/2018.
 */

public class Scores {
    static double levelOneHighScore = 20.0;
    static  double levelOneScore;

    public static void setLevelOneScore(double levelOneScore) {
        Scores.levelOneScore = levelOneScore;
    }

    public static double getLevelOneScore() {
        return levelOneScore;
    }
}
