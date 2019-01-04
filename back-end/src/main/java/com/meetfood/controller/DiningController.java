package com.meetfood.controller;

import com.meetfood.entity.Dining;
import com.meetfood.repository.DiningRepository;
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
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(path = "/dining")
@Api(value = "DiningController")
public class DiningController {
    @Autowired
    private DiningRepository diningRepository;

    //注册
    @PostMapping(path = "/register")
    @ApiOperation(value = "输入信息注册餐厅",notes = "返回string")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "email", value = "邮箱", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "餐厅类别", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "餐厅名字", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "intro", value = "餐厅简介", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "tel", value = "餐厅电话", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "address", value = "餐厅地址", required = true, dataType = "String"),
            //@ApiImplicitParam(paramType = "query", name = "icon", value = "餐厅图标", required = true, dataType = "Blob")
    })
    public @ResponseBody JsonResult addDining(@RequestParam String email,
                                          @RequestParam String password,
                                          @RequestParam String type,
                                          @RequestParam String name,
                                          @RequestParam String intro,
                                          @RequestParam String tel,
                                          @RequestParam String address
                                          //@RequestParam Blob icon
    ){
        if(diningRepository.findByEmail(email).size()==0) {
            try {
                Dining d = new Dining();

                d.setGrade(0);
                d.setEmail(email);
                d.setPassword(password);
                d.setType(type);
                d.setName(name);
                d.setIntro(intro);
                d.setTel(tel);
                d.setAddress(address);
                //d.setIcon(icon);
                d.setPrice(0);
                d.setCollections(0);
                d.setTime(new Date());

                diningRepository.save(d);
                return  new JsonResult(StatusCode.SUCCESS.getCode(), new Date());
            } catch (Exception e) {
                return  new JsonResult(StatusCode.SYS_ERROR.getCode(), new Date());
            }
        }else   return  new JsonResult(StatusCode.FAIL_REGISTERED.getCode(), new Date());

    }

    //登录
    @PostMapping(path = "/login")
    @ApiOperation(value = "使用邮箱密码登录餐厅",notes = "返回json")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType ="query",name="email",value="登录邮箱",required=true,dataType="String"),
            @ApiImplicitParam( paramType ="query",name="password",value="登陆密码",required=true,dataType="String")
    })
    public @ResponseBody JsonResult loginDining (@RequestParam String email
            , @RequestParam String password) {
        if(diningRepository.findByEmail(email).size()!=0){
            if(diningRepository.findByEmailAndPassword(email,password).size()!=0){
                List<Dining> dining = diningRepository.findByEmail(email);
                return new JsonResult(StatusCode.SUCCESS.getCode(),dining,new Date());
            }
            else return new JsonResult(StatusCode.FAIL_PASS.getCode(),new Date());
        }else return new JsonResult(StatusCode.NOT_EXIST.getCode(),new Date());
    }

    //修改信息
    @PutMapping(path = "/update")
    @ApiOperation(value = "修改餐厅信息",notes = "返回json")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType = "query",name = "id",value = "餐厅编号",required = true,dataType = "Integer"),
            @ApiImplicitParam( paramType = "query",name = "name",value = "餐厅名字",required = true,dataType = "String")
    })
    public @ResponseBody JsonResult updateDining(@RequestParam Integer id,
                                             @RequestParam String name){
        try{
            Dining dining = diningRepository.findById(id).get();
            dining.setName(name);
            diningRepository.save(dining);
            return  new JsonResult(StatusCode.SUCCESS.getCode(), new Date());
        }catch (Exception e){
            return  new JsonResult(StatusCode.NOT_EXIST.getCode(), new Date());
        }
    }

    //返回餐厅信息
    @GetMapping(path = "/view")
    @ApiOperation(value = "根据餐厅id返回餐厅信息",notes = "返回JSON")
    @ApiImplicitParam( paramType = "query",name = "id",value = "餐厅id",required = true,dataType = "Integer")
    public @ResponseBody JsonResult viewDining(@RequestParam Integer id){
        return  new JsonResult(StatusCode.SUCCESS.getCode(),diningRepository.viewById(id), new Date());
    }

    //查看所有餐厅
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Dining> getAllDinings() {
        return  diningRepository.findAll();

    }
}
