package com.example.asus.autismproject;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asus.autismproject.DAO.Database;

public class MainActivity extends AppCompatActivity {
    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = Room.databaseBuilder(getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "object").allowMainThreadQueries().build();
       /* ConstraintLayout constraintLayout =findViewById(R.id.layout);
        AnimationDrawable animationDrawable =(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/
        showButtons();
    }


    public void play(View view) {

        Intent intent1=new Intent(this, ActivityCategory.class);
        this.startActivity(intent1);

    }
    public void settings(View view) {
         Intent intent1=new Intent(this, ActivitySettings.class);
         this.startActivity(intent1);

    }
    private Handler handler;

    private void showButtons(){
        handler = new Handler();

        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnplay)).setVisibility(View.VISIBLE);
            }
        }, 1200);

        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnsetting)).setVisibility(View.VISIBLE);
            }
        }, 2400);


    }
}
