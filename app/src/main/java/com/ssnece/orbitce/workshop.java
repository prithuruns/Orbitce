package com.ssnece.orbitce;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class workshop extends Fragment implements View.OnClickListener,
        ethicalHacking.OnFragmentInteractionListener,
        Robotics.OnFragmentInteractionListener{

    private OnFragmentInteractionListener mListener;

    ImageButton air,aeh;

    public static workshop newInstance() {
        workshop fragment = new workshop();
        return fragment;
    }

    public workshop() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_workshops,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        air=(ImageButton) getActivity().findViewById(R.id.air);
        aeh=(ImageButton) getActivity().findViewById(R.id.aeh);

        air.setOnClickListener(this);
        aeh.setOnClickListener(this);
        DisplayMetrics dsp=new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dsp);
        int wt=dsp.widthPixels;

        wt=wt/2;

        air.setMaxWidth(wt);
        air.setMaxHeight(wt);
        air.setAdjustViewBounds(true);
        aeh.setMaxWidth(wt);
        aeh.setMaxHeight(wt);
        aeh.setAdjustViewBounds(true);
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();

        if (v==aeh)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,ethicalHacking.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==air)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,Robotics.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
