package org.security.springmvcsecurity.init;


import org.security.springmvcsecurity.config.ApplicationConfig;
import org.security.springmvcsecurity.config.WebConfig;
import org.security.springmvcsecurity.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfig.class, WebSecurityConfig.class};  // 指定rootContext的配置类
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};   // 指定servletContext配置类
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
