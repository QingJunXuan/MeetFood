package com.meetfood.repository;

import com.meetfood.entity.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish,Integer> {
}
