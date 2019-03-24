package com.example.asus.autismproject;

import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.autismproject.DAO.Object;
import com.example.asus.autismproject.GameViews.Level1.Screen1;
import com.example.asus.autismproject.GameViews.Level3.Screen3;
import com.example.asus.autismproject.assets.Object1;
import com.example.asus.autismproject.assets.Object2;
import com.example.asus.autismproject.assets.Object3;
import com.example.asus.autismproject.assets.Object4;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidImage;
import com.example.emobadaragaminglib.Implementation.AndroidSound;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class MainActivityLevel3 extends AndroidGame {

    @Override
    public Screen getInitScreen() {
        //Initialize the assets you will be working with on your screens here.
        //It is better to have all of them loaded, until you have performance problems then, umm,yeah
        //We will have to figure that out :')








        List<Object> objcts = AddObject.database._Dao()._getObject();

        int i= objcts.size();
        //generer des nombres aleatoires
        Random rand = new Random();
        int number1 = rand.nextInt(i);
        number1 += 1;
        /// il faut ajouter la condition pour qu il ne choisit pas le même objet c a d il faut que number1 soit diff de number2.....
        int number2 = rand.nextInt(i);
        number2 += 1;
        int number3 = rand.nextInt(i);
        number3 += 1;
        int number4 = rand.nextInt(i);
        number4 += 1;

        Object Myobject1 = objcts.get(number1);
        Object Myobject2 = objcts.get(number2);
        Object Myobject3 = objcts.get(number3);
        Object Myobject4 = objcts.get(number4);





        SoundPool s =new SoundPool(5,AudioManager.STREAM_MUSIC,0);

        Uri imageUri1 = Uri.fromFile(new File(Myobject1.getImage()));
        Uri imageUri2 = Uri.fromFile(new File(Myobject2.getImage()));
        Uri imageUri3 = Uri.fromFile(new File(Myobject3.getImage()));
        Uri imageUri4 = Uri.fromFile(new File(Myobject4.getImage()));

        try {
            Bitmap bitmap1 = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri1);
            Object1.avatar = new AndroidImage(bitmap1,Graphics.ImageFormat.ARGB8888);
            Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri2);
            Object1.avatar = new AndroidImage(bitmap2,Graphics.ImageFormat.ARGB8888);
            Bitmap bitmap3 = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri3);
            Object1.avatar = new AndroidImage(bitmap3,Graphics.ImageFormat.ARGB8888);
            Bitmap bitmap4 = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri4);
            Object1.avatar = new AndroidImage(bitmap4,Graphics.ImageFormat.ARGB8888);

        } catch (IOException e) {
            e.printStackTrace();
        }



        //voice question
        Object1.voice_question =  new AndroidSound(s,s.load(Myobject1.getFind_voice(),1));
        Object2.voice_question =  new AndroidSound(s,s.load(Myobject2.getFind_voice(),1));
        Object3.voice_question =  new AndroidSound(s,s.load(Myobject3.getFind_voice(),1));
        Object4.voice_question =  new AndroidSound(s,s.load(Myobject4.getFind_voice(),1));
        //voice answer
        Object1.voice_answer =  new AndroidSound(s,s.load(Myobject1.getVoice(),1));
        Object2.voice_answer =  new AndroidSound(s,s.load(Myobject2.getVoice(),1));
        Object3.voice_answer =  new AndroidSound(s,s.load(Myobject3.getVoice(),1));
        Object4.voice_answer =  new AndroidSound(s,s.load(Myobject4.getVoice(),1));
        //description
        Object1._description = Myobject1.getDescription();
        Object2._description = Myobject2.getDescription();
        Object3._description = Myobject3.getDescription();
        Object4._description = Myobject4.getDescription();
        //category
        Object1._category=Myobject1.getCategorie();
        Object2._category=Myobject2.getCategorie();
        Object3._category=Myobject3.getCategorie();
        Object4._category=Myobject4.getCategorie();




        //The method is going to
        return new Screen3(this);
    }

    @Override
    protected void onDestroy() {
        //Let's make life easy on your device and get rid of the memo we dont use
        //because Android system does not do that always.
        super.onDestroy();
        Object1.avatar.dispose();
        Object1.voice_question.dispose();
        Object1.voice_answer.dispose();
        Object2.avatar.dispose();
        Object2.voice_question.dispose();
        Object2.voice_answer.dispose();
        Object3.avatar.dispose();
        Object3.voice_question.dispose();
        Object3.voice_answer.dispose();
        Object4.avatar.dispose();
        Object4.voice_question.dispose();
        Object4.voice_answer.dispose();

    }
}
