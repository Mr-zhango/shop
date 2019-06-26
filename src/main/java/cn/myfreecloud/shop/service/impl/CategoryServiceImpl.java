package cn.myfreecloud.shop.service.impl;

import cn.myfreecloud.shop.basic.BasicMapper;
import cn.myfreecloud.shop.basic.service.BasicServiceImpl;
import cn.myfreecloud.shop.repo.entity.Category;
import cn.myfreecloud.shop.repo.mapper.CategoryMapper;
import cn.myfreecloud.shop.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: zhangyang
 * @date: 2019/6/26 22:42
 * @description:
 */
@Service
@Slf4j
public class CategoryServiceImpl extends BasicServiceImpl<Category,String> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public BasicMapper<Category> getBasicMapper() {
        return categoryMapper;
    }

    @Override
    public int saveOrUpdate(Category entity) {
        return 0;
    }

    @Override
    public Optional<List<Category>> queryAllCategory() {
        List<Category> categories = categoryMapper.selectAll();
        return Optional.of(categories);
    }
}