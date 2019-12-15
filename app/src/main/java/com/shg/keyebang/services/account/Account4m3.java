package com.shg.keyebang.services.account;

import com.shg.keyebang.model.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
public class Account4m3 {

    public static void getInfo(final User user, GetInfoListener listener) {


        user.update(new UpdateListener(){
            @Override
            public void done(BmobException e) {
                if(e==null){
                    listener.onSuccess("添加数据成功");
                }else{
                    listener.onFailure("添加数据失败：" + e.getErrorCode()+ "-" + e.getMessage() );
                }
            }


        });
    }
}
