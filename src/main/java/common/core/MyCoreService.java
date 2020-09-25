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
	
	public List<?> query(List<?> data,Where where,OrderBy orderBy,GroupBy groupBy,Limit limit){
		List<Object> result=new ArrayList<Object>();
		if(ObjectUtils.isNotEmpty(data)) {
			for(Object obj:data) {
				boolean b= WhereUtil.getInstance().queryWhere(data, where);
				if(b) {
					result.add(obj);
				}
			}
		}
		return result;
	}

}
