/**
 * @Title: OrderBy.java
 * @Package: common.pojo
 * @Description: 描述该文件做什么
 * @author: 许鹏飞
 * @date: 2020-9-25 15:03:36
 * @Company: 个人作品
 * @version: V1.0
 * @Copyright: 版权
 */
package common.pojo;

import common.enums.OrderEnum;
import common.utils.ObjectUtils;

/**
 * @ClassName: OrderBy
 * @Description: 排序的实体
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 15:03:36
 * @param: 
 */
public class OrderBy {
	
	/**
	 * @Fields property : 要排序的属性
	 */
	private String property;
	
	/**
	 * @Fields OrderType :排序的类型，目前支持升序（ASC）和降序（DESC），默认为DESC
	 */
	private String orderType;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getOrderType() {
		if (ObjectUtils.isNotEmpty(orderType)) {
			return orderType;
		} else {
			return OrderEnum.DESC.toString();
		}
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * @Title: OrderBy.java
	 * @Description: 构造条件查询
	 * @param: @param property 属性
	 * @param: @param orderType 条件
	 */
	public OrderBy(String property, String orderType) {
		super();
		this.property = property;
		this.orderType = orderType;
	}

	/**
	 * @Title: OrderBy.java
	 * @Description: 构造条件查询
	 * @param: @param property 属性
	 */
	public OrderBy(String property) {
		super();
		this.property = property;
	}

	

}
