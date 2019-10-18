package com.aad_team_42.travelmanticsrebranded.activities.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.activities.adapters.ExploreAdapter;
import com.aad_team_42.travelmanticsrebranded.activities.model.Explore;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ExploreAdapter mAdapter;
    private List<Explore> mExploreList = new ArrayList<>();

    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        mAdapter = new ExploreAdapter();
        mAdapter.setExplore(mExploreList);
        mRecyclerView = view.findViewById(R.id.recylerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);


        return view;
    }

}
