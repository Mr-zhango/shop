package cn.myfreecloud.shop.constant;

public interface Constant {

    /**
     * 用户已激活
     */
    int USER_IS_ACTIVE = 1;
    /**
     * 用户未激活
     */
    int USER_IS_NOT_ACTIVE = 0;
    /**
     * 商品不是热门
     */
    int PRODUCT_IS_NOT_HOT = 0;
    /**
     * 商品是热门
     */
    int PRODUCT_IS_HOT = 1;
    /**
     * 订单未付款
     */
    int ORDER_WEIFUKUAN = 0;
    /**
     * 订单已付款
     */
    int ORDER_YIFUKUAN = 1;
    /**
     * 订单已发货
     */
    int ORDER_YIFAHUO = 2;
    /**
     * 订单已完成
     */
    int ORDER_YIWANCHENG = 3;
    /**
     * 上架
     */
    int PRODUCT_ON = 0;
    /**
     * 下架
     */
    int PRODUCT_OFF = 1;

    /**
     * 是管理员
     */
    int USER_IS_ADMIN=1;
    /**
     * 不是管理员
     */
    int USER_IS_NOT_ADMIN=0;

}
