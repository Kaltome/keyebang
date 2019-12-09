package com.shg.keyebang.services.account;

import com.shg.keyebang.model.User;

public abstract class PhoneListener {

    public abstract void onFailure(String errMessage);
    public abstract void phoneSuccess( String message);

}
