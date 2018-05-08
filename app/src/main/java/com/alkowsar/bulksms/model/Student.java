package com.alkowsar.bulksms.model;

public class Student {
    int id;
    String firstName;
    String lastName;
    String standard;

    public Student(int id, String firstName, String lastName, String standard) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.standard = standard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}
