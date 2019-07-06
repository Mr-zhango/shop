package cn.myfreecloud.shop.service.impl;

import cn.myfreecloud.shop.entity.User;
import cn.myfreecloud.shop.mapper.UserMapper;
import cn.myfreecloud.shop.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
