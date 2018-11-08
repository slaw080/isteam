package com.bjgoodwill.isteam.system.service;


import com.bjgoodwill.isteam.common.domain.Tree;
import com.bjgoodwill.isteam.common.service.IService;
import com.bjgoodwill.isteam.system.domain.Dept;

import java.util.List;

/**
 * @ClassName DeptService
 * @Description 部门服务
 * @Author LI JUN
 * @Date 2018/11/7 11:24
 * @Version 0.0.1
 */
public interface DeptService extends IService<Dept> {

    Tree<Dept> getDeptTree();

    List<Dept> findAllDepts(Dept dept);

    Dept findByName(String deptName);

    Dept findById(Long deptId);

    void addDept(Dept dept);

    void updateDept(Dept dept);

    void deleteDepts(String deptIds);
}
