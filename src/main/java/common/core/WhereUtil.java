/**
 * @Title: WhereUtil.java
 * @Package: common.core
 * @Description: 描述该文件做什么
 * @author: 许鹏飞
 * @date: 2020-9-25 15:26:04
 * @Company: 个人作品
 * @version: V1.0
 * @Copyright: 版权
 */
package common.core;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import common.constants.Global;
import common.enums.ConditionEnum;
import common.enums.ConnectorEnum;
import common.pojo.Where;
import common.utils.ObjectUtils;
import common.utils.ReflectUtils;

/**
 * @ClassName: WhereUtil
 * @Description: 关于条件的核心处理方法
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 15:26:04
 * @param:
 */
public class WhereUtil {
	public static WhereUtil getInstance() {
		return new WhereUtil();
	}

	/**
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @Title: queryWhere
	 * @Description: 条件查询的核心方法：
	    *  当为true的时候，该数据在查询范围内                           
	     *为false的时候，该数据不在查询范围内             
	 * @author: 许鹏飞
	 * @param: @param data
	 * @param: @param where
	 * @param: @return 参数说明
	 * @return: int 返回类型
	 * @throws
	 */
	public List<Object> queryWhere(Object data, Where where,List<Object> result) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		if (ObjectUtils.isNotEmpty(where)) {
			Set<String> keys=where.keySet();
			boolean addFlag=true;
			for(String key:keys) {
				String[] keyStrings=StringUtils.split(key, Global.DB_SEPARATOR);
				String property = keyStrings[0];
				String condition =keyStrings[1];
				String connector=keyStrings[2];
				Object value = where.get(key);
				String valueString = ObjectUtils.objectToString(value);
				condition=Global.DB_SEPARATOR+condition;
				connector=Global.DB_SEPARATOR+connector;
				boolean b= isFitData(data, condition, property, valueString);
				if (b) {
					if (StringUtils.equals(connector, ConnectorEnum.OR.toString())) {
						result.add(data);
						continue;
					}
					if(addFlag) {
						result.add(data);
						addFlag=false;
					}
				} else {
					if (StringUtils.equals(connector, ConnectorEnum.AND.toString())) {
						result.remove(data);
						addFlag=false;
					}
				}
				
			}
			
		}
		return result;
	}

	
	/**
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @Title: isFitData
	 * @Description: 条件对比的核心处理方法
	 * @author: 许鹏飞
	 * @param: @param data
	 * @param: @param condition
	 * @param: @param property
	 * @param: @param value
	 * @param: @return 参数说明
	 * @return: boolean 返回类型
	 * @throws
	 */
	private boolean isFitData(Object data, String condition, String property, String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String dataValue = ReflectUtils.getValueStringByFieldName(data, property);
		if (ConditionEnum.EQ.toString().equals(condition)) {
			if (StringUtils.equals(dataValue, value)) {
				return true;
			}
		} else if (ConditionEnum.NE.toString().equals(condition)) {
			if (!StringUtils.equals(dataValue, value)) {
				return true;
			}
		} else if (ConditionEnum.GE.toString().equals(condition)) {
			if (isCompare(dataValue, value, false)) {
				return true;
			}
		} else if (ConditionEnum.GEEQ.toString().equals(condition)) {
			if (isCompare(dataValue, value, true)) {
				return true;
			}
		} else if (ConditionEnum.LE.toString().equals(condition)) {
			if (!isCompare(dataValue, value, false)) {
				return true;
			}
		} else if (ConditionEnum.LEEQ.toString().equals(condition)) {
			if (!isCompare(dataValue, value, true)) {
				return true;
			}
		} else if (ConditionEnum.EXISTS.toString().equals(condition)) {
			String[] values = StringUtils.split(value, ",");
			if (Arrays.asList(values).contains(dataValue)) {
				return true;
			}
		} else if (ConditionEnum.NOTEXISTS.toString().equals(condition)) {
			String[] values = StringUtils.split(value, ",");
			if (!Arrays.asList(values).contains(dataValue)) {
				return true;
			}
		} else if (ConditionEnum.LIKE.toString().equals(condition)) {
			return StringUtils.contains(dataValue, value);
		} else if (ConditionEnum.ISNOTNULL.toString().equals(condition)) {
			if (ObjectUtils.isNotEmpty(dataValue)) {
				return true;
			}
		} else if (ConditionEnum.ISNULL.toString().equals(condition)) {
			if (ObjectUtils.isEmpty(dataValue)) {
				return true;
			}
		}
		return false;
	}

	
	/**
	 * @Title: isCompare
	 * @Description:当isEqal为true时，两个字符串相等返回true，不相等返回false
	 * @author: 许鹏飞
	 * @param: @param sourceString
	 * @param: @param compareString
	 * @param: @param isEqal
	 * @param: @return 参数说明
	 * @return: boolean 返回类型
	 * @throws
	 */
	private boolean isCompare(String sourceString, String compareString, boolean isEqal) {
		int compare = StringUtils.compare(sourceString, compareString);
		if (compare == 0) {
			if (isEqal) {
				return true;
			}
		}
		if (compare >0) {
			return true;
		}
		return false;
	}

}
