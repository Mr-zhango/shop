package cn.myfreecloud.shop.controller;


import cn.myfreecloud.shop.basic.BaseResponse;
import cn.myfreecloud.shop.common.BaseController;
import cn.myfreecloud.shop.entity.Product;
import cn.myfreecloud.shop.service.IProductService;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    @PostMapping(value = "/queryProductHome", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse queryProductHome() {

        Optional<List<Product>> hotProductList = productService.queryHotProduct();

        Optional<List<Product>> newProductList = productService.queryNewProduct();

        BaseResponse baseResponse = new BaseResponse();

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("hotProduct",hotProductList.get());
        hashMap.put("newProduct",newProductList.get());
        baseResponse.setData(hashMap);
        baseResponse.setCode(HttpStatus.OK.toString());
        return baseResponse;
    }
}
