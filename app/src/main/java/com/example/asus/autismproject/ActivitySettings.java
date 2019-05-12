package com.example.asus.autismproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivitySettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        /*ConstraintLayout constraintLayout =findViewById(R.id.layout);
        AnimationDrawable animationDrawable =(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/
        showButtons();
    }


    public void addObject(View view) {
        Intent intent1=new Intent(this, AddObject.class);
        this.startActivity(intent1);

    }
    public void background(View view) {
        Intent intent1=new Intent(this, addExistingObject.class);
        this.startActivity(intent1);

    }
    public void language(View view) {
      //  Intent intent1=new Intent(this, choix2.class);
       // this.startActivity(intent1);

    }
    public void score(View view) {
        Intent intent1=new Intent(this, ScoreV.class);
        this.startActivity(intent1);

    }
    private Handler handler;

    private void showButtons(){
        handler = new Handler();

        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnbackground)).setVisibility(View.VISIBLE);
            }
        }, 1200);

        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnlanguage)).setVisibility(View.VISIBLE);
            }
        }, 2400);
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnaddobject)).setVisibility(View.VISIBLE);
            }
        }, 3600);
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnscore)).setVisibility(View.VISIBLE);
            }
        }, 4800);


    }
}
