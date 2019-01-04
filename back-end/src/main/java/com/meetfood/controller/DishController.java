package com.meetfood.controller;

import com.meetfood.entity.Dish;
import com.meetfood.repository.DishRepository;
import com.meetfood.statusCode.JsonResult;
import com.meetfood.statusCode.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.util.Date;

@Controller
@CrossOrigin
@RequestMapping(path = "/dining/dish")
@Api(value = "DishController")
public class DishController {
    @Autowired
    private DishRepository dishRepository;

    //新建菜品
    @ResponseBody
    @PostMapping(path="/addDish")
    @ApiOperation(value="",notes="返回json/String")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType = "query",name="dining_id",value="餐厅id",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType = "query",name = "name",value = "菜品名称",required = true,dataType = "String"),
            @ApiImplicitParam( paramType = "query",name = "intro",value = "菜品简介",required = true,dataType = "String"),
            @ApiImplicitParam( paramType = "query",name = "ingredient",value = "菜品成分",required = true,dataType = "String"),
            @ApiImplicitParam( paramType = "query",name = "pic",value = "菜品图片",required = true,dataType = "Blob"),
            @ApiImplicitParam( paramType = "query",name = "start_time",value = "开始供应时间",required = true,dataType = "Date"),
            @ApiImplicitParam( paramType = "query",name = "stop_time",value = "停止供应时间",required = true,dataType = "Date")
    })
    public JsonResult addDish (@RequestParam Integer dining_id,
                               @RequestParam String name,
                               @RequestParam String intro,
                               @RequestParam String ingredient,
                               @RequestParam Blob pic,
                               @RequestParam Date start_time,
                               @RequestParam Date stop_time) {

        Dish dish = new Dish();
        dish.setDining_id(dining_id);
        dish.setName(name);
        dish.setIntro(intro);
        dish.setIngredient(ingredient);
        dish.setPic(pic);
        dish.setStart_time(start_time);
        dish.setStop_time(stop_time);

        try {
            dishRepository.save(dish);
        }catch (Exception e){
            return new JsonResult(StatusCode.SYS_ERROR.getCode(),new Date());
        }
        return new JsonResult(StatusCode.SUCCESS.getCode(),new Date());
    }

    //删除现有菜品
    @ResponseBody
    @DeleteMapping(path="/deleteDish")
    @ApiOperation(value="删除某种菜品",notes="返回json/String")
    @ApiImplicitParam( paramType ="query",name="id",value="菜品id",required=true,dataType="String")
    public JsonResult deleteDish (@RequestParam Integer id) {

        boolean exists = dishRepository.existsById(id);
        if(exists){
            try {
                dishRepository.deleteById(id);
            }catch (Exception e){
                return new JsonResult(StatusCode.SYS_ERROR.getCode(),new Date());
            }
            return new JsonResult(StatusCode.SUCCESS.getCode(),new Date());
        }else
            return new JsonResult(StatusCode.NOT_EXIST.getCode(),new Date());
    }

    //修改现有菜品
    @ResponseBody
    @RequestMapping(path="/updateDish")
    @ApiOperation(value="修改菜品信息",notes="返回json/String")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType ="query",name="dining_id",value="餐厅id",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="name",value="餐厅名称",required=true,dataType="String")
    })
    public JsonResult updateDish (@RequestParam Integer dining_id,
                                  @RequestParam String name) {
        Dish dish = new Dish();
        dish.setName(name);

        dishRepository.save(dish);

        return new JsonResult(StatusCode.SUCCESS.getCode(),new Date());
    }

    //查看所有现有菜品
    @ResponseBody
    @GetMapping(path="/viewDish")
    @ApiOperation(value="根据餐厅id查看现有菜品",notes="返回json/String")
    @ApiImplicitParam( paramType ="query",name="dining_id",value="餐厅id",required=true,dataType="Integer")
    public Iterable<Dish> viewDish (@RequestParam Integer dining_id) {
        return dishRepository.findByDining_id(dining_id);
    }

}
