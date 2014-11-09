package com.example.mbarrben.rxjavasample.ui;

import com.example.mbarrben.rxjavasample.R;
import com.example.mbarrben.rxjavasample.io.MovieAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends Activity {

    @InjectView(R.id.list)
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        new MovieAdapter().create().getMovies("batman")
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> list.setAdapter(new MovieListAdapter(MainActivity.this, movies)));
    }

}
