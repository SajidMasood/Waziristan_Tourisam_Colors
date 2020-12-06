package com.waziristan.tourisam.colors.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.waziristan.tourisam.colors.R;
import com.waziristan.tourisam.colors.activities.PlaceDescription;
import com.waziristan.tourisam.colors.model.PlaceInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TopSportAdapter extends RecyclerView.Adapter<TopSportAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerView";
    private Context mContext;
    private ArrayList<PlaceInfo> infoList;

    public TopSportAdapter(Context mContext, ArrayList<PlaceInfo> infoList) {
        this.mContext = mContext;
        this.infoList = infoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(infoList.get(position).getTopimage())
                .into(holder.mPlaceImage);
        holder.mPlaceName.setText(infoList.get(position).getName());
        holder.mPlaceSummary.setText(infoList.get(position).getSummary());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }



/*    @Override
    protected void onBindViewHolder(@NonNull final MyViewHolder viewHolder, final int position, @NonNull PlaceInfo place) {
        Glide.with(viewHolder.itemView.getContext()).load(place.getTopimage()).into(viewHolder.mPlaceImage);
        viewHolder.mPlaceName.setText(place.getName());
        viewHolder.mPlaceSummary.setText(place.getSummary());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaceInfo item = getItem(position);
                Intent mainIntent = new Intent(viewHolder.itemView.getContext(), PlaceDescription.class);
                mainIntent.putExtra("CLICKED_PLACE", item);
                viewHolder.itemView.getContext().startActivity(mainIntent);
            }
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    }*/

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView mPlaceImage;
        public TextView mPlaceName,mPlaceSummary;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mPlaceImage = itemView.findViewById(R.id.place_image);
            mPlaceName =  itemView.findViewById(R.id.place_name);
            mPlaceSummary = itemView.findViewById(R.id.place_summary);
        }
    }
}
