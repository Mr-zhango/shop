package cn.myfreecloud.shop.controller;


import cn.myfreecloud.shop.basic.BasicPage;
import cn.myfreecloud.shop.basic.MyPage;
import cn.myfreecloud.shop.repo.entity.User;
import cn.myfreecloud.shop.service.UserService;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Api(tags = {"用户模块"})
@RestController
@Slf4j
public class UserController {


    @Autowired
    UserService User;

    /**
     * 解决pageHelper分页查询的分页错误问题
     * @param basicPage
     * @return
     */
    @Timed
    @ApiOperation(value = "查询所有的用户", notes = "curl -X POST \"http://127.0.0.1:8080/testAllCollectionDto\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public MyPage<User> allUser(@RequestBody BasicPage basicPage) {
        MyPage<User> cars = User.pageQuery(basicPage);
        return cars;
    }

    /**
     * 跳转BVS-文件管理-上传页面-下拉选的客户组显示
     *
     * @param request
     * @return
     */
    @RequestMapping("/userPage")
    public ModelAndView toUserPage(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("/dept/list.html");

        Map<String, Object> map = new HashMap<>();
        // 下拉选
        map.put("ESIFILECUSTOMERGROUP", "");
        view.addObject("selectValue", map);
        // url传递的参数
        view.addObject("hashMap");

        return view;
    }
}
