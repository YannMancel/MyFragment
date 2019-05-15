package com.mancel.yann.myfragment.controller.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mancel.yann.myfragment.R;
import com.mancel.yann.myfragment.controller.fragments.DetailFragment;

public class DetailActivity extends AppCompatActivity {

    // FIELDS --------------------------------------------------------------------------------------

    private DetailFragment mDetailFragment;
    public static String EXTRA_BUTTON_TAG = "com.mancel.yann.myfragment.controller.activities.EXTRA_BUTTON_TAG";

    // METHODS -------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associates the layout file to this class
        setContentView(R.layout.activity_detail);

        // Configures and shows the DetailFragment
        this.configureAndShowDetailFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Retrieves the data of the Intent object
        this.retrieveIntent();
    }

    /**
     * Configures and shows the DetailFragment
     */
    private void configureAndShowDetailFragment() {
        // Creates a Fragment object to retrieve the fragment [FragmentManager -> Fragment]
        this.mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.activity_detail_fragment_detail);

        // If the fragment is not displayed
        if (this.mDetailFragment == null) {
            // Creates a DetailFragment object
            this.mDetailFragment = new DetailFragment();

            // Adds the transaction to create the fragment [FragmentManager -> FragmentTransaction -> int]
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.activity_detail_fragment_detail, this.mDetailFragment)
                                       .commit();
        }
    }

    /**
     * Retrieves the data of the Intent object
     */
    private void retrieveIntent() {
        // Retrieves the data of the Intent object (zero is an error in the updateTextView method
        final int tag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);

        // Updates the UI of the Detail fragment
        this.mDetailFragment.updateTextView(tag);
    }
}
