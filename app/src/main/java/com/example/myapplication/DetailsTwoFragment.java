package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class DetailsTwoFragment extends Fragment {
    String country;
    String code;
    AppDatabase db;
    public DetailsTwoFragment(String country, String code) {
        this.country=country;
        this.code=code;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=MyApplication.getInstance().getDatabase();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two_ditail, container, false);
        ((MainActivity)getActivity()).detailFragment(country,code);
        Button liked = v.findViewById(R.id.like);
        TextView nameTitle = v.findViewById(R.id.nameTitle);
        nameTitle.setText(country);
        liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dat data  = new Dat();
                data =db.DatDao().getDataByTitle(country);


                if(data==null){
                    Dat dat  = new Dat();
                    dat.Code=code;
                    dat.Title=country;
                    db.DatDao().Insert(dat);
                    Toast.makeText(((MainActivity)getContext()), "New country added", Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(((MainActivity) getContext()), "country already added", Toast.LENGTH_SHORT).show();
                }



            }
        });
        return v;
    }

}
