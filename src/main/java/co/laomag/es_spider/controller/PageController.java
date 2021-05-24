package co.laomag.es_spider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * @author mzp
 * @version 1.0
 * @
 * @date 2021/5/24 17:29
 */
@Controller
public class PageController {

    @RequestMapping("/index")
    public String Index(Model model) {
        model.addAttribute("fullName","爬虫数据平台");
        model.addAttribute("nickName","nickName");
        model.addAttribute("version","version");
        /**
         * 菜单
         */
        model.addAttribute("menuList",new ArrayList<String>());
        model.addAttribute("avatar","侧耳");
        model.addAttribute("realname","侧耳");

        return "index";
    }


    @RequestMapping("/main")
    public String Main(Model model) {


        return "main";
    }




}
