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
	 * @Title: query
	 * @Description: 核心方法处理多条件，多排序，多去重和limit的方法处理
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
	 * @return: List<Object> 返回类型
	 * @throws
	 */
	public List<Object> query(List<?> data, Where where, OrderBy orderBy, GroupBy groupBy, Limit limit)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		List<Object> result = new ArrayList<Object>();
		if (ObjectUtils.isNotEmpty(data)) {
			result=WhereUtil.getInstance().queryWhere(data, where,result);
			result=OrderByUtil.getInstance().queryOrderBy(orderBy, result);
			result=GroupByUtil.getInstance().queryGroupBy(data, groupBy, result);
			result=LimitUtil.getInstance().queryLimit(limit, result);
		}
		return result;
	}

	

}
