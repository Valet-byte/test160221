package com.abyte.valet.myapplication.model;

import java.io.Serializable;

public class Student implements Serializable {
    private int age, score;
    private String name, group;

    public Student(int age, String name, String group) {
        this.age = age;
        this.name = name;
        this.group = group;
        this.score = 0;
    }

    public String getAge() {
        return String.valueOf(age);
    }

    public String getScore() {
        return String.valueOf(score);
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
