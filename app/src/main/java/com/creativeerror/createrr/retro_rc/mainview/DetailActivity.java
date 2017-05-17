package com.creativeerror.createrr.retro_rc.mainview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.creativeerror.createrr.retro_rc.R;
import com.creativeerror.createrr.retro_rc.mainhome.DetailPresenter;
import com.creativeerror.createrr.retro_rc.maininteractor.InterfaceDetail;
import com.creativeerror.createrr.retro_rc.maininteractor.InterfaceInfo;
import com.creativeerror.createrr.retro_rc.model.ExampleRetro;

import java.util.List;

public class DetailActivity extends AppCompatActivity implements InterfaceInfo {
    private List<ExampleRetro> mExampleExampleRetros;
    private InterfaceDetail mHomeInterface;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    private TextView isi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(R.string.loading);
        Intent intent = getIntent();
        String i = intent.getStringExtra("id");
        mHomeInterface = new DetailPresenter(this,this);
        mHomeInterface.getDataInfo(i);
    }

    @Override
    public void next(int id) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void setinfo(String title, String body) {
        setTitle(title);
        isi = (TextView) findViewById(R.id.textView);
        isi.setText(body);
    }
}
