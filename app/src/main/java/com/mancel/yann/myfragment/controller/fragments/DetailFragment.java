package com.mancel.yann.myfragment.controller.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mancel.yann.myfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    // FIELDS --------------------------------------------------------------------------------------

    private TextView mTextView;
    private int mButtonTag;
    private static String BUNDLE_BUTTON_TAG = "com.mancel.yann.myfragment.controller.activities.BUNDLE_BUTTON_TAG";

    // CONSTRUCTORS --------------------------------------------------------------------------------

    public DetailFragment() {}

    // METHODS -------------------------------------------------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        // Configures the TextView field
        this.configureTextView(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Retrieves the saved data if possible
        if (savedInstanceState != null) {
            // Creates an integer that contains the retrieved data
            final int RestoredButtonTag = savedInstanceState.getInt(BUNDLE_BUTTON_TAG, 0);

            // Update the UI
            this.updateTextView(RestoredButtonTag);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        // Saves the button tag state
        outState.putInt(BUNDLE_BUTTON_TAG, this.mButtonTag);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }

    /**
     * Configures the TextView field thanks to the View object in argument
     */
    private void configureTextView(final View view) {
        // Initializes the TextView field
        this.mTextView = (TextView) view.findViewById(R.id.fragment_detail_text_view);
    }

    /**
     * Updates the UI
     *
     * @param tag an integer that contains the tag value of the selected view
     */
    public void updateTextView(final int tag) {
        // Initializes the integer field
        this.mButtonTag = tag;

        // Choice
        switch (tag) {
            case 10: {
                // Updates the TextView field
                this.mTextView.setText("Happy");
                break;
            }
            case 20: {
                // Updates the TextView field
                this.mTextView.setText("Sad");
                break;
            }
            case 30: {
                // Updates the TextView field
                this.mTextView.setText("Horrible");
                break;
            }
            default: {
                Log.e(getClass().getSimpleName(), "updateTextView: error of tag");
            }
        }
    }
}
