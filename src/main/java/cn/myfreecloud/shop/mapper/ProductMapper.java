package cn.myfreecloud.shop.mapper;

import cn.myfreecloud.shop.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangyang
 * @since 2019-07-06
 */
public interface ProductMapper extends BaseMapper<Product> {

    List<Product> queryHotProduct();

    List<Product> queryNewProduct();
}
