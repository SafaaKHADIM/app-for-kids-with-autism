package com.example.asus.autismproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class From1to2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from1to2);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        final MediaPlayer mp1 = MediaPlayer.create(this,R.raw.kidscheering);
        mp1.start();
    }
    public void next(View view) {
       // Intent intent1=new Intent(this, ActivityLevel1.class);
        //this.startActivity(intent1);
        From1to2.this.finish();
      //  screen1.resume();


    }
}

