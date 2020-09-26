/**
 * @Title: OrderByUtil.java
 * @Package: common.core
 * @Description: 描述该文件做什么
 * @author: 许鹏飞
 * @date: 2020-9-26 11:00:48
 * @Company: 个人作品
 * @version: V1.0
 * @Copyright: 版权
 */
package common.core.util;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import common.pojo.OrderBy;
import common.utils.ObjectUtils;
import common.utils.ReflectUtils;

/**
 * @ClassName: OrderByUtil
 * @Description: 数据排序的辅助类
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-26 11:00:48
 * @param: 
 */
public class OrderByUtil {
	public static OrderByUtil getInstance() {
		return new OrderByUtil();
	}
	
	
	/**
	 * @Title: queryOrderBy
	 * @Description: 多属性排序
	 * @author: 许鹏飞
	 * @param: @param orderBy
	 * @param: @param result
	 * @param: @return 参数说明
	 * @return: List<Object> 返回类型
	 * @throws
	 */
	public List<Object> queryOrderBy(OrderBy orderBy,List<Object> result) {
		if (ObjectUtils.isNotEmpty(orderBy)) {
			String[] propertys =orderBy.getProperty();
			boolean[] orderType=orderBy.getOrderType();
			sort(result, propertys, orderType);
		}
		return result;
		
	}
	
	
	 /**
	 * @Title: sort
	 * @Description: 多属性，多排序方式进行排序
	 * @author: 许鹏飞
	 * @param: @param <E>
	 * @param: @param list
	 * @param: @param sortnameArr
	 * @param: @param typeArr 参数说明
	 * @return: void 返回类型
	 * @throws
	 */
	private static <E> void sort(List<E> list, final String[] propertys, final boolean[] orderType) {
	        if (propertys.length != orderType.length) {
	            throw new RuntimeException("属性数组元素个数和升降序数组元素个数不相等");
	        }
	        Collections.sort(list, new Comparator<E>() {
	            public int compare(E a, E b) {
	                int ret = 0;
	                try {
	                    for (int i = 0; i < propertys.length; i++) {
	                        ret = OrderByUtil.compareObject(propertys[i], orderType[i], a, b);
	                        if (0 != ret) {
	                            break;
	                        }
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                return ret;
	            }
	        });
	    }
	 
	 
	 /**
	 * @Title: compareObject
	 * @Description: 两个对象不同类似数据对比逻辑
	 * @author: 许鹏飞
	 * @param: @param <E>
	 * @param: @param sortname
	 * @param: @param isAsc
	 * @param: @param a
	 * @param: @param b
	 * @param: @return
	 * @param: @throws Exception 参数说明
	 * @return: int 返回类型
	 * @throws
	 */
	private static <E> int compareObject(final String sortname, final boolean isAsc, E a, E b) throws Exception {
	        int ret;
	        Object value1 =ReflectUtils.getValueStringByFieldName(a, sortname);
	        Object value2 =ReflectUtils.getValueStringByFieldName(b, sortname);
	        String str1 = value1.toString();
	        String str2 = value2.toString();
	        if (value1 instanceof Number && value2 instanceof Number) {
	            int maxlen = Math.max(str1.length(), str2.length());
	            str1 = OrderByUtil.addZero2Str((Number) value1, maxlen);
	            str2 = OrderByUtil.addZero2Str((Number) value2, maxlen);
	        } else if (value1 instanceof Date && value2 instanceof Date) {
	            long time1 = ((Date) value1).getTime();
	            long time2 = ((Date) value2).getTime();
	            int maxlen = Long.toString(Math.max(time1, time2)).length();
	            str1 = OrderByUtil.addZero2Str(time1, maxlen);
	            str2 = OrderByUtil.addZero2Str(time2, maxlen);
	        }
	        if (isAsc) {
	            ret = str1.compareTo(str2);
	        } else {
	            ret = str2.compareTo(str1);
	        }
	        return ret;
	    }
	 
	 
	 /**
	 * @Title: addZero2Str
	 * @Description: 给数字对象按照指定长度在左侧补0
	 * @author: 许鹏飞
	 * @param: @param numObj
	 * @param: @param length
	 * @param: @return 参数说明
	 * @return: String 返回类型
	 * @throws
	 */
	private static String addZero2Str(Number numObj, int length) {
	        NumberFormat nf = NumberFormat.getInstance();
	        // 设置是否使用分组
	        nf.setGroupingUsed(false);
	        // 设置最大整数位数
	        nf.setMaximumIntegerDigits(length);
	        // 设置最小整数位数
	        nf.setMinimumIntegerDigits(length);
	        return nf.format(numObj);
	    }
}
