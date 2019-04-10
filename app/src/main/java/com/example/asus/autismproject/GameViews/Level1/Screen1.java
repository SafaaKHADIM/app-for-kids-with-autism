package com.example.asus.autismproject.GameViews.Level1;
import android.util.Log;

import com.example.asus.autismproject.Sprites.Static_Object.Myobject;

import com.example.asus.autismproject.Sprites.direction;
import com.example.asus.autismproject.assets.Object1;
import com.example.asus.autismproject.assets.Object2;
import com.example.asus.autismproject.assets.Object3;
import com.example.asus.autismproject.assets.Object4;
import com.example.asus.autismproject.assets.background;
import com.example.asus.autismproject.assets.hamtaro_character_1;
import com.example.asus.autismproject.assets.hand;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;

public class Screen1 extends Screen  {
    private final String TAG = "Screen1";
    private Myobject myobject;
    private Myobject myobject12;
    private Myobject myobject13;
    private Myobject myobject14;
    private Myobject _background;
    private Myobject maxwell;
    private direction direction_main ;

    private int mX ;
    private int mY ;
    private int lecture1=0;
    private int lecture2=0;
    private int lecture3=0;
    private int lecture4=0;
    private int lecture5=0;
    private int lecture6=0;
    private int lecture7=0;
    private int lecture8=0;
    private int myHack=0; //used to get some time before re-rendering
    private int myHack1=0;
    private int myHack2=0;
    private int myHack3=0;
    private int myHack4=0;
    private int myHack5=0;
    private int myHack6=0;
    private int myHack7=0;
    private int myHack8=0;
 //   private Sprite bac;
 // private Context context;



    public Screen1(Game game) {
        //This is gonna handle other stuff for you under the hood.We will see more of that next time.
        super(game);


        //Now that your Sprite is Ready, let's initialize it and control where we are going to put it
        myobject = new Myobject(Object1.avatar,game.getScreenWidth()/7,game.getScreenHeight()/4,game.getScreenHeight()/8,game.getScreenWidth()/4);
        myobject12 = new Myobject(Object2.avatar,5*(game.getScreenWidth()/8),game.getScreenHeight()/4,game.getScreenHeight()/8,game.getScreenWidth()/4);
        myobject13 = new Myobject(Object3.avatar,game.getScreenWidth()/7,2*(game.getScreenHeight()/3),game.getScreenHeight()/8,game.getScreenWidth()/4);
        myobject14 =new Myobject(Object4.avatar,5*(game.getScreenWidth()/8),2*(game.getScreenHeight()/3),game.getScreenHeight()/8,game.getScreenWidth()/4);
        //hand
        direction_main = new direction(hand.avatar,0,0,150,150);
        _background = new Myobject(background.avatar,0,0,game.getScreenHeight(),game.getScreenWidth());
        maxwell = new Myobject(hamtaro_character_1.avatar,0,0,game.getScreenHeight()/8,game.getScreenWidth()/4);

        //Now that everything is good let's add the Sprite to the list that we have.
        addSprite(_background);
        addSprite(maxwell);
        addSprite(myobject);
        addSprite(myobject12);
        addSprite(myobject13);
        addSprite(myobject14);
        addSprite(direction_main);


        Log.d(TAG, "Constructor Called");





    }


    @Override
    public void render(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawARGB(255,0,0,0);
        if(myHack==10) {
           if(lecture1==0 ) {
               mX = myobject.getX();
               mY = myobject.getY();
               direction_main.setX(mX);
               direction_main.setY(mY);
               Object1.voice_answer.play(1);
               lecture1=1;

           }

            if(lecture2==0 && myHack2==15) {
                mX = myobject12.getX();
                mY = myobject12.getY();
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object2.voice_answer.play(1);
                lecture2=1;
                myHack2=0;
            }
            myHack2++;

        if(lecture3==0 && myHack3==30) {
            mX = myobject13.getX();
            mY = myobject13.getY();
            direction_main.setX(mX);
            direction_main.setY(mY);
            Object3.voice_answer.play(1);
            lecture3=1;
            myHack3=0;
        }
        myHack3++;
        if(lecture4==0 && myHack4==45) {
            mX = myobject14.getX();
            mY = myobject14.getY();
            direction_main.setX(mX);
            direction_main.setY(mY);
            Object4.voice_answer.play(1);
            lecture4=1;
            myHack4=0;
        }
        myHack4++;

        //-------------------------------------------------------------------
            if(lecture5==0 && myHack5==120) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object1.voice_question.play(1);


                if(myHack1==10){
                if(object1GotHit() ){
                    hand.voice_right.play(1);
                    lecture5=1;
                }
                myHack1=0;
                }
                else{
                    myHack1++;
                }
                myHack5=0;
            }
            myHack5++;
            if(lecture6==0 && myHack6==160) {


                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object2.voice_question.play(1);
                lecture6=1;
                myHack6=0;
            }
            myHack6++;
            if(lecture7==0 && myHack5==200) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object3.voice_question.play(1);
                lecture7=1;
                myHack7=0;
            }
            myHack7++;
            if(lecture8==0 && myHack8==240) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object4.voice_question.play(1);
                lecture8=1;
                myHack8=0;
            }
            myHack8++;
        //--------------------------------------------------------------------------------------------------







            myHack=0;
        }
        myHack++;





    }

    @Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
        if(object1GotHit()){
            Object1.voice_answer.play(1);
           // hand.voice_right.play(1);
        }
        if(object2GotHit()){
            Object2.voice_answer.play(1);
        }
        if(object3GotHit()){
            Object3.voice_answer.play(1);
        }
        if(object4GotHit()){
            Object4.voice_answer.play(1);
        }



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
       // super.dispose();
        System.gc();
    }

    @Override
    public void backButton() {
        pause();
    }
    boolean object1GotHit(){
        if(myobject.contain(direction_main.getX(),direction_main.getY())) return true;
        return false;
    }
    boolean object2GotHit(){
        if(myobject12.contain(direction_main.getX(),direction_main.getY())) return true;
        return false;
    }
    boolean object3GotHit(){
        if(myobject13.contain(direction_main.getX(),direction_main.getY())) return true;
        return false;
    }
    boolean object4GotHit(){
        if(myobject14.contain(direction_main.getX(),direction_main.getY())) return true;
        return false;
    }

}
