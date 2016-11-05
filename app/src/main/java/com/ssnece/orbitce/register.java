package com.ssnece.orbitce;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class register extends android.support.v4.app.Fragment implements View.OnClickListener {

    Button gen;
    Button wor1,wor2;

    private OnFragmentInteractionListener mListener;


    public static register newInstance() {
        register fragment = new register();
        return fragment;
    }

    public register() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gen= (Button) getActivity().findViewById(R.id.button);
        wor1= (Button) getActivity().findViewById(R.id.button2);
        wor2= (Button) getActivity().findViewById(R.id.button3);
        gen.setOnClickListener(this);
        wor1.setOnClickListener(this);
        wor2.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
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

        if(v==gen)
        {
            Uri webpage=Uri.parse("http://www.orbitce.com/orbsite/register.php");
            Intent i=new Intent(Intent.ACTION_VIEW,webpage);
            startActivity(i);
        }
        else if (v==wor1)
        {

            Uri webpage=Uri.parse("http://www.orbitce.com/orbsite/work1reg.php");
            Intent i=new Intent(Intent.ACTION_VIEW,webpage);
            startActivity(i);
        }

        else if (v==wor2)
        {

            Uri webpage=Uri.parse("http://www.orbitce.com/orbsite/work2reg.php");
            Intent i=new Intent(Intent.ACTION_VIEW,webpage);
            startActivity(i);
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}
