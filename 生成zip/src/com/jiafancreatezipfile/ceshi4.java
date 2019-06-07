package com.jiafancreatezipfile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class ceshi4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String aftertime=addDateMinut("2019-01-31T16:00:30");
		
		System.out.println(aftertime);
		
		
	//	def sf = new SimpleDateFormat(\"yyyy-MM-dd\'T\'HH:mm:ss\");" +
		//		def dt = sf.parse(ctx._source.create_time);def calendar = sf.getCalendar(); calendar.setTime(dt);def instant = calendar.toInstant();def localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);ctx._source.create_time =   localDateTime.plusHours(8)

	}

	

	
	/**
     * 给时间加上几个小时
     * @param day 当前时间 格式：yyyy-MM-dd HH:mm:ss
     * @param hour 需要加的时间
     * @return
     */
    public static String addDateMinut(String day){   
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        
        
        Date date = null;   
        try {   
            date = format.parse(day);   
        } catch (Exception ex) {   
            ex.printStackTrace();   
        }   
        if (date == null)   
            return "";   
       
        Calendar cal = Calendar.getInstance();   
        cal.setTime(date);   
        cal.add(Calendar.HOUR, 8);// 24小时制   
        date = cal.getTime();   
      
        cal = null;  
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+08:00'");
        return format2.format(date);   
 
    }

}
