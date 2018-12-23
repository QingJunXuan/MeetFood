package com.meetfood.controller;

import com.meetfood.entity.Dining;
import com.meetfood.repository.DiningRepository;
import com.meetfood.statusCode.JsonResult;
import com.meetfood.statusCode.StatusCode;
import com.sun.org.apache.bcel.internal.ExceptionConst;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Blob;
import java.util.Date;

@Controller
@RequestMapping(path = "/dining")
@Api(value = "DiningController|私人厨房信息增删改查")
public class DiningController {
    @Autowired
    private DiningRepository diningRepository;

    //注册
    @PostMapping(path = "/register")
    @ApiOperation(value = "输入信息注册餐厅",notes = "返回string")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "name", value = "邮箱", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "餐厅名字", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "餐厅类别", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "餐厅名字", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "intro", value = "餐厅简介", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "tel", value = "餐厅电话", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "address", value = "餐厅地址", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "icon", value = "餐厅图标", required = true, dataType = "Blob")
    })
    public @ResponseBody String addDining(@RequestParam String email,
                                          @RequestParam String password,
                                          @RequestParam String type,
                                          @RequestParam String name,
                                          @RequestParam String intro,
                                          @RequestParam String tel,
                                          @RequestParam String address,
                                          @RequestParam Blob icon){
        try{
            Dining d = new Dining();

            d.setGrade(0);
            d.setEmail(email);
            d.setPassword(password);
            d.setType(type);
            d.setName(name);
            d.setIntro(intro);
            d.setTel(tel);
            d.setAddress(address);
            d.setIcon(icon);

            diningRepository.save(d);
            return "success";
        }catch(Exception e){
            return "failed";
        }
    }

    //登录
    @PostMapping(path = "login")
    @ApiOperation(value = "使用邮箱密码登录餐厅",notes = "返回json")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType ="query",name="email",value="登录邮箱",required=true,dataType="String"),
            @ApiImplicitParam( paramType ="query",name="password",value="登陆密码",required=true,dataType="String")
    })
    public JsonResult register (@RequestParam String email
            , @RequestParam String password) {
        if(diningRepository.findByEmail(email).size()!=0){
            if(diningRepository.findByEmailAndPassword(email,password).size()!=0)
                return new JsonResult(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getMessage(),new Date());
            else return new JsonResult(StatusCode.FAIL_PASS.getCode(),StatusCode.FAIL_PASS.getMessage(),new Date());
        }else return new JsonResult(StatusCode.FAIL_UNREGISTER.getCode(),StatusCode.FAIL_UNREGISTER.getMessage(),new Date());
    }

    //修改信息
    @PostMapping(path = "/revise")
    @ApiOperation(value = "修改餐厅信息",notes = "返回json")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType = "query",name = "id",value = "餐厅编号",required = true,dataType = "Integer"),
            @ApiImplicitParam( paramType = "query",name = "name",value = "餐厅名字",required = true,dataType = "String")
    })
    public @ResponseBody String reviseDining(@RequestParam Integer id,
                                             @RequestParam String name){
        try{
            diningRepository.findById(id).get().setName(name);
            return "success";
        }catch (Exception e){
            return "failed";
        }
    }
}
