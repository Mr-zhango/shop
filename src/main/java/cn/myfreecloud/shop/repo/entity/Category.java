package cn.myfreecloud.shop.repo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_category")
public class Category implements Serializable {
    /**
     * 分类表主键
     */
    @Id
    @Column(name = "category_id")
    @GeneratedValue(generator = "JDBC")
    private String categoryId;

    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

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
     * 记录创建人账号
     */
    @Column(name = "create_user_account")
    private String createUserAccount;

    /**
     * 记录创建人姓名
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
     * 记录创建人账号
     */
    @Column(name = "delete_user_account")
    private String deleteUserAccount;

    /**
     * 记录删除日期
     */
    @Column(name = "delete_date")
    private Date deleteDate;

    private static final long serialVersionUID = -4992238080582374522L;
}