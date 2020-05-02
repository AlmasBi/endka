package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Dat {
    @PrimaryKey( autoGenerate = true)
    public int id ;
    public String Title;

    public String Code;


}
