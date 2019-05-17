package com.example.asus.autismproject;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.asus.autismproject.DAO.Database;
import com.example.asus.autismproject.DAO.Score;
/*import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
*/
import java.util.ArrayList;
import java.util.List;

public class ScoreV extends AppCompatActivity {
    public static Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //show the activity in full screen
        database = Room.databaseBuilder(getApplicationContext(), com.example.asus.autismproject.DAO.Database.class, "score").allowMainThreadQueries().build();
        // in this example, a LineChart is initialized from xml
      /*  LineChart chart = (LineChart) findViewById(R.id.chart);




        ///adding data

        List<Score> scr =ScoreV.database._Dao()._getScore();
        List<Entry> entries = new ArrayList<Entry>();
        for (Score data : scr) {
            // turn your data into Entry objects
            entries.add(new Entry(data.get_id(), data.get_score()));
        }


        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        dataSet.setColor(5);
        dataSet.setValueTextColor(10); // styling, ...
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate(); // refresh


*/
    }










}
