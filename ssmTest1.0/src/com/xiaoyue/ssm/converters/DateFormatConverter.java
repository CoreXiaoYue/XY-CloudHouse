package com.xiaoyue.ssm.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateFormatConverter implements Converter<String, Date>{

    @Override
    public Date convert(String date) {
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	try {
	   return format.parse(date);
	} catch (ParseException e) {
	    System.out.println("时间转换错误。");
	    e.printStackTrace();
	    return null;
	}
    }

}

