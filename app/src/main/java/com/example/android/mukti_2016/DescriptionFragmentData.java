package com.example.android.mukti_2016;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DescriptionFragmentData {
    private static final String TAG = "DescriptionFragmentData";
    private static final int[] IDS = { R.raw.lipi, R.raw.fantasyshootball, R.raw.incanity, R.raw.behindthescenes, R.raw.connectify};

    private SparseArray<String> mdesc = new SparseArray<String>();
    private Context mContext;


    public DescriptionFragmentData(Context context) {
        mContext = context;
        loadFeeds();
    }

    private void loadFeeds() {

        for (int id : IDS) {

            InputStream inputStream = mContext.getResources().openRawResource(id);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer buffer = new StringBuffer("");


            // Read raw data from resource file

            try {

                String line = "";
                while ((line = reader.readLine()) != null) {

                    buffer.append(line);
                }

            } catch (IOException e) {
                Log.i(TAG, "IOException");
            }

            // Convert raw data into a String
            String desc = buffer.toString();

            mdesc.put(id, desc);

        }
    }

    String getFeed (int position) {

        return mdesc.get(IDS[position]);

    }

}
