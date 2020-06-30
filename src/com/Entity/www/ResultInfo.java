package com.Entity.www;

public class ResultInfo {
	
	private boolean flag;
	private Object data;
	private String errorMsg;
	
	public ResultInfo() {
		
	};
	
	public ResultInfo(boolean flag) {
		this.flag = flag;
	}
	
	public ResultInfo(boolean flag, String errorMsg) {
		this.flag = flag;
		this.errorMsg = errorMsg;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	

}
