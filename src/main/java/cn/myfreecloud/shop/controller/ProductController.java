package cn.myfreecloud.shop.controller;


import cn.myfreecloud.shop.common.BaseController;
import cn.myfreecloud.shop.entity.Product;
import cn.myfreecloud.shop.service.IProductService;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * 商品模块
 * @author zhangyang
 * @since 2019-07-06
 */
@Controller
public class ProductController extends BaseController {

    @Autowired
    IProductService productService;

    @Timed
    @ApiOperation(value = "查询热门商品12个", notes = "curl -X POST \"http://127.0.0.1:8080/api/all\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/queryProductHome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ModelAndView queryProductHome() {

        //视图和模型对象,初始化的时候就设置页面的地址
        ModelAndView modelAndView = new ModelAndView("commons/header");
        //数据
        Optional<List<Product>> hotProductList = productService.queryHotProduct();

        Optional<List<Product>> newProductList = productService.queryNewProduct();

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("hotProduct",hotProductList.get());
        hashMap.put("newProduct",newProductList.get());

        modelAndView.addObject("hotProduct",hotProductList.get());

        return modelAndView;
    }
}
