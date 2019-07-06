package cn.myfreecloud.shop.controller;

import cn.myfreecloud.shop.basic.BaseResponse;
import cn.myfreecloud.shop.repo.entity.Category;
import cn.myfreecloud.shop.service.CategoryService;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author: zhangyang
 * @date: 2019/6/26 22:32
 * @description:
 */
@Api(tags = {"商品分类PAI"})
@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    /**
     * 查询所有的商品分类信息
     *
     */
    @Timed
    @ApiOperation(value = "商品分类bar,查询所有的商品分类", notes = "curl -X POST \"http://127.0.0.1:8080/api/category/allCategory\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/allCategory", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse allCategory() {
        Optional<List<Category>> categories = categoryService.queryAllCategory();
        return categories.map(BaseResponse::new).orElseGet(BaseResponse::new);
    }
}