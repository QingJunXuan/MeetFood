package com.meetfood.repository;

import com.meetfood.entity.Dining;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiningRepository extends CrudRepository<Dining,Integer> {
    List<Dining> findByEmail(@Param("email") String email);
    List<Dining> findByEmailAndPassword(@Param("email") String email,
                                       @Param("password") String password);
}
