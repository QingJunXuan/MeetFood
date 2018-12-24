package com.meetfood.repository;

import com.meetfood.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Integer> {
    List<Comment> findByGuest_id(Integer guest_id);
    List<Comment> findByDining_id(Integer dining_id);

}
