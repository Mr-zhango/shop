package cn.myfreecloud.shop.service.impl;

import cn.myfreecloud.shop.basic.BasicMapper;
import cn.myfreecloud.shop.basic.BasicPage;
import cn.myfreecloud.shop.basic.MyPage;
import cn.myfreecloud.shop.basic.service.BasicServiceImpl;
import cn.myfreecloud.shop.repo.entity.Car;
import cn.myfreecloud.shop.repo.mapper.CarMapper;
import cn.myfreecloud.shop.service.CarService;
import cn.myfreecloud.shop.transfer.dto.QueryUnionAllDtoUserCar;
import cn.myfreecloud.shop.transfer.dto.QueryUnionDtoUserCar;
import cn.myfreecloud.shop.transfer.dto.ResultMapTest;
import cn.myfreecloud.shop.transfer.dto.req.QueryReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: zhangyang
 * @date: 2019/6/26 22:42
 * @description:
 */
@Service
@Slf4j
public class CarServiceImpl extends BasicServiceImpl<Car,String> implements CarService {

    @Autowired
    private CarMapper carMapper;

    @Override
    public BasicMapper<Car> getBasicMapper() {
        return carMapper;
    }

    @Override
    public int saveOrUpdate(Car entity) {
        return 0;
    }

    @Override
    public Optional<List<QueryUnionDtoUserCar>> testCollection(QueryReq req) {
        //添加分页查询
        //请注意这里分页查询的问题
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<QueryUnionDtoUserCar> list = carMapper.testCollection();
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setList(list);
        return Optional.ofNullable(list);
    }

    @Override
    public Optional<List<QueryUnionAllDtoUserCar>> testAllCollection() {
        List<QueryUnionAllDtoUserCar> list = carMapper.testAllCollection();
        return Optional.ofNullable(list);
    }


    @Override
    public Optional<List<ResultMapTest>> testAllCollectionCollection() {
        List<ResultMapTest> list = carMapper.testAllCollectionCollection();
        return Optional.ofNullable(list);
    }

    @Override
    public Optional<List<ResultMapTest>> testAllCollectionDto() {
        List<ResultMapTest> list = carMapper.testAllCollectionDto();
        return Optional.ofNullable(list);
    }

    @Override
    public MyPage<QueryUnionDtoUserCar> fixAllCollectionDto(BasicPage basicPage) {


        List<QueryUnionDtoUserCar> result = carMapper.fixAllCollectionDto();

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