package cn.myfreecloud.shop.controller;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @DeleteMapping
//    @PutMapping
//    @GetMapping

    /**
     *
     * session中存放了用户的登录信息
     * @param username
     * @param password
     * @param map
     * @param session
     * @return
     */
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "111111".equals(password)){
            //登陆成功，防止表单重复提交，可以重定向到主页main.html的中转页面,在映射到主页
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else{
            //登陆失败

            map.put("msg","用户名密码错误");
            return  "login";
        }

    }

    @GetMapping(value = "/logout")
    public String login(Map<String,Object> map, HttpSession session){
        session.removeAttribute("loginUser");
        map.put("msg", "请登录");
        return  "login";
    }


}
