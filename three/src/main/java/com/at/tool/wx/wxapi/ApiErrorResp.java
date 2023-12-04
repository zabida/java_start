package com.at.tool.wx.wxapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResp {
    public Integer errcode;
    public String errmsg;
}
