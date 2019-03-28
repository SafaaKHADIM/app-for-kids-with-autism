package com.example.asus.autismproject.GameViews.Level1;
import android.util.Log;

import com.example.asus.autismproject.Sprites.Level1.Myobject11;
import com.example.asus.autismproject.Sprites.Level1.Myobject12;
import com.example.asus.autismproject.Sprites.Level1.Myobject13;
import com.example.asus.autismproject.Sprites.Level1.Myobject14;
import com.example.asus.autismproject.Sprites.direction;
import com.example.asus.autismproject.assets.Object1;
import com.example.asus.autismproject.assets.Object2;
import com.example.asus.autismproject.assets.Object3;
import com.example.asus.autismproject.assets.Object4;
import com.example.asus.autismproject.assets.hand;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;

public class Screen1 extends Screen{
    private final String TAG = "Screen1";
    private Myobject11 myobject11;
    private Myobject12 myobject12;
    private Myobject13 myobject13;
    private Myobject14 myobject14;
    private direction direction_main ;
    private int mX ;
    private int mY ;
    private int myHack=0; //used to get some time before re-rendering



    public Screen1(Game game) {
        //This is gonna handle other stuff for you under the hood.We will see more of that next time.
        super(game);
        //hand
        direction_main = new direction(game,hand.avatar,game.getScreenHeight()/2,game.getScreenWidth()/2,150,150);


        //Now that your Sprite is Ready, let's initialize it and control where we are going to put it
        myobject11 = new Myobject11(game,Object1.avatar,game.getScreenHeight()/2,game.getScreenWidth()/2,250,250);
        myobject12 = new Myobject12(game,Object2.avatar,game.getScreenHeight()/2,500,250,250);
        myobject13 = new Myobject13(game,Object3.avatar,game.getScreenHeight()/2,1000,250,250);
        myobject14 =new Myobject14(game,Object4.avatar,game.getScreenHeight()/2,1500,250,250);
        //Now that everything is good let's add the Sprite to the list that we have.
        addSprite(myobject11);
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
        super.dispose();
        System.gc();
    }

    @Override
    public void backButton() {
        pause();
    }



}
