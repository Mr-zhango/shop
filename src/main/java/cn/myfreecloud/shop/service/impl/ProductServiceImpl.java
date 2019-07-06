package cn.myfreecloud.shop.service.impl;

import cn.myfreecloud.shop.entity.Product;
import cn.myfreecloud.shop.mapper.ProductMapper;
import cn.myfreecloud.shop.service.IProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
