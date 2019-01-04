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
import java.util.Calendar;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping(path = "/myReservation")
@Api(value = "BookController")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    //根据状态查看预约信息
    @GetMapping({"/booking",
            "/waiting",
            "/finished"
    })
    @ApiOperation(value="查看预约信息",notes = "返回json")
    @ApiImplicitParams({
            @ApiImplicitParam( paramType ="query",name="state",value="预订状态",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="guest_id",value="当前用户",required=true,dataType="Integer")
    })
    public @ResponseBody JsonResult getBook1(@RequestParam Integer state,
                        @RequestParam Integer guest_id) {
        // This returns a JSON or XML with the users
        try{
        List<Book> book = bookRepository.findByStateAndGuest_id(state,guest_id);
        return new JsonResult(StatusCode.SUCCESS.getCode(),book,new Date());
        }catch (Exception e){
            return new JsonResult(StatusCode.SYS_ERROR.getCode(),new Date());
        }
    }

    //根据时间查看预约信息
    @GetMapping({"/lastWeek",
            "/lastMonth"
    })
    @ApiOperation(value = "获取最近一周、一月的订单",notes = "返回json")
    @ApiImplicitParams({@ApiImplicitParam( paramType = "query",name = "guest_id",value="当前用户",required = true,dataType = "Integer"),
    @ApiImplicitParam( paramType = "query",name = "date_state",value="距当前的时间",required = true,dataType = "Integer")
    })
    public @ResponseBody Iterable<Book> getBook2(@RequestParam Integer guest_id,
                                                 @RequestParam Integer date_state
    ){
        //SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
        //ft.format(current_time);

        //dateState不存在在表中，值有7，30(或者0，1)，表示天数
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, - date_state);
        Date d = c.getTime();
        return bookRepository.findByGuest_idAndOrder_time(guest_id,d);
    }

    //查看当前用户的所有预订订单
    @GetMapping(path = "/all")
    @CrossOrigin
    @ApiOperation(value = "当前用户的所有预订订单",notes = "返回json")
    @ApiImplicitParam( paramType = "query",name = "guest_id",value = "当前用户",required = true,dataType = "Integer")
    public @ResponseBody JsonResult getByGuest(@RequestParam Integer guest_id){
        return new JsonResult(StatusCode.SUCCESS.getCode(),bookRepository.findByGuest_id(guest_id),new Date());
    }

    //预约餐厅
    @PostMapping(path = "/book")
    @ApiOperation(value = "点击餐厅界面，进行预约",notes = "返回json")
    @ApiImplicitParams({@ApiImplicitParam( paramType ="query",name="dining_id",value="餐厅编号",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="guest_id",value="用户编号",required=true,dataType="Integer"),
            @ApiImplicitParam( paramType ="query",name="repast_time",value="用餐时间",required=true,dataType="Date")
            //@ApiImplicitParam( paramType ="query",name="order_time",value="预约时间",required=true,dataType="Date")
    })
    public @ResponseBody JsonResult addBook(@RequestParam Integer dining_id,
                                        @RequestParam Integer guest_id,
                                        @RequestParam Date repast_time
                                        //@RequestParam Date order_time
                                        ){
       try {//在数据库中新建预订订单
           Book b = new Book();
           b.setDining_id(dining_id);
           b.setGuest_id(guest_id);
           b.setState(0);
           b.setRepast_time(repast_time);
           b.setOrder_time(new Date());

           bookRepository.save(b);
           return new JsonResult(StatusCode.SUCCESS.getCode(),new Date());
       }catch(Exception e){
           return new JsonResult(StatusCode.SYS_ERROR.getCode(),new Date());
       }
    }
}
