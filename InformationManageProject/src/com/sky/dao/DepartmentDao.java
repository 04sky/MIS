package com.sky.dao;

import java.util.List;

import com.sky.pojo.Departments;

public interface DepartmentDao {
	
	//按ID查询部门
	Departments selectOneById(Integer id);
	
	//添加部门
	boolean addOneDepartment(Departments dept);
	
	//查询所有部门
	List<Departments> selectAllDepartments();
	
	//修改部门信息
	boolean updateDepartment(Departments newDeptDepartments);
	
	//修改部门状态
	boolean updatedepartmentStatus(Integer id,Integer status);
	
}
