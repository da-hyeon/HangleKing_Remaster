package com.example.hdh.hangleking.Class.Global;

import android.app.Application;
import android.util.DisplayMetrics;

public class GlobalVarialbes extends Application {

    private int width , height;

    @Override
    public void onCreate() {

        DisplayMetrics dm = getApplicationContext().getResources().getDisplayMetrics();

        width = dm.widthPixels;
        height = dm.heightPixels;

        super.onCreate();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
