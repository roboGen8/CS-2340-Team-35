package com.example.ben.cs2340.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ben.cs2340.R;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public LocationAdapter(Context context, ArrayList<String> locationNames, ArrayList<String> images) {
        mContext = context;
        mImages = images;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
//        public Button detailsButton;
        public RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
//            detailsButton = (Button) itemView.findViewById(R.id.message_button);
            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);

        }
    }

    private List<Location> locations;
    public LocationAdapter(List<Location> list) {
        locations = list;
    }

    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_location, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(LocationAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Location location = locations.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(location.getName());
//        Button button = viewHolder.detailsButton;
//        button.setText("Details");

//        Glide.with(mContext)
//                .asBitmap()
//                .load(mImages.get(position))
//                .into(viewHolder.image);

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View contactView) {
//                Toast.makeText(mContext, location.get(position), Toast.LENGTH_SHORT).show();
                Toast.makeText(mContext, "yeet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return locations.size();
    }
}
