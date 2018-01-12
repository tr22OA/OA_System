package com.oa.utils;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * String转换成Date的转换器
 * @author Administrator
 *
 */
public class StringToDateConverter implements 
Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if(!StringUtils.hasLength(source)){
			return null;
		}
		
		try {
			return java.sql.Date.valueOf(source);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("日期格式错误，格式必须为：yyyy-MM-dd");
		}
	}

}
