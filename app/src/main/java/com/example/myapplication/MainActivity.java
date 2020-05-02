package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    Retrofit retrofit1;
    APIService apiService;
    APISetvice1 apiService1;
    List<Country> country;
    Example examples;
    String codeCode;
    List<com.example.myapplication.Response> responses;
    List<CountryFull> countryFull;
    String a;
    List<CountryFull> ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofit = MyApplication.getInstance().getRetrofit();
        apiService = MyApplication.getInstance().getService();
        retrofit1 = MyApplication.getInstance().getRetrofit1();
        apiService1 = MyApplication.getInstance().getService1();

        country = new ArrayList<>();
        ss=new ArrayList<>();
        countryFull=new ArrayList<>();
        responses= new ArrayList<>();
        CountriesTwoFragment(getCountries());
        Button jobFragment = findViewById(R.id.country_fragment_button);
        jobFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CountriesTwoFragment(getCountries());
            }
        });
        Button likedFragment = findViewById(R.id.liked_fragment_button);
        likedFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LikedFragment();
            }
        });
        Button GlobalFragment = findViewById(R.id._button);
        GlobalFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Third();
            }
        });
    }
    public void detailTwoFragment(String country, String code) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new DetailsTwoFragment(country, code)).commitAllowingStateLoss();
    }
    public void CountriesFragment(List<Country> countries) {
        getSupportFragmentManager().beginTransaction().replace(R.id.ccountries, new CountriesFragment(countries)).commitAllowingStateLoss();
    }
    private void CountriesTwoFragment(List<Country> countries) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new CountriesTwoFragment(countries)).commitAllowingStateLoss();
    }
    public void detailFragment(String country, String code) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameDitail, new DetailsFragment(country, code)).commitAllowingStateLoss();
    }
    public void LikedFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new LikedFragment()).commitAllowingStateLoss();
    }
    public void LikedTwoFragment(String title, String code) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new LikedTwoFragment(title,code)).commitAllowingStateLoss();
    }
    public void LikedTFragment(String title, String code) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLiked, new DetailsFragment(title,code)).commitAllowingStateLoss();
    }
    public void Third() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new Third()).commitAllowingStateLoss();
    }
    public List<Country> getCountries() {
        apiService.getJobs().enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                setJobs(response.body());

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "smthg went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        return this.country;
    }
//    public String getExamples(String code) {
//        apiService1.getExamples().enqueue(new Callback<Example>() {
//            @Override
//            public void onResponse(Call<Example> call, Response<Example> response) {
//               examples=response.body();
//             responses=examples.getResponse();
//             for(com.example.myapplication.Response res: responses){
//                 if(res.getAlpha2Code().equals(code)){
//                     setCode(res.getFlagPng());
//                 Log.e("qqq","This shit works");
//             }}
//            }
//
//            @Override
//            public void onFailure(Call<Example> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "smthg went wrong", Toast.LENGTH_SHORT).show();
//            }
//        });
//        return this.codeCode;
//    }
//    public List<CountryFull> getCon(String a) {
//        apiService.getUrl("https://api.covid19api.com/dayone/country/"+a).enqueue(new Callback<List<CountryFull>>() {
//            @Override
//            public void onResponse(Call<List<CountryFull>>call, Response<List<CountryFull>> response) {
//                asetJobs(response.body());
//
//                    Log.e("EEEEE",response.body().size()+"");
//            }
//
//            @Override
//            public void onFailure(Call<List<CountryFull>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "smthg went wrong", Toast.LENGTH_SHORT).show();
//            }
//        });
//        return this.countryFull;
//    }

        public void setJobs(List<Country> country){
             this.country = country;
        }
    public void setCode(String code){
        this.codeCode = code;
    }

    public void asetJobs(List<CountryFull> acountry){
        this.countryFull = acountry;
        Log.e("saaasww",acountry.size()+"");
        Log.e("saaasww",countryFull.size()+"");
    }

// public void otpravka(String itemTitle){
//     Log.e("ssww",itemTitle);
//
//     Log.e("eeww",countryFull.size()+"");
//     detailFragment(getCon(itemTitle));
// }
}