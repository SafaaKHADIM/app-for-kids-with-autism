package com.example.asus.autismproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void play(View view) {
        Intent intent1=new Intent(this, Levels.class);
        this.startActivity(intent1);

    }
    public void settings(View view) {
         Intent intent1=new Intent(this, ActivitySettings.class);
         this.startActivity(intent1);

    }
}
