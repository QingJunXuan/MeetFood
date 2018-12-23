package com.meetfood.controller;

import com.meetfood.repository.CollectionRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/collection")
@Api(value = "CollectionController|客人收藏餐厅、查看已收藏餐厅")
public class CollectionController {
    @Autowired
    private CollectionRepository collectionRepository;

    //收藏餐厅
    

    //查看已收藏餐厅
}
