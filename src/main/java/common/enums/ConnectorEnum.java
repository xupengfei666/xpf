package common.enums;

/**
 * @ClassName: Connector
 * @Description: 条件连接符，目前支持and和or
 * @author: 许鹏飞
 * @Company: 个人作品
 * @date: 2020-9-25 14:54:59
 * @param: 
 */
public enum ConnectorEnum {
	AND("@and"), OR("@OR");

	private String name;

	private ConnectorEnum(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
	
}
