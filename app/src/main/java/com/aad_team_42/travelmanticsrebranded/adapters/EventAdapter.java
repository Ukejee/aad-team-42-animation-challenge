package com.aad_team_42.travelmanticsrebranded.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aad_team_42.travelmanticsrebranded.R;
import com.aad_team_42.travelmanticsrebranded.model.Event;
import com.aad_team_42.travelmanticsrebranded.model.Explore;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    List<Event> mEventDataList = new ArrayList<>();
    Context mContext;

    public void setEvent(List<Event> eventDataList, Context context) {
        mEventDataList.addAll(eventDataList);
        mContext = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event event = mEventDataList.get(position);
        holder.type.setText(event.getEvent());
        Glide.with(mContext).load(event.getImage()).centerCrop().into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mEventDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img_linear);
            type = itemView.findViewById(R.id.type);

        }

    }
}
