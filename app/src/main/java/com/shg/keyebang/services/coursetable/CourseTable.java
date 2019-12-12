package com.shg.keyebang.services.coursetable;

import com.shg.keyebang.model.Course;

import com.shg.keyebang.model.User;

import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class CourseTable {


    public static void setClass(final Course course , String className, String classPlace, String teacher,
                                int weekday, int firstClass, int lastClass, CourseTableListener listener){

        User user= BmobUser.getCurrentUser(User.class);
        course.setStudent(user);//关联到user类
        course.setClassName(className);
        course.setClassPlace(classPlace);
        course.setTeacher(teacher);
        course.setWeekday(weekday);
        course.setFirstClass(firstClass);
        course.setLastClass(lastClass);
        course.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {

                if (e == null) { listener.onSuccess("添加数据成功" +s);}
                else{listener.onFailure("添加数据失败：" + e.getErrorCode()+ "-" + e.getMessage() + "\n");}
            }

        });

    }

    public static void getClass(GetClassListener listener){
        BmobQuery<Course> query =new BmobQuery<>();
        query.addWhereEqualTo("student",BmobUser.getCurrentUser(User.class));
        query.include("student");
        query.findObjects(new FindListener<Course>() {
            @Override
            public void done(List<Course> object, BmobException e) {
                if(e==null){
                    listener.onSuccess("查询成功" + object.size()+"条数据");
                }else{
                    listener.onFailure("查询失败"+e.getMessage()+e.getErrorCode());
                }
            }
        });
    }
}
