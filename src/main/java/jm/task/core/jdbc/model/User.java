package jm.task.core.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
public class User {
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private int age;

    @Column
    private String birth;

    @Column
    private String gender;

    @Column
    private String country;

    public User() {
    }

    public User(String name, String lastName, int age, String birth, String gender, String country) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.birth = birth;
        this.gender = gender;
        this.country = country;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age +
                ", birth='" + birth +
                ", gender='" + gender +
                ", country='" + country + '\'' +
                '}';
    }
}

