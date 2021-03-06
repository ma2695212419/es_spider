package co.laomag.es_spider.configs;

import co.laomag.es_spider.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ForwardAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Resource
    DynamicFilterInvocationSecurityMetadataSource dynamicFilterInvocationSecurityMetadataSource;

    @Resource
    DynamicAccessControlConfiguration decisionVoters;

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



    /**
     * ??????user-detail??????
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }


    /**
     * ????????????
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //????????????
        http.formLogin()
                .loginPage("/tologin")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new MyAuthenticationSuccessHandler("https://www.bilibili.com/"))
                .and()
                //??????
                .authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .antMatchers("/tologin").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/assets/**").permitAll()
//                .antMatchers("/main").hasAnyAuthority("main")
                .anyRequest().authenticated();
//        super.configure(http);
        http.exceptionHandling().accessDeniedHandler(new AccessDeniedHandler() {
            @Override
            public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                // ???????????????
                response.setHeader("Content-Type", "application/json;charset=utf-8");
                PrintWriter printWriter = response.getWriter();
                // ?????????????????????
                printWriter.write("{\"status\":\"error\",\"msg\":\"????????????????????????????????????\",\"code\":\"403\"}");
                printWriter.flush();
                printWriter.close();
            }
        });
        //??????csrf??????
        http.csrf().disable();
        http.addFilterAt(customAuthenticationFilter(),
                UsernamePasswordAuthenticationFilter.class);
        http.headers().frameOptions().sameOrigin();
    }

    /**
     * ????????????
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write("{\"status\":\"ok\",\"msg\":\"????????????\",\"code\":\"0\"}");
                out.flush();
                out.close();
            }
        });
        //????????????????????????WebSecurityConfigurerAdapter?????????AuthenticationManager????????????????????????AuthenticationManager
        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }


    private ObjectPostProcessor<FilterSecurityInterceptor> filterSecurityInterceptorObjectPostProcessor() {
        return new ObjectPostProcessor<FilterSecurityInterceptor>() {
            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O object) {

                object.setAccessDecisionManager(decisionVoters);
                object.setSecurityMetadataSource(dynamicFilterInvocationSecurityMetadataSource);
                return object;
            }
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
