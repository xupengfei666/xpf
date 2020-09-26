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

/**
 * @ClassName: OrderBy
 * @Description: 排序的实体
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 15:03:36
 * @param:
 */
public class OrderBy  {



	/**
	 * @Fields property :排序的属性
	 */
	private String[] property;

	/**
	 * @Fields orderType : 排序的类型，如果是true为降序，false为升序
	 */
	private boolean[] orderType;

	public String[] getProperty() {
		return property;
	}

	public void setProperty(String[] property) {
		this.property = property;
	}

	public boolean[] getOrderType() {
		return orderType;
	}

	public void setOrderType(boolean[] orderType) {
		this.orderType = orderType;
	}
	
}
