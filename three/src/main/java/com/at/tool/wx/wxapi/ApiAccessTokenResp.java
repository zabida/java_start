package com.at.tool.wx.wxapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiAccessTokenResp {
    private String access_token;
    private String expires_in;
}
