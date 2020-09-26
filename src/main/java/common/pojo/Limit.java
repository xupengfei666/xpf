package common.pojo;

public class Limit {

	/**
	 * @Fields start : 从哪个位移开始，默认是0
	 */
	private int start;

	/**
	 * @Fields dataSize :查询的数量
	 */
	private int dataSize;

	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}

	
	/**
	 * @Title: Limit.java
	 * @Description: 描述这个构造函数的作用
	 * @param: @param start
	 * @param: @param dataSize
	 */
	public Limit(int start, int dataSize) {
		super();
		this.start = start;
		this.dataSize = dataSize;
	}

	
	/**
	 * @Title: Limit.java
	 * @Description: 描述这个构造函数的作用
	 * @param: @param dataSize
	 */
	public Limit(int dataSize) {
		super();
		setStart(0);
		this.dataSize = dataSize;
	}

}
