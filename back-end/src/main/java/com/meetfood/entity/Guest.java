package com.meetfood.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;

@Entity // This tells Hibernate to make a table out of this class
public class Guest {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer age;
    private String username;
    private String email;
    private String password;
    private String teleNumber;
    private Blob photo;//头像

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeleNumber() {
        return teleNumber;
    }
    public void setTeleNumber(String teleNumber) {
        this.teleNumber = teleNumber;
    }

    public Blob getPhoto() {
        return photo;
    }
    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

}


