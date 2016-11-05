package com.ssnece.orbitce;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class Events extends Fragment implements View.OnClickListener,
        tech_ev.OnFragmentInteractionListener,
        Scribblers.OnFragmentInteractionListener,
        Circuitrix.OnFragmentInteractionListener,
        ClashOfCircuits.OnFragmentInteractionListener,
        Electropati.OnFragmentInteractionListener,
        DomainMasters.OnFragmentInteractionListener,
        ProjectDisplay.OnFragmentInteractionListener,
        Riscit.OnFragmentInteractionListener,
        Solderit.OnFragmentInteractionListener,
        non_tech_ev.OnFragmentInteractionListener,
        Mock.OnFragmentInteractionListener,
        Mguru.OnFragmentInteractionListener,
        Wizard.OnFragmentInteractionListener,
        ethicalHacking.OnFragmentInteractionListener,
        Robotics.OnFragmentInteractionListener,
        Wired.OnFragmentInteractionListener,
        freeze.OnFragmentInteractionListener,
        silico.OnFragmentInteractionListener,
        panto.OnFragmentInteractionListener,
        onlinePhoto.OnFragmentInteractionListener,
        onlQuz.OnFragmentInteractionListener,
        treas.OnFragmentInteractionListener,
        workshop.OnFragmentInteractionListener
{

    private OnFragmentInteractionListener mListener;

    ImageButton tech,nonTech,work;

    public static Events newInstance() {
        Events fragment = new Events();
        return fragment;
    }

    public Events() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tech=(ImageButton)getActivity().findViewById(R.id.ImageButton);
        nonTech=(ImageButton)getActivity().findViewById(R.id.ImageButton1);
        work=(ImageButton)getActivity().findViewById(R.id.ImageButton2);
        tech.setOnClickListener(this);
        nonTech.setOnClickListener(this);
        work.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
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

        FragmentManager fragmentManager=getFragmentManager();
        if(v==tech)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,tech_ev.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if (v==nonTech)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,non_tech_ev.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,workshop.newInstance())
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
