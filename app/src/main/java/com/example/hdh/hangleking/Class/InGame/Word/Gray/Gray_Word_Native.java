package com.example.hdh.hangleking.Class.InGame.Word.Gray;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.hdh.hangleking.Class.Global.Obejct_Attribue;
import com.example.hdh.hangleking.R;

public class Gray_Word_Native extends Obejct_Attribue {

    public Bitmap Gray_NativeWord; // 단어 이미지

    private int ran[] = {
            R.drawable.gray_native_1,
            R.drawable.gray_native_2,
            R.drawable.gray_native_3,
            R.drawable.gray_native_4,
            R.drawable.gray_native_5
    };
    private int index = (int) (Math.random() * ran.length);          //배열개수만큼 랜덤ㄱ
    private int res = ran[index];               //res에 ran에서 랜덤으로 하나 뽑은것을 저장

    //----------------------------------
    // 생성자
    //----------------------------------
    public Gray_Word_Native(int _x, int _y, Context context) {
        super(context);

        setM_X(_x);
        setM_Y(_y);

        Gray_NativeWord = BitmapFactory.decodeResource(context.getResources(), res );               //이미지생성
        Gray_NativeWord = Bitmap.createScaledBitmap(Gray_NativeWord, getWidth() / 5, getHeight() / 5, true);       //크기조정

        setLastTime( System.currentTimeMillis () ); // 현재 시각
    }
}
