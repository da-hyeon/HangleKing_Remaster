package com.example.hdh.hangleking.Class.InGame.UI;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.hdh.hangleking.Class.Global.Obejct_Attribue;
import com.example.hdh.hangleking.R;

public class Hammer extends Obejct_Attribue {

    public Bitmap Hammer[] = new Bitmap[3]; // 단어부서짐 이미지

    //----------------------------------
    // 생성자
    //----------------------------------
    public Hammer(int _x, int _y , Context context){
        super(context);

        Hammer[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.hammer_1 , options);
        Hammer[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.hammer_2 , options );
        Hammer[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.hammer_3 , options);

        for(int i = 0; i < Hammer.length; i++) {
            Hammer[i] = Bitmap.createScaledBitmap(Hammer[i], getWidth()/5, getHeight()/5, true);       //크기조정
            setM_X(_x - (Hammer[i].getWidth()/2));
            setM_Y(_y - (Hammer[i].getHeight()/2));
        }

        setLastTime(System.currentTimeMillis ()); // 현재 시각
    }
}
