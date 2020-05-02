package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class LikedTwoFragment extends Fragment {
    String title;
    String code;
    AppDatabase db;
    public LikedTwoFragment(String title, String code) {
        this.title=title;
        this.code=code;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=MyApplication.getInstance().getDatabase();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two_liked, container, false);
        ((MainActivity)getActivity()).LikedTFragment(title,code);
        Button delete = v.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dat data  = new Dat();
                data =db.DatDao().getDataByTitle(title);
                if(data==null){
                    Toast.makeText(((MainActivity)getContext()), "country already deleted", Toast.LENGTH_SHORT).show();
                }else {
                    db.DatDao().Delete(data);
                    Toast.makeText(((MainActivity) getContext()), "country deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return v;
    }

}
