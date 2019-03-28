package com.example.asus.autismproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Levels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
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
