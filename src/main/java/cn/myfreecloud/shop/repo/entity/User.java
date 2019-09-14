package cn.myfreecloud.shop.repo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_user")
public class User implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "user_guid")
    @GeneratedValue(generator = "JDBC")
    private String userGuid;

    /**
     * 用户微信号
     */
    @Column(name = "user_weixin_id")
    private String userWeixinId;

    /**
     * 用户微信openid
     */
    @Column(name = "user_weixin_openid")
    private String userWeixinOpenid;

    /**
     * 用户微信sessionkey
     */
    @Column(name = "user_weixin_sessionkey")
    private String userWeixinSessionkey;

    /**
     * 用户微信地址
     */
    @Column(name = "user_weixin_address")
    private String userWeixinAddress;

    /**
     * 用户微信头像
     */
    @Column(name = "user_weixin_avatar")
    private String userWeixinAvatar;

    /**
     * 用户微信昵称
     */
    @Column(name = "user_weixin_nickname")
    private String userWeixinNickname;

    /**
     * 用户性别
     */
    @Column(name = "user_gender")
    private String userGender;

    /**
     * 排序
     */
    @Column(name = "row_order")
    private Integer rowOrder;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 有效状态(1:有效   0:已删除)
     */
    @Column(name = "alive_flag")
    private Integer aliveFlag;

    /**
     * 记录创建人
     */
    @Column(name = "create_user_name")
    private String createUserName;

    /**
     * 记录创建日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 记录删除人
     */
    @Column(name = "delete_user_name")
    private String deleteUserName;

    /**
     * 记录删除日期
     */
    @Column(name = "delete_date")
    private Date deleteDate;

    private static final long serialVersionUID = 6993817346653873489L;
}