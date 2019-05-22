package com.mancel.yann.myfragment.controller.activities;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mancel.yann.myfragment.R;
import com.mancel.yann.myfragment.controller.fragments.DetailFragment;
import com.mancel.yann.myfragment.controller.fragments.MainFragment;

public class MainActivity extends BaseActivity implements MainFragment.OnButtonClickedListener {

    // FIELDS --------------------------------------------------------------------------------------

    private MainFragment mMainFragment;
    private DetailFragment mDetailFragment;

    // METHODS -------------------------------------------------------------------------------------

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void configureDesign() {
        // Configures and shows the MainFragment
        this.configureAndShowMainFragment();

        // Configures and shows the DetailFragment
        this.configureAndShowDetailFragment();
    }

    @Override
    protected void updateDesign() {}

    @Override
    public void onButtonClicked(View view) {
        // Retrieves the tag corresponding to the View object in parameter
        final int buttonTag =  Integer.parseInt(view.getTag().toString());

        // Just if the DetailFragment is displayed
        if (this.mDetailFragment != null && this.mDetailFragment.isVisible()) {
            // Launches the DetailActivity class
            this.mDetailFragment.updateTextView(buttonTag);
        }
        else {
            // Launches the DetailActivity class
            this.launchDetailActivity(buttonTag);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Creates a MenuInflater object to add the menu xml file to this activity
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Depending on the item Id
        switch (item.getItemId()) {

            case R.id.menu_activity_main_params: {
                //Launches the ParamsActivity class
                this.launchParamsActivity();

                return true;
            }
            default: {
                return super.onOptionsItemSelected(item);
            }
        }
    }

    /**
     * Launches the DetailActivity class
     *
     * @param tag an integer that contains the tag value of the selected view
     */
    private void launchDetailActivity(final int tag) {
        // Creates an Intent object to connect the 2 activities
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);

        // Adds an Extra (integer value) into the Intent object
        intent.putExtra(DetailActivity.EXTRA_BUTTON_TAG, tag);

        // Launches the DetailActivity class
        startActivity(intent);
    }

    /**
     * Launches the ParamsActivity class
     */
    private void launchParamsActivity() {
        // Creates an Intent object to connect the 2 activities
        Intent intent = new Intent(MainActivity.this, ParamsActivity.class);

        // Launches the ParamsActivity class
        startActivity(intent);
    }

    /**
     * Configures and shows the MainFragment
     */
    private void configureAndShowMainFragment() {
        // Creates a Fragment object to retrieve the fragment [FragmentManager -> Fragment]
        this.mMainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.activity_main_fragment_main);

        // If the fragment is not displayed
        if (this.mMainFragment == null) {
            // Creates a MainFragment object
            this.mMainFragment = new MainFragment();

            // Adds the transaction to create the fragment [FragmentManager -> FragmentTransaction -> int]
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.activity_main_fragment_main, this.mMainFragment)
                                       .commit();
        }
    }

    /**
     * Configures and shows the DetailFragment
     */
    private void configureAndShowDetailFragment() {
        // Creates a Fragment object to retrieve the fragment [FragmentManager -> Fragment]
        this.mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.activity_main_fragment_detail);

        // If the fragment is not displayed and if it is possible (tablet mode)
        if (this.mDetailFragment == null && findViewById(R.id.activity_main_fragment_detail) != null) {
            // Creates a DetailFragment object
            this.mDetailFragment = new DetailFragment();

            // Adds the transaction to create the fragment [FragmentManager -> FragmentTransaction -> int]
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main_fragment_detail, this.mDetailFragment)
                    .commit();
        }
    }
}
