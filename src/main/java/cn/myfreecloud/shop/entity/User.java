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
@ApiModel(value="User对象", description="")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String uid;

    private String username;

    private String password;

    private String name;

    private String email;

    private String telephone;

    private Date birthday;

    private String gender;

    private Integer state;

    private String code;

    private String content;


}
