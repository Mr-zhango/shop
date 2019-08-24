package cn.myfreecloud.shop.transfer.dto;

import lombok.Data;

import java.util.List;


/**
 * 返回值list样例
 */
@Data
public class ResultMapTest {

    List<QueryUnionDtoUserCar> queryUnionDtoUserCarList;

    List<QueryUnionAllDtoUserCar> queryUnionAllDtoUserCarList;

}
