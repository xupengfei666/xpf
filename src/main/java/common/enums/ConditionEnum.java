package common.enums;

/**
 * @ClassName: Condition
 * @Description: 条件过滤器
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 14:54:43
 * @param:
 */
public enum ConditionEnum {
	EQ("@EQ"), LIKE("@LIKE"), EXISTS("@EXISTS"), NOTEXISTS("@NOTEXISTS"), GE("@GE"), LEEQ("@LEEQ"), GEEQ("@GEEQ"),
	LE("@LE"), NE("@NE"), ISNULL("@ISNULL"), ISNOTNULL("@ISNOTNULL");

	private String name;

	private ConditionEnum(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
