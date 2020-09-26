/**
 * @Title: DemoService.java
 * @Package: com.mayidb.service
 * @Description: 描述该文件做什么
 * @author: 许鹏飞
 * @date: 2020-9-25 17:01:42
 * @Company: 个人作品
 * @version: V1.0
 * @Copyright: 版权
 */
package com.mayidb.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mayidb.pojo.DemoData;
import com.mayidb.service.IDemoService;

import common.core.MyCoreService;
import common.pojo.GroupBy;
import common.pojo.Limit;
import common.pojo.OrderBy;
import common.pojo.Where;
import common.utils.ObjectUtils;

/**
 * @ClassName: DemoService
 * @Description: 数据处理
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 17:01:42
 * @param:
 */

public class DemoService implements IDemoService {

	public static DemoService getInstance() {
		return new DemoService();
	}

	/**
	 * @Title: addDatas
	 * @Description: 重写方法的描述
	 * @param: @param  count
	 * @param: @return
	 * @see com.mayidb.service.IDemoService#addDatas(int)
	 */
	@Override
	public List<DemoData> addDatas(int count) {
		List<DemoData> list = new ArrayList<DemoData>();
		String[] datas = { "测试", "演示", "正式" };
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			DemoData demoData = new DemoData();
			demoData.setId(ObjectUtils.getUUID());
			String type = datas[r.nextInt(datas.length)];
			String name = type + i;
			demoData.setName(name);
			demoData.setCount(i);
			demoData.setMoney(new BigDecimal(i));
			demoData.setType(type);
			list.add(demoData);
		}
		return list;
	}

	/**
	 * @Title: query
	 * @Description: 单个条件的实现方法
	 * @author: 许鹏飞
	 * @param: @param data
	 * @param: @param where
	 * @param: @param orderBy
	 * @param: @param groupBy
	 * @param: @param limit
	 * @param: @return
	 * @param: @throws NoSuchFieldException
	 * @param: @throws SecurityException
	 * @param: @throws IllegalArgumentException
	 * @param: @throws IllegalAccessException 参数说明
	 * @return: List<?> 返回类型
	 * @throws
	 */
	public List<?> query(List<?> data, Where where, OrderBy orderBy, GroupBy groupBy, Limit limit)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		return MyCoreService.getInstance().query(data, where, orderBy, groupBy, limit);
	}
	
	
}
