package cn.myfreecloud.shop.repo.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Data
@Table(name = "t_car")
public class Car implements Serializable {
    /**
     * 车id
     */
    @Id
    @Column(name = "car_id")
    @GeneratedValue(generator = "JDBC")
    private Integer carId;

    /**
     * 用户id
     */
    @Column(name = "u_id")
    private String uId;

    /**
     * 车name
     */
    @Column(name = "car_name")
    private String carName;

    /**
     * 有效标识
     */
    @Column(name = "alive_flag")
    private Integer aliveFlag;

    private static final long serialVersionUID = -4051691251823518671L;
}