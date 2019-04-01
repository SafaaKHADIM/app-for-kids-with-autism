package com.example.asus.autismproject;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        ConstraintLayout constraintLayout =findViewById(R.id.layout);
        AnimationDrawable animationDrawable =(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }
    public void level1(View view) {
        Intent intent1=new Intent(this, ActivityLevel1.class);
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
}
