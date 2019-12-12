package com.shg.keyebang.services.coursetable;

import com.shg.keyebang.model.Course;
import com.shg.keyebang.model.Todo;
import com.shg.keyebang.model.User;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;


public class TodoTable {

    public static void setTodo(final Todo todo, String className, String todoTitle, String todoMessage, int year, int month, int dayOfMonth, CourseTableListener listener){


        Course course =new Course();//关联到course类
        course.setClassName(className);
        todo.setClassName(course);
        //
        todo.setYear(year);
        todo.setMonth(month);
        todo.setDayOfMonth(dayOfMonth);
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

    public static void getTodo(Course course,GetTodoListener listener){
        BmobQuery<Todo> query =new BmobQuery<>();
        query.addWhereEqualTo("className",new BmobPointer(course));
        query.include("user,course.student");
        query.findObjects(new FindListener<Todo>() {
            @Override
            public void done(List<Todo> object, BmobException e) {
                if(e==null){
                    listener.onSuccess("查询成功" + object.size()+"条数据");
                }else{
                    listener.onFailure("查询失败"+e.getMessage()+e.getErrorCode());
                }
            }
        });
    }
}
