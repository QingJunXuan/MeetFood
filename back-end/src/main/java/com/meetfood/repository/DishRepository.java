package com.meetfood.repository;

import com.meetfood.entity.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DishRepository extends CrudRepository<Dish,Integer> {

    //@Query(value = "delete from Dish d where d.dining_id=:dining_id and d.name=:name")
    //void deleteByDining_idAndName(Integer dining_id,String name);

    @Query(value = "from Dish d where d.dining_id=:dining_id")
    List<Dish> findByDining_id(@Param("dining_id") Integer dining_id);
}
