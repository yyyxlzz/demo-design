package com.yyyxl.demo.design.goods;

import com.alibaba.fastjson.JSON;

public class GoodsService {

    public Boolean deliverGoods(GoodsReq req){
        System.out.println("模拟发货实物商品一个：" + JSON.toJSONString(req));
        return true;
    }

}
