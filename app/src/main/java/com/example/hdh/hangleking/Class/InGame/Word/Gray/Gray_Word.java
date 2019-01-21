package com.example.hdh.hangleking.Class.InGame.Word.Gray;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.hdh.hangleking.Class.Global.Obejct_Attribue;
import com.example.hdh.hangleking.R;

public class Gray_Word extends Obejct_Attribue {

    public Bitmap gray_Word; // 단어 이미지
    public int worldID;

    private int native_Random[] = {
            R.drawable.gray_native_1,
            R.drawable.gray_native_2,
            R.drawable.gray_native_3,
            R.drawable.gray_native_4,
            R.drawable.gray_native_5
    };

    public int loan_Random[]= {
            R.drawable.gray_loan_1,
            R.drawable.gray_loan_2,
            R.drawable.gray_loan_3,
            R.drawable.gray_loan_4,
            R.drawable.gray_loan_5
    };

    private int worldChoice;
    private int index;
    private int res;

    private int _x , _y ;
    private Context context;

    private long changeLastTime; // 경과 시간



    //----------------------------------
    // 생성자
    //----------------------------------
    public Gray_Word(int _x, int _y , Context context){
        super(context);

        this._x = _x;
        this._y = _y;
        this.context = context;

        setM_X(_x);
        setM_Y(_y);

        Change_Gray_Word();

        setLastTime( System.currentTimeMillis () ); // 현재 시각
        changeLastTime = System.currentTimeMillis ();
    }

    public void Change_Gray_Word(){
        worldChoice = (int) (Math.random() * 1);

        switch ( worldChoice ) {
            case 0:
                index = (int) (Math.random() * native_Random.length);          //단어개수만큼 랜덤ㄱ
                res = native_Random[index];               //res에 ran에서 랜덤으로 하나 뽑은것을 저장
                worldID = 0;
                break;
            case 1:
                index = (int) (Math.random() * loan_Random.length);          //단어개수만큼 랜덤ㄱ
                res = loan_Random[index];               //res에 ran에서 랜덤으로 하나 뽑은것을 저장
                worldID = 1;
                break;
        }

        gray_Word = BitmapFactory.decodeResource(context.getResources(), res );               //이미지생성
        gray_Word = Bitmap.createScaledBitmap(gray_Word, getWidth() / 5, getHeight() / 5, true);       //크기조정
    }

    public long getChangeLastTime() {
        return changeLastTime;
    }

    public void setChangeLastTime(long changeLastTime) {
        this.changeLastTime = changeLastTime;
    }
}
