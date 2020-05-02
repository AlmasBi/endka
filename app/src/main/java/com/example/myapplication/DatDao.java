package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DatDao {
    @Insert
    void Insert(Dat contact);
    @Update
    void Update(Dat contact);
    @Delete
    void Delete(Dat contact);
    @Query("SELECT * FROM Dat")
    List<Dat> getData();
    @Query("SELECT * FROM Dat WHERE Title = :title")
    Dat getDataByTitle(String title);
}
