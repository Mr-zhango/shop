package cn.myfreecloud.shop.controller;

import cn.myfreecloud.shop.entity.Category;
import cn.myfreecloud.shop.service.ICategoryService;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

/**
 * @author: zhangyang
 * @date: 2019/6/26 22:32
 * @description:
 */
@Api(tags = {"商品分类PAI"})
@Controller
@Slf4j
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    /**
     * 查询所有的商品分类信息
     *
     */
    @Timed
    @ApiOperation(value = "商品分类bar,查询所有的商品分类", notes = "curl -X POST \"http://127.0.0.1:8080/api/category/allCategory\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/api/category/allCategory", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object allCategory() {
        List<Category> list = categoryService.list();
        Optional<List<Category>> categories = Optional.of(list);
        return categories.get();
    }

    /**
     * 查询所有的商品分类信息
     *
     */
    @Timed
    @ApiOperation(value = "商品分类bar,查询所有的商品分类", notes = "curl -X POST \"http://127.0.0.1:8080/api/category/allCategory\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/toCategoryPage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String toCategoryPage() {
      return "category/index";
    }
}
