package com.at.tool;

import cn.hutool.core.util.URLUtil;

import java.net.URL;
import java.text.MessageFormat;

public class UrlTool {

    private String one(String returnUrl){
        URL url = URLUtil.url(returnUrl);
        returnUrl = MessageFormat.format("{0}://{1}{2}", url.getProtocol(), url.getHost(), url.getPort() == -1 ? "" : ":" + url.getPort());
        System.out.println(returnUrl);
        return null;
    }

    public static void main(String[] args) {
        UrlTool urlTool = new UrlTool();
        urlTool.one("https://test2-echosystem.globalgdec.net/verifycode?r=%2Fpreview%2Fhall");
    }
}
