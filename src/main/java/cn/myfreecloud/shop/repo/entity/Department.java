package cn.myfreecloud.shop.repo.entity;

import java.io.Serializable;
import javax.persistence.*;

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

    private static final long serialVersionUID = 1L;

    /**
     * 获取部门主键id
     *
     * @return DEPARTMENT_ID - 部门主键id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门主键id
     *
     * @param departmentId 部门主键id
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取部门名称
     *
     * @return DEPARTMENT_NAME - 部门名称
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 设置部门名称
     *
     * @param departmentName 部门名称
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }
}