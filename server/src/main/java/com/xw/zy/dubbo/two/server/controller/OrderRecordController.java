package com.xw.zy.dubbo.two.server.controller;

import com.xw.zy.dubbo.two.server.request.RecordPushRequest;
import com.xw.zy.dubbo.two.server.service.OrderRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * @author xw
 * @date 2019/5/7 17:51
 */
@RestController
public class OrderRecordController {
    private static final Logger log = LoggerFactory.getLogger(OrderRecordController.class);

    private static final String prefix = "order";

    @Autowired
    private OrderRecordService orderRecordService;
    /**
     * @author xw
     * @date
     * 面向客户的用户下单
     * @return
     * @throws
     * @since
    */
    @RequestMapping(value = prefix + "/record/push",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String,Object> pushOrder(@RequestBody RecordPushRequest pushRequest){
        Map<String, Object> rmap = new HashMap<>();
        rmap.put("code",0);
        rmap.put("msg","成功");
        try{
            log.info("接收到请求参数：{}",pushRequest);
            //TODO: 处理用户下单数据-发起用户下单接口的调用
            orderRecordService.pushRecord(pushRequest);

        }catch (Exception e){
            e.printStackTrace();
            rmap.put("code",-1);
            rmap.put("msg","失败");
        }
        return rmap;
    }

}
