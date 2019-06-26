package cn.myfreecloud.shop.basic.service;

import cn.myfreecloud.shop.basic.BasicMapper;

import java.util.List;

/**
 * @author: zhangyang
 * @date: 2019/6/26 22:48
 * @description:
 */
public interface BasicService<T, PK> {
    /**
     * @return
     * @description 获取该service注入的对应的mapper
     */
    public BasicMapper<T> getBasicMapper();

    /**
     * @param entity
     * @return int
     * @description 插入entity到数据表
     */
    public int insert(T entity);

    /**
     * @param entityList
     * @return int
     * @description 批量插入entity到数据表
     */
    public int batchInsert(List<T> entityList);

    /**
     * @return AaCode
     * @description 根据主键pk查寻entity实体
     */
    public T get(PK pk);

    /**
     * @param pkList
     * @return List<T>
     * @description 根据主键pk列表查寻AaCode实体列表
     */
    public List<T> listByPKList(List<PK> pkList);

    /**
     * @return int
     * @description 根据主键pk删除记录
     */
    public int deleteByPk(PK pk);

    /**
     * @param entity 不能所有字段都为空，否则sql执行出错
     * @return int
     * @description 根据实体删除记录
     */
    public int delete(T entity);

    /**
     * @param pkList
     * @return int
     * @description 根据主键pk列表删除记录
     */
    public int deleteByPKList(List<PK> pkList);

    /**
     * @param entity 主键id字段不能为空
     * @return int
     * @description 根据主键id更新记录
     */
    public int update(T entity);


    /**
     * @param aaCode
     * @return int
     * @description 根据主实体统计记录数
     */
    public long count(T aaCode);

    /**
     * @param entity
     * @return int
     * @description 根据主实体查询记录
     */
    public List<T> query(T entity);


    /**
     * 更新或保存
     *
     * @param entity
     * @return
     */
    public int saveOrUpdate(T entity);

}
