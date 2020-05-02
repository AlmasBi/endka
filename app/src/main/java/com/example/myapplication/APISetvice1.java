package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APISetvice1 {

    @GET("v1/Country/getCountries")
    Call<Example> getExamples();

}
