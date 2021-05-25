package co.laomag.es_spider.configs;

import co.laomag.es_spider.mapper.MenuMapper;
import co.laomag.es_spider.mapper.RoleMenuMapper;
import co.laomag.es_spider.models.Menu;
import co.laomag.es_spider.models.RoleMenu;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 获取当前请求路径url
 * 获取数据库全部有权限（角色）的url
 */
@Component
public class DynamicFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    /**
     * 菜单的数据库操作类
     */
    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;


    /**
     * Ant样式路径模式的PathMatcher实现。
     */
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 返回本次访问需要的权限，可以有多个权限
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取到当前的URI
        String requestURI = ((FilterInvocation) object).getRequest().getRequestURI();
        List<Menu> menus = menuMapper.selectAll();
        for (Menu menu : menus) {
            boolean match = antPathMatcher.match(menu.getUrl(), requestURI);
            if (match) {
                List<RoleMenu> roleMenus = roleMenuMapper.selectByMenuId(menu.getId());
                String[] rs = new String[roleMenus.size()];
                Set<String> collect = roleMenus.stream().map(RoleMenu::getRoleId).collect(Collectors.toSet());
                List<ConfigAttribute> list = SecurityConfig.createList(collect.toArray(new String[0]));
                return  list;
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
