package co.laomag.es_spider.configs;

import co.laomag.es_spider.mapper.UserinfoMapper;
import co.laomag.es_spider.models.Userinfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    PasswordEncoder passwordEncoder;

    @Resource
    UserinfoMapper userinfoMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userinfo userinfo = userinfoMapper.selectByPrimaryName(username);
        if (userinfo==null){
            throw new UsernameNotFoundException("用名或密码不对");
        }
        return null;
    }
}
