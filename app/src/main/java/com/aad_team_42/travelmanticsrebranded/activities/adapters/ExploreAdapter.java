package com.aad_team_42.travelmanticsrebranded.activities.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.activities.model.Explore;

import java.util.ArrayList;
import java.util.List;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {
    private List<Explore> mExploreList = new ArrayList<>();

    public void setExplore(List<Explore> exploreList) {
        mExploreList.addAll(exploreList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_explore, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       /* Explore explore = mExploreList.get(position);
        holder.bind(explore);
        holder.title.setText(explore.getTitle());*/
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, detail,  price;
        ImageView image_url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            detail = itemView.findViewById(R.id.tour_detail);
            image_url = itemView.findViewById(R.id.image_tour);
            price = itemView.findViewById(R.id.price);
        }

        public void bind(Explore explore) {
         title.setText(explore.getTitle());
        }
    }
}
