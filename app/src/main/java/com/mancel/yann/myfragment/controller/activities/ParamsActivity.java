package com.mancel.yann.myfragment.controller.activities;

import android.support.v7.app.ActionBar;

import com.mancel.yann.myfragment.R;
import com.mancel.yann.myfragment.controller.fragments.ParamsFragment;

public class ParamsActivity extends BaseActivity {

    // FIELDS --------------------------------------------------------------------------------------

    private ParamsFragment mParamsFragment;

    // METHODS -------------------------------------------------------------------------------------

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_params;
    }

    @Override
    protected void configureDesign() {
        // Configures and shows the ParamsFragment
        this.configureAndShowParamsFragment();

        // Adds the Up button in the ToolBar
        this.addUpButtonIntoToolBar();
    }

    @Override
    protected void updateDesign() {}

    /**
     * Configures and shows the ParamsFragment
     */
    private void configureAndShowParamsFragment() {
        // Creates a Fragment object to retrieve the fragment [FragmentManager -> Fragment]
        this.mParamsFragment = (ParamsFragment) getSupportFragmentManager().findFragmentById(R.id.activity_params_fragment_params);

        // If the fragment is not displayed
        if (this.mParamsFragment == null) {
            // Creates a DetailFragment object
            this.mParamsFragment = new ParamsFragment();

            // Adds the transaction to create the fragment [FragmentManager -> FragmentTransaction -> int]
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_params_fragment_params, this.mParamsFragment)
                    .commit();
        }
    }

    /**
     * Adds the Up button in the ToolBar
     */
    private void addUpButtonIntoToolBar() {
        // Gets a Support ActionBar object corresponding to this ToolBar
        ActionBar actionBar = getSupportActionBar();

        // Enables the Up Button
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
