package com.ithm;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "datasource")
@Data
public class MyDatasource {
    private String driver;
    private String url;
    private String username;
    private String[] password;

    @Override
    public String toString(){
        return "myDatasource {" + "driver='" + driver + "'" + "url='" + url + "'" + "password='" +  password.toString();
    }
}
