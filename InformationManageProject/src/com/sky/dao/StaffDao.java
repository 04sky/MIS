package com.sky.dao;

import java.util.List;

import com.sky.pojo.Staffs;

public interface StaffDao {
	
	//按ID查询员工
	Staffs selectOneById(Integer id);
	
	//添加员工
	boolean addOneStaff(Staffs staff);
	
	//查询所有员工
	List<Staffs> selectAllStaffs();
	
	//修改员工信息
	boolean updateStaff(Staffs staff);
	
	//修改员工状态
	boolean updateStaffStatus(Integer id,Integer status);
}
