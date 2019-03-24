package com.example.asus.autismproject.GameViews.Level2;
import android.util.Log;

import com.example.asus.autismproject.Sprites.Level2.Myobject21;
import com.example.asus.autismproject.Sprites.Level2.Myobject22;
import com.example.asus.autismproject.Sprites.Level2.Myobject23;
import com.example.asus.autismproject.Sprites.Level2.Myobject24;
import com.example.asus.autismproject.assets.Object1;
import com.example.asus.autismproject.assets.Object2;
import com.example.asus.autismproject.assets.Object3;
import com.example.asus.autismproject.assets.Object4;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;

public class Screen2 extends Screen{
    private final String TAG = "Screen2";
    private Myobject21 myobject21;
    private Myobject22 myobject22;
    private Myobject23 myobject23;
    private Myobject24 myobject24;
    private int mX ;
    private int mY ;
    private int myHack=0; //used to get some time before re-rendering



    public Screen2(Game game) {
        //This is gonna handle other stuff for you under the hood.We will see more of that next time.
        super(game);


        //Now that your Sprite is Ready, let's initialize it and control where we are going to put it
        myobject21 = new Myobject21(game,Object1.avatar,game.getScreenHeight()/2,game.getScreenWidth()/2,100,100);
        myobject22 = new Myobject22(game,Object2.avatar,500,500,100,100);
        myobject23 = new Myobject23(game,Object3.avatar,1000,1000,100,100);
        myobject24 =new Myobject24(game,Object4.avatar,1500,1500,100,100);
        //Now that everything is good let's add the Sprite to the list that we have.
        addSprite(myobject21);
        addSprite(myobject22);
        addSprite(myobject23);
        addSprite(myobject24);

        Log.d(TAG, "Constructor Called");




    }

    @Override
    public void render(float deltaTime) {

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
