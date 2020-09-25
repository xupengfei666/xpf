package com.mayidb.pojo;

import java.math.BigDecimal;

/**
 * @ClassName: DemoData
 * @Description: 模拟数据模型
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 17:01:07
 * @param: 
 */
public class DemoData {
	
	public String id;
	
	public String name;
	
	public String type;
	
	public Integer count;
	
	public BigDecimal money;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
