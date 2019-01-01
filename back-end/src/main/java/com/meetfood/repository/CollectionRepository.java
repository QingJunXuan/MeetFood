package com.meetfood.repository;

import com.meetfood.entity.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollectionRepository extends CrudRepository<Collection,Integer> {
    @Query(value = "from Collection c where c.guest_id =:guest_id")
    List<Collection> findByGuest_id(@Param("guest_id") Integer guest_id);
}
