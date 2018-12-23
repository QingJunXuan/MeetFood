package com.meetfood.controller;

import com.meetfood.repository.DishRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/dining/dish")
@Api(value = "DishController|菜品信息增删改查")
public class DishController {
    @Autowired
    private DishRepository dishRepository;

    //新建菜品

    //删除现有菜品

    //修改现有菜品

    //查看所有现有菜品

}
