package com.mancel.yann.myfragment.controller.fragments;

import android.util.Log;
import android.widget.TextView;

import com.mancel.yann.myfragment.R;

import butterknife.BindView;
import icepick.State;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class DetailFragment extends BaseFragment {

    // FIELDS --------------------------------------------------------------------------------------

    @BindView(R.id.fragment_detail_text_view) TextView mTextView;

    @State int mButtonTag;

    // CONSTRUCTORS --------------------------------------------------------------------------------

    public DetailFragment() {}

    // METHODS -------------------------------------------------------------------------------------

    @Override
    protected BaseFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void configureDesign() {}

    @Override
    protected void updateDesign() {
        // Updates the UI
        this.updateTextView(this.mButtonTag);
    }

    /**
     * Updates the UI
     *
     * @param tag an integer that contains the tag value of the selected view
     */
    public void updateTextView(final int tag) {
        // Initializes the integer field
        if (this.mButtonTag != tag) {
            this.mButtonTag = tag;
        }

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
