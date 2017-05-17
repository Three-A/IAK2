package com.creativeerror.createrr.retro_rc.maininteractor;

import com.creativeerror.createrr.retro_rc.model.HomeModel;

import java.util.ArrayList;

/**
 * Created by rezab on 15/05/2017.
 */

public interface HomeInterface {
    void showList(ArrayList<HomeModel> homeModels);
    void getData();
}
