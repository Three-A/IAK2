package com.creativeerror.createrr.retro_rc.mainview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.creativeerror.createrr.retro_rc.R;
import com.creativeerror.createrr.retro_rc.adapter.HomeAdapter;
import com.creativeerror.createrr.retro_rc.mainhome.HomePresenter;
import com.creativeerror.createrr.retro_rc.maininteractor.InterfaceInfo;
import com.creativeerror.createrr.retro_rc.maininteractor.HomeInterface;
import com.creativeerror.createrr.retro_rc.model.HomeModel;
import com.creativeerror.createrr.retro_rc.model.ExampleRetro;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements InterfaceInfo {

    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;
    private HomeInterface mHomeInterface;
    private ArrayList<HomeModel> mHomeModel;
    private List<ExampleRetro> mExampleExampleRetros;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i = getIntent();
        setTitle("Welcome "+i.getStringExtra("username"));
        mHomeInterface = new HomePresenter(this,this);
        mHomeModel = new ArrayList<>();
        mHomeInterface.showList(mHomeModel);
        mHomeInterface.getData();

    }
    public void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mHomeAdapter = new HomeAdapter(this, mHomeModel);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public void setinfo(String title, String body) {

    }


    @Override
    public void next(int id) {
        Intent i = new Intent(this,DetailActivity.class);
        i.putExtra("id",id);
        startActivity(i);
    }
}
