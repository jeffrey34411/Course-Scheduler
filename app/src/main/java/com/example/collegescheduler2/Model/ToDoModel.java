package com.example.collegescheduler2.Model;

public class ToDoModel {
    private int id;
    private  Boolean status;
    private String date;
    private String task;
    public ToDoModel(String task, String date, Boolean status) {
        this.task = task;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
