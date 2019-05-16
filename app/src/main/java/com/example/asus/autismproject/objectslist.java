package com.example.asus.autismproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.asus.autismproject.DAO.Object;

import java.util.List;

public class objectslist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectslist);
        TextView mylist =(TextView) this.findViewById(R.id.list1);
        List<Object> users = MainActivity.database._Dao()._getObject();
        String info ="";
        for(Object usr: users){
            String email =usr.getCategorie();
            String password =usr.getDescription();
            info=info+"\n\n"+"email :"+ email +"\n password :"+ password;



        }

        mylist.setText(info);
    }
}
