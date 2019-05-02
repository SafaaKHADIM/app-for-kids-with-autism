package com.example.asus.autismproject.DAO;

import android.arch.persistence.room.RoomDatabase;


@android.arch.persistence.room.Database(entities = {Object.class, Score.class } , version=2)
public abstract class Database extends RoomDatabase{


    public abstract DAO _Dao();
}
