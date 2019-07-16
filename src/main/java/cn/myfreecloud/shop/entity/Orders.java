package cn.myfreecloud.shop.entity;

import java.time.LocalDateTime;
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
 * @since 2019-07-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Orders对象", description="")
public class Orders extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String oid;

    private LocalDateTime ordertime;

    private Double total;

    private Integer state;

    private String address;

    private String name;

    private String telephone;

    private String uid;


}
