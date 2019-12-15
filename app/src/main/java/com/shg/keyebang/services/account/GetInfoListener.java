package com.shg.keyebang.services.account;

import com.shg.keyebang.model.User;

public abstract class GetInfoListener {

    public abstract void onSuccess(String message);

    public abstract void onFailure(String errMessage);

}
