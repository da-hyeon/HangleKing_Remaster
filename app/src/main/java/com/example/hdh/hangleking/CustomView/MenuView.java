package com.example.hdh.hangleking.CustomView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import com.example.hdh.hangleking.Activity.GameActivity;
import com.example.hdh.hangleking.Class.Menu.BitmapConstructor_Menu;
import com.example.hdh.hangleking.Class.Global.GlobalVarialbes;

/**
 * Created by hwangdahyeon on 2018. 7. 24..
 */

public class MenuView extends View {


    private int width, height; // View의 크기

    private GlobalVarialbes globalVarialbes;
    private BitmapConstructor_Menu bitmapConstructorMenu;

    //----------------------------------
    // 생성자
    //----------------------------------
    public MenuView(Context context) {
        super(context);

        globalVarialbes = (GlobalVarialbes)context.getApplicationContext();
        width = globalVarialbes.getWidth();
        height = globalVarialbes.getHeight();

        bitmapConstructorMenu = new BitmapConstructor_Menu(context , width , height);
    }

    //----------------------------------
    // 그려주는부분
    //----------------------------------
    @SuppressLint("ResourceAsColor")
    public void onDraw(Canvas canvas) {
        bitmapConstructorMenu.onDraw(canvas);
    }

    private Boolean touchBox(int x, int y , Bitmap bitmap){
        if(x > ((width / 2) - (bitmap.getWidth() / 2)) &&
                x < ((width / 2) - (bitmap.getWidth() / 2)) + bitmap.getWidth() &&
                y > (height / 3) &&
                y < (height / 3) + bitmap.getHeight())
            return true;
        else
            return false;
    }
    //------------------------------------
    // onTouch Event
    //------------------------------------
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        //놀이시작 눌렀을때
        if (event.getAction() == MotionEvent.ACTION_DOWN) {                     //터치했을때
            if (  touchBox(x , y , bitmapConstructorMenu.gameStart)  ) {
                Intent intent = new Intent(getContext(), GameActivity.class);
                getContext().startActivity(intent);
                ((Activity) getContext()).finish();
            }
        }
//
//        //놀이방법 눌렀을때
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {                     //터치했을때
//            if (x > ((width / 2) - (gamehelp.getWidth() / 2)) && x < ((width / 2) - (gamehelp.getWidth() / 2)) + gamehelp.getWidth() && y > (height / 2) && y < (height / 2) + gamehelp.getHeight()) {
//                Intent intent = new Intent(getContext(), HelpActivity.class);
//                getContext().startActivity(intent);
//                ((Activity) getContext()).finish();
//            }
//        }
//
//        //놀이순위 눌렀을때
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {                     //터치했을때
//            if (x > ((width / 2) - (gameranking.getWidth() / 2)) && x < ((width / 2) - (gameranking.getWidth() / 2)) + gameranking.getWidth() && y > (height / 1.5) && y < (height / 1.5) + gameranking.getHeight()) {
//                Intent intent = new Intent(getContext(), RankingPop.class);
//                getContext().startActivity(intent);
//            }
//        }
//
//        //환경설정 눌렀을때
//        if (event.getAction() == MotionEvent.ACTION_DOWN) {                     //터치했을때
//            if (x > 0 && x < Preferences.getWidth() && y > 0 && y <  Preferences.getHeight()) {
//                Intent intent = new Intent(getContext(), PreferencesPop.class);
//                getContext().startActivity(intent);
//            }
//        }
       return true;
    }
}
