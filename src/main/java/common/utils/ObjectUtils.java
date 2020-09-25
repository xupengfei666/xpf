package common.utils;


import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName: ObjectUtils
 * @Description: 关于Object对象处理的辅助方法
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 14:46:18
 * @param: 
 */
public class ObjectUtils {
   
    /**
     * @Title: getUUID
     * @Description: 获取uuid唯一值
     * @author: 许鹏飞
     * @param: @return 参数说明
     * @return: String 返回类型
     * @throws
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

  
    /**
     * @Title: isEmpty
     * @Description: 判断Object对象为空
     * @author: 许鹏飞
     * @param: @param obj
     * @param: @return 参数说明
     * @return: boolean 返回类型
     * @throws
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null || obj.equals("undefined")) {
            return true;
        } else if (obj instanceof String && (obj.equals(""))) {
            return true;
        } else if (obj instanceof Collection && ((Collection<?>) obj).isEmpty() && ((Collection<?>) obj).size() == 0) {
            return true;
        } else if (obj instanceof Map && ((Map<?, ?>) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
            return true;
        }
        return false;
    }

  
    /**
     * @Title: isNotEmpty
     * @Description: 判断Object对象不为空
     * @author: 许鹏飞
     * @param: @param obj
     * @param: @return 参数说明
     * @return: boolean 返回类型
     * @throws
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
