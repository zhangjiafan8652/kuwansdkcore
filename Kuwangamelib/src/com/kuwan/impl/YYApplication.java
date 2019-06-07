package com.kuwan.impl;


import com.kuwan.sdk.utils.Util;
import com.kuwan.utils.PermissionUtils;
import com.lidroid.jxutils.http.Jxutilsinit;
import com.kuwan.proxy.GameApitest;
import com.kuwan.proxy.YYWApplication;

import android.Manifest;
import android.app.Application;
import android.content.Context;

public class YYApplication extends YYWApplication {

	public static Context mContext;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mContext = getApplicationContext();
		Jxutilsinit.init(getApplicationContext());
		
			
	
		
		//System.out.println("YYApplication");
		GameApitest.getGameApitestInstants(getApplicationContext()).sendTest("YYApplicationoncreate="+Util.getPackageName(getApplicationContext()));
	}

	public static Context getmContext() {
		return mContext;
	}

	public static void setmContext(Context mContext) {
		YYWApplication.mContext = mContext;
	}
}
