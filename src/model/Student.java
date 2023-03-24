package model;

import enums.Gender;

public class Student {
    private long id;
    private String fullName;
    private int age;
    private Gender gender;

    public Student(long id, String fullName, int age, Gender gender) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\nStudent { " +
                "\nid" + id +
                "\nfullName: " + fullName + '\'' +
                "\nage: " + age +
                "\ngender: " + gender +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    }
}
