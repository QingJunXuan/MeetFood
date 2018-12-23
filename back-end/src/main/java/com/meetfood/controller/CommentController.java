package com.meetfood.controller;

import com.meetfood.repository.CommentRepository;
import com.meetfood.repository.PictureRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/comment")
@Api(value = "CommentController|客人对餐厅的评价")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    private PictureRepository pictureRepository;

    //添加评论



    //查看我的所有评论
}
