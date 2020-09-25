package com.mayidb.service;

import java.util.List;

import com.mayidb.pojo.DemoData;

public interface IDemoService {

	/**
	 * @Title: addDatas
	 * @Description: 模拟添加数据
	 * @author: 许鹏飞
	 * @param: @return 参数说明
	 * @return: List<DemoData> 返回类型
	 * @throws
	 */
	List<DemoData> addDatas(int count);

}