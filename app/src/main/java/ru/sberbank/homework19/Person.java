package ru.sberbank.homework19;

import java.io.Serializable;

public class Person implements Serializable {

    private String mName;
    private String mSurname;
    private String mPatronymic;

    public Person() {
    }

    public Person(String name, String surname, String patronymic) {
        mName = name;
        mSurname = surname;
        mPatronymic = patronymic;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSurname() {
        return mSurname;
    }

    public void setSurname(String surname) {
        mSurname = surname;
    }

    public String getPatronymic() {
        return mPatronymic;
    }

    public void setPatronymic(String patronymic) {
        mPatronymic = patronymic;
    }

    public String getFullname() {
        return getName() + " " + getSurname() + " " + getPatronymic();
    }
}
