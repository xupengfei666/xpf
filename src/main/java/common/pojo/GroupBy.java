/**
 * @Title: GroupBy.java
 * @Package: common.pojo
 * @Description: 描述该文件做什么
 * @author: 许鹏飞
 * @date: 2020-9-25 15:13:43
 * @Company: 个人作品
 * @version: V1.0
 * @Copyright: 版权
 */
package common.pojo;

/**
 * @ClassName: GroupBy
 * @Description: 进行的分组查询
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 15:13:43
 * @param: 
 */
public class GroupBy {

	/**
	 * @Fields property : 要排序的属性
	 */
	private String property;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * @Title: GroupBy.java
	 * @Description: 构造分组函数
	 * @param: @param property 分组属性
	 */
	public GroupBy(String property) {
		super();
		this.property = property;
	}
	
	
}
