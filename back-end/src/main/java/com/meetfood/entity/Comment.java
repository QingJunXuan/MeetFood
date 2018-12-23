package com.meetfood.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer guest_id;
    private String text;//评论正文
    private Date time;
    private Integer dining_id;
    private Integer score;//guest评分

    public Integer getId(){ return id;}
    public void setId(Integer id){this.id = id;}

    public Integer getGuest_id(){ return guest_id;}
    public void setGuest_id(Integer guest_id){this.guest_id= guest_id;}

    public String getText(){ return text;}
    public void setText(String text){this.text = text;}

    public Date getTime(){ return time;}
    public void setTime(Date time){this.time = time;}

    public Integer getDining_id(){ return dining_id;}
    public void setDining_id(Integer dining_id){this.dining_id = dining_id;}

    public Integer getScore(){ return  score; }
    public void setScore(Integer score){this.score= score;}
}
