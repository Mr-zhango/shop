package cn.myfreecloud.shop.service.impl;

import cn.myfreecloud.shop.entity.Category;
import cn.myfreecloud.shop.mapper.CategoryMapper;
import cn.myfreecloud.shop.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangyang
 * @since 2019-07-06
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
