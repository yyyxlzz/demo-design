package com.yyyxl.demo.design;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test(){

        // 初始化数据
        String activityId = "100001";
        ActivityService.init(activityId,Status.Editing);

        ActivityExecStatusController activityExecStatusController = new ActivityExecStatusController();
        Result result = activityExecStatusController.execStatus(activityId, Status.Editing, Status.Refuse);

        logger.info("测试结果（编辑中To审核拒绝），{}",JSON.toJSONString(result));

        Result resultCheck = activityExecStatusController.execStatus(activityId, Status.Editing, Status.Check);
        logger.info("测试结果(编辑中To提交审核)：{}", JSON.toJSONString(resultCheck));
    }

}
