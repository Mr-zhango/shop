package cn.myfreecloud.shop.transfer.dto;

import cn.myfreecloud.shop.repo.entity.Car;
import lombok.Data;

import java.util.List;

@Data
public class QueryUnionDtoUserCar {

    private String uId;
    private String userName;
    private String name;

    List<Car> carList;

}
