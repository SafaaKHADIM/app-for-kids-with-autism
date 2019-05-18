package com.example.asus.autismproject;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.asus.autismproject.DAO.Database;
import com.example.asus.autismproject.DAO.Score;
/*import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
*/
import java.util.List;

public class ScoreV extends AppCompatActivity {
    public static Database database;
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        database = Room.databaseBuilder(getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "score").allowMainThreadQueries().build();


        TextView mylist =(TextView) this.findViewById(R.id.textView8);
        List<Score> scores = MainAppActivity.database._Dao()._getScore();
        String info ="";
        for(Score scr: scores){
            int id =scr.get_id();
            String categorie =scr.get_category();
            int score =scr.get_score();
            int rightanswer =scr.getRightanswers();
            int falseanswer =scr.getFalseanswers();

            info=info+"\n\n\n______________"+"id :"+ id +"_____________"+"\n score :"+ score+"\n right answers :"+ rightanswer+"\n false answers :"+ falseanswer;



        }

        mylist.setText(info);


    }
}