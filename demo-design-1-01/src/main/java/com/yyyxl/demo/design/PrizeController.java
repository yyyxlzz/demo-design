package com.yyyxl.demo.design;

import com.alibaba.fastjson.JSON;
import com.yyyxl.demo.design.coupon.CouponService;
import com.yyyxl.demo.design.coupon.Result;
import com.yyyxl.demo.design.goods.GoodsReq;
import com.yyyxl.demo.design.goods.GoodsService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 模拟发奖服务
 */

public class PrizeController {

    private Logger logger = LoggerFactory.getLogger(PrizeController.class);

    public AwardRes awardToUser(AwardReq req){
        logger.info("奖品发放开始{}。req:{}", req.getuId(), JSON.toJSONString(req));
        AwardRes awardRes = null;
        // 奖品类型为 1优惠券
        if(req.getAwardType() == 1){
            CouponService couponService = new CouponService();
            Result result = couponService.sendCoupon(req.getuId(), req.getAwardNumber(), req.getBizId());
            logger.info("Code: {}",result.getCode());
            if("0000".equals(result.getCode())){
                awardRes = new AwardRes("0000","发送成功");
            }else{
                awardRes = new AwardRes("0001","发送失败");
            }
        }else if(req.getAwardType() == 2){
            GoodsService goodsService = new GoodsService();
            GoodsReq goodsReq = new GoodsReq();
            goodsReq.setUserName(queryUserName(req.getuId()));
            goodsReq.setUserPhone(queryUserPhoneNumber(req.getuId()));
            goodsReq.setSku(req.getAwardNumber());
            goodsReq.setOrderId(req.getBizId());
            goodsReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
            goodsReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
            goodsReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
            Boolean aBoolean = goodsService.deliverGoods(goodsReq);
            if (aBoolean) {
                awardRes = new AwardRes("0000", "发放成功");
            } else {
                awardRes = new AwardRes("0001", "发放失败");
            }
        }
        return awardRes;
    }

    private String queryUserPhoneNumber(String getuId) {
        return "15200101232";
    }

    private String queryUserName(String getuId) {
        return "花花";
    }
}
