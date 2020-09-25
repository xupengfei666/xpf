package common.enums;

/**
 * @ClassName: Order
 * @Description: 排序类型，目前支持升序（ASC）和降序（DESC）
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 14:55:23
 * @param: 
 */
public enum OrderEnum {
	DESC("@DESC"), ASC("@ASC");

	private String name;

	private OrderEnum(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
