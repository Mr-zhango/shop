package cn.myfreecloud.shop.service.impl;

import cn.myfreecloud.shop.basic.BasicMapper;
import cn.myfreecloud.shop.basic.service.BasicServiceImpl;
import cn.myfreecloud.shop.repo.entity.Category;
import cn.myfreecloud.shop.repo.mapper.CategoryMapper;
import cn.myfreecloud.shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class CategoryServiceImpl extends BasicServiceImpl<Category,String> implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public BasicMapper<Category> getBasicMapper() {
        return categoryMapper;
    }

    @Override
    public int saveOrUpdate(Category entity) {
        if (StringUtils.isEmpty(entity.getCid())) {
            return categoryMapper.insert(entity);
        } else {
            return categoryMapper.updateByPrimaryKeySelective(entity);
        }
    }
}
