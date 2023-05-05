package com.yyyxl.demo.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.yyyxl.demo.design.goods.GoodsReq;
import com.yyyxl.demo.design.goods.GoodsService;
import com.yyyxl.demo.design.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Map;

public class GoodsCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    GoodsService goodsService = new GoodsService();


    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        GoodsReq goodsReq = new GoodsReq();
        goodsReq.setUserName(queryUserName(uId));
        goodsReq.setUserPhone(queryUserPhoneNumber(uId));
        goodsReq.setSku(commodityId);
        goodsReq.setOrderId(bizId);
        goodsReq.setConsigneeUserName(extMap.get("consigneeUserName"));
        goodsReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        goodsReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));
        Boolean isSuccess = goodsService.deliverGoods(goodsReq);

        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", isSuccess);

        if (!isSuccess){
            throw new RuntimeException("实物商品发放失败");
        }

    }

    public String queryUserName(String uId){
        return "花花";
    }
    public String queryUserPhoneNumber(String uId){
        return "15200101232";
    }
}
