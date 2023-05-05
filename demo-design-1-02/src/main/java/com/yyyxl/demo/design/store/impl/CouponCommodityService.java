package com.yyyxl.demo.design.store.impl;

import com.alibaba.fastjson.JSON;
import com.yyyxl.demo.design.coupon.CouponService;
import com.yyyxl.demo.design.coupon.Result;
import com.yyyxl.demo.design.store.ICommodity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CouponCommodityService implements ICommodity {

    private Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);


    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
        Result result = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(result));

        if(!"0000".equals(result.getCode())){
            throw new RuntimeException(result.getInfo());
        }
    }
}
