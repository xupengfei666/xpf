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

import java.util.HashMap;
import java.util.Map;

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
public class Where extends HashMap<String, Object> implements Map<String, Object> {
	/**
	 * @Fields serialVersionUID : TODO(这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * @Title: put
	 * @Description: 描述这个方法的作用
	 * @author: 许鹏飞
	 * @param: @param condition:代表条件支持的类型，支持的类型有EQ("@EQ")相等, LIKE("@LIKE")包含,
	 *         LIKEBEFORE("@LIKEBEFORE")前部分包含, LIKEAFTER("@LIKEAFTER")后部分包含,
	 *         EXISTS("@EXISTS")存在, NOTEXISTS("@NOTEXISTS")不存在, GE("@GE")大于,
	 *         LEEQ("@LEEQ")小于或者等于, GEEQ("@GEEQ")大于或者等于, LE("@LE")小于， NE("@NE")不相等,
	 *         ISNULL("@ISNULL")是null, ISNOTNULL("@ISNOTNULL")不是null
	 * @param: @param connector  : 条件连接符，支持and和or，如果不设置，默认是and
	 * @param: @param property: 要查询的数据属性
	 * @param: @param value  : 要查询数据匹配的值
	 * @return: void 返回类型
	 * @throws
	 */
	public void  set( String property, Object value,String condition, String connector) {
		String key=property;
		if(ObjectUtils.isNotEmpty(condition)) {
			key=key+condition;
		}else {
			key=key+ConditionEnum.EQ.toString();
		}
		if(ObjectUtils.isNotEmpty(connector)) {
			key=key+connector;
		}else {
			key=key+ConnectorEnum.AND.toString();
		}
		put(key, value);
	}
	
	
	/**
	 * @Title: set
	 * @Description: 设置条件、属性和值
	 * @author: 许鹏飞
	 * @param: @param condition
	 * @param: @param property
	 * @param: @param value 参数说明
	 * @return: void 返回类型
	 * @throws
	 */
	public void  set(String property, Object value,String condition) {
		set( property, value,condition, null);
	}
	
	/**
	 * @Title: setConnector
	 * @Description: 设置连接符、属性和值
	 * @author: 许鹏飞
	 * @param: @param connector
	 * @param: @param property
	 * @param: @param value 参数说明
	 * @return: void 返回类型
	 * @throws
	 */
	public void  setConnector(String connector, String property, Object value) {
		set( property, value,null, connector);
	}
	
	/**
	 * @Title: set
	 * @Description: 设置属性和值
	 * @author: 许鹏飞
	 * @param: @param property
	 * @param: @param value 参数说明
	 * @return: void 返回类型
	 * @throws
	 */
	public void  set(String property, Object value) {
		set( property, value,null, null);
	}
	

}
