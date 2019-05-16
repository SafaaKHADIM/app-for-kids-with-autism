package com.example.asus.autismproject;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ActivityLanguage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
       /* ConstraintLayout constraintLayout =findViewById(R.id.layout);
        AnimationDrawable animationDrawable =(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/
       showButtons();
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
    }
    public void eng(View view) {
       // Intent intent1=new Intent(this, AddObject.class);
        //this.startActivity(intent1);

    }
    public void fr(View view) {
        // Intent intent1=new Intent(this, choix2.class);
        //this.startActivity(intent1);

    }
    public void ar(View view) {
        // Intent intent1=new Intent(this, choix2.class);
        //this.startActivity(intent1);

    }
    private Handler handler;

    private void showButtons(){
        handler = new Handler();

        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btneng)).setVisibility(View.VISIBLE);
            }
        }, 1200);

        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnfr)).setVisibility(View.VISIBLE);
            }
        }, 2400);
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnar)).setVisibility(View.VISIBLE);
            }
        }, 3600);


    }
}
