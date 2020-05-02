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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesTwoFragment extends Fragment {
    List<Country> countries;
    public CountriesTwoFragment(List<Country> countries) {
        this.countries=countries;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two_countries, container, false);
        ((MainActivity)getActivity()).CountriesFragment(countries);
        Button search = v.findViewById(R.id.search);
        EditText edit = v.findViewById(R.id.find);
        APIService service = MyApplication.getInstance().getService();
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edit.getText().toString();
                service.getJobs().enqueue(new Callback<List<Country>>() {
                    @Override
                    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                        for(Country count:response.body()){
                            if(count.getCountry().equals(title)){
                                Log.e("uuu",title);
                                ((MainActivity)getActivity()).detailTwoFragment(title,count.getISO2());
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Country>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "smthg went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
//                List<Job> aa= ((MainActivity)getActivity()).getFind(title);
//                ((MainActivity)getActivity()).SSearchFragment(aa);
            }
        });
        return v;}

}
