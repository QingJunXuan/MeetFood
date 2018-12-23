package com.meetfood.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Collection {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Integer dining_id;
    //private Integer guest_id;
    private CollectionPK id;
    private Date time;

    public CollectionPK getId(){return id;}
    public void setId(CollectionPK id){this.id = id;}

    public Date getTime(){ return time;}
    public void setTime(Date time){this.time = time;}
}
