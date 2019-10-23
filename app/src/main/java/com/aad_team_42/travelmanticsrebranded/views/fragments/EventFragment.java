package com.aad_team_42.travelmanticsrebranded.views.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.adapters.EventAdapter;
import com.aad_team_42.travelmanticsrebranded.adapters.ExploreAdapter;
import com.aad_team_42.travelmanticsrebranded.model.Event;
import com.aad_team_42.travelmanticsrebranded.model.Explore;
import com.aad_team_42.travelmanticsrebranded.utils.FirebaseUtils;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private EventAdapter mAdapter;
    private ChildEventListener mChildEventLisener;
    private ProgressBar progressBar;
    TextView tvError;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        progressBar = view.findViewById(R.id.progressBar);
        tvError = view.findViewById(R.id.network_error);
        mAdapter = new EventAdapter();
        mRecyclerView = view.findViewById(R.id.recylerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        getData();


        return view;
    }

    private void getData() {
        mChildEventLisener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                List<Event> eventList = new ArrayList<>();
                Event event = dataSnapshot.getValue(Event.class);
                eventList.add(event);
                mAdapter.setEvent(eventList, getContext());
                if (mRecyclerView != null) {
                    mRecyclerView.setAdapter(mAdapter);
                    progressBar.setVisibility(View.GONE);
                    tvError.setVisibility(View.GONE);
                }
                progressBar.setVisibility(View.GONE);
                tvError.setVisibility(View.GONE);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        FirebaseUtils.mRef.child("event").addChildEventListener(mChildEventLisener);
    }
}
