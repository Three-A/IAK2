package com.creativeerror.createrr.retro_rc.mainview;
import android.text.TextUtils;

import com.creativeerror.createrr.retro_rc.maininteractor.InterfacePresenter;
import com.creativeerror.createrr.retro_rc.maininteractor.InterfaceMain;
/**
 * Created by rezab on 13/05/2017.
 */

public class MainPresenter implements InterfacePresenter{
    private InterfaceMain mInterface;
    public MainPresenter(MainActivity mainActivity) {
            this.mInterface = mainActivity;
    }

    @Override
    public void login(String username,String password){
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mInterface.messageempty();
        } else {
            if(username.equals("yudha")&& password.equals("patria")) {
                mInterface.loginsukses(username);
            } else {
                mInterface.messageinvalid();
            }
        }
    }
}
