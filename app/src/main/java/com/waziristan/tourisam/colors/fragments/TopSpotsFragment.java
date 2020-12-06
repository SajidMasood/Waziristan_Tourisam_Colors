package com.waziristan.tourisam.colors.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.waziristan.tourisam.colors.R;
import com.waziristan.tourisam.colors.adapter.TopSportAdapter;
import com.waziristan.tourisam.colors.model.PlaceInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TopSpotsFragment extends Fragment {

    private Context mContext;
    private RecyclerView mRecyclerView;
    private DatabaseReference mReference;
    private ArrayList<PlaceInfo> topSportList;
    private TopSportAdapter adapter;
    View rootView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.places_list, container, false);


        // TODO: 11/15/2018  Recycler View declaration...
        mRecyclerView = rootView.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
        // TODO: 11/15/2018 Database References...
        mReference = FirebaseDatabase.getInstance().getReference();


        // TODO: 12/6/2020 ArrayList...
        topSportList = new ArrayList<>();

        // TODO: 12/6/2020 Clear Arraylist...
        ClearAll();


        // TODO: 12/6/2020 Get Data Method...
        GetDataFromFirebase();

        return rootView;
    }

    private void GetDataFromFirebase() {
        Query query = mReference.child("topspots");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ClearAll();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    PlaceInfo placeInfo = new PlaceInfo();
                    placeInfo.setTopimage(dataSnapshot.child("topimage").getValue().toString());
                    placeInfo.setName(dataSnapshot.child("name").getValue().toString());
                    placeInfo.setSummary(dataSnapshot.child("summary").getValue().toString());

                    topSportList.add(placeInfo);
                }

                adapter = new TopSportAdapter(mContext, topSportList);
                mRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void ClearAll(){
        if (topSportList != null){
            topSportList.clear();
            if (adapter != null){
                adapter.notifyDataSetChanged();
            }
        }

        topSportList = new ArrayList<>();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
