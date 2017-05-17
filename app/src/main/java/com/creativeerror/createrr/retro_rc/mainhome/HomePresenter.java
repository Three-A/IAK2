package com.creativeerror.createrr.retro_rc.mainhome;

import android.content.Context;
import android.widget.Toast;

import com.creativeerror.createrr.retro_rc.R;
import com.creativeerror.createrr.retro_rc.maininteractor.InterfaceInfo;
import com.creativeerror.createrr.retro_rc.maininteractor.HomeInterface;
import com.creativeerror.createrr.retro_rc.mainview.HomeActivity;
import com.creativeerror.createrr.retro_rc.model.HomeModel;
import com.creativeerror.createrr.retro_rc.model.ExampleRetro;
import com.creativeerror.createrr.retro_rc.service.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rezab on 14/05/2017.
 */

public class HomePresenter implements HomeInterface {
    private InterfaceInfo InterfaceInfo;
    private ArrayList<HomeModel> mHomeModel;
    private List<ExampleRetro> mExampleExampleRetros;
    private Context mContext;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    private String ids;
    public HomePresenter(HomeActivity interfaceMain2, Context mContext) {
        this.InterfaceInfo = interfaceMain2;
        this.mContext = mContext;
    }

    public HomePresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void showList(ArrayList<HomeModel> homeModels) {
        mHomeModel = homeModels;
    }

    @Override
    public void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceApi serviceApi = retrofit.create(ServiceApi.class);
        Call<List<ExampleRetro>> call = serviceApi.getData();
        call.enqueue(new Callback<List<ExampleRetro>>() {
            @Override
            public void onResponse(Call<List<ExampleRetro>> call, Response<List<ExampleRetro>> response) {
                mExampleExampleRetros = response.body();
                for (int i = 0; i < mExampleExampleRetros.size() ; i++) {
                    String judul = mExampleExampleRetros.get(i).getJudul();
                    String tipe = mExampleExampleRetros.get(i).getTentang();
                    mHomeModel.add(new HomeModel(judul,"Tipe :"+tipe,"Klik Untuk Informasi Lebih Lanjut",""));
                }
                InterfaceInfo.initView();

            }

            @Override
            public void onFailure(Call<List<ExampleRetro>> call, Throwable t) {
                Toast.makeText(mContext, R.string.koneksierror, Toast.LENGTH_SHORT).show();
            }
        });
    }
    

}
