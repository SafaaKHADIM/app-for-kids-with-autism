package com.example.asus.autismproject.GameViews.Level3;
import android.util.Log;

import com.example.asus.autismproject.Sprites.Static_Object.Myobject;

import com.example.asus.autismproject.Sprites.direction;
import com.example.asus.autismproject.assets.Object1;
import com.example.asus.autismproject.assets.Object2;
import com.example.asus.autismproject.assets.Object3;
import com.example.asus.autismproject.assets.Object4;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;

public class Screen3 extends Screen{
    private final String TAG = "Screen3";
    private Myobject myobject31;
    private Myobject myobject32;
    private Myobject myobject33;
    private Myobject myobject34;
    private direction direction_main ;
    private int mX ;
    private int mY ;
    private int myHack=0; //used to get some time before re-rendering
    private int myHack1=0;
    private int myHack2=0;
    private int myHack3=0;
    private int myHack4=0;
    private int lecture1=0;
    private int lecture2=0;
    private int lecture3=0;
    private int lecture4=0;



    public Screen3(Game game) {
        //This is gonna handle other stuff for you under the hood.We will see more of that next time.
        super(game);
        //hand
        direction_main = new direction(Object1.avatar,game.getScreenHeight()/2,game.getScreenWidth()/2,300,300);


        //Now that your Sprite is Ready, let's initialize it and control where we are going to put it
        myobject31 = new Myobject(Object1.avatar,game.getScreenWidth()/7,game.getScreenHeight()/4,game.getScreenHeight()/8,game.getScreenWidth()/4);
        myobject32 = new Myobject(Object2.avatar,5*(game.getScreenWidth()/8),game.getScreenHeight()/4,game.getScreenHeight()/8,game.getScreenWidth()/4);
        myobject33 = new Myobject(Object3.avatar,game.getScreenWidth()/7,2*(game.getScreenHeight()/3),game.getScreenHeight()/8,game.getScreenWidth()/4);
        myobject34 =new Myobject(Object4.avatar,5*(game.getScreenWidth()/8),2*(game.getScreenHeight()/3),game.getScreenHeight()/8,game.getScreenWidth()/4);
        //Now that everything is good let's add the Sprite to the list that we have.
        addSprite(myobject31);
        addSprite(myobject32);
        addSprite(myobject33);
        addSprite(myobject34);
        addSprite(direction_main);

        Log.d(TAG, "Constructor Called");




    }

    @Override
    public void render(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawARGB(255,0,0,0);

        if(myHack==10) {
            if(lecture1==0 ) {
                mX = myobject31.getX();
                mY = myobject31.getY();
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object1.voice_answer.play(1);
                lecture1=1;

            }

            if(lecture2==0 && myHack2==30) {
                mX = myobject32.getX();
                mY = myobject32.getY();
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object2.voice_answer.play(1);
                lecture2=1;
                myHack2=0;
            }
            myHack2++;

            if(lecture3==0 && myHack3==60) {
                mX = myobject33.getX();
                mY = myobject33.getY();
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object3.voice_answer.play(1);
                lecture3=1;
                myHack3=0;
            }
            myHack3++;
            if(lecture4==0 && myHack4==90) {
                mX = myobject34.getX();
                mY = myobject34.getY();
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object4.voice_answer.play(1);
                lecture4=1;
                myHack4=0;
            }
            myHack4++;
            myHack=0;
        }
        myHack++;



    }

    @Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    //The handle dragging is activated anytime you drag on your screen.
    /*@Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
        Hero.voice.play(1);
    }*/

    @Override
    public void dispose() {
     //   super.dispose();
        System.gc();
    }

    @Override
    public void backButton() {
        pause();
    }
    boolean object1GotHit(){
        if(direction_main.contain(myobject31.getX(),myobject31.getY())) return true;
        return false;
    }
    boolean object2GotHit(){
        if(direction_main.contain(myobject32.getX(),myobject32.getY())) return true;
        return false;
    }
    boolean object3GotHit(){
        if(direction_main.contain(myobject33.getX(),myobject33.getY())) return true;
        return false;
    }
    boolean object4GotHit(){
        if(direction_main.contain(myobject34.getX(),myobject34.getY())) return true;
        return false;
    }



}
