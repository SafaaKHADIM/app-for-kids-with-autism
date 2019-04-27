package com.example.asus.autismproject;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus.autismproject.DAO.Database;
import com.example.asus.autismproject.DAO.Object;
import com.example.asus.autismproject.GameViews.Level1.Screen1;
import com.example.asus.autismproject.assets.Object1;
import com.example.asus.autismproject.assets.Object2;
import com.example.asus.autismproject.assets.Object3;
import com.example.asus.autismproject.assets.Object4;
import com.example.asus.autismproject.assets.background;
import com.example.asus.autismproject.assets.hamtaro_character_1;
import com.example.asus.autismproject.assets.hamtaro_character_2;
import com.example.asus.autismproject.assets.hand;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidImage;
import com.example.emobadaragaminglib.Implementation.AndroidSound;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import id.zelory.compressor.Compressor;
//import pl.droidsonroids.gif.GifImageView;


public class ActivityLevel1 extends AndroidGame {
    public static Database database;
    private Context context;


    @Override
    public Screen getInitScreen() {

        database = Room.databaseBuilder(getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "object").allowMainThreadQueries().build();
        List<Object> objcts = ActivityLevel1.database._Dao()._getObject();
        int i= objcts.size();
        //generer des nombres aleatoires
        Random rand = new Random();
        int number1 = rand.nextInt(i);
        /// il faut ajouter la condition pour qu il ne choisit pas le même objet c a d il faut que number1 soit diff de number2.....
        int number2 = rand.nextInt(i);
        int number3 = rand.nextInt(i);
        int number4 = rand.nextInt(i);
        context = (Context) this;
       /* Intent _my_intent = new Intent(context,ActivityLevel3.class);
        _my_intent.putExtra("num1",number1);
        _my_intent.putExtra("num2",number2);
        _my_intent.putExtra("num3",number3);
        _my_intent.putExtra("num4",number4);
        startActivity(_my_intent);
*/
        //get the objects
        Object Myobject1 = objcts.get(number1);
        Object Myobject2 = objcts.get(number2);
        Object Myobject3 = objcts.get(number3);
        Object Myobject4 = objcts.get(number4);
         //image
        try {
            Bitmap bitmap1 = new Compressor(this).compressToBitmap(new File(Myobject1.getImage()));
            Object1.avatar =(Image) new AndroidImage(bitmap1,Graphics.ImageFormat.ARGB8888);
            Bitmap bitmap2 = new Compressor(this).compressToBitmap(new File(Myobject2.getImage()));
            Object2.avatar =(Image) new AndroidImage(bitmap2,Graphics.ImageFormat.ARGB8888);
            Bitmap bitmap3 = new Compressor(this).compressToBitmap(new File(Myobject3.getImage()));
            Object3.avatar =(Image) new AndroidImage(bitmap3,Graphics.ImageFormat.ARGB8888);
            Bitmap bitmap4 = new Compressor(this).compressToBitmap(new File(Myobject4.getImage()));
            Object4.avatar =(Image) new AndroidImage(bitmap4,Graphics.ImageFormat.ARGB8888);
            } catch (IOException e) {
            e.printStackTrace();
        }
        //sound
        SoundPool s =new SoundPool(5,AudioManager.STREAM_MUSIC,0);
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



        //hand
        hand.avatar = getGraphics().newImage(R.drawable.hand,Graphics.ImageFormat.ARGB8888,getResources());
        hand.voice_right =  (AndroidSound) getAudio().createSound(R.raw.tres_bien);
        hand.voice_false =  (AndroidSound) getAudio().createSound(R.raw.create);
        //background
        background.avatar= getGraphics().newImage(R.drawable.board1,Graphics.ImageFormat.ARGB8888,getResources());
        //hamtaro characters

       // GifImageView iv = new GifImageView(this); //dynamically created imageview

        //iv.setImageResource(R.drawable.maxwell);
        hamtaro_character_1.avatar=getGraphics().newImage(R.drawable.maxwellframe1,Graphics.ImageFormat.ARGB8888,getResources());
        hamtaro_character_2.avatar=getGraphics().newImage(R.drawable.maxwellframe2,Graphics.ImageFormat.ARGB8888,getResources());

        //The method is going to
        return new Screen1(this);

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
