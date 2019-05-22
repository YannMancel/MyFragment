package com.mancel.yann.myfragment.controller.fragments;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.mancel.yann.myfragment.R;

import butterknife.BindView;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class MainFragment extends BaseFragment implements View.OnClickListener{

    // INTERFACE -----------------------------------------------------------------------------------

    public interface OnButtonClickedListener {
        void onButtonClicked(View view);
    }

    // FIELDS --------------------------------------------------------------------------------------

    @BindView(R.id.fragment_main_button_happy) Button mButtonHappy;
    @BindView(R.id.fragment_main_button_sad) Button mButtonSad;
    @BindView(R.id.fragment_main_button_horrible) Button mButtonHorrible;

    private OnButtonClickedListener mCallback;

    // CONSTRUCTORS --------------------------------------------------------------------------------

    public MainFragment() {}

    // METHODS -------------------------------------------------------------------------------------

    @Override
    protected BaseFragment newInstance() {
        return new MainFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    protected void configureDesign() {
        // Adds the Listener to the Button fields
        this.mButtonHappy.setOnClickListener(this);
        this.mButtonSad.setOnClickListener(this);
        this.mButtonHorrible.setOnClickListener(this);
    }

    @Override
    protected void updateDesign() {}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Configures the callback to the parent activity
        this.configureCallbackToParentActivity();
    }

    @Override
    public void onClick(View v) {
        // Spreads the click to the parent activity
        this.mCallback.onButtonClicked(v);
    }

    /**
     * Configures the callback to the parent activity
     */
    private void configureCallbackToParentActivity() {
        // Initializes the callback field
        try {
            this.mCallback = (OnButtonClickedListener) getActivity();
        }
        catch (ClassCastException e){
            throw new ClassCastException(e.toString() + " must implement OnButtonClickedListener");
        }
    }
}
