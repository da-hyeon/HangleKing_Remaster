package com.example.hdh.hangleking.Class.InGame.Word.Brown;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.hdh.hangleking.Class.Global.Obejct_Attribue;
import com.example.hdh.hangleking.R;

public class Word_Loan extends Obejct_Attribue {

    public Bitmap LoanWord; // 단어 이미지

    private static final int ran[]= {
            R.drawable.loanword_1,
            R.drawable.loanword_2,
            R.drawable.loanword_3,
            R.drawable.loanword_4,
            R.drawable.loanword_5
    };

    private int index = (int) (Math.random() * ran.length);          //배열개수만큼 랜덤ㄱ
    private int res = ran[index];               //res에 ran에서 랜덤으로 하나 뽑은것을 저장

    //----------------------------------
    // 생성자
    //----------------------------------
    public Word_Loan(int _x, int _y , Context context){
        super(context);

        setM_X(_x);
        setM_Y(_y);

        LoanWord = BitmapFactory.decodeResource(context.getResources(), res );               //이미지생성
        LoanWord = Bitmap.createScaledBitmap(LoanWord, getWidth() / 5, getHeight() / 5, true);       //크기조정

        setLastTime(System.currentTimeMillis ()); // 현재 시각
    }
}
