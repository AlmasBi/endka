package com.example.myapplication;

import android.app.Application;

import androidx.room.Room;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {
    public  static MyApplication instance;
    private Retrofit retrofit;
    private APIService service;
    private APISetvice1 service1;
    private Retrofit retrofit1;
    private AppDatabase database;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit1=new Retrofit.Builder()
                .baseUrl("http://countryapi.gear.host/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service1 = retrofit1.create(APISetvice1.class);
        service = retrofit.create(APIService.class);

        database= Room.databaseBuilder(this,AppDatabase.class,"job_db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
    public static MyApplication getInstance(){
        return instance;
    }
    public  Retrofit getRetrofit(){
        return retrofit;
    }
    public  Retrofit getRetrofit1(){
        return retrofit1;
    }
    public  APIService getService(){
        return service;
    }
    public  APISetvice1 getService1(){
        return service1;
    }

    public AppDatabase getDatabase(){
        return database;
    }

}