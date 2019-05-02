package com.example.asus.autismproject.GameViews.Level1;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.asus.autismproject.AboutTheGame;
import com.example.asus.autismproject.ActivityLevel1;
import com.example.asus.autismproject.DAO.Database;
import com.example.asus.autismproject.DAO.Score;
import com.example.asus.autismproject.From1to2;
import com.example.asus.autismproject.Sprites.Static_Object.Myobject;

import com.example.asus.autismproject.Sprites.direction;
import com.example.asus.autismproject.assets.Object1;
import com.example.asus.autismproject.assets.Object2;
import com.example.asus.autismproject.assets.Object3;
import com.example.asus.autismproject.assets.Object4;
import com.example.asus.autismproject.assets.background;
import com.example.asus.autismproject.assets.hamtaro_character_1;
import com.example.asus.autismproject.assets.hamtaro_character_2;
import com.example.asus.autismproject.assets.hand;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;

import java.util.ArrayList;
import java.util.Random;

public class Screen1 extends Screen  {
    private final String TAG = "Screen1";
    public static Database database;
    //public static Database database1;
    private int score=0 ;
    private int rightanswers=0;
    private int falseanswers=0;
    private Myobject myobject;
    private Myobject myobject12;
    private Myobject myobject13;
    private Myobject myobject14;
    private Myobject _background;
    private direction maxwell1;
    private direction maxwell2;
    private Myobject bijou;
    private direction direction_main ;
    int a=0;
    private int hamtaro=0;
    private int showinghamtaro=0;
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
    private int lecture15=0;
    private int lecture16=0;
    private int lecture17=0;
    private int lecture18=0;
    private int lecture19=0;
    private int lecture20=0;
    private int lecture21=0;
    private int lecture22=0;

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
    private int myHack15=0;
    private int myHack16=0;
    private int myHack17=0;
    private int myHack18=0;
    private int myHack19=0;
    private int myHack20=0;
    private int myHack21=0;
    private int myHack22=0;
    private int end=0;


    private int myHack11=0;
    private int myHack12=0;
    private int question1=0;
    private int question2=0;
    private int question3=0;
    private int question4=0;
    private int question5=0;
    private int question6=0;
    private int question7=0;
    private int question8=0;
    private Context context;
    private int changeposition=0;
    int level2=0;
    int i=4;
    Random rand = new Random();
    int number1 = rand.nextInt(i);


    private ArrayList<Sprite> sprites;
 //   private Sprite bac;
 // private Context context;



