package cn.myfreecloud.shop.controller.user;

import cn.myfreecloud.shop.repo.entity.Department;
import cn.myfreecloud.shop.repo.entity.Employee;
import cn.myfreecloud.shop.repo.entity.Product;
import cn.myfreecloud.shop.repo.entity.User;
import cn.myfreecloud.shop.repo.mapper.DepartmentMapper;
import cn.myfreecloud.shop.repo.mapper.EmployeeMapper;
import cn.myfreecloud.shop.repo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @author zhangyang
 */
@Controller
public class UserController {


    @Autowired
    UserMapper userMapper;

    /**
     * 查询所有员工返回列表页面
     * @param model
     * @return
     */
    @GetMapping("/users")
    public String  list(Model model){
        List<User> userList = userMapper.selectAll();

        //放在请求域中
        model.addAttribute("userList",userList);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "user/list";
    }


    /**
     * SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
     * @param user
     * @return
     */
    @PostMapping("/user")
    public String addEmp(User user){
        //来到员工列表页面

        System.out.println("保存的员工信息："+user);
        //保存员工
        userMapper.insert(user);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/users";
    }

    /**
     * 员工修改；需要提交员工id；
     * @param user
     * @return
     */
    @PutMapping("/user")
    public String updateEmployee(User user){
        System.out.println("修改的员工数据："+user);
        userMapper.updateByPrimaryKeySelective(user);
        return "redirect:/users";
    }

    //修改
    @GetMapping("/user/{id}")
    public String toEditPage(@PathVariable("id") String id,Model model){
        User user = userMapper.selectByPrimaryKey(id);
        model.addAttribute("user",user);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "user/add";
    }


    /**
     * 员工删除
     * @param id
     * @return
     */
    @DeleteMapping("/user/{id}")
    public String deleteEmployee(@PathVariable("id") String id){
        userMapper.deleteByPrimaryKey(id);
        return "redirect:/users";
    }

}
