package com.shg.keyebang.services.coursetable;

import com.shg.keyebang.model.Course;
import com.shg.keyebang.model.Todo;

import java.util.Map;

public abstract class GetClassListener {
    public abstract void onSuccess(Map<Course, Todo> table);
    public abstract void onFailure(String errMessage);
}
