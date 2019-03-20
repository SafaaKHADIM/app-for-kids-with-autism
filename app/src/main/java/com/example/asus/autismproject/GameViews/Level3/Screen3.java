package com.example.asus.autismproject.GameViews.Level3;
import android.util.Log;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;

public class Screen3 extends Screen{


    public Screen3 (Game game) {
        //This is gonna handle other stuff for you under the hood.We will see more of that next time.
        super(game);




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
