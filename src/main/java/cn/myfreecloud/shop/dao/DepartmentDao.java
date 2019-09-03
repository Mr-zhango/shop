//package cn.myfreecloud.shop.dao;
//
//import cn.myfreecloud.shop.entities.Department;
//import cn.myfreecloud.shop.mapper.DepartmentMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//
//@Repository
//public class DepartmentDao {
//
//    /**
//     * 注入部门mapper
//     */
//    @Autowired
//    private DepartmentMapper departmentMapper;
//
//    /**
//     * 添加部门
//     * @param department
//     * @return
//     */
//    public Integer insertDept(Department department){
//        return departmentMapper.insertDept(department);
//    }
//
//    /**
//     * 删除部门
//     * @param id
//     * @return
//     */
//    public void deleteDet(Integer id){
//        departmentMapper.deleteDet(id);
//    }
//
//    /**
//     * 修改部门
//     * @return
//     */
//    public void updateDet(Department department){
//        departmentMapper.updateDet(department);
//    }
//
//    /**
//     * 查询部门
//     * @param id
//     * @return
//     */
//    public Department getDept(Integer id){
//        return departmentMapper.getDept(id);
//    }
//
//    /**
//     * 查询所有的部门
//     * @return
//     */
//    public List<Department> getAllDept(){
//        return departmentMapper.getAllDept();
//    }
//}
