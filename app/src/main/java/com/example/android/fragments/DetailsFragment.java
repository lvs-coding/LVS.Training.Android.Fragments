package com.example.android.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Created by laurent on 4/4/17.
 */

public class DetailsFragment extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        Bundle bundle = this.getArguments();
        int movieTitleClickedPosition = bundle.getInt("movieTitleClickedPosition");

        textView = (TextView)view.findViewById(R.id.tv_movie_details);
        textView.setText(String.format("%s",Integer.toString(movieTitleClickedPosition)));



        return view;
    }
}
