package com.example.android.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CrimeActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        //The FragmentManager is responsible for managing your fragments
        //and adding their views to the activity’s view hierarchy
        FragmentManager fm = getSupportFragmentManager();

        //Fragment transactions are used to add, remove, attach, detach, or replace fragments in the fragment
        //list. They are the heart of how you use fragments to compose and recompose screens at runtime. The
        //FragmentManager maintains a back stack of fragment transactions that you can navigate.
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new CrimeFragment();
            fm.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit();
        }

    }
}
