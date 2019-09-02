package cn.myfreecloud.shop.controller;


import cn.myfreecloud.shop.basic.BaseResponse;
import cn.myfreecloud.shop.basic.BasicPage;
import cn.myfreecloud.shop.basic.MyPage;
import cn.myfreecloud.shop.service.CarService;
import cn.myfreecloud.shop.transfer.dto.QueryUnionAllDtoUserCar;
import cn.myfreecloud.shop.transfer.dto.QueryUnionDtoUserCar;
import cn.myfreecloud.shop.transfer.dto.ResultMapTest;
import cn.myfreecloud.shop.transfer.dto.req.QueryReq;
import com.codahale.metrics.annotation.Timed;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"测试关联查询"})
@RestController
@Slf4j
public class CarController {


    @Autowired
    CarService carService;

    @Timed
    @ApiOperation(value = "最常用的collection查询方式", notes = "curl -X POST \"http://127.0.0.1:8080/testCollection\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/testCollection", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse testCollection(@RequestBody QueryReq req) {
        Optional<List<QueryUnionDtoUserCar>> cars = carService.testCollection(req);
        return cars.map(BaseResponse::new).orElseGet(BaseResponse::new);
    }

    @Timed
    @ApiOperation(value = "直接把查询结果封装成dto返回的查询方式", notes = "curl -X POST \"http://127.0.0.1:8080/testAllCollection\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/testAllCollection", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object testAllCollection(@RequestBody QueryReq req) {
        Optional<List<QueryUnionAllDtoUserCar>> cars = carService.testAllCollection();
        return cars.map(BaseResponse::new).orElseGet(BaseResponse::new);
    }

    @Timed
    @ApiOperation(value = "询结果封装成list返回的查询方式", notes = "curl -X POST \"http://127.0.0.1:808/testAllCollectionCollection\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/testAllCollectionCollection", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object testAllCollectionCollection(@RequestBody QueryReq req) {
        Optional<List<ResultMapTest>> cars = carService.testAllCollectionCollection();
        return cars.map(BaseResponse::new).orElseGet(BaseResponse::new);
    }

    @Timed
    @ApiOperation(value = "询结果封装成list(dto)返回的查询方式", notes = "curl -X POST \"http://127.0.0.1:8080/testAllCollectionDto\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/testAllCollectionDto", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object testAllCollectionDto(@RequestBody QueryReq req) {
        Optional<List<ResultMapTest>> cars = carService.testAllCollectionDto();
        return cars.map(BaseResponse::new).orElseGet(BaseResponse::new);
    }

    /**
     * 解决pageHelper分页查询的分页错误问题
     * @param basicPage
     * @return
     */
    @Timed
    @ApiOperation(value = "询结果封装成list(dto)返回的查询方式", notes = "curl -X POST \"http://127.0.0.1:8080/testAllCollectionDto\" -H \"accept: application/json;charset=UTF-8\"")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/testAllCollectionDto", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public  MyPage<QueryUnionDtoUserCar> fixAllCollectionDto(@RequestBody BasicPage basicPage) {
        MyPage<QueryUnionDtoUserCar> cars = carService.fixAllCollectionDto(basicPage);
        return cars;
    }
}
