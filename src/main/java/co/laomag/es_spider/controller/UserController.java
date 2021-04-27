package co.laomag.es_spider.controller;

import co.laomag.es_spider.models.RequestMessages;
import co.laomag.es_spider.models.Userinfo;
import co.laomag.es_spider.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController(value = "/admin")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/adduser")
    public RequestMessages AddUser(Userinfo userinfo){
        return userService.AddUser(userinfo);

    }
}
