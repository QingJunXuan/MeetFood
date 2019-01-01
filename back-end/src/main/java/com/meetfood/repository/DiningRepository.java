package com.meetfood.repository;

import com.meetfood.entity.Dining;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DiningRepository extends CrudRepository<Dining,Integer> {
    @Query(value = "from  Dining d where d.email=:email")
    List<Dining> findByEmail(@Param("email") String email);
    @Query(value = "from Dining d where d.email=:email and d.password=:password")
    List<Dining> findByEmailAndPassword(@Param("email") String email,
                                       @Param("password") String password);
    @Query(value = "from Dining d where d.id=:id")
    List<Dining> viewById(@Param("id") Integer id);

    @Query(value = "update Dining d  set d.name=:name where d.id=:id")
    void updateDining(@Param("id") Integer id);
}
