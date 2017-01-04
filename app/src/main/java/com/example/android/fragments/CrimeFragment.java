package com.example.android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by laurent on 1/4/17.
 */

public class CrimeFragment extends Fragment {
    private Crime mCrime;
    private EditText mTitleField;

    //Fragment.onCreate(...) and other Fragment lifecycle methods must be public because
    //they will be called by whatever activity is hosting the fragment.
    //
    //Similar to an activity, a fragment has a bundle to which it saves and retrieves its state.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    //Inflate fragment_crime.xml
    //and wire up the EditText to respond to user input.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
                // This space intentionally left blank
            }
        });

        return v;
    }

}
