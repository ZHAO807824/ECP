package com.ecp.dto;

/**
 * 前后端交互数据:ajax请求返回类型,封装json结果
 * 
 * @author zhao
 *
 */
public class Result<T> {
	private boolean success;
	private T data;
	private String error;

	public Result() {
	}

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String error) {
		this.success = success;
		this.error = error;
	}
	
	public Result(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public Result(boolean success, T data, String error) {
		this.success = success;
		this.data = data;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
