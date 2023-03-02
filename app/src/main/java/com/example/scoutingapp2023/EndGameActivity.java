package com.example.scoutingapp2023;

import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scoutingapp2023.filemanagement.ApplicationInstance;
import com.example.scoutingapp2023.filemanagement.Constants;

import java.io.File;
import java.io.FileWriter;

public class EndGameActivity extends AppCompatActivity {
    String matchNum;
    String teamNum;

    String autoChargeStation;
    int autoTopCones = 0;
    int autoMidCones = 0;
    int autoLowCones = 0;

    int autoTopCubes = 0;
    int autoMidCubes = 0;
    int autoLowCubes = 0;

    String teleChargeStation;
    //Cubes
    int topCubes = 0;
    int midCubes = 0;
    int lowCubes = 0;
    //Cones
    int topCones = 0;
    int midCones = 0;
    int lowCones = 0;

    Boolean leftCommunity;

    String drivingSkills;
    String generalComments;




    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);
        Bundle bundleTele = getIntent().getExtras();

        autoTopCones = bundleTele.getInt("autoTopCones");
        autoMidCones = bundleTele.getInt("autoMidCones");
        autoLowCones = bundleTele.getInt("autoLowCones");

        autoTopCubes = bundleTele.getInt("autoTopCubes");
        autoMidCubes = bundleTele.getInt("autoMidCubes");
        autoLowCubes = bundleTele.getInt("autoLowCubes");

        autoChargeStation = bundleTele.getString("autoChargeStation");
        matchNum = bundleTele.getString("matchNum");
        teamNum = bundleTele.getString("teamNum");
        leftCommunity = bundleTele.getBoolean("leftCommunity");

        //cones
        topCones = bundleTele.getInt("topCones");
        midCones = bundleTele.getInt("midCones");
        lowCones = bundleTele.getInt("lowCones");

        //cubes
        topCubes = bundleTele.getInt("topCubes");
        midCubes = bundleTele.getInt("midCubes");
        lowCubes = bundleTele.getInt("lowCubes");

        teleChargeStation = bundleTele.getString("teleChargeStation");

    }


    public void createCSV(View v){
        EditText drivingEditable =(EditText) findViewById(R.id.driverEditText);
        EditText generalEditable =(EditText) findViewById(R.id.generalEditText);

        MediaScannerConnection mMs;
        drivingSkills =drivingEditable.getText().toString();
        generalComments = generalEditable.getText().toString();

        String FILENAME = "m_:" + matchNum + "_t_:" + teamNum + "_.csv";

        drivingSkills = removeCommas(drivingSkills);
        generalComments = removeCommas(generalComments);

        int totalpoints = 0;

        if (leftCommunity){
            totalpoints += 3;
        }
        totalpoints += 3*(autoLowCones+autoLowCubes)+4*(autoMidCones+autoMidCubes)+6*(autoTopCones+autoTopCubes);
        totalpoints += 2*(lowCones+lowCubes)+3*(midCones+midCubes)+5*(topCones+topCubes);


        if (autoChargeStation.equals("Docked")){
            totalpoints += 8;
        } else if (autoChargeStation.equals("Engaged")){
            totalpoints += 12;
        }

        if (teleChargeStation.equals("Docked")){
            totalpoints += 6;
        } else if (teleChargeStation.equals("Engaged")){
            totalpoints += 10;
        } else if (teleChargeStation.equals("Parked")){
            totalpoints += 2;
        }




        String entry = ""+teamNum+","+matchNum+","+leftCommunity+","+autoTopCones+","+autoMidCones+","+autoLowCones+","+autoTopCubes+","+autoMidCubes+","+autoLowCubes+","+autoChargeStation+","+
                topCones+","+midCones+","+lowCones+","+topCubes+","+midCubes+","+lowCubes+","+teleChargeStation+","+totalpoints+","+drivingSkills+","+generalComments+"\n";

        // Create directory if it does not exist
        File directory = new File(Constants.SCOUTING_DIR);
        if (!directory.exists()) {
            directory.mkdir();
        }
        // Write file and save in directory specified
        try {
            File file = new File(directory, FILENAME);
            FileWriter writer = new FileWriter(file);
            writer.append(entry);
            writer.flush();
            writer.close();
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://"+ Environment.getExternalStorageDirectory())));

        }
        catch (Exception e) {
            /*Toast toast = Toast.makeText(getApplicationContext(), "Something went wrong.", Toast.LENGTH_LONG);
            toast.show();
            */

        }
        Toast toast = Toast.makeText(getApplicationContext(), "File Downloaded! Check Directory.", Toast.LENGTH_LONG);
        toast.show();

        Intent resetIntent = new Intent(this, MainActivity.class);
        startActivity(resetIntent);
    }

    public String removeCommas(String str){
        str = str.replace(",","");
        return str;
    }
}
