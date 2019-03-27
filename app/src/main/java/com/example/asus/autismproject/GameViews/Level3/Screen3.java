package com.example.asus.autismproject.GameViews.Level3;
import android.util.Log;

import com.example.asus.autismproject.Sprites.Level3.Myobject31;
import com.example.asus.autismproject.Sprites.Level3.Myobject32;
import com.example.asus.autismproject.Sprites.Level3.Myobject33;
import com.example.asus.autismproject.Sprites.Level3.Myobject34;
import com.example.asus.autismproject.assets.Object1;
import com.example.asus.autismproject.assets.Object2;
import com.example.asus.autismproject.assets.Object3;
import com.example.asus.autismproject.assets.Object4;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;

public class Screen3 extends Screen{
    private final String TAG = "Screen3";
    private Myobject31 myobject31;
    private Myobject32 myobject32;
    private Myobject33 myobject33;
    private Myobject34 myobject34;
    private int mX ;
    private int mY ;
    private int myHack=0; //used to get some time before re-rendering



    public Screen3(Game game) {
        //This is gonna handle other stuff for you under the hood.We will see more of that next time.
        super(game);


        //Now that your Sprite is Ready, let's initialize it and control where we are going to put it
        myobject31 = new Myobject31(game,Object1.avatar,game.getScreenHeight()/2,game.getScreenWidth()/2,300,300);
        myobject32 = new Myobject32(game,Object2.avatar,500,500,300,300);
        myobject33 = new Myobject33(game,Object3.avatar,1000,1000,300,300);
        myobject34 =new Myobject34(game,Object4.avatar,1500,1500,300,300);
        //Now that everything is good let's add the Sprite to the list that we have.
        addSprite(myobject31);
        addSprite(myobject32);
        addSprite(myobject33);
        addSprite(myobject34);

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
