package com.meetfood.controller;
import com.meetfood.entity.Book;
import com.meetfood.repository.BookRepository;
import com.meetfood.statusCode.JsonResult;
import com.meetfood.statusCode.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(path = "/myOrderForm")
@Api(value = "OrderFormController")

public class OrderFormController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping({"/booking",
            "/waiting",
            "/finished"
    })
    @ApiOperation(value="餐厅查看订单信息",notes = "返回json")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType ="query",name="state",value="预订状态",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="dining_id",value="当前餐厅",required=true,dataType="Integer")
    })
    public @ResponseBody
    JsonResult getBookByStateAndDining_id(@RequestParam Integer state,
                                          @RequestParam Integer dining_id) {
        // This returns a JSON or XML with the users
        return new JsonResult(StatusCode.SUCCESS.getCode(),bookRepository.findByStateAndDining_id(state,dining_id),new Date());
    }

    @GetMapping({"/lastWeek",
            "/lastMonth"
    })
    @ApiOperation(value = "获取最近一周、一月的订单",notes = "返回json")
    @ApiImplicitParams({@ApiImplicitParam( paramType = "query",name = "dining_id",value="当前用户",required = true,dataType = "Integer"),
            @ApiImplicitParam( paramType = "query",name = "date_state",value="距当前的时间",required = true,dataType = "Integer")
    })
    public @ResponseBody JsonResult getBookByTime(@RequestParam Integer dining_id,
                                                 @RequestParam Integer date_state){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
        //ft.format(current_time);

        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - date_state);
        Date d = c.getTime();

        return new JsonResult(StatusCode.SUCCESS.getCode(),bookRepository.findByDining_idAndOrder_time(dining_id,d), new Date());
    }

        @GetMapping(path = "/all")
        @ApiOperation(value = "当前餐厅的所有预定订单",notes = "返回json")
        @ApiImplicitParam( paramType = "query",name = "dining_id",value = "当前用户",required = true,dataType = "Integer")
        public @ResponseBody JsonResult getByGuest(@RequestParam Integer dining_id){
            return new JsonResult(StatusCode.SUCCESS.getCode(),bookRepository.findByDining_id(dining_id), new Date());

        }


    @PutMapping(path = "/changeState")
    @ApiOperation(value = "餐厅确认预约成功",notes = "返回json")
    @ApiImplicitParams({@ApiImplicitParam( paramType ="query",name="id",value="订单编号",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="toState",value="将处于的状态",required=true,dataType="Integer")
    })

    public @ResponseBody JsonResult setBookState(@RequestParam Integer id,
                                             @RequestParam Integer toState){
        try {//在数据库中新建预订订单
            //Book b = new Book();
            //b.setState(1);

            //将state由0转为1，确认接受订单
            //bookRepository.findOrderById(id).setState(1);
            Book book = bookRepository.findById(id).get();
            book.setState(toState);
            bookRepository.save(book);
            return new JsonResult(StatusCode.SUCCESS.getCode(), new Date());
        }catch(Exception e){
            return new JsonResult(StatusCode.SYS_ERROR.getCode(), new Date());
        }
    }
}

