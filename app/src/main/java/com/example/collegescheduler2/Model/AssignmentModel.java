package com.example.collegescheduler2.Model;

import com.example.collegescheduler2.Assignments;

import java.util.Comparator;
import java.util.Date;
import java.util.Calendar;

public class AssignmentModel {
    private String name;
    private String section;
    private String date;
    private  Boolean status;

    public AssignmentModel(String name, String section, String date, Boolean status){
        this.name = name;
        this.section = section;
        this.date = date;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public static Comparator<Assignments> secASC = new Comparator<Assignments>() {
        @Override
        public int compare(Assignments assignment1, Assignments assignment2) {
            int sec1 = Integer.valueOf(assignment1.getSection());
            int sec2 = Integer.valueOf(assignment2.getSection());

            return Integer.compare(sec1, sec2);
        }
    };

    public static Comparator<Assignments> dateASC = new Comparator<Assignments>() {
        @Override
        public int compare(Assignments assignment1, Assignments assignment2) {
            Date date1 = assignment1.getDate();
            Date date2 = assignment2.getDate();

            return date1.compareTo(date2);
        }
    };
}
