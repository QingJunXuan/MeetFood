package com.meetfood.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;

@Entity
public class Dining {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer price;
    private String email;
    private String password;
    private String type;
    private float grade;//评分
    private String name;
    private String intro;
    private String tel;
    private String address;
    private Integer collections;//收藏数
    private Blob icon;
    private Date time;//创建时间

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getPassword(){return password;}
    public void  setPassword(String password){this.password = password;}

    public String getType(){return type;}
    public void setType(String type){this.type =type;}

    public float getGrade() {
        return grade;
    }
    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }
    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCollections(){return collections;}
    public void setCollections(Integer collections){this.collections=collections;}

    public Blob getIcon() {
        return icon;
    }
    public void setIcon(Blob icon) {
        this.icon = icon;
    }

    public Date getTime(){return time;}
    public void setTime(Date time){this.time= time;}
}
