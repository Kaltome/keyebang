package com.shg.keyebang.services.coursetable;

import com.shg.keyebang.model.Course;
import com.shg.keyebang.model.Todo;
import com.shg.keyebang.model.User;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;


public class TodoTable {

    public static void setTodo(final Todo todo,Course course, String className, String todoTitle, String todoMessage, int year, int month, int dayOfMonth, int hourOfDay, int minute, CourseTableListener listener){

        User user = BmobUser.getCurrentUser(User.class);
        //Course course =new Course()//关联到course类
        course.setClassName(className);
        todo.setClassName(course);
        //
        todo.setYear(year);
        todo.setMonth(month);
        todo.setDayOfMonth(dayOfMonth);
        todo.setHourOfDay(hourOfDay);
        todo.setMinute(minute);
        todo.setTodoMessage(todoMessage);
        todo.setTodoTitle(todoTitle);
        todo.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

                if (e == null) { listener.onSuccess("添加数据成功" +s);}
                else{listener.onFailure("添加数据失败：" + e.getErrorCode()+ "-" + e.getMessage() + "\n");}
            }

        });
    }
}
