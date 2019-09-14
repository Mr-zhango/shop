package cn.myfreecloud.shop.repo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "t_employee")
public class Employee implements Serializable {
    /**
     * 员工表主键
     */
    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(generator = "JDBC")
    private Integer employeeId;

    /**
     * 员工姓名
     */
    @Column(name = "LAST_NAME")
    private String lastName;

    /**
     * 员工邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 员工性别
     */
    @Column(name = "GENDER")
    private Integer gender;

    /**
     * 员工部门id
     */
    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;

    /**
     * 员工生日
     */
    @Column(name = "BIRTHDAY")
    private Date birthday;

    private static final long serialVersionUID = -7154503090114926333L;

}