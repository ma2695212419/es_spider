package co.laomag.es_spider.service.impl;

import co.laomag.es_spider.mapper.UserinfoMapper;
import co.laomag.es_spider.models.RequestMessages;
import co.laomag.es_spider.models.Userinfo;
import co.laomag.es_spider.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("UserServiceSqlImpl")
public class UserServiceSqlImpl implements UserService {

    @Resource
    UserinfoMapper userinfoMapper;


    @Override
    public RequestMessages AddUser(Userinfo userinfo) {
        RequestMessages messages = null;
        try {
            int insert = userinfoMapper.insert(userinfo);
            if (insert>0){
                messages  = RequestMessages.success();
            }else{
                messages = RequestMessages.errorMsg("添加用户失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            messages = RequestMessages.errorMsg("程序出现异常，请联系管理员");
        }

        return messages;
    }
}
