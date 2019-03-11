package ru.sberbank.homework19;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(mName, person.mName) &&
                Objects.equals(mSurname, person.mSurname) &&
                Objects.equals(mPatronymic, person.mPatronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mName, mSurname, mPatronymic);
    }
}
