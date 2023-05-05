package com.yyyxl.demo.design.store;

import java.util.Map;

public interface ICommodity {

    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;

}
