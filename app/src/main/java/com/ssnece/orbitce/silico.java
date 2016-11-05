package com.ssnece.orbitce;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class silico extends Fragment {

    ImageView logo;
    TextView title,subtitle,desc,rules,prelims,inter,finals,organisers;
    private OnFragmentInteractionListener mListener;


    public static silico newInstance() {
        silico fragment = new silico();
        return fragment;
    }

    public silico() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.events, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        logo = (ImageView) getActivity().findViewById(R.id.logo);
        title = (TextView) getActivity().findViewById(R.id.title);
        subtitle = (TextView) getActivity().findViewById(R.id.subtitle);
        desc = (TextView) getActivity().findViewById(R.id.descriptioncontent);
        prelims = (TextView) getActivity().findViewById(R.id.prelims);
        inter = (TextView) getActivity().findViewById(R.id.intermediate);
        rules = (TextView) getActivity().findViewById(R.id.rulescontent);
        finals = (TextView) getActivity().findViewById(R.id.finalscontent);
        organisers = (TextView) getActivity().findViewById(R.id.organiserscontent);

        logo.setImageDrawable(getResources().getDrawable(R.mipmap.pap));
        title.setText(R.string.silicoTitle);
        subtitle.setText(R.string.silicoSubtitle);
        desc.setText(R.string.silicoDesc);
        prelims.setVisibility(View.INVISIBLE);
        prelims.setText(R.string.silicoPrelims);
        prelims.setHeight(1);
        inter.setVisibility(View.INVISIBLE);
        inter.setHeight(1);
        inter.setText(R.string.silicoInter);
        rules.setText(R.string.silicoRules);
        finals.setText(R.string.silicoFinal);
        organisers.setText(R.string.silicoOrganizers);
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


    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}
