package com.example.hdh.hangleking.Class.InGame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.hdh.hangleking.R;

public class BitmapConstructor_Game {

    private int width , height;

    public Bitmap imgBack; // 배경
    public Bitmap ui; // 게임 하단 UI
    public Bitmap character; // 게임 하단 캐릭터

    public BitmapFactory.Options options;

    public BitmapConstructor_Game(Context context , int width , int height){
        this.width = width;
        this.height = height;

        options = new BitmapFactory.Options();
        options.inSampleSize = 2;

        imgBack = BitmapFactory.decodeResource(context.getResources(), R.drawable.game_back, options);
        imgBack = Bitmap.createScaledBitmap(imgBack, width, height, false);

        ui = BitmapFactory.decodeResource(context.getResources(), R.drawable.gameui, options);
        ui = Bitmap.createScaledBitmap(ui, width, height / 5, false);

        character = BitmapFactory.decodeResource(context.getResources(), R.drawable.character, options);
        character = Bitmap.createScaledBitmap(character, width / 8, height / 5, false);

    }

    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(imgBack, 0, 0, null);
        canvas.drawBitmap(ui, 0, height - (height / 5), null);
        canvas.drawBitmap(character, 0, height - (height / 5), null);
    }
}
