package com.example.asus.autismproject;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityLanguage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        ConstraintLayout constraintLayout =findViewById(R.id.layout);
        AnimationDrawable animationDrawable =(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
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
}
