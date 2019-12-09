package com.shg.keyebang.services.account;

import android.content.Context;
import android.content.SharedPreferences;

import com.shg.keyebang.MyApplication;
import com.shg.keyebang.model.User;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

public class Account {


    public static void logIn( String phoneNumber, String password,SignUpLogInListener listener){

        BmobUser.loginByAccount(phoneNumber, password, new LogInListener<User>() {

            @Override
            public void done(User user, BmobException e) {
                if(e==null){
                    listener.onSuccess(user, user.getUsername());
                }
                else {listener.onFailure("登录失败：" + e.getErrorCode()+ "-" + e.getMessage() + "\n" );}
            }
        });

    }

    public static void logOut(){
        SharedPreferences.Editor editor= MyApplication.getContext().getSharedPreferences("thisAccount", Context.MODE_PRIVATE).edit();
        editor.clear().apply();
        User.logOut();
    }


}
