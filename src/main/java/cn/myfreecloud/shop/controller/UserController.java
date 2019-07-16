package cn.myfreecloud.shop.controller;


import cn.myfreecloud.shop.basic.BaseResponse;
import cn.myfreecloud.shop.common.BaseController;
import cn.myfreecloud.shop.entity.User;
import cn.myfreecloud.shop.service.IUserService;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 用户模块
 * @author zhangyang
 * @since 2019-07-06
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {
    @Autowired
    IUserService userService;

    @Timed
    @ApiOperation(value = "查询所有的用户信息", notes = "curl -X POST \"http://127.0.0.1:8080/api/all\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/allUSer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse allCategory() {

        List<User> list = userService.list();

        Optional<List<User>> categories = Optional.of(list);
        return categories.map(BaseResponse::new).orElseGet(BaseResponse::new);
    }

}
