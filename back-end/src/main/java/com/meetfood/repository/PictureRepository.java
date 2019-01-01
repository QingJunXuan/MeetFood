package com.meetfood.repository;

import com.meetfood.entity.Picture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PictureRepository extends CrudRepository<Picture,Integer> {
    @Query(value = "from Picture p where p.comment_id=:comment_id")
    List<Picture> findByComment_id(@Param("comment_id") Integer comment_id);
}
