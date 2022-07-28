package com.example.finalproject.entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public",name="user")

public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="level")
    private int level;
    @Column(name="age")
    private int age;
    @Column(name="email")
    private String email;


    public user() {

    }

    public user(String name, String password, int age, String email) {
        this.name = name;
        this.password = password;
        this.level = 0;
        this.age = age;
        this.email = email;
    }


    @Override
    public String toString() {
        return "user{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", level=" + level +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
