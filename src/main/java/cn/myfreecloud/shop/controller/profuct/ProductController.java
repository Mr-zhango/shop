package cn.myfreecloud.shop.controller.profuct;

import cn.myfreecloud.shop.repo.entity.Category;
import cn.myfreecloud.shop.repo.entity.Product;
import cn.myfreecloud.shop.repo.mapper.CategoryMapper;
import cn.myfreecloud.shop.repo.mapper.ProductMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 跳转到添加部门页面
     * @return
     */
    @GetMapping("/product")
    public String  list(Model model){

        //查询所有的分类信息
        List<Category> categoryList = categoryMapper.selectAll();
        model.addAttribute("categoryList",categoryList);
        //来到部门添加页面
        return "product/add";
    }

    @GetMapping("/products")
    public Object toAddPage(Model model){
        List<Product> productList = productMapper.selectAll();
        model.addAttribute("productList",productList);
        return "product/list";
    }

    /**
     * 添加方法
     * @param product
     * @return
     */
    @PostMapping("/product")
    public String deleteDept(Product product){
        System.out.println("保存的商品信息："+product);
        productMapper.insert(product);
        return "redirect:/products";
    }

    //删除
    @DeleteMapping("/product/{id}")
    public String deleteDept(@PathVariable("id") Integer id){
        productMapper.deleteByPrimaryKey(id);
        return "redirect:/products";
    }

    //修改
    @GetMapping("/product/{id}")
    public String toEditPage(@PathVariable("id") String id,Model model){
        Product product = productMapper.selectByPrimaryKey(id);
        model.addAttribute("product",product);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "product/add";
    }

    /**
     * 修改
     * @param product
     * @return
     */
    @ApiOperation(value = "商品分类API" ,notes = "curl -X PUT \"http://127.0.0.1:8080/category\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/product")
    public String updateDept(Product product){
        System.out.println("修改的员工数据："+product);
        productMapper.updateByPrimaryKeySelective(product);
        return "redirect:/products";
    }

}
