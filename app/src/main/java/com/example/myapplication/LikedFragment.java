package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LikedFragment extends Fragment implements CountrieAdapter.OnTouchItem {
    private ArrayList<ExampleItem> exampleList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    AppDatabase db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=MyApplication.getInstance().getDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_liked, container, false);
        recyclerView = v.findViewById(R.id.recyclerViewliked);
        exampleList= new ArrayList<>();
        List<Dat> data=db.DatDao().getData();
        String title;
        String code;
        for(Dat contact:data){


            title= contact.Title;

            code=contact.Code;
            exampleList.add(new ExampleItem(title,code));
        }
        Log.e("ss",exampleList.size()+"");
        adapter = new CountrieAdapter(exampleList, this);
        layoutManager = new LinearLayoutManager((MainActivity)getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
return v;}

    @Override
    public void onTouch(int position) {
        ExampleItem item =exampleList.get(position);
        String code = item.getUrl();
        String itemTitle=item.getTitle();
        ((MainActivity)getActivity()).LikedTwoFragment(itemTitle,code);
    }
}
