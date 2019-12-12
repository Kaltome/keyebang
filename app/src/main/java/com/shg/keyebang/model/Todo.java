package com.shg.keyebang.model;

import java.util.Calendar;
import java.util.Date;
import cn.bmob.v3.BmobObject;
public class Todo extends BmobObject{
    private String todoTitle;
    private String todoMessage;
    private Calendar date;
    private int year;
    private int month;
    private int dayOfMonth;


    private User user;
    private Course course;
    private Course className;

    private User student;

    public Todo(String todoTitle, String todoMessage, Calendar date) {
        this.todoTitle = todoTitle;
        this.todoMessage = todoMessage;
        this.date = date;
    }

    public User getStudent(){
        return student;
    }
    public Todo setStudent(User student){
        this.student=student;
        return this;
    }
    //关联到user类
    public User getUser(){
        return user;

    }
    public Todo setUser(User user){
        this.user=user;
        return this;
    }
    //关联到course类
    public Course getCourse(){
        return course;
    }
    public Todo setCourse(Course course){
        this.course=course;
        return this;
    }

    public Course getClassName(){
        return className;
    }

    public Todo setClassName(Course className){
        this.className=className;
        return this;
    }
    public String getTodoTitle() {
        return todoTitle;
    }

    public Todo setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
        return this;
    }

    public String getTodoMessage() {
        return todoMessage;
    }

    public Todo setTodoMessage(String todoMessage) {
        this.todoMessage = todoMessage;
        return this;
    }

    public Calendar getDate() {
        return date;
    }

    public Todo setDate(Calendar date) {
        this.date = date;
        return this;
    }
    public Todo setYear(int year){
        this.year=year;
        return this;
    }

    public Todo setMonth(int month){
        this.month=month;
        return this;
    }

    public Todo setDayOfMonth(int dayOfMonth){
        this.dayOfMonth=dayOfMonth;
        return this;
    }


}
