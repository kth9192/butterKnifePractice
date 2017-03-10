package com.example.butterknifeexam;


import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by kth919 on 2017-03-07.
 */

public class ListPresenterImpl implements listPresenter, listInteractor.Interactor {

    private mainView mainView;
    private listInteractor mlistInteractor;
    private ListModel listModel;

    protected ListPresenterImpl(mainView mmainView) {
        this.mainView = mmainView;
        listModel = new ListModel(this);
    }

    @Override
    public void ListCall() {
        listModel.getList();
    }

    @Override
    public void successCallData(ArrayList<PictureInfo> pictureInfo ) {
        mainView.recyclerHandler(pictureInfo);
    }

    @Override
    public void failedCallData() {

    }
}
