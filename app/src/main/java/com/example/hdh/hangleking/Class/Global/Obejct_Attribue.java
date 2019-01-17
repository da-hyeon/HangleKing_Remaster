package com.example.hdh.hangleking.Class.Global;

import android.content.Context;
import android.graphics.BitmapFactory;

public class Obejct_Attribue{

    private int width , height;  // display 가로,세로 길이
    private int m_X, m_Y ; // 단어 좌표
    private int alpha; // 이미지의 Alpha (투명도)

    private boolean dead = false; // 터질것인지 여부
    private long lastTime; // 경과 시간

    private GlobalVarialbes globalVarialbes;

    public BitmapFactory.Options options;

    public Obejct_Attribue(Context context){
        options = new BitmapFactory.Options();
        options.inSampleSize = 2;

        alpha = 255;
        globalVarialbes = (GlobalVarialbes)context.getApplicationContext();
        width = globalVarialbes.getWidth();
        height = globalVarialbes.getHeight();
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public int getM_X() {
        return m_X;
    }
    public int getM_Y() {
        return m_Y;
    }
    public int getAlpha() {
        return alpha;
    }
    public boolean isDead() {
        return dead;
    }
    public long getLastTime() {
        return lastTime;
    }

    public void setM_X(int m_X) {
        this.m_X = m_X;
    }
    public void setM_Y(int m_Y) {
        this.m_Y = m_Y;
    }
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }
}
