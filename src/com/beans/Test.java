package com.beans;

import com.util.HIBUtil;

public class Test {
	
	public static void main(String[] args) {

	}
	
	
	public static void queryAndUpdate(){
		UserInfo u1=(UserInfo)HIBUtil.get(UserInfo.class, 1);
		UserInfo u2=(UserInfo)HIBUtil.get(UserInfo.class, 1);
	}
	
}
