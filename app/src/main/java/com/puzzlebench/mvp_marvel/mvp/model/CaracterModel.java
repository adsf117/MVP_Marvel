package com.puzzlebench.mvp_marvel.mvp.model;

import com.puzzlebench.mvp_marvel.service.CaracterService;

/**
 * Created by andresdavid on 21/02/17.
 */

public class CaracterModel {

    private CaracterService caracterService;

    public CaracterModel(CaracterService caracterService) {
        this.caracterService = caracterService;
    }

    public void getCaracters() {
        caracterService.getCaracters();
    }
}
