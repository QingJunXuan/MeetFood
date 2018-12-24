package com.meetfood.controller;

import com.meetfood.entity.Collection;
import com.meetfood.entity.CollectionPK;
import com.meetfood.repository.CollectionRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(path = "/collection")
@Api(value = "CollectionController|客人收藏餐厅、查看已收藏餐厅")
public class CollectionController {
    @Autowired
    private CollectionRepository collectionRepository;

    //收藏餐厅
    @RequestMapping(path = "/collect")
    @ApiOperation(value = "客人收藏餐厅",notes = "返回string")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "guest_id",value = "客人编号",required = true,dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "dining_id",value = "被收藏餐厅的编号",required = true,dataType = "Integer")
    })
    public @ResponseBody String collectDining(@RequestParam Integer guest_id,
                         @RequestParam Integer dining_id){
        /*
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        Collection collection = new Collection();
        collection.setTime(ft.format(now));
        */
        try {
            CollectionPK collectionPK = new CollectionPK();
            collectionPK.setDining_id(dining_id);
            collectionPK.setGuest_id(guest_id);

            Collection collection = new Collection();
            collection.setTime(new Date());
            collection.setId(collectionPK);
            collectionRepository.save(collection);
            return "success";
        }catch (Exception e){
            return "failed";
        }
    }

    //查看已收藏餐厅
    @RequestMapping(path = "/viewCollection")
    @ApiOperation(value = "客人查看被收藏的餐厅",notes = "返回JSON")
    @ApiImplicitParam(paramType = "query",name = "guest_id",value = "客人编号",required = true,dataType = "Integer")
    public @ResponseBody Iterable<Collection> getCollectionsByGuest_id(@RequestParam Integer guest_id){
        return collectionRepository.findByGuest_id(guest_id);
    }

    //取消收藏
    @RequestMapping(path = "/delete")
    @ApiOperation(value = "客人删除已收藏的餐厅",notes = "返回string")
    @ApiImplicitParams({
            @ApiImplicitParam(),
            @ApiImplicitParam(),
    })
    public @ResponseBody String deleteCollection(@RequestParam Integer guest_id,
                                                @RequestParam Integer dining_id){
        CollectionPK id = new CollectionPK();
        id.setGuest_id(guest_id);
        id.setDining_id(dining_id);
        if( collectionRepository.findById(id) != null){
            try {
                collectionRepository.deleteById(id);
                return "success";
            }catch (Exception e){
                return "failed";
            }
        }else return "notExist";
    }
}
