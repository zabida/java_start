package com.at.tool;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class HttpClientUtils {

    private static CloseableHttpClient httpClient;

//    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

    private static final String DEFAULT_CHARSET = "UTF-8";

    private static final int DEFAULT_CONNECT_TIMEOUT = 60000;

    private static final int DEFAULT_SOCKET_TIMEOUT = 15000;

    private static final String JSON_CONTENT_TYPE = "application/json";

    static {
        SSLContextBuilder builder = new SSLContextBuilder();
        try {
//            builder.loadTrustMaterial(null, new TrustStrategy() {
//                @Override
//                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//                    return true;
//                }
//            });
            builder.loadTrustMaterial(null, (x509Certificates, s) -> true);
        } catch (NoSuchAlgorithmException | KeyStoreException e) {
            throw new RuntimeException(e);
        }
        SSLConnectionSocketFactory socketFactory;
        try {
            socketFactory = new SSLConnectionSocketFactory(builder.build(), NoopHostnameVerifier.INSTANCE);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }
        RequestConfig config = RequestConfig.custom().setConnectTimeout(DEFAULT_CONNECT_TIMEOUT)
                .setSocketTimeout(DEFAULT_SOCKET_TIMEOUT).build();
        httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
                .setSSLSocketFactory(socketFactory).build();
    }

    public static String execute(HttpUriRequest method, String charset) {
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(method);
            log.info("response ============== " + response.toString());
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                method.abort();
                throw new RuntimeException("HttpClient, error status code :" + statusCode);
            }
            HttpEntity entity = response.getEntity();
            return toString(entity, charset);
        } catch (IOException e) {
            log.error("Http call error: " + e.getMessage(), e);
            return null;
        } finally {
            close(response);
        }
    }

    private static String toString(HttpEntity entity, String charset) throws IOException {
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, charset);
        }
        EntityUtils.consume(entity);
        return result;
    }

    private static void close(CloseableHttpResponse response) {
        if (response != null) {
            try {
                response.close();
            } catch (IOException ignored) {
            }
        }
    }


    public static String postJson(String url, Map<String, String> params) throws JsonProcessingException {
        return postJson(url, params, DEFAULT_CHARSET);
    }

    /**
     * 以json作为参数发送Http Post请求
     *
     * @param url     请求路径
     * @param params  请求参数
     * @param charset 字符集
     * @return
     */
    public static String postJson(String url, Map<String, String> params, String charset) throws JsonProcessingException {
        String json = null;

        json = new ObjectMapper().writeValueAsString(params);


        StringEntity entity = new StringEntity(json, charset);
        entity.setContentEncoding(charset);
        entity.setContentType(JSON_CONTENT_TYPE);

        System.out.println(url);
        HttpPost method = new HttpPost(url);
        method.setEntity(entity);

        return execute(method, charset);
    }


    public static String get(String url, Map<String, String> params) throws IOException {
        return get(url, params, DEFAULT_CHARSET);
    }

    public static String get(String url, Map<String, String> params, String charset) throws IOException {
        if (params != null && !params.isEmpty()) {
            List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String value = entry.getValue();
                if (value != null) {
                    pairs.add(new BasicNameValuePair(entry.getKey(), value));
                }
            }
            url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, charset));
        }
        log.info(url);
        HttpGet method = new HttpGet(url);
        return execute(method, charset);
    }

    public static void main(String[] args) {
        HttpGet httpGet = new HttpGet("http://test.data.sh.gov.cn/zq/api/data_set/count/");
        String execute = execute(httpGet, DEFAULT_CHARSET);
        System.out.println(execute);
    }
}
