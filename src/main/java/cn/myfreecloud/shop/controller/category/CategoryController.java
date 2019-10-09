package cn.myfreecloud.shop.controller.category;

import cn.myfreecloud.shop.repo.entity.Category;
import cn.myfreecloud.shop.repo.mapper.CategoryMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class CategoryController {

    @Autowired
    CategoryMapper categoryMapper;


    //跳转到添加部门页面
    @GetMapping("/category")
    public Object  list(){
        //来到部门添加页面
        return "category/add";
    }

    //查询所有部门返回列表页面
    @GetMapping("/categorys")
    public Object  list(Model model){
        List<Category> categorys = categoryMapper.selectAll();
        model.addAttribute("categoryList",categorys);
        return "category/list";
    }

    //添加
    @PostMapping("/category")
    public String deleteDept(Category category){

        System.out.println("保存的分类信息："+category);
        category.setCategoryId(UUID.randomUUID().toString());
        category.setAliveFlag(1);
        categoryMapper.insert(category);
        return "redirect:/categorys";
    }

    //删除
    @DeleteMapping("/category/{id}")
    public String deleteDept(@PathVariable("id") String id){
        categoryMapper.deleteByPrimaryKey(id);
        return "redirect:/categorys";
    }

    //来到修改页面，查出当前部门
    @GetMapping("/category/{id}")
    public String toEditPage(@PathVariable("id") String id,Model model){
        Category category = categoryMapper.selectByPrimaryKey(id);
        model.addAttribute("dept",category);

        //回到修改页面(add是一个修改添加二合一的页面);
        return "category/add";
    }

    /**
     * 修改
     * @param category
     * @return
     */
    @ApiOperation(value = "商品分类API" ,notes = "curl -X PUT \"http://127.0.0.1:8080/category\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/category")
    public String updateDept(Category category){
        System.out.println("修改的员工数据："+category);
        categoryMapper.updateByPrimaryKeySelective(category);
        return "redirect:/categorys";
    }

}
