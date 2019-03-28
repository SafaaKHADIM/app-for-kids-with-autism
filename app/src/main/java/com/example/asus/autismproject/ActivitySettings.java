package com.example.asus.autismproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivitySettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    public void addObject(View view) {
        Intent intent1=new Intent(this, AddObject.class);
        this.startActivity(intent1);

    }
    public void background(View view) {
       // Intent intent1=new Intent(this, choix2.class);
        //this.startActivity(intent1);

    }
    public void language(View view) {
      //  Intent intent1=new Intent(this, choix2.class);
       // this.startActivity(intent1);

    }
    public void score(View view) {
        //Intent intent1=new Intent(this, choix2.class);
        //this.startActivity(intent1);

    }
}
