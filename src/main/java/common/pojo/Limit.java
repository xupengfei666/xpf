package common.pojo;

import common.constants.Global;
import common.utils.ObjectUtils;

public class Limit {
	

	/**
	 * @Fields page : 第几页开始
	 */
	private int page;
	
	/**
	 * @Fields pageSize : 每一页多少条数据
	 */
	private int pageSize;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		if(ObjectUtils.isNotEmpty(pageSize)) {
			return pageSize;
		}else {
			return Global.PAGESIZE;
		}
		
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @Title: Limit.java
	 * @Description: 构造分页函数
	 * @param: @param page
	 * @param: @param pageSize
	 */
	public Limit(int page, int pageSize) {
		super();
		this.page = page;
		this.pageSize = pageSize;
	}

	/**
	 * @Title: Limit.java
	 * @Description: 构造分页函数
	 * @param: @param page
	 */
	public Limit(int page) {
		super();
		this.page = page;
	}
	
	
	
}
