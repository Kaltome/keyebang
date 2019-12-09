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
    private int hourOfDay;
    private int minute;

    private  Course className;

    public Todo(){
        this.setTableName("ClassTable");
    }
    public Todo(String todoTitle, String todoMessage, Calendar date) {
        this.todoTitle = todoTitle;
        this.todoMessage = todoMessage;
        this.date = date;
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

    public Todo setHourOfDay(int hourOfDay){
        this.hourOfDay=hourOfDay;
        return this;
    }
    public Todo setMinute(int minute){
        this.minute=minute;
        return this;
    }
}
