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

public class Solderit extends Fragment {

    private OnFragmentInteractionListener mListener;

    ImageView logo;
    TextView title,subtitle,desc,rules,prelims,inter,finals,organisers;

    public static Solderit newInstance() {
        Solderit fragment = new Solderit();
        return fragment;
    }

    public Solderit() {
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

        logo= (ImageView) getActivity().findViewById(R.id.logo);
        title= (TextView) getActivity().findViewById(R.id.title);
        subtitle=(TextView) getActivity().findViewById(R.id.subtitle);
        desc=(TextView) getActivity().findViewById(R.id.descriptioncontent);
        prelims=(TextView) getActivity().findViewById(R.id.prelimscontent);
        inter=(TextView) getActivity().findViewById(R.id.intermediatecontent);
        rules=(TextView) getActivity().findViewById(R.id.rulescontent);
        finals=(TextView) getActivity().findViewById(R.id.finalscontent);
        organisers=(TextView) getActivity().findViewById(R.id.organiserscontent);

        logo.setImageDrawable(getResources().getDrawable(R.mipmap.sol));
        title.setText(R.string.solderitTitle);
        subtitle.setText(R.string.solderitSubtitle);
        desc.setText(R.string.solderitDesc);
        prelims.setText(R.string.solderitPrelims);
        inter.setText(R.string.solderitInter);
        rules.setText(R.string.solderitRules);
        finals.setText(        R.string.solderitFinal);
        organisers.setText(R.string.solderitOrganizers);

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
