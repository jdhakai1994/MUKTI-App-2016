package com.example.android.mukti_2016;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescriptionFragment extends Fragment {

    private TextView mHeading;
    private TextView mContent;

    private String eventNames[] = {"LIPI", "FANTASY SHOOTBALL", "INCANITY", "BEHIND THE SCENES", "CONNECTIFY-2048" };

    private static DescriptionFragmentData descriptionFragmentData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //get all description
        if (null == descriptionFragmentData) {

            descriptionFragmentData = new DescriptionFragmentData(getActivity());
        }
    }

    //change the display
    void updateDescriptionDisplay(int position) {

        //get a reference to the heading text view
        mHeading = (TextView) getView().findViewById(R.id.feed_heading);
        mHeading.setText(eventNames[position]);

        //get a reference to the content text view
        mContent = (TextView) getView().findViewById(R.id.feed_content);
        mContent.setText(descriptionFragmentData.getFeed(position));

    }

}
