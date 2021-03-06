package com.meetfood.controller;

import com.meetfood.entity.Comment;
import com.meetfood.entity.Dining;
import com.meetfood.entity.Picture;
import com.meetfood.repository.CommentRepository;
import com.meetfood.repository.DiningRepository;
import com.meetfood.repository.PictureRepository;
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
@RequestMapping(path = "/comment")
@Api(value = "CommentController")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private DiningRepository diningRepository;

    //添加评论
    @ResponseBody
    @PostMapping(path="/addComment/text")
    @ApiOperation(value="添加评论",notes="返回json/String")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType ="query",name="dining_id",value="被评论的餐厅id",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="guest_id",value="发表评论的客人id",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="text",value="发表评论的内容",required=true,dataType="String"),
            @ApiImplicitParam( paramType ="query",name="score",value="评分",required=true,dataType="Integer"),
    })
    public JsonResult addComment (@RequestParam  Integer dining_id,
                                  @RequestParam  Integer guest_id,
                                  @RequestParam String text,
                                  @RequestParam Integer score) {

        Comment comment = new Comment();
        comment.setDining_id(dining_id);
        comment.setGuest_id(guest_id);
        comment.setText(text);
        comment.setScore(score);
        comment.setTime(new Date());

        try {
            commentRepository.save(comment);

            //计算评分
            Integer avg = commentRepository.avgScore(dining_id);

            //写入dining
            Dining dining = diningRepository.findById(dining_id).get();
            dining.setGrade(avg);
            diningRepository.save(dining);
            return new JsonResult(StatusCode.SUCCESS.getCode(),new Date());


        }catch (Exception e){
            return new JsonResult(StatusCode.SYS_ERROR.getCode(),new Date());

        }
    }

    //上传评论图片
    @ResponseBody
    @PostMapping(path="/addComment/picture")
    @ApiOperation(value="上传评论图片",notes="返回json/String")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType ="query",name="comment_id",value="对应评论的id",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="picture",value="二进制图片",required=true,dataType="Blob")
    })
    public JsonResult addCommentPicture (@RequestParam Integer comment_id,
                                     @RequestParam Blob picture){
        Picture p = new Picture();
        p.setComment_id(comment_id);
        p.setPicture(picture);

        try {
            pictureRepository.save(p);
            return new JsonResult(StatusCode.SUCCESS.getCode(),new Date());
        }catch (Exception e){
            return new JsonResult(StatusCode.SYS_ERROR.getCode(),new Date());
        }
    }

    //根据comment_id返回对应图片
    @ResponseBody
    @GetMapping(path="/myComments/picture")
    @ApiOperation(value="根据comment_id返回对应图片",notes="返回json/String")
    @ApiImplicitParam( paramType ="query",name="picture",value="二进制图片",required=true,dataType="Blob")
    public JsonResult viewPicture(@RequestParam Integer comment_id){
        return new JsonResult(StatusCode.SUCCESS.getCode(),pictureRepository.findByComment_id(comment_id),new Date());
    }

    //客人查看我的所有评论
    @ResponseBody
    @GetMapping(path="/myComments/text")
    @ApiOperation(value="客人查看我发出的评论",notes="返回json/String")
    @ApiImplicitParam( paramType ="query",name="guest_id",value="客人id",required=true,dataType="Integer")
    public JsonResult viewCommentGuest (@RequestParam Integer guest_id) {
        return new JsonResult(StatusCode.SUCCESS.getCode(),commentRepository.findByGuest_id(guest_id),new Date());

    }

    //餐厅查看所有评论
    @ResponseBody
    @GetMapping(path="/receivedComments")
    @ApiOperation(value="餐厅查看我收到的评论",notes="返回json/String")
    @ApiImplicitParam( paramType ="query",name="dining_id",value="餐厅id",required=true,dataType="Integer")
    public JsonResult viewCommentDining (@RequestParam Integer dining_id) {
        return new JsonResult(StatusCode.SUCCESS.getCode(),commentRepository.findByDining_id(dining_id),new Date());
    }
}
