package co.laomag.es_spider.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Api(value = "登录接口类",tags = {"登录"})
public class LoginController {

//    @RequestMapping("/Login")
//    @ApiOperation(value = "登录方法",notes = "用户登录接口",tags = {"登录"})
//    @ResponseBody
//    public JSONObject Login(JSONObject body){
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("测试","登录方法");
//        return jsonObject;
//    }

    /**
     * 跳转登录页面
     * @param model 向页面添加平台名称
     * @return 页面名称
     */
    @RequestMapping("/tologin")
    public String login(Model model) {
        model.addAttribute("fullName","爬虫数据平台");
        return "login";
    }
}
