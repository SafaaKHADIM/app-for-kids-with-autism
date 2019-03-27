package com.example.asus.autismproject;

import android.Manifest;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.example.asus.autismproject.DAO.DAO;
import com.example.asus.autismproject.DAO.Database;
import com.example.asus.autismproject.DAO.Object;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import info.androidhive.fontawesome.FontDrawable;


public class AddObject extends AppCompatActivity implements ExampleDialog.ExampleDialogListener{








    //Declare variables
    public static Database database;
    FloatingActionButton record,stopRecord,play,stop,record2,stopRecord2,play2,stop2,button;
    String pathSave1="",pathSave2="";
    MediaRecorder mediaRecorder1,mediaRecorder2;
    MediaPlayer mediaPlayer1,mediaPlayer2;
    ImageView imageView;
    File photoFile = null;



    String mCurrentPhotoPath;
    private static final String IMAGE_DIRECTORY_NAME = "VLEMONN";
    static final int CAPTURE_IMAGE_REQUEST = 1;
    final int REQUEST_PERMISSION_CODE=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_object);
        TypefaceProvider.registerDefaultIconSets();
        database = Room.databaseBuilder(getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "object").allowMainThreadQueries().build();

        // font awsome
        FontDrawable drawable1 = new FontDrawable(this, R.string.fa_microchip_solid, true, false);
        FontDrawable drawable2 = new FontDrawable(this, R.string.fa_microphone_slash_solid, true, false);
        FontDrawable drawable3 = new FontDrawable(this, R.string.fa_play_solid, true, false);
        FontDrawable drawable4 = new FontDrawable(this, R.string.fa_stop_solid, true, false);
        // white color to icon
        drawable1.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        drawable2.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        drawable3.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        drawable4.setTextColor(ContextCompat.getColor(this, android.R.color.white));

        ///pour la capture d'image
        imageView =  findViewById(R.id.imageView);
        button = findViewById(R.id.btnCaptureImage);


        if(!checkPermissionFromDevice())
            requestPermission();

        record = findViewById(R.id.recordbtn);
        stopRecord = findViewById(R.id.stoprecordbtn);
        play = findViewById(R.id.playbtn);
        stop = findViewById(R.id.stopbtn);
        record2 = findViewById(R.id.recordbtn2);
        stopRecord2 = findViewById(R.id.stoprecordbtn2);
        play2 = findViewById(R.id.playbtn2);
        stop2 = findViewById(R.id.stopbtn2);




        //using font awsome for my FloatingActionButtons
        record.setImageDrawable(drawable1);
        stopRecord.setImageDrawable(drawable2);
        play.setImageDrawable(drawable3);
        stop.setImageDrawable(drawable4);
        record2.setImageDrawable(drawable1);
        stopRecord2.setImageDrawable(drawable2);
        play2.setImageDrawable(drawable3);
        stop2.setImageDrawable(drawable4);


            record.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkPermissionFromDevice()){


                    pathSave1=Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+UUID.randomUUID().toString()+"_audio_record.3gp";
                    setupMediaRecorder1();
                    try{
                        mediaRecorder1.prepare();
                        mediaRecorder1.start();
                    }catch(IOException e){
                        e.printStackTrace();

                    }
                    play.setEnabled(false);
                    stop.setEnabled(false);
                        Toast.makeText(AddObject.this,"Reccording",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        requestPermission();
                    }
                }
            });

            stopRecord.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaRecorder1.stop();
                    stopRecord.setEnabled(false);
                    play.setEnabled(true);
                    record.setEnabled(true);
                    stop.setEnabled(false);
                }
            });

            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    stop.setEnabled(true);
                    stopRecord.setEnabled(false);
                    record.setEnabled(false);
                    mediaPlayer1= new MediaPlayer();

                    try{
                        mediaPlayer1.setDataSource(pathSave1);
                        mediaPlayer1.prepare();
                    }catch(IOException e){
                        e.printStackTrace();
                    }

                    mediaPlayer1.start();

                }
            });

            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    record.setEnabled(true);
                    stopRecord.setEnabled(false);
                    play.setEnabled(true);
                    stop.setEnabled(false);

                    if(mediaPlayer1!=null){
                        mediaPlayer1.stop();
                        mediaPlayer1.release();
                        setupMediaRecorder1();

                    }
                }
            });



        record2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPermissionFromDevice()){


                    pathSave2=Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+UUID.randomUUID().toString()+"_audio_record.3gp";
                    setupMediaRecorder2();
                    try{
                        mediaRecorder2.prepare();
                        mediaRecorder2.start();
                    }catch(IOException e){
                        e.printStackTrace();

                    }
                    play.setEnabled(false);
                    stop.setEnabled(false);
                    Toast.makeText(AddObject.this,"Reccording",Toast.LENGTH_SHORT).show();
                }
                else{
                    requestPermission();
                }
            }
        });

        stopRecord2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaRecorder2.stop();
                stopRecord.setEnabled(false);
                play.setEnabled(true);
                record.setEnabled(true);
                stop.setEnabled(false);
            }
        });

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop.setEnabled(true);
                stopRecord.setEnabled(false);
                record.setEnabled(false);
                mediaPlayer2= new MediaPlayer();

                try{
                    mediaPlayer2.setDataSource(pathSave2);
                    mediaPlayer2.prepare();
                }catch(IOException e){
                    e.printStackTrace();
                }

                mediaPlayer2.start();

            }
        });

        stop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                record.setEnabled(true);
                stopRecord.setEnabled(false);
                play.setEnabled(true);
                stop.setEnabled(false);

                if(mediaPlayer2!=null){
                    mediaPlayer2.stop();
                    mediaPlayer2.release();
                    setupMediaRecorder2();

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    captureImage();
                }
                else
                {
                    captureImage2();
                }
            }
        });




        //spinner : doit afficher les categories déja existantes dans la base de données
        ArrayList<String> arraySpinner = new ArrayList<String>();
        arraySpinner.add("Add new category");
        List<Object> objs = AddObject.database._Dao()._getObject();
        for(Object myobject: objs) {
            String mycategorie = myobject.getCategorie();
            arraySpinner.add(mycategorie);
        }
        Spinner myspinner = (Spinner) findViewById(R.id.categories);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(adapter);




        myspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if(selectedItem.equals("Add new category"))
                {
                    openDialog();
                }
            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


    }




    private void setupMediaRecorder1() {
        mediaRecorder1 =new MediaRecorder();
        mediaRecorder1.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder1.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder1.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder1.setOutputFile(pathSave1);

    }
    private void setupMediaRecorder2() {
        mediaRecorder2 =new MediaRecorder();
        mediaRecorder2.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder2.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder2.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder2.setOutputFile(pathSave2);

    }

    private void requestPermission(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO},REQUEST_PERMISSION_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case REQUEST_PERMISSION_CODE:
            {
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,"Permission granted",Toast.LENGTH_SHORT).show();
            }
            break;
            case 0: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    captureImage();
                }
            }
            break;
        }
    }

    private boolean checkPermissionFromDevice(){
        int write_external_storage_result =ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO));
        return write_external_storage_result==PackageManager.PERMISSION_GRANTED && record_audio_result==PackageManager.PERMISSION_GRANTED;

    }



    /* Capture Image function for 4.4.4 and lower. Not tested for Android Version 3 and 2 */
    private void captureImage2() {

        try {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            photoFile = createImageFile4();
            if(photoFile!=null)
            {
                displayMessage(getBaseContext(),photoFile.getAbsolutePath());
                Log.i("Mayank",photoFile.getAbsolutePath());
                Uri photoURI  = Uri.fromFile(photoFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(cameraIntent, CAPTURE_IMAGE_REQUEST);
            }
        }
        catch (Exception e)
        {
            displayMessage(getBaseContext(),"Camera is not available."+e.toString());
        }
    }

    private void captureImage()
    {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }
        else
        {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                // Create the File where the photo should go
                try {

                    photoFile = createImageFile();
                    displayMessage(getBaseContext(),photoFile.getAbsolutePath());
                    Log.i("Mayank",photoFile.getAbsolutePath());

                    // Continue only if the File was successfully created
                    if (photoFile != null) {
                        Uri photoURI = FileProvider.getUriForFile(this,
                                "com.example.asus.autismproject.fileprovider",
                                photoFile);
                        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                        startActivityForResult(takePictureIntent, CAPTURE_IMAGE_REQUEST);
                    }
                } catch (Exception ex) {
                    // Error occurred while creating the File
                    displayMessage(getBaseContext(),ex.getMessage().toString());
                }


            }else
            {
                displayMessage(getBaseContext(),"Nullll");
            }
        }



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //Bundle extras = data.getExtras();
        //Bitmap imageBitmap = (Bitmap) extras.get("data");
        //imageView.setImageBitmap(imageBitmap);

        if (requestCode == CAPTURE_IMAGE_REQUEST && resultCode == RESULT_OK) {
            Bitmap myBitmap = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
            imageView.setImageBitmap(myBitmap);
            imageView.setRotation((float) -90);
        }
        else
        {
            displayMessage(getBaseContext(),"Request cancelled or something went wrong.");
        }
    }

    private File createImageFile4()
    {
        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME);
        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                displayMessage(getBaseContext(),"Unable to create directory.");
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile = new File(mediaStorageDir.getPath() + File.separator
                + "IMG_" + timeStamp + ".jpg");

        return mediaFile;

    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void displayMessage(Context context, String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }




    public void add(View view) {
        int a=0;
        EditText desc =this.findViewById(R.id.decription);
        //EditText cat =this.findViewById(R.id.categories);
        Spinner cat = (Spinner) findViewById(R.id.categories);
        String description = desc.getText().toString();
        //String categorie = cat.getText().toString();
        String categorie = cat.getSelectedItem().toString();
        List<Object> objs = AddObject.database._Dao()._getObject();
        for(Object obj: objs){
            String _desc =obj.getDescription();
            if(_desc.equals(description) ){
                a=1;
            }
        }

        if(a==0) {
            Object myobject = new Object(  description,  mCurrentPhotoPath,  pathSave2, pathSave1,  categorie);
            Log.i("safaa",mCurrentPhotoPath);
            database._Dao()._add_object(myobject);
            Intent intent1=new Intent(this, MainActivityLevel1.class);
            this.startActivity(intent1);
            }
        else{
            Toast.makeText(this,"ce nom d'objet  existe déja",Toast.LENGTH_LONG).show();
            Intent intent1=new Intent(this, AddObject.class);
            this.startActivity(intent1);
        }
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String category) {

        ArrayList<String> arraySpinner = new ArrayList<String>();
        arraySpinner.add("Add new category");
        arraySpinner.add(category);
        List<Object> objs = AddObject.database._Dao()._getObject();
        for(Object myobject: objs) {
            String mycategorie = myobject.getCategorie();
            arraySpinner.add(mycategorie);
        }
        Spinner myspinner = (Spinner) findViewById(R.id.categories);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(adapter);


    }





}

