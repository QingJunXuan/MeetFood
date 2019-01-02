package com.meetfood.controller;

import com.meetfood.entity.Collection;
//import com.meetfood.entity.CollectionPK;
import com.meetfood.entity.Dining;
import com.meetfood.repository.CollectionRepository;
import com.meetfood.repository.DiningRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/collection")
@Api(value = "CollectionController|客人收藏餐厅、查看已收藏餐厅")
public class CollectionController {
    @Autowired
    private CollectionRepository collectionRepository;
    @Autowired
    private DiningRepository diningRepository;

    //收藏餐厅

    @PostMapping(path = "/collect")
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
            //CollectionPK collectionPK = new CollectionPK();
            //collectionPK.setDining_id(dining_id);
            //collectionPK.setGuest_id(guest_id);

            Collection collection = new Collection();
            collection.setTime(new Date());
            collection.setDining_id(dining_id);
            collection.setGuest_id(guest_id);
            collectionRepository.save(collection);

            Dining dining = new Dining();
            Integer num = dining.getCollections();
            dining.setCollections(num+1);
            diningRepository.save(dining);
            return "success";
        }catch (Exception e){
            return "failed";
        }
    }

    //查看已收藏餐厅
    @GetMapping(path = "/viewCollection")
    @ApiOperation(value = "客人查看收藏的餐厅",notes = "返回json")
    @ApiImplicitParam(paramType = "query",name = "guest_id",value = "客人编号",required = true,dataType = "Integer")
    public @ResponseBody List<Collection> getCollectionsByGuest_id(@RequestParam Integer guest_id){
        return collectionRepository.findByGuest_id(guest_id);
    }

    @GetMapping(path = "all")
    public @ResponseBody Iterable<Collection> getAllCollections(){
        return  collectionRepository.findAll();
    }
    //取消收藏
    @DeleteMapping(path = "/delete")
    @ApiOperation(value = "客人删除已收藏的餐厅",notes = "返回string")
    @ApiImplicitParam(paramType = "param",name = "id",value = "收藏编号",required = true,dataType = "Integer")
    public @ResponseBody String deleteCollection(@RequestParam Integer id){
        //CollectionPK id = new CollectionPK();
        //id.setGuest_id(guest_id);
        //id.setDining_id(dining_id);
        //Collection n = new Collection();
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
