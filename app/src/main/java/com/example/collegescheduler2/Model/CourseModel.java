package com.example.collegescheduler2.Model;

import java.util.Comparator;
import java.util.Date;
import java.util.Calendar;

public class CourseModel {
    private String name;
    private String section;
    private String location;
    private String date;
    private Calendar calendar;
    private  Boolean status;

    public CourseModel(String name, String section, String location, String date, Boolean status) {
        this.section = section;
        this.name = name;
        this.date = date;
        this.status = status;
        this.location = location;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public Calendar getCalendar(){
        return calendar;
    }

    public void setCalendar(){
        calendar.set(Calendar.MONTH, Integer.parseInt("1"));
        calendar.set(Calendar.DATE, Integer.parseInt("1"));
        calendar.set(Calendar.YEAR, Integer.parseInt("1"));
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

    public static Comparator<com.example.collegescheduler2.Course> sectionASC = new Comparator<com.example.collegescheduler2.Course>() {
        @Override
        public int compare(com.example.collegescheduler2.Course course1, com.example.collegescheduler2.Course course2) {
            int sec1 = Integer.valueOf(course1.getSection());
            int sec2 = Integer.valueOf(course2.getSection());

            return Integer.compare(sec1, sec2);
        }
    };

    public static Comparator<com.example.collegescheduler2.Course> nameASC = new Comparator<com.example.collegescheduler2.Course>() {
        @Override
        public int compare(com.example.collegescheduler2.Course course1, com.example.collegescheduler2.Course course2) {
            String name1 = course1.getName();
            String name2 = course2.getName();
            name1 = name1.toLowerCase();
            name2 = name2.toLowerCase();

            return name1.compareTo(name2);
        }
    };

    public static Comparator<com.example.collegescheduler2.Course> dateASC = new Comparator<com.example.collegescheduler2.Course>() {
        @Override
        public int compare(com.example.collegescheduler2.Course course1, com.example.collegescheduler2.Course course2) {
            Date date1 = course1.getDate();
            Date date2 = course2.getDate();

            return date1.compareTo(date2);
        }
    };
}
