package com.yyyxl.demo.design;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ActivityService {

    private static Map<String,Enum<Status>> statusMap = new ConcurrentHashMap<>();

    public static void init(String activityId,Enum<Status> status){
        // 模拟查询活动信息
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("早起学习打卡领奖活动");
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        activityInfo.setStatus(status);

        statusMap.put(activityId,status);
    }

    /**
     * 查询活动信息
     * @param activityId
     * @return
     */
    public static ActivityInfo queryActivityInfo(String activityId){
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.setActivityId(activityId);
        activityInfo.setActivityName("早起学习打卡领奖活动");
        activityInfo.setStatus(statusMap.get(activityId));
        activityInfo.setBeginTime(new Date());
        activityInfo.setEndTime(new Date());
        return activityInfo;
    }

    /**
     * 查询活动状态
     * @param activityId
     * @return
     */
    public static Enum<Status> queryActivityStatus(String activityId){
        return statusMap.get(activityId);
    }

    /**
     * 执行状态变更
     *
     * @param activityId   活动ID
     * @param beforeStatus 变更前状态
     * @param afterStatus  变更后状态 b
     */
    public static synchronized void execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {
        if (!beforeStatus.equals(statusMap.get(activityId))) {
            return;
        }
        statusMap.put(activityId, afterStatus);
    }

}
