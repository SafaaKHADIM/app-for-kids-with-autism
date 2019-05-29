package com.example.asus.autismproject;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.example.asus.autismproject.DAO.Database;
import com.example.ensias_auth_library.FoxyAuth;

public class MainAppActivity extends AppCompatActivity {


    public static Database database;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_main);
        FoxyAuth.emerge(this,MainAppActivity.class);
        database = Room.databaseBuilder(getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "object").allowMainThreadQueries().build();
       /* ConstraintLayout constraintLayout =findViewById(R.id.layout);
        AnimationDrawable animationDrawable =(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();*/
        final MediaPlayer mp1 = (MediaPlayer)MediaPlayer.create(this,R.raw.hamtarosong);
        mp1.start();
       /* Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mp1.start();
            }
        }, 5000); */  //5 seconds
        showButtons();

        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
    }


    public void play(View view) {

        Intent intent1=new Intent(this, ActivityCategory.class);
        this.startActivity(intent1);

    }
    public void settings(View view) {
         Intent intent1=new Intent(this, ActivitySettings.class);
         this.startActivity(intent1);

    }
    public void abtus(View view) {
        Intent intent1=new Intent(this, AboutTheGame.class);
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
