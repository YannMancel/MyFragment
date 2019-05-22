package com.mancel.yann.myfragment.controller.fragments;

import com.mancel.yann.myfragment.R;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class ParamsFragment extends BaseFragment {

    // CONSTRUCTORS --------------------------------------------------------------------------------

    public ParamsFragment() {}

    // METHODS -------------------------------------------------------------------------------------

    @Override
    protected BaseFragment newInstance() {
        return new ParamsFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_params;
    }

    @Override
    protected void configureDesign() {}

    @Override
    protected void updateDesign() {}
}
