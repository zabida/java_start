package com.at.tool;

// import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.chinadep.common.api.ApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Objects;

public class Tt {
    public static void main(String[] args) throws JsonProcessingException {
        HashMap<String, String> params = new HashMap<>();
        params.put("code", "1000210608-ZHEⅢFI0802");
        params.put("AppCode", "811d9afb89b4459c91aef313a8f95452");
        String s;
        BrokerProductSimpleInfoVo vo = new BrokerProductSimpleInfoVo();
        try {
            s = HttpClientUtils.get("https://prod-crabc.indep.com/api/web/v1/product/price", params);
            System.out.println(s);
            // ApiResult<CrabcBrokerProductSimpleInfoDto> apiResp = JSONUtil.toBean(s, new TypeReference<ApiResult<CrabcBrokerProductSimpleInfoDto>>() {}, true);
            // System.out.println(apiResp);

            ObjectMapper objectMapper = new ObjectMapper();
            ApiResult<CrabcBrokerProductSimpleInfoDto> apiResp = objectMapper.readValue(s, new TypeReference<ApiResult<CrabcBrokerProductSimpleInfoDto>>() {
            });
            CrabcBrokerProductSimpleInfoDto data = apiResp.getData();
            System.out.println(data);
            if (Objects.nonNull(data)){

                System.out.println(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApiException("获取产品信息异常");
        }
    }
}
