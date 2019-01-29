package com.example.hdh.hangleking.Class.InGame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.hdh.hangleking.R;

public class BitmapConstructor_Game {

    private int width , height;

    public Bitmap imgBack; // 배경
    public Bitmap ui; // 게임 하단 UI
    public Bitmap character; // 게임 하단 캐릭터

    private int Correct_Score = 0;      //맞은 갯수
    private int Wrong_Score = 0;        //틀린 갯수
    private int Combo = 0;               //콤보
    private int LIFE = 7;               //목숨
    private int SCORE = 0;               //점수

    private int textField_Width;
    private int textField_Height;

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

        textField_Width = character.getWidth();
        textField_Height = character.getHeight();

    }

    public void onDraw(Canvas canvas , Paint paint) {
        canvas.drawBitmap(imgBack, 0, 0, null);
        canvas.drawBitmap(ui, 0, height - (height / 5), null);
        canvas.drawBitmap(character, 0, height - (height / 5), null);

        //목숨 그리는 부분
        canvas.drawText(" X ", textField_Width, height - (textField_Height / 3), paint);
        canvas.drawText(" " + LIFE + " ", textField_Width + 100, height - (textField_Height / 3), paint);

        //점수 그리는 부분
        canvas.drawText(SCORE + "", width / 2, (float) (height - (textField_Height / 1.6)), paint);

        //맞은 갯수 그리는 부분
        canvas.drawText(Correct_Score + "", (float) (width / 1.7), (float) (height - (textField_Height / 3.7)), paint);

        //틀린 갯수 그리는 부분
        canvas.drawText(Wrong_Score + "", (float) (width / 1.1), (float) (height - (textField_Height / 1.6)), paint);

        canvas.drawText(Combo + "", (float) (width / 1.1), (float) (height - (textField_Height / 3.7)), paint);
    }


}
