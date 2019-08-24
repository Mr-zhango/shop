package cn.myfreecloud.shop.repo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @Column(name = "u_id")
    @GeneratedValue(generator = "JDBC")
    private String uId;

    @Column(name = "user_name")
    private String userName;

    /**
     * 有效标识
     */
    @Column(name = "alive_flag")
    private Integer aliveFlag;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "state")
    private Integer state;

    private static final long serialVersionUID = 2624416548753286268L;
}