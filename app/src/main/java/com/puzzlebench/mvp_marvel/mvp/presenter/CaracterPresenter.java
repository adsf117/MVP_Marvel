package com.puzzlebench.mvp_marvel.mvp.presenter;

import com.puzzlebench.mvp_marvel.GetItemsSuccessEvent;
import com.puzzlebench.mvp_marvel.adapters.CaracterAdapter;
import com.puzzlebench.mvp_marvel.mvp.model.CaracterModel;
import com.puzzlebench.mvp_marvel.mvp.view.CaracterView;
import com.squareup.otto.Subscribe;

/**
 * Created by andresdavid on 21/02/17.
 */

public class CaracterPresenter {

    private CaracterModel caracterModel;
    private CaracterView caracterView;

    public CaracterPresenter(CaracterModel caracterModel, CaracterView caracterView) {
        this.caracterModel = caracterModel;
        this.caracterView = caracterView;
        init();
    }

    private void init() {
        caracterModel.getCaracters();
    }

    @Subscribe
    public void onItemsSuccessEvent(GetItemsSuccessEvent event) {
        caracterView.setAdapter(new CaracterAdapter(event.getItemList()));
    }

}
