/**
 * @Title: LimitUtil.java
 * @Package: common.core
 * @Description: 描述该文件做什么
 * @author: 许鹏飞
 * @date: 2020-9-26 14:06:32
 * @Company: 个人作品
 * @version: V1.0
 * @Copyright: 版权
 */
package common.core;

import java.util.ArrayList;
import java.util.List;

import common.pojo.Limit;
import common.utils.ObjectUtils;

/**
 * @ClassName: LimitUtil
 * @Description: 分页查询的辅助方法
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-26 14:06:32
 * @param:
 */
public class LimitUtil {

	public static LimitUtil getInstance() {
		return new LimitUtil();
	}

	/**
	 * @Title: queryGroupBy
	 * @Description: 描述这个方法的作用
	 * @author: 许鹏飞
	 * @param: @param limit
	 * @param: @param result
	 * @param: @return 参数说明
	 * @return: List<?> 返回类型
	 * @throws
	 */
	public List<Object> queryLimit(Limit limit, List<Object> result) {
		if (ObjectUtils.isNotEmpty(limit)) {
			int start = limit.getStart();
			int dataSize = limit.getDataSize();
			result=batchList(result, start, dataSize);
		}
		return result;
	}

	/**
	 * @Title: batchList
	 * @Description: 描述这个方法的作用
	 * @author: 许鹏飞
	 * @param: @param <T>
	 * @param: @param sourceList
	 * @param: @param start
	 * @param: @param dataSize
	 * @param: @return 参数说明
	 * @return: List<Object> 返回类型
	 * @throws
	 */
	public static <T> List<Object> batchList(List<Object> sourceList, int start, int dataSize) {
		List<Object> returnList = new ArrayList<Object>();
		int listSize = sourceList.size();
		if(listSize>start) {
			int endIndex = 0;
			if (sourceList.size() - dataSize < start) {
				endIndex = sourceList.size();
			} else {
				endIndex = start + dataSize;
			}
			returnList.add(sourceList.subList(start, endIndex));
		}
		return returnList;
	}

}
