package cn.myfreecloud.shop.repo.mapper;

import cn.myfreecloud.shop.basic.BasicMapper;
import cn.myfreecloud.shop.repo.entity.Car;
import cn.myfreecloud.shop.transfer.dto.QueryUnionAllDtoUserCar;
import cn.myfreecloud.shop.transfer.dto.QueryUnionDtoUserCar;
import cn.myfreecloud.shop.transfer.dto.ResultMapTest;

import java.util.List;

public interface CarMapper extends BasicMapper<Car> {

    List<QueryUnionDtoUserCar> testCollection();

    List<QueryUnionAllDtoUserCar> testAllCollection();

    List<ResultMapTest> testAllCollectionCollection();

    List<ResultMapTest> testAllCollectionDto();

    List<QueryUnionDtoUserCar> fixAllCollectionDto();
}
