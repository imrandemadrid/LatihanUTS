package com.imran.latihanuts;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/*
    Mohamad Imran 10117170 IF5
    Tanggal pengerjaan Kamis 14 Mei
 */

public class GalleryFragment extends Fragment {
    @Nullable



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);



        return view;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<Integer> items = new ArrayList<>();
        items.add(R.drawable.hotel);
        items.add(R.drawable.im);
        items.add(R.drawable.poison1m);
        items.add(R.drawable.scbd);
        items.add(R.drawable.tes0);
        items.add(R.drawable.ulu);
        items.add(R.drawable.logo1);
        items.add(R.drawable.im);

        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.gridrecycleview);
        LinearLayoutManager GridLayoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        GridAdapter gridAdapter = new GridAdapter(items);
        recyclerView.setLayoutManager(GridLayoutManager);
        recyclerView.setAdapter(gridAdapter);

        recyclerView.setHasFixedSize(true);
    }
}



