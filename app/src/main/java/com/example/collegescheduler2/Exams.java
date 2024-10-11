package com.example.collegescheduler2;
import java.util.Comparator;
import java.util.Date;

public class Exams {
    private String name;
    private Date date;
    private String course;
    private String time;
    private String location;

    public Exams(String name, Date date, String course, String time, String location) {
        this.name = name;
        this.date = date;
        this.course = course;
        this.time = time;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static Comparator<Exams> dateASC = new Comparator<Exams>() {
        @Override
        public int compare(Exams exam1, Exams exam2) {
            Date date1 = exam1.getDate();
            Date date2 = exam2.getDate();

            return date1.compareTo(date2);
        }
    };

    public static Comparator<Exams> courseASC = new Comparator<Exams>() {
        @Override
        public int compare(Exams exam1, Exams exam2) {
            String course1 = exam1.getCourse();
            String course2 = exam1.getCourse();
            course1 = course1.toLowerCase();
            course2 = course2.toLowerCase();

            return course1.compareTo(course2);
        }
    };
}