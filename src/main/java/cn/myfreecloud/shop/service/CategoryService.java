package cn.myfreecloud.shop.service;

import cn.myfreecloud.shop.basic.service.BasicService;
import cn.myfreecloud.shop.repo.entity.Category;

import java.util.List;
import java.util.Optional;

/**
 * @author: zhangyang
 * @date: 2019/6/26 22:42
 * @description:
 */
public interface CategoryService extends BasicService<Category,String> {

    /**
     * 查询所有的商品分类信息
     * @return
     */
   Optional<List<Category>> queryAllCategory();
}
