package com.mancel.yann.myfragment.controller.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.mancel.yann.myfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    // FIELDS --------------------------------------------------------------------------------------

    @BindView(R.id.toolbar) Toolbar mToolbar;

    // METHODS -------------------------------------------------------------------------------------

    protected abstract int getActivityLayout();
    protected abstract void configureDesign();
    protected abstract void updateDesign();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associates the layout file to this class
        setContentView(this.getActivityLayout());

        // Using the ButterKnife library
        ButterKnife.bind(this);

        // Configures the ToolBar field
        this.configureToolBar();

        // Configures the design
        this.configureDesign();
    }

    /**
     * Configures the ToolBar field
     */
    private void configureToolBar() {
        // Adds the ToolBar field to the activity
        setSupportActionBar(this.mToolbar);
    }
}
