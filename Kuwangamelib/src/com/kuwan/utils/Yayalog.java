package com.kuwan.utils;

import com.kuwan.impl.YYApplication;
import com.kuwan.proxy.GameApitest;
import com.kuwan.proxy.YYcontants;

import android.util.Log;

public class Yayalog {

	
	public static boolean canlog=false;
	
	public static void  loger(String msg){
		
		//DeviceUtil.isDebug(paramContext)
		if (canlog) {
			Log.e("kuwanYayalog", msg);
		}
			
		
		
	}
	public static void  loger(String msg,String value){
		
		//DeviceUtil.isDebug(paramContext)
		if (canlog) {
			Log.d("Yayalog", msg+":"+value);
		}
			
		
		
	}
	
	public static void  logerlife(String msg){
		
		//DeviceUtil.isDebug(paramContext)
		
		
	}
	
	public static void setCanlog(boolean msg){
		canlog=msg;
	}
}
