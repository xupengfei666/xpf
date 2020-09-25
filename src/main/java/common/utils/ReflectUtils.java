package common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import common.constants.Global;
import net.sf.json.JSONObject;


/**
 * @ClassName: ReflectUtils
 * @Description: 反射工具类
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 15:34:30
 * @param: 
 */
public class ReflectUtils {
	private static final String JAVA_LANG = Global.JAVA_LANG;

	
	/**
	 * @Title: objectToMap
	 * @Description: 对象转化为TreeMap
	 * @author: 许鹏飞
	 * @param: @param obj
	 * @param: @return
	 * @param: @throws IllegalAccessException 参数说明
	 * @return: TreeMap<String,Object> 返回类型
	 * @throws
	 */
	public static TreeMap<String, Object> objectToMap(Object obj) throws IllegalAccessException {
		TreeMap<String, Object> map = new TreeMap<>();
		Class<?> clazz = obj.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			// System.out.println(fieldName);
			Object value = field.get(obj);
			map.put(fieldName, value);
		}
		return map;
	}

	
	/**
	 * @Title: objectToMapNotNull
	 * @Description: 对象转化为Map
	 * @author: 许鹏飞
	 * @param: @param obj
	 * @param: @return
	 * @param: @throws IllegalAccessException 参数说明
	 * @return: Map<String,String> 返回类型
	 * @throws
	 */
	public static Map<String, String> objectToMapNotNull(Object obj) throws IllegalAccessException {
		Map<String, String> map = new HashMap<String, String>();
		Class<?> clazz = obj.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			// System.out.println(fieldName);
			Object value = field.get(obj);
			if (ObjectUtils.isNotEmpty(value)) {
				map.put(fieldName, value.toString());
			}
		}
		return map;
	}

	/**
	 * @Title: objectToMapNotNull
	 * @Description: 对象转化为JSONObject
	 * @author: 许鹏飞
	 * @param: @param obj
	 * @param: @return
	 * @param: @throws IllegalAccessException 参数说明
	 * @return: Map<String,String> 返回类型
	 * @throws
	 */
	public static JSONObject objectToJson(Object obj) throws IllegalAccessException {
		JSONObject map = new JSONObject();
		Class<?> clazz = obj.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			String fieldName = field.getName();
			Object value = field.get(obj);
			map.put(fieldName, value);
		}
		return map;
	}



	
	/**
	 * @discription: 反射获取set方法
	 * @author: 许鹏飞
	 * @created: 2018年7月29日 下午1:57:51
	 * @param entity
	 * @param property
	 * @param value
	 * @param className
	 * @return
	 * @throws Exception
	 */
	public static Object setValueForMethod(Object entity, String property, Object value, String className)
			throws Exception {
		Object o = null;
		property = "set" + StringUtils.capitalize(property);
		Class<?> initClass = null;
		Class<?> onwClass = null;
		if (ObjectUtils.isNotEmpty(property)) {
			if (StringUtils.isNotEmpty(className)) {
				if (className.equals("Boolean") || className.equals(JAVA_LANG + "Boolean")) {
					className = JAVA_LANG + className;
					value = new Boolean(value.toString());
				} else if (className.equals("Integer") || className.equals(JAVA_LANG + "Integer")) {
					className = JAVA_LANG + className;
					value = new Integer(value.toString());
				} else if (className.equals("BigDecimal") || className.equals("java.math.BigDecimal")) {
					className = "java.math.BigDecimal";
					value = new BigDecimal(value.toString());
				} else if (className.equals("String") || className.equals(JAVA_LANG + "String")) {
					className = JAVA_LANG + "String";
				} else if (className.equals("Date") || className.equals("java.util.Date")) {
					className = "java.util.Date";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					value = sdf.parse(value.toString());
				} else if (className.equals("Timestamp") || className.equals("java.sql.Timestamp")) {
					className = "java.sql.Timestamp";
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = sdf.parse(value.toString());
					value = new java.sql.Timestamp(date.getTime());
				} else if (className.equals("Double") || className.equals(JAVA_LANG + "Double")) {
					className = JAVA_LANG + className;
					value = new Double(value.toString());
				} else if (className.equals("Long") || className.equals(JAVA_LANG + "Long")) {
					className = JAVA_LANG + className;
					value = new Long(value.toString());
				} else if (className.equals("Float") || className.equals(JAVA_LANG + "Float")) {
					className = JAVA_LANG + className;
					value = new Float(value.toString());
				} else if (className.equals("Short") || className.equals(JAVA_LANG + "Short")) {
					value = new Short(value.toString());
					className = JAVA_LANG + className;
				} else if (className.equals("Byte") || className.equals(JAVA_LANG + "Byte")) {
					value = new Byte(value.toString());
					className = JAVA_LANG + className;
				} else {
					// 基本类型
					if (className.equals("int")) {
						value = new Integer(value.toString()).intValue();
						initClass = int.class;
					} else if (className.equals("long")) {
						value = new Long(value.toString()).longValue();
						initClass = long.class;
					} else if (className.equals("double")) {
						value = new Double(value.toString()).doubleValue();
						initClass = double.class;
					} else if (className.equals("boolean")) {
						value = new Boolean(value.toString()).booleanValue();
						initClass = boolean.class;
					} else if (className.equals("float")) {
						value = new Float(value.toString()).floatValue();
						initClass = float.class;
					} else if (className.equals("short")) {
						value = new Short(value.toString()).shortValue();
						initClass = short.class;
					} else if (className.equals("byte")) {
						value = new Byte(value.toString()).byteValue();
						initClass = byte.class;
					} else if (className.equals("char")) {
						value = value.toString().toCharArray();
						initClass = char.class;
					}
					className = "Original";
				}
			} else {
				className = "NOTPASS";
			}
			if (ObjectUtils.isNotEmpty(className)) {
				if (StringUtils.equals(className, "NOTPASS")) {
					return o;
				} else if (StringUtils.equals(className, "Original")) {
					onwClass = initClass;
				} else {
					onwClass = Class.forName(className);
				}
				try {
					Method method = entity.getClass().getDeclaredMethod(property, onwClass);
					o = method.invoke(entity, value);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return o;
			} else {
				return o;
			}
		}
		return o;
	}

	/**
	 * @discription: 反射获取get方法
	 * @author: xupengfei
	 * @created: 2018年7月29日 下午1:57:39
	 * @param entity
	 * @param property
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static Object getValueForMethod(Object entity, String property) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object obj = null;
		if (null != entity) {
			if (StringUtils.isNotEmpty(property)) {

				String[] propertys = StringUtils.split(property, ".");
				for (String pro : propertys) {
					if (null != entity) {
						Method method = entity.getClass().getDeclaredMethod("get" + StringUtils.capitalize(pro));
						obj = method.invoke(entity);
					} else {
						obj = "";
					}
				}
			}
		}
		return obj;
	}

	public static Object exceForMethod(String classFull, String functionName, Class<?>[] params, Object[] values)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException, InstantiationException {
		Class<?> cls = Class.forName(classFull);
		return exceForMethod(cls, functionName, params, values);
	}



	public static Object exceForMethod(Class<?> cls, String functionName, Class<?>[] params, Object[] values)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException, InstantiationException {
		Object obj = cls.newInstance();
		return exceForMethod(obj, functionName, params, values);
	}

	public static Object exceForMethod(Object obj, String functionName, Class<?>[] params, Object[] values)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException, InstantiationException {
		Object result = null;
		if (ObjectUtils.isNotEmpty(obj)) {
			if (StringUtils.isNotEmpty(functionName)) {
				Method method = obj.getClass().getDeclaredMethod(functionName, params);
				result = method.invoke(obj, values);
			}
		}
		return result;
	}


	

	/**
	 * 设置obj对象fieldName的属性值
	 * 
	 * @param obj
	 * @param fieldName
	 * @param value
	 */
	public static void setValueByFieldName(Object obj, String fieldName,
			Object value) {
		Field field;
		try {
			field = obj.getClass().getDeclaredField(fieldName);
			 if (field.isAccessible()) {  
		            field.set(obj, value);  
		        } else {  
		            field.setAccessible(true);  
		            field.set(obj, value);  
		            field.setAccessible(false);  
		        }  
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			e1.printStackTrace();
		}
	}
	
	public static String getValueStringByFieldName(Object obj, String fieldName) {
		Object result=getValueByFieldName(obj, fieldName);
		return ObjectUtils.objectToString(result);
		
	}
	/**
	 * @Title: getValueByFieldName
	 * @Description: 类的反射获取值Object
	 * @author: 许鹏飞
	 * @param: @param obj
	 * @param: @param fieldName
	 * @param: @return 参数说明
	 * @return: Object 返回类型
	 * @throws
	 */
	public static Object getValueByFieldName(Object obj, String fieldName) {
		Field field = getFieldByFieldName(obj, fieldName);
		Object value = null;
		if (field != null) {
			try {
				if (field.isAccessible()) {  
	                value = field.get(obj);  
	            } else {  
	                field.setAccessible(true);  
	                value = field.get(obj);  
	                field.setAccessible(false);  
	            }  
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
	/**
	 * @Title: getFieldByFieldName
	 * @Description: 获取类的反射实体Field
	 * @author: 许鹏飞
	 * @param: @param obj
	 * @param: @param fieldName
	 * @param: @return 参数说明
	 * @return: Field 返回类型
	 * @throws
	 */
	public static Field getFieldByFieldName(Object obj, String fieldName) {
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
			}
		}
		return null;
	}
}
