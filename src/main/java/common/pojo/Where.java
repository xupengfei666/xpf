/**
 * @Title: Where.java
 * @Package: common.pojo
 * @Description: 类似sql的条件查询
 * @author: 许鹏飞
 * @date: 2020-9-25 14:17:48
 * @Company: 个人作品
 * @version: V1.0
 * @Copyright: 版权
 */
package common.pojo;

import common.enums.ConditionEnum;
import common.enums.ConnectorEnum;
import common.utils.ObjectUtils;

/**
 * @ClassName: Where
 * @Description: 类似sql的条件查询
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 14:17:48
 * @param:
 */
public class Where {

	/**
	 * @Fields condition : 代表条件支持的类型，支持的类型有EQ("@EQ")相等, LIKE("@LIKE")包含,
	 *         LIKEBEFORE("@LIKEBEFORE")前部分包含, LIKEAFTER("@LIKEAFTER")后部分包含,
	 *         EXISTS("@EXISTS")存在, NOTEXISTS("@NOTEXISTS")不存在, GE("@GE")大于,
	 *         LEEQ("@LEEQ")小于或者等于, GEEQ("@GEEQ")大于或者等于, LE("@LE")小于， NE("@NE")不相等,
	 *         ISNULL("@ISNULL")是null, ISNOTNULL("@ISNOTNULL")不是null
	 */
	private String condition;

	/**
	 * @Fields connector : 条件连接符，支持and和or，如果不设置，默认是and
	 */
	private String connector;

	/**
	 * @Fields property : 要查询的数据属性
	 */
	private String property;

	/**
	 * @Fields value : 要查询数据匹配的值
	 */
	private String value;

	public String getCondition() {
		if (ObjectUtils.isNotEmpty(condition)) {
			return condition;
		} else {
			return ConditionEnum.EQ.toString();
		}

	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getConnector() {
		if (ObjectUtils.isNotEmpty(condition)) {
			return connector;
		} else {
			return ConnectorEnum.AND.toString();
		}
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @Title: Where.java
	 * @Description: 创建where条件
	 * @param: @param condition
	 * @param: @param connector
	 * @param: @param property
	 * @param: @param value
	 */
	public Where(String condition, String connector, String property, String value) {
		super();
		this.condition = condition;
		this.connector = connector;
		this.property = property;
		this.value = value;
	}

	public Where(String connector, String property, String value) {
		super();
		this.connector = connector;
		this.property = property;
		this.value = value;
	}

	public Where(String property, String value) {
		super();
		this.property = property;
		this.value = value;
	}

}
