package com.meetfood.repository;

import com.meetfood.entity.Collection;
import com.meetfood.entity.CollectionPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CollectionRepository extends CrudRepository<Collection, CollectionPK> {
    List<Collection> findByGuest_id(Integer guest_id);
}
