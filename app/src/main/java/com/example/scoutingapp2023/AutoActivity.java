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

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_screen);
        Bundle bundleMain = getIntent().getExtras();

        bundleMain.putString("matchNum", matchNum);
        bundleMain.putString("teamNum", teamNum);
        bundleMain.putString("chargeStation", chargeStation);

    }


    public void startTele(View v){



        Bundle bundleStart = new Bundle();

        bundleStart.putInt("autoConeTop", coneTop);
        bundleStart.putInt("autoConeMid", coneMid);
        bundleStart.putInt("autoConeBot", coneBot);

        bundleStart.putInt("autoCubeTop", cubeTop);
        bundleStart.putInt("autoCubeMid", cubeMid);
        bundleStart.putInt("autoCubeBot", cubeBot);

        Intent TeleIntent = new Intent(this, TeleOpActivity.class);
        //AutoIntent.putExtras(bundleStart);
        startActivity(TeleIntent);
    }

    public void parked(View v){
        chargeStation = "Parked";
    }

    public void docked(View v){
        chargeStation = "Docked";
    }

    public void dockedAndEngaged(View v){
        chargeStation = "Engaged";
    }

    public void resetChargeStation(View v){
        chargeStation = "None";
    }
    public void coneTop(View v){
        coneTop++;
        //((TextView)findViewById(R.id.coneTopAutoText)).setText("hi");
        updateText();
    }
    public void coneTopUndo(View v){
        coneTop--;
        //((TextView)findViewById(R.id.coneTopAutoText)).setText("hi");
        updateText();
    }

    public void coneMidUndo(View v){
        coneMid--;
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
        coneBot--;
        updateText();
    }

    public void cubeTop(View v){
        cubeTop++;
        updateText();
    }
    public void cubeTopUndo(View v){
        cubeTop--;
        updateText();
    }

    public void cubeMid(View v){
        cubeMid++;
        updateText();
    }
    public void cubeMidUndo(View v){
        cubeMid--;
        updateText();
    }

    public void cubeBot(View v){
        cubeBot++;
        updateText();
    }
    public void cubeBotUndo(View v){
        cubeBot--;
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
    }


}
