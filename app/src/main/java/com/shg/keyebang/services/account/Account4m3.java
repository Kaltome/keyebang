package com.shg.keyebang.services.account;

import com.shg.keyebang.model.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
public class Account4m3 {

    public static void getInfo(final User user, String password, String id4m3 , String password4m3, GetInfoListener listener) {

        user.setPassword(password);
        user.setId4m3(id4m3);
        user.setPassword4m3(password4m3);
        user.update(new UpdateListener(){
            @Override
            public void done(BmobException e) {
                if(e==null){
                    listener.onSuccess(user,"添加数据成功");
                }else{
                    listener.onFailure("添加数据失败：" + e.getErrorCode()+ "-" + e.getMessage() + "\n");
                }
            }


        });
    }
}
