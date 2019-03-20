package com.example.asus.autismproject.DAO;

import android.arch.persistence.room.RoomDatabase;


@android.arch.persistence.room.Database(entities = {Object.class } , version=1)
public abstract class Database extends RoomDatabase{


    public abstract DAO _Dao();
}
