package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Third extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.third, container, false);




       APIService apiService = MyApplication.getInstance().getService();
        apiService.getOveral().enqueue(new Callback<Overal>() {

            @Override
            public void onResponse(Call<Overal> call, Response<Overal> response) {
                Log.e("aaa",response.body()+"");
                Overal tt=response.body();
                Global global= tt.getGlobal();
                TextView newConfirmed=v.findViewById(R.id.newConfirmed);
                TextView totalConfirmed=v.findViewById(R.id.totalConfirmed);
                TextView newDeaths=v.findViewById(R.id.newDeaths);
                TextView totalDeaths=v.findViewById(R.id.totalDeaths);
                TextView newRecovered=v.findViewById(R.id.newRecovered);
                TextView totalRecovered=v.findViewById(R.id.totalRecovered);

                Integer inewConfirmed = global.getNewConfirmed();
                Integer    itotalConfirmed= global.getTotalConfirmed();
                Integer inewDeaths= global.getNewDeaths();
                Integer       itotalDeaths= global.getTotalDeaths();
                Integer inewRecovered= global.getNewRecovered();
                Integer       itotalRecovered= global.getTotalRecovered();

                newConfirmed.setText((inewConfirmed).toString());
                totalConfirmed.setText((itotalConfirmed).toString());
                newDeaths.setText((inewDeaths).toString());
                totalDeaths.setText((itotalDeaths).toString());
                newRecovered.setText((inewRecovered).toString());
                totalRecovered.setText((itotalRecovered).toString());
            }

            @Override
            public void onFailure(Call<Overal> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "smthg went wrong", Toast.LENGTH_SHORT).show();
            }
        });

        return v;}
}
