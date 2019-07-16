package cn.myfreecloud.shop.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: zhangyang
 * @date: 2019/6/26 22:32
 * @description:
 */
@Api(tags = {"商品分类PAI"})
@Controller
@Slf4j
public class CategoryPageController {


    /***************跳转页面的两种方法介绍:开始***************/
    /**
     *
     * 页面调试url
     * @return
     */
    @RequestMapping("/category/toCategoryPage")
    public String toEditPage(){
        return "commons/header";
    }


    @RequestMapping("/category/toPage")
    public ModelAndView toTestPage(){
        ModelAndView view = new ModelAndView("commons/header");
        return view;
    }

    /***************跳转页面的两种方法介绍:结束***************/



}
