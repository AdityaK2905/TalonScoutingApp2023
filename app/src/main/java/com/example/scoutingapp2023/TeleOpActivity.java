package com.example.scoutingapp2023;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TeleOpActivity extends AppCompatActivity {

    String scouter;
    String teamNum;

    String teleChargeStation = "none";
    //Cubes
    int topCubes = 0;
    int midCubes = 0;
    int lowCubes = 0;
    //Cones
    int topCones = 0;
    int midCones = 0;
    int lowCones = 0;
    //Others
    int autoTopCones = 0;
    int autoMidCones = 0;
    int autoLowCones = 0;

    int autoTopCubes = 0;
    int autoMidCubes = 0;
    int autoLowCubes = 0;

    String autoChargeStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teleop_screen);
        Bundle bundleAuto = getIntent().getExtras();

        autoTopCones = bundleAuto.getInt("autoConeTop");
        autoMidCones = bundleAuto.getInt("autoConeMid");
        autoLowCones = bundleAuto.getInt("autoConeBot");

        autoTopCubes = bundleAuto.getInt("autoCubeTop");
        autoMidCubes = bundleAuto.getInt("autoCubeMid");
        autoLowCubes = bundleAuto.getInt("autoCubeBot");

        autoChargeStation = bundleAuto.getString("chargeStation");
    }










    //Increment Methods
    public void cubeTopPlus(View v){
        topCubes++;
        updateText();
    }

    public void cubeMidPlus(View v){
        midCubes++;
        updateText();
    }

    public void cubeLowPlus(View v){
        lowCubes++;
        updateText();
    }

    public void coneTopPlus(View v){
        topCones++;
        updateText();
    }

    public void coneMidPlus(View v){
        midCones++;
        updateText();
    }

    public void coneLowPlus(View v){
        lowCones++;
        updateText();
    }

    //Undo Methods
    public void coneTopUndo(View v){
        topCones--;
        updateText();
    }

    public void coneMidUndo(View v){
        midCones--;
        updateText();
    }

    public void coneLowUndo(View v){
        lowCones--;
        updateText();
    }

    public void cubeTopUndo(View v){
        topCubes--;
        updateText();
    }

    public void cubeMidUndo(View v){
        midCubes--;
        updateText();
    }

    public void cubeLowUndo(View v){
        lowCubes--;
        updateText();
    }

    public void updateText(){
        //CONES
        ((TextView)findViewById(R.id.coneTopText)).setText(Integer.toString(topCones));
        ((TextView)findViewById(R.id.coneMidText)).setText(Integer.toString(midCones));
        ((TextView)findViewById(R.id.coneBotText)).setText(Integer.toString(lowCones));
        //CUBES
        ((TextView)findViewById(R.id.cubeTopText)).setText(Integer.toString(topCubes));
        ((TextView)findViewById(R.id.cubeMidText)).setText(Integer.toString(midCubes));
        ((TextView)findViewById(R.id.cubeBotText)).setText(Integer.toString(lowCubes));
    }

}
