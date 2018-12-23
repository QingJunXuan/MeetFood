package com.meetfood.repository;

import com.meetfood.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called guestRepository
// CRUD refers Create, Read, Update, Delete

public interface GuestRepository extends CrudRepository<Guest, Integer> {
    //@Query(value = "from Guest u where u.email=:email")
    List<Guest> findByEmail(@Param("email") String email);
    List<Guest> findByEmailAndPassword(@Param("email") String email,
                                       @Param("password") String password);
}
