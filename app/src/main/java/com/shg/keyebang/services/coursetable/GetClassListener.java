package com.shg.keyebang.services.coursetable;

import com.shg.keyebang.model.Course;

public abstract class GetClassListener {
    public abstract void onSuccess(String message);
    public abstract void onFailure(String errMessage);
}
