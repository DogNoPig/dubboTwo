package com.xw.zy.dubbo.two.server.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xw
 * @date 2019/5/7 17:59
 */
@Data
@ToString
public class RecordPushRequest implements Serializable {
    private Integer itemId;

    private Integer total;

    private String customerName;

}