    public Screen1(Game game) {
        //This is gonna handle other stuff for you under the hood.We will see more of that next time.
        super(game);
        context = (Context) game;
        database = Room.databaseBuilder(context.getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "object").allowMainThreadQueries().build();
        //database1 = Room.databaseBuilder(context.getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "score").allowMainThreadQueries().build();

        //Now that your Sprite is Ready, let's initialize it and control where we are going to put it
        myobject = new Myobject(Object1.avatar,game.getScreenWidth()/7,3*(game.getScreenHeight())/7,game.getScreenHeight()/8,game.getScreenWidth()/4);
        myobject12 = new Myobject(Object2.avatar,5*(game.getScreenWidth()/8),3*(game.getScreenHeight())/7,game.getScreenHeight()/8,game.getScreenWidth()/4);
        myobject13 = new Myobject(Object3.avatar,game.getScreenWidth()/7,7*(game.getScreenHeight()/9),game.getScreenHeight()/8,game.getScreenWidth()/4);
        myobject14 =new Myobject(Object4.avatar,5*(game.getScreenWidth()/8),7*(game.getScreenHeight()/9),game.getScreenHeight()/8,game.getScreenWidth()/4);
        //hand
        direction_main = new direction(hand.avatar,0,0,150,150);
        _background = new Myobject(background.avatar,0,0,game.getScreenHeight(),game.getScreenWidth());
       // maxwell = new Myobject(hamtaro_character_1.avatar,0,0,game.getScreenHeight()/8,game.getScreenWidth()/4);
        //bijou = new Myobject(hamtaro_character_1.avatar,0,0,game.getScreenHeight()/8,game.getScreenWidth()/4);
        //Now that everything is good let's add the Sprite to the list that we have.


        maxwell1 = new direction(hamtaro_character_1.avatar,770,230,game.getScreenHeight()/4,game.getScreenWidth()/3);
        maxwell2 = new direction(hamtaro_character_2.avatar,770,230,game.getScreenHeight()/4,game.getScreenWidth()/3);

        addSprite(_background);
       // addSprite(maxwell);
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
        int x1 =game.getScreenWidth()/7;
        int y1=3*(game.getScreenHeight())/7;
        int x2 =5*(game.getScreenWidth()/8);
        int y2=3*(game.getScreenHeight())/7;
        int x3 =game.getScreenWidth()/7;
        int y3=7*(game.getScreenHeight()/9);
        int x4 =5*(game.getScreenWidth()/8);
        int y4=7*(game.getScreenHeight()/9);
        //hamtaro character gif : maxwell _______________________________________________________
       /* if(showinghamtaro>=0 && showinghamtaro<=10) {
            addSprite(maxwell1);
            maxwell1.setX(770);
            maxwell1.setY(230);
        }
        if(showinghamtaro==11){
            int mx=game.getScreenHeight();
            int my=game.getScreenWidth();
            maxwell1.setX(mx);
            maxwell1.setY(my);
            addSprite(maxwell2);
            maxwell2.setX(770);
            maxwell2.setY(230);
        }
        if(showinghamtaro>=12 && showinghamtaro <=22){
            addSprite(maxwell2);
            maxwell2.setX(770);
            maxwell2.setY(230);
        }
        if(showinghamtaro==23){
             int mx=game.getScreenHeight();
             int my=game.getScreenWidth();
             maxwell2.setX(mx);
             maxwell2.setY(my);
             showinghamtaro=0;
             addSprite(maxwell1);
             maxwell1.setX(770);
             maxwell1.setY(230);
        }
        showinghamtaro++;*/
        //end of hamtaro gif _________________________________________________________________



       // showing the objects_________________________________________________________________
        if(myHack==10 ) {
           if(lecture1==0 ) {
               mX = myobject.getX();
               mY = myobject.getY();
               direction_main.setX(mX);
               direction_main.setY(mY);
               Object1.voice_answer.play(1);
               lecture1=1;
           }
            if(lecture2==0 && myHack2==5) {
                mX = myobject12.getX();
                mY = myobject12.getY();
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object2.voice_answer.play(1);
                lecture2=1;
                myHack2=0;
            }
            myHack2++;
        if(lecture3==0 && myHack3==10) {
                mX = myobject13.getX();
                mY = myobject13.getY();
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object3.voice_answer.play(1);
                lecture3=1;
                myHack3=0;
            }
             myHack3++;
        if(lecture4==0 && myHack4==15) {
                 mX = myobject14.getX();
                 mY = myobject14.getY();
                 direction_main.setX(mX);
                 direction_main.setY(mY);
                 Object4.voice_answer.play(1);
                 lecture4=1;
                 myHack4=0;
             }
             myHack4++;

        //end of showing objects_______________________________________________





        //questions____________________________________________________________

 //____________________________________________________________________________1rst question level 1_________________________________________
            if(lecture5==0 && myHack5==20) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object1.voice_question.play(1);
                 question1=1;
            }
            myHack5++;
            if(lecture6==0 && myHack6>=21 && question1==1) {
                myHack7=24; myHack9=24; myHack11=24; myHack15=24; myHack17=24; myHack19=24;myHack21=24;
                if(object1GotHit() && question1==1){
                    hand.voice_right.play(1);
                    score=score+30;
                    rightanswers++;
                    question1=0;
                }
                if((object2GotHit() || object3GotHit() || object4GotHit()) && question1==1){
                    hand.voice_false.play(1);
                    score=score-10;
                    falseanswers++;
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    //Object1.voice_question.play(1);
                    myHack5=20;
                }

            }
            myHack6++;
 //_______________________________________________________________________________________________________________ 2nd question level 1______________________________________________

            if(lecture7==0 && myHack7==25) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object2.voice_question.play(1);
                question2=1;
            }
            myHack7++;
            if(lecture8==0 && myHack8>=25 && question2==1) {
                myHack9=20; myHack11=20; myHack15=20; myHack17=20; myHack19=20;myHack21=20;
                if(object2GotHit() && question2==1){
                    hand.voice_right.play(1);
                    score=score+30;
                    rightanswers++;
                    question2=0;
                }
                if((object1GotHit() || object3GotHit() || object4GotHit()) && question2==1){
                    hand.voice_false.play(1);
                    score=score-10;
                    falseanswers++;
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack7=24;
                }

            }
            myHack8++;




