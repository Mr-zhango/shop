package cn.myfreecloud.shop.basic.service;

import cn.myfreecloud.shop.basic.BasicMapper;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.StringJoiner;
/**
 * @author: zhangyang
 * @date: 2019/6/26 22:48
 * @description:
 */
@Slf4j
public abstract class BasicServiceImpl<T, PK> implements BasicService<T, PK> {

    /**
     * @return
     * @description 获取该service注入的对应的mapper
     */
    @Override
    public abstract BasicMapper<T> getBasicMapper();

    /**
     * @param entity
     * @return int
     * @description 插入entity到数据表
     */
    @Override
    public int insert(T entity) {
        return getBasicMapper().insert(entity);
    }

    /**
     * @param entityList
     * @return int
     * @description 批量插入entity到数据表
     */
    @Override
    public int batchInsert(List<T> entityList) {
        return getBasicMapper().insertList(entityList);
    }

    /**
     * @param pk
     * @return T
     * @description 根据主键pk查寻entity实体
     */
    @Override
    public T get(PK pk) {
        return (T) getBasicMapper().selectByPrimaryKey(pk);
    }

    /**
     * @param pkList
     * @return List<AaImport>
     * @description 根据主键id列表查寻AaImport实体列表
     */
    @Override
    public List<T> listByPKList(List<PK> pkList) {
        return getBasicMapper().selectByIds(Joiner.on(",").join(pkList));
    }

    /**
     * @param pk
     * @return int
     * @description 根据主键删除记录
     */
    @Override
    public int deleteByPk(PK pk) {
        return getBasicMapper().deleteByPrimaryKey(pk);
    }

    /**
     * @param entity
     * @return int
     * @description 根据实体删除记录
     */
    @Override
    public int delete(T entity) {
        return getBasicMapper().delete(entity);
    }

    /**
     * @param pkList
     * @return
     * @description 根据主键列表删除记录
     */
    @Override
    public int deleteByPKList(List<PK> pkList) {
        StringJoiner stringJoiner = new StringJoiner("','","'","'");
        pkList.forEach(key -> stringJoiner.add(String.valueOf(key)));
        return getBasicMapper().deleteByIds(stringJoiner.toString());
    }

    /**
     * @param entity (主键字段不能为空)
     * @return int
     * @description 根据主键id更新记录
     */
    @Override
    public int update(T entity) {
        return getBasicMapper().updateByPrimaryKeySelective(entity);
    }

    /**
     * @param entity
     * @return long
     * @description 根据主实体统计记录数
     */
    @Override
    public long count(T entity) {
        return getBasicMapper().selectCount(entity);
    }

    /**
     * @param entity
     * @return List<T>
     * @description 根据主实体查询记录
     */
    @Override
    public List<T> query(T entity) {
        return getBasicMapper().select(entity);
    }
}
