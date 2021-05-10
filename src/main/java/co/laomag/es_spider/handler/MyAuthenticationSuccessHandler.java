package co.laomag.es_spider.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final String forwardUrl;

    public MyAuthenticationSuccessHandler(String url) {
        Assert.isTrue(UrlUtils.isAbsoluteUrl(url),
                () -> "'" + url + "' is not a valid  URL");
        this.forwardUrl = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = (User)  authentication.getPrincipal();
        // 打印用户名
        System.out.println(user.getUsername());
        // 密码，出于安全考虑，Spring Security这里会返回一个Null
        System.out.println(user.getPassword());
        // 权限
        System.out.println(user.getAuthorities());

        response.sendRedirect(forwardUrl);
    }
}
