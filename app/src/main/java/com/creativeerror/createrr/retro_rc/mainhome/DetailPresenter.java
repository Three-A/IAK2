package com.creativeerror.createrr.retro_rc.mainhome;

import android.content.Context;
import android.widget.Toast;

import com.creativeerror.createrr.retro_rc.R;
import com.creativeerror.createrr.retro_rc.maininteractor.InterfaceDetail;
import com.creativeerror.createrr.retro_rc.maininteractor.InterfaceInfo;
import com.creativeerror.createrr.retro_rc.mainview.DetailActivity;
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
 * Created by rezab on 15/05/2017.
 */

public class DetailPresenter implements InterfaceDetail {
    private InterfaceInfo InterfaceInfo;
    private ArrayList<HomeModel> mHomeModel;
    private List<ExampleRetro> mExampleExampleRetros;
    private Context mContext;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    private String ids;

    public DetailPresenter(DetailActivity interfaceMain2, Context mContext) {
        InterfaceInfo = interfaceMain2;
        this.mContext = mContext;
    }
    @Override
    public void getDataInfo(String id) {
        final String ids = id;
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
                String judul = mExampleExampleRetros.get(Integer.parseInt(ids)).getJudul();
                String tipe = mExampleExampleRetros.get(Integer.parseInt(ids)).getTentang();
                String isia = mExampleExampleRetros.get(Integer.parseInt(ids)).getIsi();
                InterfaceInfo.setinfo(judul,"\n Tipe : "+tipe+" \n Isi : "+isia);

            }

            @Override
            public void onFailure(Call<List<ExampleRetro>> call, Throwable t) {
                Toast.makeText(mContext, R.string.koneksierror, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
