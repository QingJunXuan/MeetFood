package com.meetfood.repository;

import com.meetfood.entity.Picture;
import org.springframework.data.repository.CrudRepository;

public interface PictureRepository extends CrudRepository<Picture,Integer> {
}
