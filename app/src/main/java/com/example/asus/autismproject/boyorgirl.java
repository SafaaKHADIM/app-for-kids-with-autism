package com.example.asus.autismproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class boyorgirl extends AppCompatActivity {
    public String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boyorgirl);
        getSupportActionBar().hide();
        Bundle b = getIntent().getExtras();
        category=b.getString("category");
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
    }
    public void boy(View view) {

        Intent intent1=new Intent(this, ActivityLevel2.class);
        intent1.putExtra("category",category);
        Log.e("safaa hhhhhh", "category: "+category);
        this.startActivity(intent1);

    }
    public void girl(View view) {
        Intent intent1=new Intent(this, ActivityLevel1.class);
        intent1.putExtra("category",category);
        Log.e("safaa hhhhhh", "category: "+category);
        this.startActivity(intent1);

    }
}
