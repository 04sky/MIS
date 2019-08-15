package com.sky.dao;

import java.util.List;

import com.sky.pojo.Titles;

public interface TitleDao {
	
	//按ID查询职称
	Titles selectOneById(Integer id);
	
	//添加职称
	boolean addOneTitle(Titles titles);
	
	//查询所有职称
	List<Titles> selectAllTitles();
	
	//修改职称信息
	boolean updateTitle(Titles titles);
	
	//修改职称状态
	boolean updateTitleStatus(Integer id,Integer status);
}
