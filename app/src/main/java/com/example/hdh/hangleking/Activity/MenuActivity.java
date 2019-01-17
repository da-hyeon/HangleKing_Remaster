package com.example.hdh.hangleking.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hdh.hangleking.CustomView.MenuView;
import com.example.hdh.hangleking.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(new MenuView(this));
    }
    @Override
    public void finish() {
        super.finish();
        this.overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }
}
