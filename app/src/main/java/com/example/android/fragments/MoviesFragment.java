package com.example.android.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;

import static java.util.Arrays.asList;

/**
 * Created by laurent on 4/4/17.
 */

public class MoviesFragment extends Fragment {
    OnMovieTitleClickedListener callback;

    // Container Activity must implement this interface
    public interface OnMovieTitleClickedListener {
        void onMovieTitleClicked(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            callback = (OnMovieTitleClickedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnListItemClickedListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_movies, container, false);

        ListView lvMovies = (ListView)v.findViewById(R.id.lv_movies);

        ArrayList<String> moviesList = new ArrayList<>(asList("pedro","Barnabé","Nestor","John"));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,moviesList);
        lvMovies.setAdapter(arrayAdapter);



        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                callback.onMovieTitleClicked(position);




            }
        });

        return v;
    }
}
