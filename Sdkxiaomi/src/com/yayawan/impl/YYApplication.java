package com.yayawan.impl;


import com.xiaomi.gamecenter.sdk.MiCommplatform;
import com.xiaomi.gamecenter.sdk.entry.MiAppInfo;
import com.xiaomi.gamecenter.sdk.entry.MiAppType;
import com.yayawan.proxy.YYWApplication;
import com.yayawan.utils.DeviceUtil;
import com.yayawan.utils.Yayalog;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class YYApplication extends YYWApplication {

	
	@Override
	public void onCreate() {
		super.onCreate();
		Yayalog.loger("123==============");
		MiAppInfo appInfo = new MiAppInfo();
		appInfo.setAppId(DeviceUtil.getGameInfo(getApplicationContext(), "AppId"));
		appInfo.setAppKey(DeviceUtil.getGameInfo(getApplicationContext(), "AppKey"));
		appInfo.setAppType(MiAppType.online);
		System.out.println(DeviceUtil.getGameInfo(getApplicationContext(), "AppId")+"  "+DeviceUtil.getGameInfo(getApplicationContext(), "AppKey"));
		MiCommplatform.Init( this, appInfo );
	}
	
	@Override
	protected void attachBaseContext(Context base) {
		// TODO Auto-generated method stub
		super.attachBaseContext(base);
		MultiDex.install(this);
	}
}
