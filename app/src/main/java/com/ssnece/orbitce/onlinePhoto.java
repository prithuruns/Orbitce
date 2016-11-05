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

public class onlinePhoto extends Fragment {

    ImageView logo;
    TextView title,subtitle,desc,rules,prelims,inter,finals,organisers;

    private OnFragmentInteractionListener mListener;

    public static onlinePhoto newInstance() {
        onlinePhoto fragment = new onlinePhoto();
        return fragment;
    }

    public onlinePhoto() {
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
        prelims=(TextView) getActivity().findViewById(R.id.prelims);
        inter=(TextView) getActivity().findViewById(R.id.intermediate);
        rules=(TextView) getActivity().findViewById(R.id.rules);
        finals=(TextView) getActivity().findViewById(R.id.finals);
        organisers=(TextView) getActivity().findViewById(R.id.organiserscontent);

        logo.setImageDrawable(getResources().getDrawable(R.mipmap.pho));
        title.setText(R.string.onlineTitle);
        subtitle.setText(R.string.onlineSubtitle);
        desc.setText(R.string.onlineDesc);
        prelims.setText(R.string.treasPrelims);
        prelims.setVisibility(View.INVISIBLE);
        prelims.setHeight(1);
        inter.setText(R.string.treasInter);
        inter.setHeight(1);
        inter.setVisibility(View.INVISIBLE);
        rules.setText(R.string.treasRules);
        rules.setHeight(1);
        rules.setVisibility(View.INVISIBLE);
        finals.setText(R.string.treasFinal);
        finals.setHeight(1);
        finals.setVisibility(View.INVISIBLE);
        organisers.setText(R.string.onlineOrganizers);

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
