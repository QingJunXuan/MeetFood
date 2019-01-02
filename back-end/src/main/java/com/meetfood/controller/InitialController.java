package com.meetfood.controller;


import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

//初始化
@Controller
@CrossOrigin
@RequestMapping
@Api(value = "InitialController|初始化界面")
public class InitialController {
    //返回收藏数量最高的四家餐厅

}
