package com.example.asus.autismproject.DAO;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao

public interface DAO {
//for objects
    @Insert
    public void _add_object(Object object);

    @Query("select * from OBJECT")
    public List<Object> _getObject();


    @Delete
    public void _deleteObject(Object object);

//for score
    @Insert
    public void _add_score(Score score);

    @Query("select * from SCORE")
    public List<Score> _getScore();


    @Delete
    public void _deleteScore(Score score);
}
