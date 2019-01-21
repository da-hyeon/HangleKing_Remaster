package com.example.hdh.hangleking.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.hdh.hangleking.CustomView.GameView;

public class GameActivity extends AppCompatActivity {
    GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        gameView = new GameView(this);
        setContentView(gameView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        gameView.m_Handler.removeMessages(0);
        gameView.m_Handler.removeMessages(1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.m_Handler.sendEmptyMessageDelayed(0, 10); // Handler 호출
        gameView.m_Handler.sendEmptyMessageDelayed(1, gameView.WORD_CREATE_CYCLE); // Handler 호출
    }
}
