package cn.myfreecloud.shop.service;

import cn.myfreecloud.shop.basic.service.BasicService;
import cn.myfreecloud.shop.repo.entity.Car;
import cn.myfreecloud.shop.transfer.dto.QueryUnionAllDtoUserCar;
import cn.myfreecloud.shop.transfer.dto.QueryUnionDtoUserCar;
import cn.myfreecloud.shop.transfer.dto.ResultMapTest;
import cn.myfreecloud.shop.transfer.dto.req.QueryReq;

import java.util.List;
import java.util.Optional;

/**
 * @author: zhangyang
 * @date: 2019/6/26 22:42
 * @description:
 */
public interface CarService extends BasicService<Car,String> {

   Optional<List<QueryUnionDtoUserCar>> testCollection(QueryReq req);


   Optional<List<QueryUnionAllDtoUserCar>> testAllCollection();

   Optional<List<ResultMapTest>> testAllCollectionCollection();

   Optional<List<ResultMapTest>> testAllCollectionDto();
}

