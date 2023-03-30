package com.example.scoutingapp2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TeleOpActivity extends AppCompatActivity {

    String scouter;
    String teamNum;
    String matchNum;

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
    Boolean leftCommunity;

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
        matchNum = bundleAuto.getString("matchNum");
        teamNum = bundleAuto.getString("teamNum");
        leftCommunity = bundleAuto.getBoolean("leftCommunity");
    }

    public void startEndGame(View v){
        Bundle bundleTele = new Bundle();
        bundleTele.putString("matchNum", matchNum);
        bundleTele.putString("teamNum", teamNum);

        bundleTele.putBoolean("leftCommunity", leftCommunity);

        bundleTele.putInt("autoTopCones", autoTopCones);
        bundleTele.putInt("autoMidCones", autoMidCones);
        bundleTele.putInt("autoLowCones", autoLowCones);

        bundleTele.putInt("autoTopCubes", autoTopCubes);
        bundleTele.putInt("autoMidCubes", autoMidCubes);
        bundleTele.putInt("autoLowCubes", autoLowCubes);

        bundleTele.putString("autoChargeStation", autoChargeStation);

        //TELEOP STUFF
        bundleTele.putString("teleChargeStation", teleChargeStation);

        bundleTele.putInt("topCones", topCones);
        bundleTele.putInt("midCones", midCones);
        bundleTele.putInt("lowCones", lowCones);

        bundleTele.putInt("topCubes", topCubes);
        bundleTele.putInt("midCubes", midCubes);
        bundleTele.putInt("lowCubes", lowCubes);

        Intent EndIntent = new Intent(this, EndGameActivity.class);
        EndIntent.putExtras(bundleTele);
        startActivity(EndIntent);
    }



    //charge station

    public void parked(View v){
        teleChargeStation = "Parked";
        updateText();
    }

    public void docked(View v){
        teleChargeStation = "Docked";
        updateText();
    }

    public void dockedAndEngaged(View v){
        teleChargeStation = "Engaged";
        updateText();
    }

    public void resetChargeStation(View v){
        teleChargeStation = "None";
        updateText();
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
        if (topCones > 0) {
            topCones--;
        }
        updateText();
    }

    public void coneMidUndo(View v){
        if (midCones > 0) {
            midCones--;
        }
        updateText();
    }

    public void coneLowUndo(View v){
        if (lowCones > 0) {
            lowCones--;
        }
        updateText();
    }

    public void cubeTopUndo(View v){
        if (topCubes > 0) {
            topCubes--;
        }
        updateText();
    }

    public void cubeMidUndo(View v){
        if (midCubes > 0) {
            midCubes--;
        }
        updateText();
    }

    public void cubeLowUndo(View v){
        if (lowCubes > 0) {
            lowCubes--;
        }
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
        ((TextView)findViewById(R.id.teleChargeStationText)).setText("Charge Station: " + teleChargeStation);
    }

}
