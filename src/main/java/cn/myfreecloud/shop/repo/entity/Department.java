package cn.myfreecloud.shop.repo.entity;

import lombok.Data;

import java.io.Serializable;
import javax.persistence.*;

@Data
@Table(name = "t_department")
public class Department implements Serializable {
    /**
     * 部门主键id
     */
    @Id
    @Column(name = "DEPARTMENT_ID")
    @GeneratedValue(generator = "JDBC")
    private Integer departmentId;

    /**
     * 部门名称
     */
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    private static final long serialVersionUID = 988962512212538438L;
}