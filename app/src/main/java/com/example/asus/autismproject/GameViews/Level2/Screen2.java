package com.example.asus.autismproject.GameViews.Level2;
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

public class Screen2 extends Screen  {
    private final String TAG = "Screen2";
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
    private int lecture9=0;
    private int lecture10=0;
    private int lecture11=0;
    private int lecture12=0;

    private int myHack=0; //used to get some time before re-rendering
    private int myHack1=0;
    private int myHack2=0;
    private int myHack3=0;
    private int myHack4=0;
    private int myHack5=0;
    private int myHack6=0;
    private int myHack7=0;
    private int myHack8=0;
    private int myHack9=0;
    private int myHack10=0;
    private int myHack11=0;
    private int myHack12=0;
    private int question1=0;
    private int question2=0;
    private int question3=0;
    private int question4=0;
    //   private Sprite bac;
    // private Context context;



    public Screen2(Game game) {
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


            //____________________________________________________________________________1rst question_________________________________________
            if(lecture5==0 && myHack5==60) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object1.voice_question.play(1);
                question1=1;
            }
            myHack5++;
            if(lecture6==0 && myHack6>=65 && question1==1) {
                myHack7=60; myHack9=60; myHack11=60;
                if(object1GotHit() && question1==1){
                    hand.voice_right.play(1);
                    question1=0;
                }
                if((object2GotHit() || object3GotHit() || object4GotHit()) && question1==1){
                    hand.voice_false.play(1);
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack5=59;
                }

            }
            myHack6++;
            //_______________________________________________________________________________________________________________ 2nd question______________________________________________

            if(lecture7==0 && myHack7==65) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object2.voice_question.play(1);
                question2=1;
            }
            myHack7++;
            if(lecture8==0 && myHack8>=65 && question2==1) {
                myHack9=60; myHack11=60;
                if(object2GotHit() && question2==1){
                    hand.voice_right.play(1);
                    question2=0;
                }
                if((object1GotHit() || object3GotHit() || object4GotHit()) && question2==1){
                    hand.voice_false.play(1);
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack7=64;
                }

            }
            myHack8++;




            //_________________________________________________________________3rd question_____________________________________________________________

            if(lecture9==0 && myHack9==70) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object3.voice_question.play(1);
                question3=1;
            }
            myHack9++;
            if(lecture10==0 && myHack10>=65 && question3==1) {
                myHack11=60;
                if(object3GotHit() && question3==1){
                    hand.voice_right.play(1);
                    question3=0;
                }
                if((object2GotHit() || object1GotHit() || object4GotHit()) && question3==1){
                    hand.voice_false.play(1);
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack9=69;
                }

            }
            myHack10++;
            //_________________________________________________________________________________4th question__________________________________________________


            if(lecture11==0 && myHack11==75) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object4.voice_question.play(1);
                question4=1;
            }
            myHack11++;
            if(lecture12==0 && myHack12>=65 && question4==1) {
                if(object4GotHit() && question4==1){
                    hand.voice_right.play(1);
                    question4=0;
                }
                if((object2GotHit() || object3GotHit() || object1GotHit()) && question4==1){
                    hand.voice_false.play(1);
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack11=74;
                }

            }
            myHack12++;

            //___________________________________________________end of questions_____________________________________________________














           /* if(lecture6==0 && myHack6==80) {


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
            if(lecture8==0 && myHack8==215) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object4.voice_question.play(1);
                lecture8=1;
                myHack8=0;
            }
            myHack8++;*/
            //--------------------------------------------------------------------------------------------------







            myHack=0;
        }
        myHack++;





    }

    @Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
       /* if(object1GotHit() && question1==1){
            hand.voice_right.play(1);
        }
        if(object2GotHit() || object3GotHit() || object4GotHit() || question1==1){
            hand.voice_false.play(1);
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

*/

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
