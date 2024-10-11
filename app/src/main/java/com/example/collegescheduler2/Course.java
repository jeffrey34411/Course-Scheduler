package com.example.collegescheduler2;

import java.util.Comparator;
import java.util.Date;
import java.util.Calendar;

public class Course {
    private String name;
    private String section;
    private Date date;
    private Calendar calendar;

    public Course(String section, String name, Date date){
        this.section = section;
        this.name = name;
        this.date = date;
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

    public Calendar getCalendar(){
        return calendar;
    }

    public void setCalendar(){
        calendar.set(Calendar.MONTH, Integer.parseInt("1"));
        calendar.set(Calendar.DATE, Integer.parseInt("1"));
        calendar.set(Calendar.YEAR, Integer.parseInt("1"));
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = calendar.getTime();
    }

    public static Comparator<Course> sectionASC = new Comparator<Course>() {
        @Override
        public int compare(Course course1, Course course2) {
            int sec1 = Integer.valueOf(course1.getSection());
            int sec2 = Integer.valueOf(course2.getSection());

            return Integer.compare(sec1, sec2);
        }
    };

    public static Comparator<Course> nameASC = new Comparator<Course>() {
        @Override
        public int compare(Course course1, Course course2) {
            String name1 = course1.getName();
            String name2 = course2.getName();
            name1 = name1.toLowerCase();
            name2 = name2.toLowerCase();

            return name1.compareTo(name2);
        }
    };

    public static Comparator<Course> dateASC = new Comparator<Course>() {
        @Override
        public int compare(Course course1, Course course2) {
            Date date1 = course1.getDate();
            Date date2 = course2.getDate();

            return date1.compareTo(date2);
        }
    };
}
