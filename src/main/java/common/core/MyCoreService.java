/**
 * @Title: MyCoreService.java
 * @Package: common.core
 * @Description: 描述该文件做什么
 * @author: 许鹏飞
 * @date: 2020-9-25 15:23:09
 * @Company: 个人作品
 * @version: V1.0
 * @Copyright: 版权
 */
package common.core;

import java.util.ArrayList;
import java.util.List;

import common.pojo.GroupBy;
import common.pojo.Limit;
import common.pojo.OrderBy;
import common.pojo.Where;
import common.utils.ObjectUtils;

/**
 * @ClassName: MyCoreService
 * @Description: 描述这个类的作用
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 15:23:09
 * @param:
 */
public class MyCoreService {

	public static MyCoreService getInstance() {
		return new MyCoreService();
	}

	/**
	 * @Title: query @Description: 单个条件的实现方法 @author: 许鹏飞 @param: @param
	 * data @param: @param where @param: @param orderBy @param: @param
	 * groupBy @param: @param limit @param: @return @param: @throws
	 * NoSuchFieldException @param: @throws SecurityException @param: @throws
	 * IllegalArgumentException @param: @throws IllegalAccessException 参数说明 @return:
	 * List<Object> 返回类型 @throws
	 */
	public List<Object> query(List<?> data, Where where, OrderBy orderBy, GroupBy groupBy, Limit limit)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		List<Object> result = new ArrayList<Object>();
		if (ObjectUtils.isNotEmpty(data)) {
			for (Object obj : data) {
				WhereUtil.getInstance().queryWhere(obj, where,result);
				OrderByUtil.getInstance().queryOrderBy(orderBy, result);
			}
		}
		return result;
	}

	/**
	 * @Title: query @Description: 多个条件的实现方法 @author: 许鹏飞 @param: @param
	 * data @param: @param where @param: @param orderBy @param: @param
	 * groupBy @param: @param limit @param: @return @param: @throws
	 * NoSuchFieldException @param: @throws SecurityException @param: @throws
	 * IllegalArgumentException @param: @throws IllegalAccessException 参数说明 @return:
	 * List<Object> 返回类型 @throws
	 *//*
		 * public List<Object> query(List<?> data, List<Where> wheres, OrderBy orderBy,
		 * GroupBy groupBy, Limit limit) throws NoSuchFieldException, SecurityException,
		 * IllegalArgumentException, IllegalAccessException { List<Object> result = new
		 * ArrayList<Object>(); if (ObjectUtils.isNotEmpty(data)) { outSize:for (Object
		 * obj : data) { if(ObjectUtils.isNotEmpty(wheres)) { for (Where where : wheres)
		 * { String connector = where.getConnector(); boolean b =
		 * WhereUtil.getInstance().queryWhere(obj, where); if (b) { result.add(obj);
		 * if(StringUtils.equals(connector, ConnectorEnum.OR.toString())) { continue
		 * outSize; } }else { if(StringUtils.equals(connector,
		 * ConnectorEnum.AND.toString())) { result.remove(obj); } } } } } } return
		 * result; }
		 */

}
