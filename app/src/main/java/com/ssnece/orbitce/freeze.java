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

public class freeze extends Fragment {

    ImageView logo;
    TextView title,subtitle,desc,rules,prelims,inter,finals,organisers,prelimss,interr,finalss;
    private OnFragmentInteractionListener mListener;

    public static freeze newInstance() {
        freeze fragment = new freeze();
        return fragment;
    }

    public freeze() {
        // Required empty public constructor
    }

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
        desc=(TextView) getActivity().findViewById(R.id.description);
        prelims=(TextView) getActivity().findViewById(R.id.prelims);
        inter=(TextView) getActivity().findViewById(R.id.intermediate);
        rules=(TextView) getActivity().findViewById(R.id.rulescontent);
        finals=(TextView) getActivity().findViewById(R.id.finals);
        organisers=(TextView) getActivity().findViewById(R.id.organiserscontent);

        logo.setImageDrawable(getResources().getDrawable(R.mipmap.fre));
        title.setText(R.string.freezeTitle);
        subtitle.setText(R.string.freezeSubtitle);
        desc.setVisibility(View.INVISIBLE);
        desc.setText(R.string.freezeDesc);
        desc.setHeight(1);
        prelims.setText(R.string.freezePrelims);
        prelims.setVisibility(View.INVISIBLE);
        prelims.setHeight(1);
        inter.setText(R.string.freezeInter);
        inter.setHeight(1);
        inter.setVisibility(View.INVISIBLE);
        rules.setText(R.string.freezeRules);
        finals.setText(R.string.freezeFinal);
        finals.setVisibility(View.INVISIBLE);
        finals.setHeight(1);
        organisers.setText(R.string.freezeOrganizers);

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
