package cn.myfreecloud.shop.basic;

import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

@RegisterMapper
public interface ShopMySQLMapper<T> extends Mapper<T>, IdsMapper<T>, InsertListMapper<T> {
}
