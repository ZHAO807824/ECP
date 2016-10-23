package com.ecp.dto;

import java.util.Collection;

/**
 * 前后端交互数据:ajax请求返回类型,封装json结果
 * 
 * @User zhao
 *
 */
public class Page<T> {

	private Collection<T> rows;

	private Long total;

	public Page() {

	}

	public Page(Collection<T> rows, Long total) {
		this.rows = rows;
		this.total = total;
	}

	public Collection<T> getRows() {
		return rows;
	}

	public void setRows(Collection<T> rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
