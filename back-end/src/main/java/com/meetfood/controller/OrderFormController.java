package com.meetfood.controller;
import com.meetfood.entity.Book;
import com.meetfood.repository.BookRepository;
import com.sun.xml.internal.ws.wsdl.writer.document.ParamType;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.xml.bind.ValidationEventLocator;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping(path = "/myOrderForm")
@Api(value = "BookController|用于用户预约餐厅和查看预约信息")

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
            @ApiImplicitParam( paramType ="query",name="dinning_id",value="当前餐厅",required=true,dataType="Integer")
    })
    public @ResponseBody Iterable<Book> getBookByState(@RequestParam Integer state,
                                                 @RequestParam Integer dining_id) {
        // This returns a JSON or XML with the users
        return bookRepository.findByStateAndDining_id(state,dining_id);
    }

    @GetMapping({"/all",
            "/lastWeek",
            "/lastMonth"
    })
    @ApiOperation(value = "获取最近一周、一月的订单",notes = "返回json")
    @ApiImplicitParams({@ApiImplicitParam( paramType = "query",name = "guest_id",value="当前用户",required = true,dataType = "Integer"),
            @ApiImplicitParam( paramType = "query",name = "date_state",value="距当前的时间",required = true,dataType = "Integer")
    })
    public @ResponseBody Iterable<Book> getBookByTime(@RequestParam Integer dining_id,
                                                 @RequestParam Integer date_state){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
        //ft.format(current_time);

        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - date_state);
        Date d = c.getTime();

        return bookRepository.findByTimestampAfter(d,dining_id);
    }
    /*
        @GetMapping(path = "/all")
        @ApiOperation(value = "当前用户的所有预定订单",notes = "返回json")
        @ApiImplicitParam( paramType = "query",name = "guest_id",value = "当前用户",required = true,dataType = "Integer")
        public @ResponseBody Iterable<Book> getByGuest(@RequestParam Integer guest_id){
            return bookRepository.findByGuest_id(guest_id);
        }
    */

    @RequestMapping(path = "/changeState/accept")
    @ApiOperation(value = "点击餐厅界面，进行预约",notes = "返回json")
    @ApiImplicitParam( paramType ="query",name="id",value="订单编号",required=true,dataType="Integer")
    public @ResponseBody String setBookState(@RequestParam Integer id){
        try {//在数据库中新建预订订单
            //Book b = new Book();
            //b.setState(1);

            //将state由0转为1，确认接受订单
            //bookRepository.findOrderById(id).setState(1);
            bookRepository.findById(id).get().setState(1);
            return "success";
        }catch(Exception e){
            return "failed!";
        }
    }
}

