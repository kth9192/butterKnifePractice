package com.example.butterknifeexam;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements mainView{

    private static String TAG = MainActivity.class.getName();

    private ListPresenterImpl mListPresenterImpl;

    @BindView(R.id.testBtn)
    Button testBtn;

    @BindView(R.id.recycler)
    RecyclerView picRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        LinearLayoutManager llm = new LinearLayoutManager(this);
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
        picRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mListPresenterImpl = new ListPresenterImpl(this);

        mListPresenterImpl.ListCall();

    }

    @OnClick(R.id.testBtn)
    public void submit(View view){
        if (view.getId() == R.id.testBtn) {

            Toast.makeText(this, "ㅋ", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void recyclerHandler(ArrayList<PictureInfo> pictureInfo) {

        KnifeRecyclerAdapter adapter = new KnifeRecyclerAdapter(pictureInfo, getApplicationContext());
         picRecyclerView.setAdapter(adapter);
    }
}
