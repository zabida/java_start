package org.mvcsecurity.security.interceptor;

import org.mvcsecurity.security.model.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object object = request.getSession().getAttribute(UserDto.SESSION_USER_KEY);
        if (object == null) {
            writeContent(response, "请登录");
        }
        UserDto userDto = (UserDto) object;
        String requestURI = request.getRequestURI();
        assert userDto != null;
        if (userDto.getAuthorities().contains("p1") && requestURI.contains("/r1")) return true;
        if (userDto.getAuthorities().contains("p2") && requestURI.contains("/r2")) return true;
        writeContent(response, "权限不足，拒绝访问");
        return false;
    }

    // 响应信息给客户端
    private void writeContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.close();
        response.resetBuffer();
    }

}
