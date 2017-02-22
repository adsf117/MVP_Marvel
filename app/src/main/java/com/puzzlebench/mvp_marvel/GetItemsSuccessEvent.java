package com.puzzlebench.mvp_marvel;

import com.puzzlebench.mvp_marvel.models.Result;

import java.util.ArrayList;


/**
 * Created by andresdavid on 21/02/17.
 */

public class GetItemsSuccessEvent {
    ArrayList<Result> itemList;

    public GetItemsSuccessEvent(ArrayList<Result> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<Result> getItemList() {
        return  itemList;
    }
}
