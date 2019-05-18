package com.example.asus.autismproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Congrats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        final MediaPlayer mp1 = MediaPlayer.create(this,R.raw.kidscheering);
        mp1.start();
    }
    public void finish(View view) {
         Intent intent1=new Intent(this, MainAppActivity.class);
        this.startActivity(intent1);




    }
}
