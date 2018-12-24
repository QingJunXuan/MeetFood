package com.meetfood.controller;

import com.meetfood.entity.Comment;
import com.meetfood.entity.Picture;
import com.meetfood.repository.CommentRepository;
import com.meetfood.repository.PictureRepository;
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
@RequestMapping(path = "/comment")
@Api(value = "CommentController|客人对餐厅的评价")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    private PictureRepository pictureRepository;

    //添加评论
    @ResponseBody
    @PostMapping(path="/addComment/text")
    @ApiOperation(value="添加评论",notes="返回json/String")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType ="query",name="dining_id",value="被评论的餐厅id",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="guest_id",value="发表评论的客人id",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="text",value="发表评论的内容",required=true,dataType="String"),
            @ApiImplicitParam( paramType ="query",name="score",value="评分",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="time",value="发表评论的时间",required=true,dataType="Date"),
    })
    public String addComment (@RequestParam  Integer dining_id,
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

        }catch (Exception e){
            return "failed";
        }
        return "success";
    }

    //上传评论图片
    @ResponseBody
    @PostMapping(path="/addComment/picture")
    @ApiOperation(value="",notes="返回json/String")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType ="query",name="comment_id",value="对应评论的id",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="picture",value="二进制图片",required=true,dataType="Blob")
    })
    public String addCommentPicture (@RequestParam Integer comment_id,
                                     @RequestParam Blob picture){
        Picture p = new Picture();
        p.setComment_id(comment_id);
        p.setPicture(picture);

        try {
            pictureRepository.save(p);
            //return "success";
        }catch (Exception e){
            return "failed";
        }
        return "success";
    }

    //根据comment_id返回对应图片



    //客人查看我的所有评论
    @ResponseBody
    @PostMapping(path="/myComments")
    @ApiOperation(value="",notes="返回json/String")
    @ApiImplicitParam( paramType ="query",name="guest_id",value="客人id",required=true,dataType="Integer")
    public Iterable<Comment> viewCommentGuest (@RequestParam Integer guest_id) {
        return commentRepository.findByGuest_id(guest_id);
    }

    //餐厅查看所有评论
    @ResponseBody
    @PostMapping(path="/receivedComments")
    @ApiOperation(value="",notes="返回json/String")
    @ApiImplicitParam( paramType ="query",name="dining_id",value="餐厅id",required=true,dataType="Integer")
    public Iterable<Comment> viewCommentDining (@RequestParam Integer dining_id) {
        return commentRepository.findByDining_id(dining_id);
    }
}
