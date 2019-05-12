package com.example.asus.autismproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class addExistingObject extends AppCompatActivity {

    Button button ;
    Intent intent ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_existing_object);

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

                }
                break;

        }
    }

}
