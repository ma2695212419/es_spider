package co.laomag.es_spider.service;

import co.laomag.es_spider.models.RequestMessages;
import co.laomag.es_spider.models.Userinfo;
import com.github.pagehelper.PageInfo;

public interface UserService {
    RequestMessages AddUser(Userinfo userinfo);
}
