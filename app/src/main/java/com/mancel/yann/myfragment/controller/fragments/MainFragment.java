package com.mancel.yann.myfragment.controller.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mancel.yann.myfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener{

    // INTERFACE -----------------------------------------------------------------------------------

    public interface OnButtonClickedListener {
        void onButtonClicked(View view);
    }

    // FIELDS --------------------------------------------------------------------------------------

    private Button mButtonHappy;
    private Button mButtonSad;
    private Button mButtonHorrible;
    private OnButtonClickedListener mCallback;

    // CONSTRUCTORS --------------------------------------------------------------------------------

    public MainFragment() {}

    // METHODS -------------------------------------------------------------------------------------

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Configures the callback to the parent activity
        this.configureCallbackToParentActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Configures the Button fields
        this.configureButtons(view);

        return view;
    }

    @Override
    public void onClick(View v) {
        // Spreads the click to the parent activity
        this.mCallback.onButtonClicked(v);
    }

    /**
     * Configures the Button fields thanks to the View object in argument
     *
     * @param view a View object that contains all the fragment
     */
    private void configureButtons(final View view) {
        // Initializes the Button fields
        this.mButtonHappy = (Button) view.findViewById(R.id.fragment_main_button_happy);
        this.mButtonSad = (Button) view.findViewById(R.id.fragment_main_button_sad);
        this.mButtonHorrible = (Button) view.findViewById(R.id.fragment_main_button_horrible);

        // Adds the Listener to the Button fields
        this.mButtonHappy.setOnClickListener(this);
        this.mButtonSad.setOnClickListener(this);
        this.mButtonHorrible.setOnClickListener(this);
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
