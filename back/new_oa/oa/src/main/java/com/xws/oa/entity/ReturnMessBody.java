package com.xws.oa.entity;

public class ReturnMessBody {

	private String type;

	private String msg;

	private Object data;


	public ReturnMessBody() {

	}

	public ReturnMessBody(String type,String msg, Object data) {
		this.type = type;
		this.msg= msg;
		this.data = data;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}