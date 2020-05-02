package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Dat.class }, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatDao DatDao();
}
