package cn.myfreecloud.shop.entity;

import cn.myfreecloud.shop.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

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
@ApiModel(value="Product对象", description="")
public class Product extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String pid;

    private String pname;

    private Double marketPrice;

    private Double shopPrice;

    private String pimage;

    private Date pdate;

    private Integer isHot;

    private String pdesc;

    private Integer pflag;

    private String cid;


}
