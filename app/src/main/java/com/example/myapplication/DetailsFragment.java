package com.example.myapplication;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsFragment extends Fragment implements CountryAdapter.OnTouchItem {
     List<CountryFull> country;
    ImageView imageView;
    List<com.example.myapplication.Response> responses;
    RecyclerView recyclerView1;
    CountryAdapter adapter1;
    RecyclerView.LayoutManager layoutManager1;
    ArrayList<ExampleItem2> exampleList;
String image;
    APIService apiService;
    APISetvice1 apiService1;
    Example examples;
    String strana;
    String code;Boolean isLiked=true;
    AppDatabase db;
CountryAdapter.OnTouchItem onTouchItem;
    public DetailsFragment(String strana, String code) {
        this.strana=strana;
        this.code=code;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=MyApplication.getInstance().getDatabase();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ditail_country, container, false);
        recyclerView1 = v.findViewById(R.id.recyclerView1);
        apiService = MyApplication.getInstance().getService();
        apiService1 = MyApplication.getInstance().getService1();
        String title;
        String image = null;
        Integer Confirmed;
        Integer Deaths;
        Integer Recovered;
        Integer Active;
         String Date;

         exampleList = new ArrayList<>();
        exampleList=getCon(strana);




//        String s= ((MainActivity)getActivity()).  getExamples(image);

         imageView = v.findViewById(R.id.image11);

//        Picasso.get()
//                .load(s)
////               .placeholder(R.drawable.place)
////                .centerCrop()
////                .resize(150, 150)
//                .into(imageView);
//        Log.e("rrr",exampleList.size()+"");
//        adapter1 = new CountryAdapter(exampleList, onTouchItem);
//        layoutManager1 = new LinearLayoutManager((MainActivity)getActivity());
//        recyclerView1.setAdapter(adapter1);
//        recyclerView1.setLayoutManager(layoutManager1);
//        exampleList=getCon(strana);

        return v;}

    @Override
    public void onTouch(int position) {

    }
    public ArrayList<ExampleItem2> getCon(String a) {
        apiService.getUrl("https://api.covid19api.com/dayone/country/"+a).enqueue(new Callback<List<CountryFull>>() {
            @Override
            public void onResponse(Call<List<CountryFull>>call, Response<List<CountryFull>> response) {
                String title;
                Integer Confirmed;
                Integer Deaths;
                Integer Recovered;
                Integer Active;
                String Date;


                exampleList = new ArrayList<>();
                for(CountryFull count:response.body()){

                    Confirmed= count.getConfirmed();
                    Deaths= count.getDeaths();
                    Recovered= count.getRecovered();
                    Active= count.getActive();
                    Date= count.getDate();
                    image=count.getCountryCode();
                    exampleList.add(new ExampleItem2(Confirmed,Deaths,Recovered,Active,Date));

                }
//                String s= ((MainActivity)getActivity()).  getExamples(image);
                apiService1.getExamples().enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        examples=response.body();
                        responses=examples.getResponse();
                        Log.e("qqq",responses.size()+"");
                        for(com.example.myapplication.Response res: responses){
                            if(res.getAlpha2Code().equals(code)){
                                  Picasso.get()
                                        .load(res.getFlagPng())
                                        .into(imageView);
                                Log.e("qqq","This shit works");
                            }}
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Toast.makeText(((MainActivity)getContext()), "smthg went wrong", Toast.LENGTH_SHORT).show();
                    }
                });



                adapter1 = new CountryAdapter(exampleList, onTouchItem);
                layoutManager1 = new LinearLayoutManager((MainActivity)getActivity());
                recyclerView1.setAdapter(adapter1);
                recyclerView1.setLayoutManager(layoutManager1);
                Log.e("EEEEE",response.body().size()+"");
                adapter1.setPostt(exampleList);
            }

            @Override
            public void onFailure(Call<List<CountryFull>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "smthg went wrong", Toast.LENGTH_SHORT).show();
            }
        });
        return this.exampleList;
    }
}
