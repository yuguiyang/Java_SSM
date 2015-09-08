package org.ygy.util;

import com.google.gson.Gson;

public class GsonUtil {
	
	public static <T> T fromJson(String json ,Class<T> T) {
		Gson gson = new Gson();
		//UNICODE 转为中文
		return gson.fromJson(json, T);
		
	}
	
	public static String toJson(Object obj) {
		Gson gson = new Gson();
		
		return gson.toJson(obj);
	}
}
