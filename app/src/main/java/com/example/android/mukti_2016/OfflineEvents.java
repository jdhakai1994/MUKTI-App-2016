package com.example.android.mukti_2016;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class OfflineEvents extends AppCompatActivity implements DetailsFragment.SelectionListener{

    //instance of details fragment which contains the detailed list of offline events
    private DetailsFragment mDetailsFragment;

    //instance of description fragment which displays the description of offline events
    private DescriptionFragment mDescriptionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the view of the empty layout. separate fragments are loaded later programmatically
        setContentView(R.layout.activity_offline_events);

        //remove the back caret
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        mDetailsFragment = new DetailsFragment();

        //load the detail fragment to the container
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, mDetailsFragment);
        fragmentTransaction.commit();
    }

    //method to load the description of the offline events
    public void onItemSelected(int position) {

        if (mDescriptionFragment == null)
            mDescriptionFragment = new DescriptionFragment();

        //replace the fragment_container with the description fragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //must use .replace instead of .add
        fragmentTransaction.replace(R.id.fragment_container, mDescriptionFragment);
        //adding the transaction to the backstack so it can be popped while using the back button
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        // execute transaction now absolutely necessary
        getFragmentManager().executePendingTransactions();

        // Update description display on based on the position selected with the method described in DescriptionFragment.java
        mDescriptionFragment.updateDescriptionDisplay(position);

    }

    //so that the back button replaces the description fragment with
    // the details fragment containing the list of offline events
    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getFragmentManager();
        if(fragmentManager.getBackStackEntryCount() > 0)
            fragmentManager.popBackStack();
        else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_offline_events, menu);

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
