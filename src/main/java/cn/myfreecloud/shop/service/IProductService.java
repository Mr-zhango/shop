package cn.myfreecloud.shop.service;

import cn.myfreecloud.shop.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangyang
 * @since 2019-07-06
 */
public interface IProductService extends IService<Product> {

    /**
     * 查询最热商品12条
     * @return
     */
    Optional<List<Product>> queryHotProduct();

    /**
     * 查询最新商品12条
     * @return
     */
    Optional<List<Product>> queryNewProduct();
}
