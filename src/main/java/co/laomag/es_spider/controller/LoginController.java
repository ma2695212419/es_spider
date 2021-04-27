package co.laomag.es_spider.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "登录接口类",tags = {"登录"})
public class LoginController {

    @RequestMapping("/Login")
    @ApiOperation(value = "登录方法",notes = "用户登录接口",tags = {"登录"})
    @ResponseBody
    public JSONObject Login(JSONObject body){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("测试","登录方法");
        return jsonObject;
    }
}
