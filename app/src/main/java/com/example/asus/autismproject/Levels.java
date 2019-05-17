package com.example.asus.autismproject;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Levels extends AppCompatActivity {
    public String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
       /* ConstraintLayout constraintLayout =findViewById(R.id.layout);
        AnimationDrawable animationDrawable =(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/
        Bundle b = getIntent().getExtras();
        category=b.getString("category");
       showButtons();
    }
    public void level1(View view) {
        Intent intent1=new Intent(this, boyorgirl.class);
        intent1.putExtra("category",category);
        Log.e("safaa hhhhhh", "category: "+category);
        this.startActivity(intent1);

    }
    public void level2(View view) {
        Intent intent1=new Intent(this, ActivityLevel2.class);
        this.startActivity(intent1);

    }
    public void level3(View view) {
        Intent intent1=new Intent(this, ActivityLevel3.class);
        this.startActivity(intent1);

    }
    private Handler handler;

    private void showButtons(){
        handler = new Handler();

        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnlevel1)).setVisibility(View.VISIBLE);
            }
        }, 1200);

       /* handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnlevel2)).setVisibility(View.VISIBLE);
            }
        }, 2400);
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                ((Button) findViewById(R.id.btnlevel3)).setVisibility(View.VISIBLE);
            }
        }, 3600);*/


    }
}
