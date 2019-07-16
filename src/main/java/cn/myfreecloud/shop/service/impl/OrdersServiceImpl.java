package cn.myfreecloud.shop.service.impl;

import cn.myfreecloud.shop.entity.Orders;
import cn.myfreecloud.shop.mapper.OrdersMapper;
import cn.myfreecloud.shop.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangyang
 * @since 2019-07-16
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
