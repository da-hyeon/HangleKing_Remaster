package com.example.hdh.hangleking.Class.Menu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.hdh.hangleking.R;

public class BitmapConstructor_Menu {

    private int width , height;

    public Bitmap imgBack; // 배경
    public Bitmap Title;   // 게임제목
    public Bitmap[] Army = new Bitmap[2];      //관군 2명
    public Bitmap paper; // 종이판

    public Bitmap gameStart;        // 게임시작
    public Bitmap gameHelp;         // 게임방법
    public Bitmap gameRanking;       // 게임순위

    public Bitmap Preferences;       // 환경설정

    public BitmapFactory.Options options;

    public BitmapConstructor_Menu(Context context , int width , int height){

        this.width = width;
        this.height = height;

        options = new BitmapFactory.Options();
        options.inSampleSize = 2;

        //----------------------------------
        // MenuImage
        //----------------------------------
        imgBack = BitmapFactory.decodeResource(context.getResources(), R.drawable.game_back , options);
        imgBack = Bitmap.createScaledBitmap(imgBack, width, height, false);

        Title = BitmapFactory.decodeResource(context.getResources(), R.drawable.menu_hangleking, options);
        Title = Bitmap.createScaledBitmap(Title, width / 2, height / 4, false);

        Army[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.menu_army1 , options);
        Army[0] = Bitmap.createScaledBitmap(Army[0], width / 6, (int) (height / 1.3), false);

        Army[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.menu_army2 , options);
        Army[1] = Bitmap.createScaledBitmap(Army[1], width / 6, (int) (height / 1.3), false);

        paper = BitmapFactory.decodeResource(context.getResources(), R.drawable.paper , options);
        paper = Bitmap.createScaledBitmap(paper, (int) (width / 1.4), (int) (height / 1.2), false);


        //----------------------------------
        // Button
        //----------------------------------
        gameStart = BitmapFactory.decodeResource(context.getResources(), R.drawable.menu_start );
        gameStart = Bitmap.createScaledBitmap(gameStart, width / 3, height / 5, false);

        gameHelp = BitmapFactory.decodeResource(context.getResources(), R.drawable.menu_help );
        gameHelp = Bitmap.createScaledBitmap(gameHelp, width / 3, height / 5, false);

        gameRanking = BitmapFactory.decodeResource(context.getResources(), R.drawable.menu_ranking );
        gameRanking = Bitmap.createScaledBitmap(gameRanking, width / 3, height / 5, false);

        Preferences = BitmapFactory.decodeResource(context.getResources(), R.drawable.fix , options);
        Preferences = Bitmap.createScaledBitmap(Preferences, width / 10, height / 10, false);

    }

    public void onDraw(Canvas canvas) {
        //배경
        canvas.drawBitmap(imgBack, 0, 0, null);

        //게임제목
        canvas.drawBitmap(Title, width / 2 - (Title.getWidth() / 2), 0, null);

        //왼쪽관군
        canvas.drawBitmap(Army[0], 0, height / 5, null);

        //오른쪽관군
        canvas.drawBitmap(Army[1], (float) (width / 1.2), height / 5, null);

        //종이
        canvas.drawBitmap(paper, (width / 2) - (paper.getWidth() / 2), ((height / 5)), null);

        //게임시작
        canvas.drawBitmap(gameStart, ((width / 2) - (gameStart.getWidth() / 2)), (height / 3), null);

        //게임방법
        canvas.drawBitmap(gameHelp,((width / 2) - (gameHelp.getWidth() / 2)), (height / 2), null);

        //게임순위
        canvas.drawBitmap(gameRanking, ((width / 2) - (gameRanking.getWidth() / 2)), (float) (height / 1.5), null);

        //게임순위
        canvas.drawBitmap(Preferences, 0 , 0, null);
    }
}
