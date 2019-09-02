package cn.myfreecloud.shop.service.impl;

import cn.myfreecloud.shop.basic.BasicMapper;
import cn.myfreecloud.shop.basic.BasicPage;
import cn.myfreecloud.shop.basic.MyPage;
import cn.myfreecloud.shop.basic.service.BasicServiceImpl;
import cn.myfreecloud.shop.repo.entity.User;
import cn.myfreecloud.shop.repo.mapper.UserMapper;
import cn.myfreecloud.shop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl extends BasicServiceImpl<User,String> implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public BasicMapper<User> getBasicMapper() {
        return userMapper;
    }

    @Override
    public int saveOrUpdate(User entity) {
        if (StringUtils.isEmpty(entity.getUid())) {
            return userMapper.insert(entity);
        } else {
            return userMapper.updateByPrimaryKeySelective(entity);
        }
    }

    @Override
    public MyPage<User> pageQuery(BasicPage basicPage) {
        List<User> result = userMapper.selectAll();

        MyPage paging = MyPage.pagination(result.size(),basicPage.getPageSize(),basicPage.getPageIndex());

        int fromIndex = paging.getQueryIndex();
        //
        int toIndex = 0;

        if (fromIndex + paging.getPageSize() >= result.size()){
            toIndex = result.size();
        }else {
            toIndex = fromIndex +  paging.getPageSize();
        }
        //如果
        if (fromIndex > toIndex){
            return paging;
        }

        paging.setPageList(result.subList(fromIndex,toIndex));
        return paging;
    }
}
