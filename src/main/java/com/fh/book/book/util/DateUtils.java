/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:DateUtils.java 
 * 包名:com.fh.shop.utils 
 * 创建日期:2019年6月7日下午4:10:01 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.book.book.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * <pre>项目名称：shop-admin    
 * 类名称：DateUtils    
 * 类描述：    
 * 创建人：刘永辉 2427284064@qq.com    
 * 创建时间：2019年6月7日 下午4:10:01    
 * 修改人：刘永辉 2427284064@qq.com     
 * 修改时间：2019年6月7日 下午4:10:01    
 * 修改备注：       
 * @version </pre>    
 */
public class DateUtils {
	
	//为了提高用户体验度我们定义两个常量防止输入错误的情况出现
	public static final String D_Y_M = "yyyy-MM-dd";
	public static final String D_Y_M_H_S_M = "yyyy-MM-dd HH:mm:ss";
	public static String dateFormatting(Date date,String format){
		if(date == null){
			return "";
		}
		SimpleDateFormat sim = new SimpleDateFormat(format);
		String stringDate = sim.format(date);
		return stringDate;
	}

}
