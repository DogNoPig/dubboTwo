package com.xw.zy.dubbo.two.server.controller;

import com.xw.zy.dubbo.one.api.response.BaseResponse;
import com.xw.zy.dubbo.one.api.service.ItemInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xw
 * @date 2019/5/7 14:33
 */
@RestController
public class ItemController {
    private static Logger log = LoggerFactory.getLogger(ItemController.class);

    private static final String prefix = "item";

    @Autowired
    private ItemInfoService dubboItemService;

    /**
     * @author xw
     * @date
     * 用户商城列表查询
     * @return
     * @throws
     * @since
    */
    @GetMapping(prefix+"/list")
    public Map<String,Object> list(){
        Map<String, Object> returnMap = new HashMap<>();
//        Map<String, Object> returnMap = Maps.newHashMap();
        returnMap.put("code","0");
        returnMap.put("msg","成功");
        try{
            BaseResponse response = dubboItemService.listItems();
            if (response != null && response.getCode().equals(0)){
                returnMap.put("data",response.getData());
            }
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code","-1");
            returnMap.put("msg","失败");
        }


        return returnMap;
    }

    /**
     * @author xw
     * @date
     * 用户商城分页列表查询
     * @return
     * @throws
     * @since
    */
    @GetMapping(prefix+"/page/list")
    public Map<String,Object> pageList(@RequestParam Integer pageNo, @RequestParam Integer pageSize, @RequestParam String search){
        if (pageNo == null || pageSize == null || pageNo <= 0 || pageSize <= 0){
            pageNo = 1;
            pageSize = 2;
        }

        Map<String, Object> returnMap = new HashMap<>();
//        Map<String, Object> returnMap = Maps.newHashMap();
        returnMap.put("code","0");
        returnMap.put("msg","成功");
        try{
            BaseResponse response = dubboItemService.listPageItems(pageNo,pageSize,search);
            if (response != null && response.getCode().equals(0)){
                returnMap.put("data",response.getData());
            }
        }catch (Exception e){
            e.printStackTrace();
            returnMap.put("code","-1");
            returnMap.put("msg","失败");
        }


        return returnMap;
    }



}
