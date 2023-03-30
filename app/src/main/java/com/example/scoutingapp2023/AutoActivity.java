package com.example.scoutingapp2023;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AutoActivity extends AppCompatActivity {
    String teamNum;
    String matchNum;



    int coneTop = 0;
    int coneMid = 0;
    int coneBot = 0;

    int cubeTop = 0;
    int cubeMid = 0;
    int cubeBot = 0;

    String chargeStation = "None";
    Boolean leftCommunity = false;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);
        Bundle bundleMain = getIntent().getExtras();

       matchNum = bundleMain.getString("matchNum");
       teamNum = bundleMain.getString("teamNum");

    }


    public void startTele(View v){



        Bundle bundleStart = new Bundle();

        bundleStart.putInt("autoConeTop", coneTop);
        bundleStart.putInt("autoConeMid", coneMid);
        bundleStart.putInt("autoConeBot", coneBot);

        bundleStart.putInt("autoCubeTop", cubeTop);
        bundleStart.putInt("autoCubeMid", cubeMid);
        bundleStart.putInt("autoCubeBot", cubeBot);

        bundleStart.putString("matchNum", matchNum);
        bundleStart.putString("teamNum", teamNum);
        bundleStart.putString("chargeStation", chargeStation);

        bundleStart.putBoolean("leftCommunity", leftCommunity);

        Intent TeleIntent = new Intent(this, TeleOpActivity.class);
        TeleIntent.putExtras(bundleStart);
        startActivity(TeleIntent);
    }

    public void leftCommunity(View v){
        leftCommunity = true;
        ((TextView)findViewById(R.id.autoChargeStationText)).setText("Charge Station: Left Community");
    }

    public void undoLeftCommunity(View v){
        leftCommunity = false;
    }

    public void docked(View v){
        chargeStation = "Docked";
        updateText();
    }

    public void dockedAndEngaged(View v){
        chargeStation = "Engaged";
        updateText();
    }

    public void resetChargeStation(View v){
        chargeStation = "None";
        updateText();
    }

    public void coneTop(View v){

        coneTop++;
        //((TextView)findViewById(R.id.coneTopAutoText)).setText("hi");
        updateText();
    }
    public void coneTopUndo(View v){
        if (coneTop>0) {
            coneTop--;
        }
        //((TextView)findViewById(R.id.coneTopAutoText)).setText("hi");
        updateText();
    }

    public void coneMidUndo(View v){
        if (coneMid > 0) {
            coneMid--;
        }
        updateText();
    }
    public void coneMid(View v){
        coneMid++;
        updateText();
    }

    public void coneBot(View v){
        coneBot++;
        updateText();
    }
    public void coneBotUndo(View v){
        if (coneBot > 0) {
            coneBot--;
        }
        updateText();
    }

    public void cubeTop(View v){
        cubeTop++;
        updateText();
    }
    public void cubeTopUndo(View v){
        if (cubeTop > 0) {
            cubeTop--;
        }
        updateText();
    }

    public void cubeMid(View v){
        cubeMid++;
        updateText();
    }
    public void cubeMidUndo(View v){
        if (cubeMid > 0) {
            cubeMid--;
        }
        updateText();
    }

    public void cubeBot(View v){
        cubeBot++;
        updateText();
    }
    public void cubeBotUndo(View v){
        if (cubeBot > 0) {
            cubeBot--;
        }
        updateText();
    }


    public void updateText(){
    //CONES
        ((TextView)findViewById(R.id.coneTopText)).setText(Integer.toString(coneTop));
        ((TextView)findViewById(R.id.coneMidText)).setText(Integer.toString(coneMid));
        ((TextView)findViewById(R.id.coneBotText)).setText(Integer.toString(coneBot));
    //CUBES
        ((TextView)findViewById(R.id.cubeTopText)).setText(Integer.toString(cubeTop));
        ((TextView)findViewById(R.id.cubeMidText)).setText(Integer.toString(cubeMid));
        ((TextView)findViewById(R.id.cubeBotText)).setText(Integer.toString(cubeBot));

        ((TextView)findViewById(R.id.autoChargeStationText)).setText("Charge Station: " + chargeStation);
    }


}
