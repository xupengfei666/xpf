package com.mayidb.service;

import java.util.List;

import com.mayidb.pojo.DemoData;

import common.pojo.GroupBy;
import common.pojo.Limit;
import common.pojo.OrderBy;
import common.pojo.Where;

public interface IDemoService {

	/**
	 * @Title: addDatas
	 * @Description: 模拟添加数据
	 * @author: 许鹏飞
	 * @param: @return 参数说明
	 * @return: List<DemoData> 返回类型
	 * @throws
	 */
	 List<DemoData> addDatas(int count) ;
	
	
	/**
	 * @Title: query
	 * @Description: 描述这个方法的作用
	 * @author: 许鹏飞
	 * @param: @param data  模拟数据集合
	 * @param: @param where  条件查询，支持多个，以set方式设置多个条件
	 * @param: @param orderBy 排序，支持多个，以property 字符串数组和orderType 布尔值数组方式设置
	 * @param: @param groupBy 分组，支持多个，以property 字符串数组设置
	 * @param: @param limit   start开始的位置，dataSize 查询的数据量
	 * @param: @return
	 * @param: @throws NoSuchFieldException
	 * @param: @throws SecurityException
	 * @param: @throws IllegalArgumentException
	 * @param: @throws IllegalAccessException 参数说明
	 * @return: List<?> 返回类型
	 * @throws
	 */
	public List<?> query(List<?> data, Where where, OrderBy orderBy, GroupBy groupBy, Limit limit)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException;

}