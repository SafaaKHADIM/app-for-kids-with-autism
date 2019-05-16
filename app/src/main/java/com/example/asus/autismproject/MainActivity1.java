package com.example.asus.autismproject;


import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.asus.autismproject.DAO.Database;
import com.example.asus.autismproject.DAO.Object;

import java.util.ArrayList;
import java.util.List;

public class MainActivity1 extends AppCompatActivity {
    public static Database database;
    private static final String TAG = "MainActivity1";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mDescription = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Log.d(TAG, "onCreate: started.");
        RelativeLayout constraintLayout =findViewById(R.id.layout);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
       // database = Room.databaseBuilder(getApplicationContext(), Database.class, "userdb").allowMainThreadQueries().build();
        database = Room.databaseBuilder(getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "object").allowMainThreadQueries().build();

        AnimationDrawable animationDrawable =(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();



        initImageBitmaps();
    }

    @Override
    protected void onResume() {
        super.onResume();




        //  initImageBitmaps();
    }






    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        List<Object> objects = MainActivity1.database._Dao()._getObject();
        for(Object obj : objects ){
            String desc =obj.getDescription();
            String lab =obj.getCategorie();
            String img= obj.getImage();

            mImageUrls.add(img);
            mNames.add(lab);
            mDescription.add(desc);








        }





     /*  Bundle b = getIntent().getExtras();
        String descrip=b.getString("_descrip");
        String label=b.getString("_label");
        String url=b.getString("_url");

        mImageUrls.add(url);
        mNames.add(label);
        mDescription.add(descrip);

*/




        initRecyclerView();
    }


    public static void delete_school(Object obj){


        database._Dao()._deleteObject(obj);
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mDescription);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        ItemTouchHelper itemTouchHelper = new
                ItemTouchHelper(new swipe(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}






















