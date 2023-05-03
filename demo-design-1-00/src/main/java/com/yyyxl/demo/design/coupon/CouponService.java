package com.yyyxl.demo.design.coupon;

public class CouponService {
    public Result sendCoupon(String uId, String couponNumber, String uuid){
        System.out.println("模拟发送优惠券一张："+uId+","+couponNumber+","+uuid);
        return new Result("0000","发送成功");
    }
}
