package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private double averageGrade;

    @Override
    public String getPosition() {
        return "Студент";
    }

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public int getCourse() {
        return course;
    }


    public void incAverageGrade(double delta){
        double temp = getAverageGrade() + delta;
        setAverageGrade(temp);
        //averageGrade += delta;
    }

    public void setCourse(int value){
        this.course = value;
    }

    public void setAverageGrade(double value){
        this.averageGrade = value;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}