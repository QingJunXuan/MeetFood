package com.meetfood.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Blob;
import java.util.Date;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String intro;
    private String ingredient;//成分
    private Blob pic;
    private Date start_time;
    private Date stop_time;
    private Integer dining_id;

    private Integer getId(){ return id;}
    private void setId(Integer id){this.id = id;}

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

    public String getIngredient() {
        return ingredient;
    }
    public void setIngredient(String tel) {
        this.ingredient = ingredient;
    }

    public Blob getPic(){return pic;}
    public void  setPic( Blob pic){this.pic = pic;}

    public Date getStart_time(){return start_time;}
    public void setStart_time(Date start_time){this.start_time=start_time;}

    public Date getStop_time(){return  stop_time;}
    public void setStop_time(Date stop_time){this.stop_time=stop_time;}

    public Integer getDining_id(){ return dining_id;}
    public void setDining_id(Integer dining_id){this.dining_id= dining_id;}

}
