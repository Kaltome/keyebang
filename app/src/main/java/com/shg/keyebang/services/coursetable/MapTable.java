package com.shg.keyebang.services.coursetable;

import com.shg.keyebang.model.Course;
import com.shg.keyebang.model.Todo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTable {
    public static void courseMap( String className, String classPlace, String teacher,
                                  int weekday, int firstClass, int lastClass,CourseTableListener listener){
        Course course=new Course(className,classPlace,teacher,weekday,firstClass,lastClass);
        Map<Course, Todo> courseTable = new HashMap<>();
        courseTable.put(course,null);
    }
    public static void todoMap(Course course,String todoTitle, String todoMessage, int year,int month,int dayOfMonth,int hourOfDay,int minute){
        Calendar calendar = new GregorianCalendar(year,month,dayOfMonth,hourOfDay,minute);
        Todo todo = new Todo(todoTitle,todoMessage,calendar);
        Map<Course, Todo> courseTable = new HashMap<>();
        courseTable.put(course,todo);
    }
}
