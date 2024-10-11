package com.example.collegescheduler2;

import java.util.Date;
import java.util.Comparator;

public class Assignments {
    private String name;
    private String section;
    private Date date;

    public Assignments(String name, String section, Date date){
        this.name = name;
        this.section = section;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

