package com.example.hdh.hangleking.CustomView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.hdh.hangleking.Class.Global.GlobalVarialbes;
import com.example.hdh.hangleking.Class.InGame.BitmapConstructor_Game;
import com.example.hdh.hangleking.Class.InGame.UI.*;
import com.example.hdh.hangleking.Class.InGame.Word.*;
import com.example.hdh.hangleking.Class.InGame.Word.Brown.Word_Loan;
import com.example.hdh.hangleking.Class.InGame.Word.Brown.Word_Native;
import com.example.hdh.hangleking.R;

import java.util.LinkedList;

public class GameView extends View {

    private int LIFE = 7;               //목숨
    private int SCORE = 0;               //점수

    public int WORD_CREATE_CYCLE = 1500;                                    //단어생성주기
    private int WORD_BROKEN_CYCLE = 2000;                                    //단어삭제주기

    private int width, height; // View의 크기

    private Hammer m_Hammer;                                    // 망치 LinkedList 선언
    private int Ani_Num_Hammer_Counter = 0, Ani_Num_Hammer = 0;           //망치 애니메이션 변수

    private Word_Location wordLocation;                        //단어위치 객체 선언

    private LinkedList<Word_Native> m_WordNative;              //고유어 LinkedList 선언
    private LinkedList<Word_Loan> m_WordLoan;                  //외래어 LinkedList 선언

    private Paint paint;                                      //글씨를 써주기 위함

    private BitmapFactory.Options options;
    private GlobalVarialbes globalVarialbes;

    private BitmapConstructor_Game bitmapConstructor_game;

    //----------------------------------
    // 생성자
    //----------------------------------
    public GameView(Context context) {
        super(context);

        options = new BitmapFactory.Options();
        options.inSampleSize = 2;

        globalVarialbes = (GlobalVarialbes) context.getApplicationContext();
        width = globalVarialbes.getWidth();
        height = globalVarialbes.getHeight();

        //고정Bitmap 생성 관리 Class
        bitmapConstructor_game = new BitmapConstructor_Game(context , width , height);

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(bitmapConstructor_game.character.getWidth() / 4);

        m_WordNative = new LinkedList<>(); // 고유어 LinkedList 생성
        m_WordLoan = new LinkedList<>(); // 외래어 LinkedList 생성

        wordLocation = new Word_Location(getContext());      // 단어위치 객체 생성

        m_Handler.sendEmptyMessageDelayed(0, 10); // Handler 호출
        wordCreate_Handler.sendEmptyMessageDelayed(0, WORD_CREATE_CYCLE); // Handler 호출
    }

    //----------------------------------
    // 그려주는부분
    //----------------------------------
    @SuppressLint("ResourceAsColor")
    public void onDraw(Canvas canvas) {
        paint.setAlpha(255);
        bitmapConstructor_game.onDraw(canvas);

        //----------------------------------
        // 고유어 그리기
        //----------------------------------
        for (Word_Native tNative_Word : m_WordNative) {
            canvas.drawBitmap(tNative_Word.NativeWord, tNative_Word.getM_X(), tNative_Word.getM_Y(), paint);
        }

        //----------------------------------
        // 외래어 그리기
        //----------------------------------
        for (Word_Loan tLoan_Word : m_WordLoan) {
            canvas.drawBitmap(tLoan_Word.LoanWord, tLoan_Word.getM_X(), tLoan_Word.getM_Y(), paint);
        }

        //----------------------------------
        // 망치 그리기
        //----------------------------------
        if(m_Hammer != null) {
            Ani_Num_Hammer_Counter++;
            Ani_Num_Hammer = Ani_Num_Hammer_Counter % 30 / 10;
            canvas.drawBitmap(m_Hammer.Hammer[Ani_Num_Hammer], m_Hammer.getM_X(), m_Hammer.getM_Y(), paint);
        }

        Delete_Object_Check();
    }

    //----------------------------------
    // 단어 제거
    //----------------------------------
    private void Delete_Object() {

        //고유어삭제
        for (int i = m_WordNative.size() - 1; i >= 0; i--) {
            if (m_WordNative.get(i).isDead()) {
                wordLocation.Location_Check_False(m_WordNative.get(i).getM_X(), m_WordNative.get(i).getM_Y());
                m_WordNative.remove(i);
                return;
            }
        }

        //외래어 삭제
        for (int i = m_WordLoan.size() - 1; i >= 0; i--) {
            if (m_WordLoan.get(i).isDead()) {
                wordLocation.Location_Check_False(m_WordLoan.get(i).getM_X(), m_WordLoan.get(i).getM_Y());
                m_WordLoan.remove(i);
                return;
            }
        }

        //망치 삭제
        if (m_Hammer != null && m_Hammer.isDead()) {
            m_Hammer = null;
            return;
        }
    }

    //----------------------------------
    // 객체 제거체크
    //----------------------------------
    private void Delete_Object_Check() {

        long thisTime = System.currentTimeMillis();

        //망치 제거 0.3초
        if (m_Hammer != null && thisTime - m_Hammer.getLastTime() >= 450) {
            m_Hammer.setDead(true);
            Delete_Object();
        }

        //고유어 녹이기
        for (int i = m_WordNative.size() - 1; i >= 0; i--) {
            if (thisTime - m_WordNative.get(i).getLastTime() >= WORD_BROKEN_CYCLE) {
                m_WordNative.get(i).setDead(true);
                Delete_Object();
            }
        }

        //외래어 녹이기
        for (int i = m_WordLoan.size() - 1; i >= 0; i--) {
            if (thisTime - m_WordLoan.get(i).getLastTime() >= WORD_BROKEN_CYCLE) {
                m_WordLoan.get(i).setDead(true);
                Delete_Object();
                LIFE--;
            }
        }
    }

    //------------------------------------
    // onTouch Event
    //------------------------------------
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN) {                     //터치했을때
            Ani_Num_Hammer_Counter = 0;                                     //해머 애니메이션은 항상 0에서 시작
            m_Hammer = new Hammer(x, y, getContext());                    //해머 애니메이션 생셩
            Log.d("클릭좌표", "X : " + x + " Y : " + y);
        }
        return true;
    }

    public Handler m_Handler = new Handler() {
        public void handleMessage(Message msg) {
            invalidate(); // View를 다시 그림
            m_Handler.removeMessages(0);
            m_Handler.sendEmptyMessageDelayed(0, 10);
        }
    }; // Handler


    //단어생성 핸들러
    public Handler wordCreate_Handler = new Handler() {
        public void handleMessage(Message msg) {
            int randChoice = (int) (Math.random() * 100);
            wordLocation.rollXY();                                      //단어 X,Y좌표 롤링
            int wordLocation_X = wordLocation.getFaceValueX();              //랜덤함수 값 저장
            int wordLocation_Y = wordLocation.getFaceValueY();              //랜덤함수 값 저장

            if (randChoice >= 50) {                                             //0이면 고유어 , 1이면 외래어생성
                m_WordNative.add(new Word_Native(wordLocation_X, wordLocation_Y, getContext()));
                Log.d("고유어 기왓장", "X : " + wordLocation_X + " Y : " + wordLocation_Y + "생성");
            } else {
                m_WordLoan.add(new Word_Loan(wordLocation_X, wordLocation_Y, getContext()));
                Log.d("외래어 기왓장", "X : " + wordLocation_X + " Y : " + wordLocation_Y + "생성");
            }

            wordCreate_Handler.removeMessages(0);
            wordCreate_Handler.sendEmptyMessageDelayed(0, WORD_CREATE_CYCLE);
        }
    };
}
