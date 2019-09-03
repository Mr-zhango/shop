package cn.myfreecloud.shop.controller.dept;

import cn.myfreecloud.shop.repo.entity.Department;
import cn.myfreecloud.shop.repo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentDao;


    //跳转到添加部门页面
    @GetMapping("/dept")
    public Object  list(){
        //来到部门添加页面
        return "dept/add";
    }

    //查询所有部门返回列表页面
    @GetMapping("/depts")
    public Object  list(Model model){
        List<Department> depts = departmentDao.selectAll();
        model.addAttribute("depts",depts);
        return "dept/list";
    }

    //添加部门
    @PostMapping("/dept")
    public String deleteDept(Department department){

        System.out.println("保存的部门信息："+department);

        departmentDao.insert(department);
        //重定向到部门类表页面
        return "redirect:/depts";
    }

    //删除部门
    @DeleteMapping("/dept/{id}")
    public String deleteDept(@PathVariable("id") Integer id){
        departmentDao.deleteByPrimaryKey(id);
        return "redirect:/depts";
    }

    //来到修改页面，查出当前部门
    @GetMapping("/dept/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Department department = departmentDao.selectByPrimaryKey(id);
        model.addAttribute("dept",department);

        //回到修改页面(add是一个修改添加二合一的页面);
        return "dept/add";
    }

    //部门修改；需要提交部门id；
    @PutMapping("/dept")
    public String updateDept(Department department){
        System.out.println("修改的员工数据："+department);
        departmentDao.updateByPrimaryKeySelective(department);
        return "redirect:/depts";
    }

}
