package com.example.asus.autismproject;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.asus.autismproject.DAO.Database;
import com.example.asus.autismproject.DAO.Object;

import java.util.ArrayList;
import java.util.List;

public class ActivityCategory extends AppCompatActivity {
    public static Database database;
    public String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
/*        ConstraintLayout constraintLayout =findViewById(R.id.layout);
        AnimationDrawable animationDrawable =(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        */
        database = Room.databaseBuilder(getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "object").allowMainThreadQueries().build();
        final MediaPlayer mp1 = MediaPlayer.create(this,R.raw.whatdoyouwanttolearn);
        mp1.start();
        //spinner : doit afficher les categories déja existantes dans la base de données
        final ArrayList<String> arraySpinner = new ArrayList<String>();
        List<Object> objs = ActivityCategory.database._Dao()._getObject();
        for(Object myobject: objs) {
            String mycategorie = myobject.getCategorie();
            arraySpinner.add(mycategorie);
        }
        Spinner myspinner = (Spinner) findViewById(R.id.category);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(adapter);
        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
               category=selectedItem;
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {
                category=arraySpinner.get(1);
            }

        });

    }





    public void okey(View view) {
         Intent intent1=new Intent(this, Levels.class);
        intent1.putExtra("category",category);
        Log.e("safaa", "category: "+category);
        this.startActivity(intent1);



    }
}
