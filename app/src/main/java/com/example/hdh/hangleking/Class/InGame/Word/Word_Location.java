package com.example.hdh.hangleking.Class.InGame.Word;

import android.content.Context;
import android.util.Log;

import com.example.hdh.hangleking.Class.Global.Obejct_Attribue;

public class Word_Location extends Obejct_Attribue {

    private int faceValueX, faceValueY;                               //랜덤값 반환 변수

    private int LocationX, LocationY;

    private int width, height;

    public boolean LocationCheck[][] = new boolean[5][4];

    public Word_Location(Context context) {
        super(context);
        width = getWidth() / 5;
        height = getHeight() / 5;
    }

    public void rollXY() {

        LocationX = (int) (Math.random() * 5);
        LocationY = (int) (Math.random() * 4);

        if(LocationCheck[LocationX][LocationY]){
            rollXY();
            Log.d("LocationCheck" , "재진입");
        }else {

            switch (LocationX) {
                case 0:
                    faceValueX = 0;
                    break;
                case 1:
                    faceValueX = width;
                    break;
                case 2:
                    faceValueX = width * 2;
                    break;
                case 3:
                    faceValueX = width * 3;
                    break;
                case 4:
                    faceValueX = width * 4;
                    break;
            }

            switch (LocationY) {
                case 0:
                    faceValueY = 0;
                    break;
                case 1:
                    faceValueY = height;
                    break;
                case 2:
                    faceValueY = height * 2;
                    break;
                case 3:
                    faceValueY = height * 3;
                    break;
            }
        }
        LocationCheck[LocationX][LocationY] = true;
        Log.d("LocationCheck" , LocationX + "," + LocationY + "생성");
    }

    public void Location_Check_False(float x, float y) {
        int LocX = 0, LocY = 0;

        if(x == 0){
            LocX = 0;
        }
        else if( x == width){
            LocX = 1;
        }
        else if( x == width * 2){
            LocX = 2;
        }
        else if( x == width * 3){
            LocX = 3;
        }
        else if( x == width * 4){
            LocX = 4;
        }

        if(y == 0){
            LocY = 0;
        }
        else if( y == height){
            LocY = 1;
        }
        else if( y == height * 2){
            LocY = 2;
        }
        else if( y == height * 3){
            LocY = 3;
        }

        LocationCheck[LocX][LocY] = false;
        Log.d("LocationCheck" , LocX + "," + LocY + "삭제");
    }

    public int getFaceValueX() {
        return faceValueX;
    }
    public int getFaceValueY() {
        return faceValueY;
    }
}
