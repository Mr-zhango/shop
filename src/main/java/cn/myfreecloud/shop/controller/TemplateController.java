package cn.myfreecloud.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: zhangyang
 * @date: 2019/6/30 13:23
 * @description: 页面调试专用Controller
 */
@Controller
public class TemplateController {

    /**
     *
     * 页面调试url
     * @return
     */
    @GetMapping("/html")
    public String toEditPage(){
        return "product/index";
    }

    /**
     *
     * 页面调试url
     * @return
     */
    @GetMapping("/admin")
    public String toAdminPage(){
        return "admin/index";
    }

    /**
     *
     * 分类页面
     * @return
     */
    @GetMapping("/categoryPage")
    public String toCategoryPage(){
        return "admin/category";
    }
}
