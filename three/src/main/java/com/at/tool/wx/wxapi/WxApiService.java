package com.at.tool.wx.wxapi;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

@Component
@Slf4j
public class WxApiService {
    WxApiConfig wxApiConfig;
    public ObjectMapper objectMapper = new ObjectMapper();
    public String token = "71_8gyildES6CZfTxLWCdMcNHqmQi-e7bUucz60zSPE6evRwDOMaHvBrz2j_nMWBHVmf2gbNy9teyDOD3eW1CEvAFVozZXRapIjz8fdxhH3uJ2LhVOu-BvW6AhQhqUKOCcAIASWK";

    private String refreshToken(String appName) {
        ApiAccessTokenResp accToken = null;
        int i = 0;
        while (i < 3){
            String res = "";
            try {
                String appid = "wxe2200e55320ee317";
                String secret = "588d699078c633b349d607da6a85795e";
                String url = "https://api.weixin.qq.com/cgi-bin/token";
                HashMap<String, String> paramMap = new HashMap<>();
                paramMap.put("appid", appid);
                paramMap.put("secret", secret);
                paramMap.put("grant_type", "client_credential");
                res = HttpClient.get(url, paramMap);
                accToken = objectMapper.readValue(res, ApiAccessTokenResp.class);
                break;
            } catch (Exception e) {
                log.error("异常，err: {} ======= 响应res: {}",e.getMessage(), res);
            }
            i += 1;
        }
        token = accToken.getAccess_token();
        System.out.println(token);
        return accToken.getAccess_token();
    }

    private ApiReleaseArticleListResp getAllReleaseArticle(String appName, Integer offset, Integer count){
        ApiReleaseArticleListResp resp = null;
        int i = 0;
        while (i < 3){
            try {
                String appid = "wxe2200e55320ee317";
                String secret = "588d699078c633b349d607da6a85795e";
                String url = "https://api.weixin.qq.com/cgi-bin/freepublish/batchget";
                HashMap<String, String> paramMap = new HashMap<>();
                paramMap.put("access_token", token);
                HashMap<String, Object> bodyMap = new HashMap<>();
                bodyMap.put("offset", offset);
                bodyMap.put("count", count);
                bodyMap.put("no_content", 1);
                String body = objectMapper.writeValueAsString(bodyMap);
                String res = HttpClient.post(url, paramMap, body);
                resp = objectMapper.readValue(res, ApiReleaseArticleListResp.class);
                break;
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            i += 1;
        }
        if (Objects.isNull(resp)){
            log.error("获取列表失败, resp:{}", resp);
        }
        System.out.println(resp);
        return resp;
    }

    public void reset(){
        try {
            String appid = "wxe2200e55320ee317";
            String secret = "588d699078c633b349d607da6a85795e";
            String url = "https://api.weixin.qq.com/cgi-bin/clear_quota/v2?appid=" + appid + "&appsecret=" + secret;
//            HashMap<String, String> paramMap = new HashMap<>();
//            paramMap.put("appid", appid);
//            paramMap.put("secret", secret);
//            paramMap.put("grant_type", "client_credential");
//            String res = HttpClient.get(url, paramMap);
            String post = HttpClient.post(url, "");
            System.out.println(post);
        } catch (Exception e) {
            log.error("异常，err: {} ======= 响应res", e.getMessage());
        }
    }

    public static void main(String[] args) {
        WxApiService wxApiService = new WxApiService();
//        wxApiService.refreshToken("aa");
//        wxApiService.getAllReleaseArticle("aa", 0, 10);
        wxApiService.reset();
    }
}
