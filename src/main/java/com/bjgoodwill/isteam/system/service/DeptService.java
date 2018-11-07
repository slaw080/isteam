package com.bjgoodwill.isteam.system.service;


import com.bjgoodwill.isteam.common.domain.Tree;
import com.bjgoodwill.isteam.common.service.IService;
import com.bjgoodwill.isteam.system.domain.Dept;

import java.util.List;

public interface DeptService extends IService<Dept> {

	Tree<Dept> getDeptTree();

	List<Dept> findAllDepts(Dept dept);

	Dept findByName(String deptName);

	Dept findById(Long deptId);
	
	void addDept(Dept dept);
	
	void updateDept(Dept dept);

	void deleteDepts(String deptIds);
}
