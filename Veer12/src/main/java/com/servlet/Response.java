package com.servlet;


public class Response {
	String string;
    Boolean b;
    public void setStatus(String string2) {
		this.string=string2;
		
	}
    public void setSuccess(boolean c) {
		this.b=c;
		
	}
    public String getStatus()
    {
    	return string;
    }
    public Boolean getSuccess()
    {
    	return b;
    }
}