package com.oa.utils;

import java.util.HashMap;
import java.util.Map;

public class ResultMap {
	private static HashMap<String,Object> resultMap;
	
	private ResultMap(){
	}
	
	public static HashMap<String,Object> putObj(String key,Object value){
		if(resultMap==null){
			resultMap=new HashMap<>();
		}
		resultMap.put(key, value);
		return resultMap;
	}

	public static HashMap<String,Object> getResultMap() {
		return resultMap;
	}
	
	
}
