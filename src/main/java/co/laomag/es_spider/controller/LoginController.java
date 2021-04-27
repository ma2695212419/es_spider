package co.laomag.es_spider.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "登录接口类",tags = {"登录"})
public class LoginController {

    @PostMapping("/Login")
    @ApiOperation(value = "登录方法",notes = "用户登录接口",tags = {"登录"})
    public JSONObject Login(JSONObject body){
        return null;
    }
}
