package com.example.android.mukti_2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //get a reference to the rootview
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //reference to the offline events text view
        ImageView offlineEvents = (ImageView) rootView.findViewById(R.id.offline_events_image);

        //reference to the online events text view
        ImageView onlineEvents = (ImageView) rootView.findViewById(R.id.online_events_image);

        //reference to the workshops events text view
        ImageView workshops = (ImageView) rootView.findViewById(R.id.workshops_image);

        //handling clicks on the offline events poster
        offlineEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent offlineIntent = new Intent(getActivity(),OfflineEvents.class);
                startActivity(offlineIntent);
            }
        });

        //handling clicks on the online events poster
        onlineEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent onlineIntent = new Intent(getActivity(),OnlineEvents.class);
                startActivity(onlineIntent);
            }
        });

        //handling clicks on the workshops poster
        workshops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent workshops = new Intent(getActivity(),Workshops.class);
                startActivity(workshops);
            }
        });

        return rootView;
    }
}
