package com.meetfood.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CollectionPK implements Serializable {
    private Integer dining_id;

    private Integer guest_id;

    public Integer getDining_id(){ return dining_id;}
    public void setDining_id(Integer dining_id){this.dining_id = dining_id;}

    public Integer getGuest_id(){ return guest_id;}
    public void setGuest_id(Integer guest_id){this.guest_id = guest_id;}

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result +((dining_id ==null) ? 0 : dining_id.hashCode());
        result = prime * result +((guest_id == null) ? 0 : guest_id.hashCode());

        return result;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        CollectionPK other = (CollectionPK) obj;
        if(dining_id == null){
            if(other.dining_id != null)
                return  false;
        }else if(!dining_id.equals(other.dining_id))
            return false;

        if(guest_id == null){
            if(other.guest_id != null)
                return  false;
        }else if(!guest_id.equals(other.guest_id))
            return false;

        return true;
    }
}
