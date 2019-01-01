package com.meetfood.repository;

import com.meetfood.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Integer> {

    @Query(value = "from Comment c where c.guest_id=:guest_id")
    List<Comment> findByGuest_id(@Param("guest_id") Integer guest_id);

    @Query(value = "from  Comment c where c.dining_id=:dining_id")
    List<Comment> findByDining_id(@Param("dining_id") Integer dining_id);

}
