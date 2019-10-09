package cn.myfreecloud.shop.repo.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_product")
public class Product implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name = "product_guid")
    @GeneratedValue(generator = "JDBC")
    private String productGuid;

    /**
     * 图片链接
     */
    @Column(name = "product_image")
    private String productImage;

    /**
     * 分类表主键
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商品价格，单位为：元
     */
    @Column(name = "product_price")
    private BigDecimal productPrice;

    /**
     * 商品库存数量
     */
    @Column(name = "product_stock_count")
    private String productStockCount;

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

    private static final long serialVersionUID = 3454620945937940304L;

}