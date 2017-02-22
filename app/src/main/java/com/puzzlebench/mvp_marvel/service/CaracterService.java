package com.puzzlebench.mvp_marvel.service;

import android.util.Log;
import com.puzzlebench.mvp_marvel.GetItemsSuccessEvent;
import com.puzzlebench.mvp_marvel.models.Data;
import com.puzzlebench.mvp_marvel.models.MarvelResponse;
import com.puzzlebench.mvp_marvel.models.Result;
import com.squareup.otto.Bus;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by andresdavid on 21/02/17.
 */

public class CaracterService {

    private Bus bus;

    public CaracterService(Bus bus) {
        this.bus = bus;
    }


    public void getCaracters() {
        CaracterClient client = ServiceGenerator.createService(CaracterClient.class);

        Call<MarvelResponse<Data<ArrayList<Result>>>> call =
                client.getCharacter();

        call.enqueue(new Callback<MarvelResponse<Data<ArrayList<Result>>>>() {
            @Override
            public void onResponse(Call<MarvelResponse<Data<ArrayList<Result>>>> call, Response<MarvelResponse<Data<ArrayList<Result>>>> response) {
                bus.post(new GetItemsSuccessEvent(response.body().getData().getResults()));
            }

            @Override
            public void onFailure(Call<MarvelResponse<Data<ArrayList<Result>>>> call, Throwable t) {
                //Handle failure
                Log.e(CaracterService.class.getName(),t.getMessage());
            }
        });
    }

}
