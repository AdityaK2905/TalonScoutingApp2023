package com.example.scoutingapp2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String scouter;
    String teamNum;
    String matchNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startAuto(View v){


        teamNum = ((EditText)findViewById(R.id.editTeamNumber)).getText().toString();
        matchNum = ((EditText)findViewById(R.id.editMatchNumber)).getText().toString();


        Bundle bundleStart = new Bundle();

        bundleStart.putString("scouter", scouter);
        bundleStart.putString("teamNum", teamNum);
        bundleStart.putString("matchNum", matchNum);

        Intent AutoIntent = new Intent(this, AutoActivity.class);
        AutoIntent.putExtras(bundleStart);
        startActivity(AutoIntent);
    }
}