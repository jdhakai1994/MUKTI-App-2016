package com.example.android.mukti_2016;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class DetailsFragment extends ListFragment {

    private static final String[] EVENTS = { "LIPI", "FANTASY SHOOTBALL", "INCANITY", "BEHIND THE SCENES", "CONNECTIFY-2048" };

    //must implement
    public interface SelectionListener {
        void onItemSelected(int position);
    }

    private SelectionListener mCallback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //create an array adapter
        ArrayAdapter<String> eventsAdapter = new ArrayAdapter<String>(getActivity(), R.layout.offline_events_row, EVENTS);

        //set the list adapter
        setListAdapter(eventsAdapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (SelectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement SelectionListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View view, int position, long id) {

        // Notify the hosting Activity (OfflineEvents.java) that a selection has been made.
        mCallback.onItemSelected(position);

    }

}
