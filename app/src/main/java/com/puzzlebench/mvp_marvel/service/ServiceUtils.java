package com.puzzlebench.mvp_marvel.service;

import com.puzzlebench.mvp_marvel.bus.BusProvider;
import com.puzzlebench.mvp_marvel.service.CaracterService;

/**
 * Created by andresdavid on 21/02/17.
 */

public class ServiceUtils {

    private static CaracterService caracterService;

    private ServiceUtils(){}

    public static final CaracterService getItemService() {
        if (caracterService == null) {
            caracterService = new CaracterService(BusProvider.getInstance());
        }
        return caracterService;
    }
}
