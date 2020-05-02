package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIService {
    @GET("countries")
    Call<List<Country>> getJobs();

    @GET("countries")
    Call<List<Example>> getExamples();


    @GET("summary")
    Call<Overal> getOveral();


    @GET("total/dayone/country/{Country}/")
    Call<List<CountryFull>> getTitle(@Path("Country") String title);


    @Headers({"Cache-Control: max-age=640000", "User-Agent: My-App-Name"})
    @GET("total/dayone/country/")
    Call<List<CountryFull>> getCon(@Query("Country") String title);


    @FormUrlEncoded
    @POST("positions.json/")
    Call<Country> addJob(@Field("userId") int userId,
                     @Field("title") String title,
                     @Field("completed") boolean completed);

    @GET("countries")
    Call<List<Country>> getFind(@Query("search") String title);

    @GET
    Call<List<CountryFull>> getUrl(@Url String url);
}
