package cn.myfreecloud.shop.repo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

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

    private static final long serialVersionUID = 1L;

    /**
     * 获取员工表主键
     *
     * @return EMPLOYEE_ID - 员工表主键
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * 设置员工表主键
     *
     * @param employeeId 员工表主键
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 获取员工姓名
     *
     * @return LAST_NAME - 员工姓名
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 设置员工姓名
     *
     * @param lastName 员工姓名
     */
    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    /**
     * 获取员工邮箱
     *
     * @return EMAIL - 员工邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置员工邮箱
     *
     * @param email 员工邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取员工性别
     *
     * @return GENDER - 员工性别
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置员工性别
     *
     * @param gender 员工性别
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取员工部门id
     *
     * @return DEPARTMENT_ID - 员工部门id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置员工部门id
     *
     * @param departmentId 员工部门id
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取员工生日
     *
     * @return BIRTHDAY - 员工生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置员工生日
     *
     * @param birthday 员工生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}