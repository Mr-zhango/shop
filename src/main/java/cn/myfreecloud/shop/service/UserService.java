package cn.myfreecloud.shop.service;

import cn.myfreecloud.shop.basic.BasicPage;
import cn.myfreecloud.shop.basic.MyPage;
import cn.myfreecloud.shop.basic.service.BasicService;
import cn.myfreecloud.shop.repo.entity.User;
import org.springframework.stereotype.Service;

public interface UserService extends BasicService<User,String> {

    MyPage<User> pageQuery(BasicPage basicPage);
}