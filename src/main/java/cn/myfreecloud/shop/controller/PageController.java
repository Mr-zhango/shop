package cn.myfreecloud.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author: zhangyang
 * @date: 2019/7/7 22:54
 * @description:
 */
@RestController
public class PageController {

    /**
     *  @RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
     *  @RequestParam(value = "total", required = false, defaultValue = "20") Integer size
     */


    /**
     * 跳转到产品列表页面
     * @return
     */
    @RequestMapping("/toProductListPage")
    public ModelAndView allProduct() {

        ModelAndView view = new ModelAndView("/templates/product/index.html");

        return view;
    }
}
