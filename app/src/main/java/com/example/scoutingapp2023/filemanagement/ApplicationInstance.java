package com.example.scoutingapp2023.filemanagement;

import android.app.Application;

import java.io.File;

public class ApplicationInstance extends Application {
    public static ApplicationInstance INSTANCE;

    // Set basic app settings when it is opened
    public void onCreate() {
        super.onCreate();
        INSTANCE = ApplicationInstance.this;


        // Create the scouting directory on the tablets filesystem if it does not exist yet
        File file = new File(Constants.SCOUTING_DIR);
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
