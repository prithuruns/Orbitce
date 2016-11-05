package com.ssnece.orbitce;

import android.app.ActionBar;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class tech_ev extends Fragment implements View.OnClickListener,
        Scribblers.OnFragmentInteractionListener,
        Circuitrix.OnFragmentInteractionListener,
        ClashOfCircuits.OnFragmentInteractionListener,
        Electropati.OnFragmentInteractionListener,
        DomainMasters.OnFragmentInteractionListener,
        ProjectDisplay.OnFragmentInteractionListener,
        Riscit.OnFragmentInteractionListener,
        Solderit.OnFragmentInteractionListener,
        Wired.OnFragmentInteractionListener,
        freeze.OnFragmentInteractionListener,
        silico.OnFragmentInteractionListener,
        panto.OnFragmentInteractionListener
{

    private OnFragmentInteractionListener mListener;

    ImageButton scribblers,pd,circ,risc,panto,domainmasters,solderit,wired,coc,electro,freeze,silico;

    public static tech_ev newInstance() {
        tech_ev fragment = new tech_ev();
        return fragment;
    }

    public tech_ev() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        scribblers=(ImageButton) getActivity().findViewById(R.id.scribblers);
        pd=(ImageButton) getActivity().findViewById(R.id.pd);
        circ=(ImageButton) getActivity().findViewById(R.id.circ);
        risc=(ImageButton) getActivity().findViewById(R.id.risc);
        panto=(ImageButton) getActivity().findViewById(R.id.panto);
        domainmasters=(ImageButton) getActivity().findViewById(R.id.domainmasters);
        solderit=(ImageButton) getActivity().findViewById(R.id.solderit);
        wired=(ImageButton) getActivity().findViewById(R.id.wired);
        coc=(ImageButton) getActivity().findViewById(R.id.coc);
        electro=(ImageButton) getActivity().findViewById(R.id.electropati);
        freeze=(ImageButton) getActivity().findViewById(R.id.freezequiz);
        silico=(ImageButton) getActivity().findViewById(R.id.siliconundrum);

        scribblers.setOnClickListener(this);
        pd.setOnClickListener(this);
        circ.setOnClickListener(this);
        risc.setOnClickListener(this);
        panto.setOnClickListener(this);
        domainmasters.setOnClickListener(this);
        solderit.setOnClickListener(this);
        wired.setOnClickListener(this);
        coc.setOnClickListener(this);
        electro.setOnClickListener(this);
        freeze.setOnClickListener(this);
        silico.setOnClickListener(this);

        DisplayMetrics dsp=new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dsp);
        int wt=dsp.widthPixels;

        wt=wt/3;

        scribblers.setMaxWidth(wt);
        scribblers.setMaxHeight(wt);
        scribblers.setAdjustViewBounds(true);
        pd.setMaxWidth(wt);
        pd.setMaxHeight(wt);
        pd.setAdjustViewBounds(true);
        circ.setMaxWidth(wt);
        circ.setMaxHeight(wt);
        circ.setAdjustViewBounds(true);
        risc.setMaxWidth(wt);
        risc.setMaxHeight(wt);
        risc.setAdjustViewBounds(true);
        panto.setMaxWidth(wt);
        panto.setMaxHeight(wt);
        panto.setAdjustViewBounds(true);
        domainmasters.setMaxWidth(wt);
        domainmasters.setMaxHeight(wt);
        domainmasters.setAdjustViewBounds(true);
        solderit.setMaxWidth(wt);
        solderit.setMaxHeight(wt);
        solderit.setAdjustViewBounds(true);
        wired.setMaxWidth(wt);
        wired.setMaxHeight(wt);
        wired.setAdjustViewBounds(true);
        coc.setMaxWidth(wt);
        coc.setMaxHeight(wt);
        coc.setAdjustViewBounds(true);
        electro.setMaxWidth(wt);
        electro.setMaxHeight(wt);
        electro.setAdjustViewBounds(true);
        freeze.setMaxWidth(wt);
        freeze.setMaxHeight(wt);
        freeze.setAdjustViewBounds(true);
        silico.setMaxWidth(wt);
        silico.setMaxHeight(wt);
        silico.setAdjustViewBounds(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tech_ev, container, false);
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

        if (v==scribblers)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,Scribblers.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==pd)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,ProjectDisplay.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==circ)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,Circuitrix.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==risc)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,Riscit.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==panto)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container, com.ssnece.orbitce.panto.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==domainmasters)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,DomainMasters.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==solderit)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,Solderit.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==wired) {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container, Wired.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==coc)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,ClashOfCircuits.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==electro)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,Electropati.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==freeze)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container, com.ssnece.orbitce.freeze.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==silico)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container, com.ssnece.orbitce.silico.newInstance())
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
