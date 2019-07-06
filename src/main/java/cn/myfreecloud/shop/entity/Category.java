package cn.myfreecloud.shop.entity;

import cn.myfreecloud.shop.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangyang
 * @since 2019-07-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Category对象", description="")
public class Category extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String cid;

    private String cname;


}
