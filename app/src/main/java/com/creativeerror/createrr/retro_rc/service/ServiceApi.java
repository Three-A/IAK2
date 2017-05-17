package com.creativeerror.createrr.retro_rc.service;

import com.creativeerror.createrr.retro_rc.model.ExampleRetro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rezab on 15/05/2017.
 */

public interface ServiceApi {
    String END_POINT = "questions";

    @GET("questions")
    Call<List<ExampleRetro>>getData();
}
