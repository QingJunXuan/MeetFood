package com.meetfood.entity;

import io.swagger.models.auth.In;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.sql.Timestamp;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer dining_id;
    private Date order_time;//guest下订单时间
    private Date repast_time;//guest选择的就餐时间
    private Integer guest_id;
    private Integer state;

    public Integer getId(){ return id;}
    public void setId(Integer id){this.id = id;}

    public Integer getDining_id(){ return dining_id;}
    public void setDining_id(Integer dining_id){this.dining_id = dining_id;}

    public Date getOrder_time(){ return order_time;}
    public void setOrder_time(Date order_time){this.order_time = order_time;}

    public Date getRepast_time(){ return repast_time;}
    public void setRepast_time(Date repast_time){this.repast_time = repast_time;}

    public Integer getGuest_id(){ return guest_id;}
    public void setGuest_id(Integer guest_id){this.guest_id = guest_id;}

    public Integer getState(){ return state;}
    public void setState(Integer state){this.state = state;}

}
