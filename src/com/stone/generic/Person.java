package com.stone.generic;

import java.time.LocalDate;

public class Person {
    public enum Sex{
        MALE,FEMALE
    }

    public Person(String name, LocalDate birthday, Sex gender) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public String getEmailAddress() {
        return emailAddress;
    }

    public Sex getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public static int compareByAge(Person a,Person b){
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                '}';
    }
}