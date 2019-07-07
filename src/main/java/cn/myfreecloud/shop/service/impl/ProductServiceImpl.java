package cn.myfreecloud.shop.service.impl;

import cn.myfreecloud.shop.entity.Product;
import cn.myfreecloud.shop.mapper.ProductMapper;
import cn.myfreecloud.shop.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Autowired
    ProductMapper productMapper;

    @Override
    public Optional<List<Product>> queryHotProduct() {
        List<Product> products = productMapper.queryHotProduct();
        return Optional.of(products);
    }

    @Override
    public Optional<List<Product>> queryNewProduct() {
        List<Product> productList = productMapper.queryNewProduct();
        return Optional.of(productList);
    }
}
