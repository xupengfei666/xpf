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

import common.utils.ObjectUtils;

/**
 * @ClassName: DemoService
 * @Description: 数据处理
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 17:01:42
 * @param: 
 */
public class DemoServiceImpl {
	
	/**
	 * @Title: addDatas
	 * @Description: 模拟添加数据
	 * @author: 许鹏飞
	 * @param: @return 参数说明
	 * @return: List<DemoData> 返回类型
	 * @throws
	 */
	public List<DemoData> addDatas(int count){
		List<DemoData> list=new ArrayList<DemoData>();
		String[] datas= {"测试","演示","正式"};
		Random r=new Random(datas.length);
		for(int i=0;i<count;i++) {
			DemoData demoData=new DemoData();
			demoData.setId(ObjectUtils.getUUID());
			String name=datas[r.nextInt()]+i;
			demoData.setName(name);
			demoData.setCount(i);
			demoData.setMoney(new BigDecimal(i));
			list.add(demoData);
		}
		return list;
	}

}
