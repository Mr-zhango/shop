package cn.myfreecloud.shop.controller;


import cn.myfreecloud.shop.basic.BaseResponse;
import cn.myfreecloud.shop.common.BaseController;
import cn.myfreecloud.shop.entity.Product;
import cn.myfreecloud.shop.service.IProductService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 商品模块
 * @author zhangyang
 * @since 2019-07-06
 */
@RestController
@RequestMapping("/api/product")
public class ProductController extends BaseController {

    @Autowired
    IProductService productService;

    @Timed
    @ApiOperation(value = "查询热门商品12个", notes = "curl -X POST \"http://127.0.0.1:8080/api/all\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/hotProduct", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse allProduct(
            /*@RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
            @RequestParam(value = "total", required = false, defaultValue = "20") Integer size*/) {
        Optional<List<Product>> products = productService.queryHotProduct();
        return products.map(BaseResponse::new).orElseGet(BaseResponse::new);
    }

    @Timed
    @ApiOperation(value = "查询最新商品12个", notes = "curl -X POST \"http://127.0.0.1:8080/api/all\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/newProduct", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse newProduct(
            @RequestParam(value = "current", required = false, defaultValue = "1") Integer current,
            @RequestParam(value = "total", required = false, defaultValue = "20") Integer size) {

        IPage<Product> tiPage = new Page();
        //当前页,默认第一页
        tiPage.setCurrent(current);
        //每页数,默认查询20条
        tiPage.setSize(size);

        IPage<Product> page = productService.page(tiPage);

        Optional<IPage<Product>> categories = Optional.of(page);
        return categories.map(BaseResponse::new).orElseGet(BaseResponse::new);
    }

}
