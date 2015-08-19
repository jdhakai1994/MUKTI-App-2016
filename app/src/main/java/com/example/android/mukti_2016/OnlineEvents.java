package com.example.android.mukti_2016;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OnlineEvents extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private static final String TAG = "DescriptionFragmentData";

    private String eventNames[] = {"CODECRACKER", "ONLINE TREASURE HUNT", "DIGITAL FORTRESS", "FREE-PL", "FREEMEX" };
    private static final int[] IDS = { R.raw.codecracker, R.raw.oth, R.raw.digitalfortress, R.raw.freepl, R.raw.freemex};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_events);

        //remove the back caret
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        int i=0;
        while(i<eventNames.length){
            listDataHeader.add(eventNames[i]);
            i++;
        }

        // Adding child data
        List<String> codecracker = new ArrayList<String>();
        codecracker.add(loadChild(0));

        List<String> oth = new ArrayList<String>();
        oth.add(loadChild(0));

        List<String> digitalfortress = new ArrayList<String>();
        digitalfortress.add(loadChild(0));

        List<String> freepl = new ArrayList<String>();
        freepl.add(loadChild(0));

        List<String> freemex = new ArrayList<String>();
        freemex.add(loadChild(0));


        listDataChild.put(listDataHeader.get(0), codecracker); // Header, Child data
        listDataChild.put(listDataHeader.get(1), oth);
        listDataChild.put(listDataHeader.get(2), digitalfortress);
        listDataChild.put(listDataHeader.get(3), freepl);
        listDataChild.put(listDataHeader.get(4), freemex);

    }

    private String loadChild(int id) {



            InputStream inputStream = getApplicationContext().getResources().openRawResource(IDS[id]);
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

            return desc;

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_online_events, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
