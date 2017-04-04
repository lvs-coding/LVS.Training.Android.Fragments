package com.example.android.fragments;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements MoviesFragment.OnMovieTitleClickedListener {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();


                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showActionBar(false);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);

        showActionBar(false);


        // Check whether the activity is using the layout version with
        // the fragment_container FrameLayout. If so, we must add the first fragment
        if (findViewById(R.id.fl_fragments_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create an instance of ExampleFragment
            MoviesFragment firstFragment = new MoviesFragment();

            // In case this activity was started with special instructions from an Intent,
            // pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_fragments_container, firstFragment).commit();
        }
    }

    private void showActionBar(boolean show) {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            if(show) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                return;
            }
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public void onMovieTitleClicked(int position) {
        Log.d("TAG",Integer.toString(position));

        Bundle bundle = new Bundle();
        bundle.putInt("movieTitleClickedPosition", position);

        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);

        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_fragments_container, detailsFragment)
                .addToBackStack(null)
                .commit();
        showActionBar(true);
    }
}
