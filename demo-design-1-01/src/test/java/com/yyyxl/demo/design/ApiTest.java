package com.yyyxl.demo.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(PrizeController.class);


    @Test
    public void test(){

        PrizeController prizeController = new PrizeController();
        System.out.println("\r\n模拟发放优惠券测试\r\n");
        AwardReq awardReq01 = new AwardReq();
        awardReq01.setuId("10001");
        awardReq01.setAwardType(1);
        awardReq01.setAwardNumber("EGM1023938910232121323432");
        awardReq01.setBizId("791098764902132");
        AwardRes awardRes01 = prizeController.awardToUser(awardReq01);
        logger.info("请求参数：{}", JSON.toJSON(awardReq01));
        logger.info("测试结果：{}", JSON.toJSON(awardRes01));


        System.out.println("\r\n模拟方法实物商品\r\n");
        AwardReq awardReq02 = new AwardReq();
        awardReq02.setuId("10001");
        awardReq02.setAwardType(2);
        awardReq02.setAwardNumber("9820198721311");
        awardReq02.setBizId("1023000020112221113");
        awardReq02.setExtMap(new HashMap<String, String>() {{
            put("consigneeUserName", "谢飞机");
            put("consigneeUserPhone", "15200292123");
            put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        }});
        AwardRes awardRes02 = prizeController.awardToUser(awardReq02);
        logger.info("请求参数：{}", JSON.toJSON(awardReq02));
        logger.info("测试结果：{}", JSON.toJSON(awardRes02));

    }
}
