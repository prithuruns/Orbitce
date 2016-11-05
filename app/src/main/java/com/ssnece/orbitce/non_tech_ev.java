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

public class non_tech_ev extends Fragment implements
        View.OnClickListener,
        Mock.OnFragmentInteractionListener,
        Mguru.OnFragmentInteractionListener,
        Wizard.OnFragmentInteractionListener,
        onlinePhoto.OnFragmentInteractionListener,
        onlQuz.OnFragmentInteractionListener,
        treas.OnFragmentInteractionListener{

    private OnFragmentInteractionListener mListener;

    ImageButton mockp,mguru,tre,wiz,onlPho,onlQuz;

    public static non_tech_ev newInstance() {
        non_tech_ev fragment = new non_tech_ev();
        return fragment;
    }

    public non_tech_ev() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mockp=(ImageButton) getActivity().findViewById(R.id.mockp);
        mguru=(ImageButton) getActivity().findViewById(R.id.mguru);
        tre=(ImageButton) getActivity().findViewById(R.id.tre);
        wiz=(ImageButton) getActivity().findViewById(R.id.wizard);
        onlPho=(ImageButton) getActivity().findViewById(R.id.onlPho);
        onlQuz=(ImageButton) getActivity().findViewById(R.id.onlQuz);
        
        mockp.setOnClickListener(this);
        mguru.setOnClickListener(this);
        tre.setOnClickListener(this);
        wiz.setOnClickListener(this);
        onlPho.setOnClickListener(this);
        onlQuz.setOnClickListener(this);

        DisplayMetrics dsp=new DisplayMetrics();
        this.getActivity().getWindowManager().getDefaultDisplay().getMetrics(dsp);
        int wt=dsp.widthPixels;

        wt=wt/2;
        
        mockp.setMaxWidth(wt);
        mockp.setMaxHeight(wt);
        mockp.setAdjustViewBounds(true);
        mguru.setMaxWidth(wt);
        mguru.setMaxHeight(wt);
        mguru.setAdjustViewBounds(true);
        tre.setMaxWidth(wt);
        tre.setMaxHeight(wt);
        tre.setAdjustViewBounds(true);
        wiz.setMaxWidth(wt);
        wiz.setMaxHeight(wt);
        wiz.setAdjustViewBounds(true);
        onlPho.setMaxWidth(wt);
        onlPho.setMaxHeight(wt);
        onlPho.setAdjustViewBounds(true);
        onlQuz.setMaxWidth(wt);
        onlQuz.setMaxHeight(wt);
        onlQuz.setAdjustViewBounds(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_non_tech_ev, container, false);
        
        
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
        FragmentManager fragmentManager = getFragmentManager();

        if (v==mockp)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,Mock.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==mguru)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,Mguru.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==tre)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,treas.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==wiz)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,Wizard.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==onlPho)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container,onlinePhoto.newInstance())
                    .addToBackStack(null)
                    .commit();
        }
        else if(v==onlQuz)
        {
            fragmentManager.beginTransaction()
                    .replace(nav_draw.container, com.ssnece.orbitce.onlQuz.newInstance())
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
