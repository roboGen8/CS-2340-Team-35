package com.example.ben.cs2340.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ben.cs2340.R;
import com.example.ben.cs2340.controllers.DonationDetailActivity;


import java.util.List;

public class DonationAdapter extends RecyclerView.Adapter<DonationAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public Button detailsButton;

        public ViewHolder(View itemView) {
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            detailsButton = (Button) itemView.findViewById(R.id.message_button);

        }
    }

    private List<Donation> donations;
    public DonationAdapter(List<Donation> list) {
        donations = list;
    }

    @Override
    public DonationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
    public void onBindViewHolder(DonationAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        final Donation donation = donations.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(donation.get_shortDescription());
        Button button = viewHolder.detailsButton;
        button.setText("Details");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openDonationDetail(v);
                Intent intent = new Intent(v.getContext(), DonationDetailActivity.class);
//                intent.putExtra("Donation", donation);
                v.getContext().startActivity(intent);
            }
        });
    }

    //delete this comment later

//    public void openLocationDetail(View v) {
//        Intent intent = new Intent(v.getContext(), LocationDetailActivity.class);
//        intent.putExtra("Donation"),
//        v.getContext().startActivity(intent);
//    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return donations.size();
    }
}