  //_________________________________________________________________3rd question level 1_____________________________________________________________

            if(lecture9==0 && myHack9==30) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object3.voice_question.play(1);
                question3=1;
            }
            myHack9++;
            if(lecture10==0 && myHack10>=25 && question3==1) {
                myHack11=20; myHack15=20; myHack17=20; myHack19=20;myHack21=20;
                if(object3GotHit() && question3==1){
                    hand.voice_right.play(1);
                    score=score+30;
                    rightanswers++;
                    question3=0;
                }
                if((object2GotHit() || object1GotHit() || object4GotHit()) && question3==1){
                    hand.voice_false.play(1);
                    score=score-10;
                    falseanswers++;
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack9=29;
                }

            }
            myHack10++;
   //_________________________________________________________________________________4th question level 1__________________________________________________


            if(lecture11==0 && myHack11==35) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object4.voice_question.play(1);
                question4=1;
            }
            myHack11++;
            Log.d("safaa", "hack15 "+myHack15);
            if(lecture12==0 && myHack12>=25 && question4==1) {
                myHack15=34; myHack17=34; myHack19=34;myHack21=34;
                if(object4GotHit() && question4==1){
                    hand.voice_right.play(1);
                    question4=0;
                    score=score+30;
                    rightanswers++;
                    //go to another activity hit safi sala level1 dialou
                    level2=1;
                    Intent intent1=new Intent(context, From1to2.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent1);
                    pause();

                }
                if((object2GotHit() || object3GotHit() || object1GotHit()) && question4==1){
                    hand.voice_false.play(1);
                    score=score-10;
                    falseanswers++;
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack11=34;
                }

            }
            myHack12++;

          //___________________________________________________end of questions level 1_____________________________________________________


          //__________________________________________________level 2 ______________________________________________________________________________




            if(level2==1){
                //int i=4;
               // Random rand = new Random();
                //int number1 = rand.nextInt(i);
                if(myHack11==46) {
                    myobject.setX(350);
                    myobject.setY(1200);
                    myobject12.setX(350);
                    myobject12.setY(1200);
                    myobject13.setX(350);
                    myobject13.setY(1200);
                    myobject14.setX(350);
                    myobject14.setY(1200);
                }
                Log.d("safaa", "number1= "+number1);
                Log.d("safaa", "myHack "+myHack11);
               if(number1==0 && changeposition==0 && myHack11==52){
                    Log.d("safaa", "number1=0");
                    changeposition=1;
                    myobject.setX(x2);
                    myobject.setY(y2);
                    myobject12.setX(x3);
                    myobject12.setY(y3);
                    myobject13.setX(x4);
                    myobject13.setY(y4);
                    myobject14.setX(x1);
                    myobject14.setY(y1);


                }
               // myHack11++;
                if(number1==1 && changeposition==0 && myHack11==52){
                    Log.d("safaa", "number1=1");
                    changeposition=1;
                    myobject.setX(x3);
                    myobject.setY(y3);
                    myobject12.setX(x4);
                    myobject12.setY(y4);
                    myobject13.setX(x2);
                    myobject13.setY(y2);
                    myobject14.setX(x1);
                    myobject14.setY(y1);


                }
                if(number1==2 && changeposition==0 && myHack11==52){
                    Log.d("safaa", "number1=2");
                    changeposition=1;
                    myobject.setX(x4);
                    myobject.setY(y4);
                    myobject12.setX(x3);
                    myobject12.setY(y3);
                    myobject13.setX(x2);
                    myobject13.setY(y2);
                    myobject14.setX(x1);
                    myobject14.setY(y1);


                }
                if(number1==3 && changeposition==0 && myHack11==52){
                    Log.d("safaa", "number1=3");
                    changeposition=1;
                   myobject.setX(x3);
                    myobject.setY(y3);
                    myobject12.setX(x1);
                    myobject12.setY(y1);
                    myobject13.setX(x4);
                    myobject13.setY(y4);
                    myobject14.setX(x2);
                    myobject14.setY(y2);


                }


            }

        //________________________________________________________________question 1 level 2___________________________________________________

            if(lecture15==0 && myHack15==60) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object1.voice_question.play(1);
                question5=1;
            }
            myHack15++;
            if(lecture16==0 && myHack16>=65 && question5==1) {
                myHack17=60; myHack19=60;myHack21=60;
                if(object1GotHit() && question5==1){
                    hand.voice_right.play(1);
                    score=score+30;
                    rightanswers++;
                    question5=0;
                }
                if((object2GotHit() || object3GotHit() || object4GotHit()) && question5==1){
                    hand.voice_false.play(1);
                    score=score-10;
                    falseanswers++;
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack15=59;
                }

            }
            myHack16++;
            //______________________________________________________________ 2nd question level 2______________________________________________

            if(lecture17==0 && myHack17==65) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object2.voice_question.play(1);
                question6=1;
            }
            myHack17++;
            if(lecture18==0 && myHack18>=65 && question6==1) {
                myHack19=60; myHack21=60;
                if(object2GotHit() && question6==1){
                    hand.voice_right.play(1);
                    score=score+30;
                    rightanswers++;
                    question6=0;
                }
                if((object1GotHit() || object3GotHit() || object4GotHit()) && question6==1){
                    hand.voice_false.play(1);
                    score=score-10;
                    falseanswers++;
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack17=64;
                }

            }
            myHack18++;




            //_________________________________________________________________3rd question level 2_____________________________________________________________

            if(lecture19==0 && myHack19==70) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object3.voice_question.play(1);
                question7=1;
            }
            myHack19++;
            if(lecture20==0 && myHack20>=65 && question7==1) {
                myHack21=60;
                if(object3GotHit() && question7==1){
                    hand.voice_right.play(1);
                    score=score+30;
                    rightanswers++;
                    question7=0;
                }
                if((object2GotHit() || object1GotHit() || object4GotHit()) && question7==1){
                    hand.voice_false.play(1);
                    score=score-10;
                    falseanswers++;
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack19=69;
                }

            }
            myHack20++;
            //____________________________________________________________________4th question level 2__________________________________________________


            if(lecture21==0 && myHack21==75) {
                mX = 0;
                mY = 0;
                direction_main.setX(mX);
                direction_main.setY(mY);
                Object4.voice_question.play(1);
                question8=1;
            }
            myHack21++;
            if(lecture22==0 && myHack22>=65 && question8==1) {
                if(object4GotHit() && question8==1){
                    hand.voice_right.play(1);
                    score=score+30;
                    rightanswers++;
                    question8=0;
                    end=1;
                }
                if((object2GotHit() || object3GotHit() || object1GotHit()) && question8==1){
                    hand.voice_false.play(1);
                    score=score-10;
                    falseanswers++;
                    mX = 0;
                    mY = 0;
                    direction_main.setX(mX);
                    direction_main.setY(mY);
                    myHack21=74;
                }

            }
           myHack22++;

            //___________________________________________________end of questions_____________________________________________________

            //_____________________________________enregistrer le score__________________________________________
           /* if(end==1){
                Score myscore= new Score(score,rightanswers,falseanswers);
                Screen1.database._Dao()._add_score(myscore);
            }*/
            //____________________________________end of score
























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
