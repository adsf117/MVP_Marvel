package com.puzzlebench.mvp_marvel.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.puzzlebench.mvp_marvel.R;
import com.puzzlebench.mvp_marvel.service.ServiceUtils;
import com.puzzlebench.mvp_marvel.bus.BusProvider;
import com.puzzlebench.mvp_marvel.mvp.model.CaracterModel;
import com.puzzlebench.mvp_marvel.mvp.presenter.CaracterPresenter;
import com.puzzlebench.mvp_marvel.mvp.view.CaracterView;

import butterknife.ButterKnife;

public class CaracterActivity extends AppCompatActivity {

    CaracterPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new CaracterPresenter(new CaracterModel(ServiceUtils.getItemService()),new CaracterView(this));
    }
    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.unregister(presenter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.register(presenter);
    }

}
