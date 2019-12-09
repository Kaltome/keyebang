package com.shg.keyebang.services.account;


import com.shg.keyebang.model.User;

public abstract class PhoneSignUpLogInListener {
    public abstract void loginSuccess(String message);
    public abstract void signupSuccess(User user, String message);
    public abstract void onFailure(String errMessage);
}
