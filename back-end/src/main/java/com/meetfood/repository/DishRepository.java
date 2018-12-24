package com.meetfood.repository;

import com.meetfood.entity.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishRepository extends CrudRepository<Dish,Integer> {
    void deleteByDining_idAndName(Integer dining_id,String name);
    List<Dish> findByDining_id(Integer dining_id);
}
