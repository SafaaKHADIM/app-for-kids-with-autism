package com.example.asus.autismproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.TypefaceProvider;

import java.io.IOException;
import java.util.UUID;

import info.androidhive.fontawesome.FontDrawable;


public class AddObject extends AppCompatActivity {








    //Declare variables
    FloatingActionButton record,stopRecord,play,stop,record2,stopRecord2,play2,stop2;
    String pathSave1="",pathSave2="";
    MediaRecorder mediaRecorder1,mediaRecorder2;
    MediaPlayer mediaPlayer1,mediaPlayer2;

    final int REQUEST_PERMISSION_CODE=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_object);
        TypefaceProvider.registerDefaultIconSets();
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
        }
    }

    private boolean checkPermissionFromDevice(){
        int write_external_storage_result =ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int record_audio_result = (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO));
        return write_external_storage_result==PackageManager.PERMISSION_GRANTED && record_audio_result==PackageManager.PERMISSION_GRANTED;

    }
}

