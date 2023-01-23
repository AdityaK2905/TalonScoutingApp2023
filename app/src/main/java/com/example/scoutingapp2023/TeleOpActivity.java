package com.example.scoutingapp2023;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TeleOpActivity extends AppCompatActivity {

    String scouter;
    String teamNum;

    //Cubes
    int topCubes = 0;
    int midCubes = 0;
    int lowCubes = 0;
    //Cones
    int topCones = 0;
    int midCones = 0;
    int lowCones = 0;
    //Others
    int autoScore;
    int teleOpScore = 0;
    int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);
    }










    //Increment Methods
    public void cubeTopPlus(View v){
        topCubes++;
    }

    public void cubeMidPlus(View v){
        midCubes++;
    }

    public void cubeLowPlus(View v){
        lowCubes++;
    }

    public void coneTopPlus(View v){
        topCones++;
    }

    public void coneMidPlus(View v){
        midCones++;
    }

    public void coneLowPlus(View v){
        lowCones++;
    }



}
