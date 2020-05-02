package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesFragment extends Fragment implements CountriesAdapter.OnTouchItem{
    ArrayList<ExampleItem> exampleList;
    RecyclerView recyclerView;
    CountriesAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Country> country;
    CountryFull c;
    public CountriesFragment(List<Country> country) {
        this.country=country;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_countries, container, false);
        recyclerView = v.findViewById(R.id.recyclerView);
        APIService service = MyApplication.getInstance().getService();
        String title;
        String image;
        exampleList = new ArrayList<>();


        for(Country count:country){
            title= count.getCountry();
            image=count.getISO2();
            exampleList.add(new ExampleItem(title,image));

        }

        adapter = new CountriesAdapter(exampleList, this);
        layoutManager = new LinearLayoutManager((MainActivity)getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

service.getJobs().enqueue(new Callback<List<Country>>() {
    @Override
    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
        String title;
        String image;
        exampleList = new ArrayList<>();
        for(Country count:response.body()){
            title= count.getCountry();
            image=count.getISO2();

            exampleList.add(new ExampleItem(title,image));

        }
        adapter.setPosts(exampleList);
    }

    @Override
    public void onFailure(Call<List<Country>> call, Throwable t) {

    }
});

        return v;}

    @Override
    public void onTouch(int position) {
       ExampleItem item =exampleList.get(position);
       String code = item.getUrl();
       String itemTitle=item.getTitle();
        ((MainActivity)getActivity()).detailTwoFragment(itemTitle,code);

    }

}
