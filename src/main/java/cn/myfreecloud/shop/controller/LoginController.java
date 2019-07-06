package cn.myfreecloud.shop.controller;

import cn.myfreecloud.shop.entity.User;
import cn.myfreecloud.shop.mapper.UserMapper;
import cn.myfreecloud.shop.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    IUserService userService;

    @Autowired
    UserMapper userMapper;

    /**
     *
     * session中存放了用户的登录信息
     * @param username
     * @param password
     * @param map
     * @param session
     * @return
     */
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password,Map<String,Object> map, HttpSession session){

        map.put("username",username);
        map.put("password",password);

        List<User> userList  = userMapper.selectByMap(map);

        if(userList.size() == 1){
            //登陆成功，防止表单重复提交，可以重定向到主页main.html的中转页面,在映射到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "login";
        }

    }
}
