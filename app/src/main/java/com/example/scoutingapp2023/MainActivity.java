package com.example.scoutingapp2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String scouter;
    String teamNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startAuto(View v){

        //Bundle bundleStart = new Bundle();

        Intent AutoIntent = new Intent(this, AutoActivity.class);
        //AutoIntent.putExtras(bundleStart);
        startActivity(AutoIntent);
    }
}