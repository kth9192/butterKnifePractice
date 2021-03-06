package com.example.butterknifeexam;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kth919 on 2017-03-07.
 */

public class ListModel implements listInteractor {

    private static String TAG = ListModel.class.getName();

    private listInteractor.Interactor mInteractor;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference();
    private DatabaseReference bindingInstance = myRef.child("imgMeta");

    private ArrayList<String> listName = new ArrayList<>();
    private ArrayList<String> listUrl = new ArrayList<>();
    private ArrayList<String> listDesc = new ArrayList<>();

    public ListModel(listInteractor.Interactor mInteractor ) {
        this.mInteractor = mInteractor;
    }

    @Override
    public void getList() {
        bindingInstance.addValueEventListener(new ValueEventListener() {

            int i =0;
             ArrayList<PictureInfo> mPictureInfo = new ArrayList<PictureInfo>();

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot jsonData : dataSnapshot.getChildren()){

                    listName.add(i, (String) jsonData.child("name").getValue());
                    listDesc.add(i, (String) jsonData.child("desc").getValue());
                    listUrl.add(i, (String) jsonData.child("url").getValue());

                    Log.d(TAG, (String) jsonData.child("name").getValue());
                    Log.d(TAG, (String) jsonData.child("desc").getValue());
                    Log.d(TAG, (String) jsonData.child("url").getValue());

                    mPictureInfo.add(new PictureInfo(listName.get(i), listDesc.get(i), listUrl.get(i)));
                    i++;

                }

                ReturnInfo(mPictureInfo);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "firebase call error" + String.valueOf(databaseError));
            }
        });
    }

    public void ReturnInfo(ArrayList<PictureInfo> pictureInfo){
        mInteractor.successCallData(pictureInfo);
    }


}
