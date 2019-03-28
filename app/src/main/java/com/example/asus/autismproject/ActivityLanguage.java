package com.example.asus.autismproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivityLanguage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
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
