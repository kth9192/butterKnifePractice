package com.example.butterknifeexam;

import java.util.ArrayList;

/**
 * Created by kth919 on 2017-03-07.
 */

public interface listInteractor {

    void getList();

    interface Interactor{
        void successCallData(ArrayList<PictureInfo> pictureInfo);
        void failedCallData();
    }
}
