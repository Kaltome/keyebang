package com.shg.keyebang.services.coursetable;

import com.shg.keyebang.model.Course;
import com.shg.keyebang.model.Todo;

import java.util.Map;

public abstract class CourseTableListener {
    public abstract void onSuccess(String message);
    public abstract void onFailure(String errMessage);
}
