/**
 * @Title: GroupByUtil.java
 * @Package: common.core
 * @Description: 描述该文件做什么
 * @author: 许鹏飞
 * @date: 2020-9-26 12:33:32
 * @Company: 个人作品
 * @version: V1.0
 * @Copyright: 版权
 */
package common.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import common.pojo.GroupBy;
import common.utils.ObjectUtils;
import common.utils.ReflectUtils;
import net.sf.json.JSONObject;

/**
 * @ClassName: GroupByUtil
 * @Description: Group By的辅助处理方法
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-26 12:33:32
 * @param: 
 */
public class GroupByUtil {

	public static GroupByUtil getInstance() {
		return new GroupByUtil();
	}
	
	
	/**
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @Title: queryOrderBy
	 * @Description: 多属性排序
	 * @author: 许鹏飞
	 * @param: @param orderBy
	 * @param: @param result
	 * @param: @return 参数说明
	 * @return: List<Object> 返回类型
	 * @throws
	 */
	public List<Object> queryGroupBy(List<Object> result, GroupBy groupBy)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> groupList=new ArrayList<Object>();
		if (ObjectUtils.isNotEmpty(groupBy)) {
			String[] propertys = groupBy.getProperty();
			for (Object data : result) {
				String key = "";
				JSONObject jsonData=new JSONObject();
				for (String property : propertys) {
					Object obj = ReflectUtils.getValueStringByFieldName(data, property);
					if (ObjectUtils.isNotEmpty(obj)) {
						jsonData.put(property, obj);
						key = key + obj;
					}
				}
				if (ObjectUtils.isNotEmpty(key)) {
					if (!map.containsKey(key)) {
						map.put(key, jsonData);
					}
				}
			}
			Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> entry = it.next();
				groupList.add(entry.getValue());
			}
		}else {
			groupList=result;
		}
		return groupList;
	}
}
