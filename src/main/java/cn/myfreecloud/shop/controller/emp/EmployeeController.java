package cn.myfreecloud.shop.controller.emp;

import cn.myfreecloud.shop.repo.entity.Department;
import cn.myfreecloud.shop.repo.entity.Employee;
import cn.myfreecloud.shop.repo.mapper.DepartmentMapper;
import cn.myfreecloud.shop.repo.mapper.EmployeeMapper;
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
public class EmployeeController {


    @Autowired
    EmployeeMapper employeeDao;

    @Autowired
    DepartmentMapper departmentDao;

    /**
     * 查询所有员工返回列表页面
     * @param model
     * @return
     */
    @GetMapping("/emps")
    public String  list(Model model){
        List<Employee> employees = employeeDao.selectAll();

        //放在请求域中
        model.addAttribute("emps",employees);
        // thymeleaf默认就会拼串
        // classpath:/templates/xxxx.html
        return "emp/list";
    }

    /**
     * 来到员工添加页面
     * @param model
     * @return
     */
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有的部门，在页面显示
        Collection<Department> depts = departmentDao.selectAll();
        model.addAttribute("depts",depts);
        return "emp/add";
    }

    //员工添加

    /**
     * SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
     * @param employee
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面

        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeDao.insert(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    /**
     * 来到修改页面，查出当前员工，在页面回显
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.selectByPrimaryKey(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.selectAll();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "emp/add";
    }

    /**
     * 员工修改；需要提交员工id；
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeeDao.updateByPrimaryKeySelective(employee);
        return "redirect:/emps";
    }

    /**
     * 员工删除
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.deleteByPrimaryKey(id);
        return "redirect:/emps";
    }


    /**
     * 来到jQueryDemo页面
     * @return
     */
    @GetMapping("/jQueryDemo/demo01")
    public String toDemo01(){
        return "jQueryDemo/input";
    }

    /**
     * json测试
     * @param id
     * @return
     */
    @GetMapping("/empJson/{id}")
    @ResponseBody
    public Object findEmpById(@PathVariable("id") Integer id){
        Employee employee = employeeDao.selectByPrimaryKey(id);
        //回到修改页面(add是一个修改添加二合一的页面);
        return employee;
    }

}
