package com.example.asus.autismproject;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.util.Base64;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.asus.autismproject.DAO.Database;
import com.example.asus.autismproject.DAO.Object;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class addExistingObject extends AppCompatActivity {

    Button button ;
    Intent intent ;
    Object myobjectjson;
    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_existing_object);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        database = Room.databaseBuilder(getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "object").allowMainThreadQueries().build();

        button = (Button)findViewById(R.id.button) ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
                intent.putExtra("CONTENT_TYPE", "*/*");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                //intent.setType("*/*");
                //Intent i = Intent.createChooser(intent, "View Default File Manager");
                //startActivityForResult(i, 1);
               startActivityForResult(intent, 7);



            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub

        switch(requestCode){

            case 7:

                if(resultCode==RESULT_OK){

                    String PathHolder = data.getData().getPath();

                    Toast.makeText(addExistingObject.this, PathHolder , Toast.LENGTH_LONG).show();
                    Gson gson = new Gson();

                    // 1. JSON file to Java object
                    try {
                         myobjectjson  = gson.fromJson(new FileReader(PathHolder), Object.class);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                  /*  byte[] decoded = Base64.decode( myobjectjson.getFind_voice(), 0);

                    String path1=Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+UUID.randomUUID().toString()+"_audio_record.3gp";
                    try
                    {
                        File file2 = new File(path1);
                        FileOutputStream os = new FileOutputStream(file2, true);
                        os.write(decoded);
                        os.close();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }

                    byte[] decoded1 = Base64.decode( myobjectjson.getVoice(), 0);
                    String path2=Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+UUID.randomUUID().toString()+"_audio_record.3gp";
                    try
                    {
                        File file2 = new File(path2);
                        FileOutputStream os = new FileOutputStream(file2, true);
                        os.write(decoded1);
                        os.close();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }




                    byte[] decodedString = Base64.decode(myobjectjson.getImage(), Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);


                    //save image in external storage
                    String root = Environment.getExternalStorageDirectory().toString();
                    File myDir = new File(root + "/req_images");
                    myDir.mkdirs();
                    String n =UUID.randomUUID().toString();
                    String fname = "Image-" + n + ".jpg";
                    File file = new File(myDir, fname);

                    if (file.exists())
                        file.delete();
                    try {
                        FileOutputStream out = new FileOutputStream(file);
                        decodedByte.compress(Bitmap.CompressFormat.JPEG, 90, out);
                        out.flush();
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String imagePath=root+"/req_images"+"/"+"Image-" + n + ".jpg";



                    String description = myobjectjson.getDescription()+"old";
                    String image=imagePath;
                    String voice=path2;
                    String find_voice=path1;
                    String categorie=myobjectjson.getCategorie();
                    Object myobject=new Object(  description,  image,  path2, find_voice,  categorie);*/
                    myobjectjson.setDescription(myobjectjson.getDescription()+"/_old");
                    database._Dao()._add_object(myobjectjson);

                }
                break;

        }
    }





}
