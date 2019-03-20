package com.example.asus.autismproject;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

public class AddObject extends AppCompatActivity {
    //Declare variables
    Button record,stopRecord,play,stop;
    String pathSave="";
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;

    final int REQUEST_PERMISSION_CODE=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_object);

        if(!checkPermissionFromDevice())
            requestPermission();

        record=(Button)findViewById(R.id.recordbtn);
        stopRecord=(Button)findViewById(R.id.stoprecordbtn);
        play=(Button)findViewById(R.id.playbtn);
        stop=(Button)findViewById(R.id.stopbtn);


            record.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(checkPermissionFromDevice()){


                    pathSave=Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+UUID.randomUUID().toString()+"_audio_record.3gp";
                    setupMediaRecorder();
                    try{
                        mediaRecorder.prepare();
                        mediaRecorder.start();
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
                    mediaRecorder.stop();
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
                    mediaPlayer= new MediaPlayer();

                    try{
                        mediaPlayer.setDataSource(pathSave);
                        mediaPlayer.prepare();
                    }catch(IOException e){
                        e.printStackTrace();
                    }

                    mediaPlayer.start();

                }
            });
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
            stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    record.setEnabled(true);
                    stopRecord.setEnabled(false);
                    play.setEnabled(true);
                    stop.setEnabled(false);

                    if(mediaPlayer!=null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        setupMediaRecorder();

                    }
                }
            });



    }

    private void setupMediaRecorder() {
        mediaRecorder =new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(pathSave);

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

