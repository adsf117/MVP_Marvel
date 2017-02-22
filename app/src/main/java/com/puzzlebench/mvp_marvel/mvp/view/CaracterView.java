package com.puzzlebench.mvp_marvel.mvp.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.puzzlebench.mvp_marvel.ui.ActivityView;
import com.puzzlebench.mvp_marvel.ui.CaracterActivity;
import com.puzzlebench.mvp_marvel.R;
import com.puzzlebench.mvp_marvel.adapters.CaracterAdapter;
import com.puzzlebench.mvp_marvel.models.Result;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andresdavid on 21/02/17.
 */

public class CaracterView extends ActivityView<CaracterActivity> {

    @BindView(R.id.my_recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar) ProgressBar progressBar;



    public CaracterView(CaracterActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
        recyclerView.setAdapter(new CaracterAdapter(new ArrayList<Result>()));
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
    }

    public void setAdapter(CaracterAdapter adapter) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setAdapter(adapter);
        recyclerView.invalidate();
    }
}
