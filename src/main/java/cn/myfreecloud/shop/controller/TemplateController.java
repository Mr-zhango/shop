package cn.myfreecloud.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: zhangyang
 * @date: 2019/6/30 13:23
 * @description:
 */
@Controller
public class TemplateController {

    /**
     *
     * 页面调试url
     * @return
     */
    @GetMapping("/test/header")
    public String toEditPage(){
        return "commons/header";
    }
}
